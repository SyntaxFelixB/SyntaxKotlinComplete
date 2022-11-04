package de.syntaxinstitut.firebaselogin.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import de.syntaxinstitut.firebaselogin.data.Player

const val TAG = "MainViewModel"

/**
 * Das MainViewModel kümmert sich um die Kommunikation mit der Firebase Authentication
 * um einen SHA-1 Key zu generieren einfach folgene Zeilen ins Terminal kopieren
 * >>keytool -alias androiddebugkey -keystore ~/.android/debug.keystore -list -v -storepass android<<
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    // Kommunikationspunkt mit der Firestore Datenbank
    val db = FirebaseFirestore.getInstance()

    // Kommunikationspunkt mit der FirebaseAuth
    private val firebaseAuth = FirebaseAuth.getInstance()

    // currentuser ist null wenn niemand eingeloggt ist
    private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser: LiveData<FirebaseUser?>
        get() = _currentUser

    // Player enthält alle relevanten Daten aus dem Firestore
    private val _player = MutableLiveData<Player>()
    val player: LiveData<Player>
        get() = _player

    private val _toast = MutableLiveData<String?>()
    val toast: LiveData<String?>
        get() = _toast

    // hier wird versucht einen User zu erstellen um diesen anschließend auch gleich
    // einzuloggen
    fun signUp(email: String, password: String, player: Player) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        _currentUser.value = firebaseAuth.currentUser
                        setNameAndLevel(player)
                        _toast.value = "welcome"
                        _toast.value = null
                    } else {
                        Log.e(TAG, "Login failed: ${it.exception}")
                        _toast.value = "login failed\n${it.exception?.localizedMessage}"
                        _toast.value = null
                    }
                }
            } else {
                Log.e(TAG, "SignUp failed: ${it.exception}")
                _toast.value = "signup failed\n${it.exception?.localizedMessage}"
                _toast.value = null
            }
        }
    }

    private fun setNameAndLevel(player: Player) {
        db.collection("user").document(currentUser.value!!.uid)
            .set(player)
            .addOnFailureListener {
                Log.w(TAG, "Error writing document: $it")
                _toast.value = "error creating player"
                _toast.value = null
            }
    }

    fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                _currentUser.value = firebaseAuth.currentUser
                _toast.value = "welcome"
                _toast.value = null
            } else {
                Log.e(TAG, "Login failed: ${it.exception}")
                _toast.value = "login failed\n${it.exception?.localizedMessage}"
                _toast.value = null
            }
        }
    }

    fun logout() {
        firebaseAuth.signOut()
        _currentUser.value = firebaseAuth.currentUser
    }

    // hier werden Spielerdaten mittles userid aus dem Firestore geladen
    fun getPlayerData() {
        db.collection("user").document(currentUser.value!!.uid)
            .get().addOnSuccessListener {
                _player.value = it.toObject(Player::class.java)
            }
            .addOnFailureListener {
                Log.e(TAG, "Error reading document: $it")
            }
    }

    // hier wird das level des Spielers erhöht und in den FireStore geschrieben
    fun levelUp() {
        val newLevel = player.value!!.level + 1
        db.collection("user").document(currentUser.value!!.uid)
            .update("level", newLevel)
            .addOnSuccessListener { getPlayerData() }
    }
}
