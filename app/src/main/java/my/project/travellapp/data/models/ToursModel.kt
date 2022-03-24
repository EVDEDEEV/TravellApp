package my.project.travellapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tours_data_table")
class ToursModel (



    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tours_id")
    val id: Int,

    @ColumnInfo(name = "tours_name")
    val name: String,

    @ColumnInfo(name = "short_description")
    val shortDescription: String,

    @ColumnInfo(name = "tours_image")
    val image: String,

    @ColumnInfo(name = "tours_price")
    val price: String

    )
