package de.syntaxinstitut.swimmingpoolfinder.data.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(tableName = "swimming_pools_table")
data class SwimmingPoolData(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var address: String,
    var price: Double,
    var openMonday: Int?,
    var closeMonday: Int?,
    var openTuesday: Int?,
    var closeTuesday: Int?,
    var openWednesday: Int?,
    var closeWednesday: Int?,
    var openThursday: Int?,
    var closeThursday: Int?,
    var openFriday: Int?,
    var closeFriday: Int?,
    var openSaturday: Int?,
    var closeSaturday: Int?,
    var openSunday: Int?,
    var closeSunday: Int?,
    var divingPlatform: Boolean,
    var gastronomy: Boolean,
    var slide: Boolean
)