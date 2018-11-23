package com.santosh.sqlitetutorial.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
public class Tracks {
    @PrimaryKey
    var TrackId: Int = 0

    var Name: String? = null

    var AlbumId: Int = 0

    var MediaTypeId: Int = 0

    var GenreId: Int = 0

    var Composer: String? = null

    var Milliseconds: Long = 0

    var bytes: Long = 0

    var UnitPrice: Float = 0F
}