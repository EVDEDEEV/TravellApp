package my.project.travellapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "desc_data_table")
class DescriptionModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "desc_id")
    val idDesc: Int,

    @ColumnInfo(name = "desc_name")
    val nameDesc: String,

    @ColumnInfo(name = "desc_description")
    val descDescription: String,

    @ColumnInfo(name = "desc_image")
    val imageDesc: String,

    @ColumnInfo(name = "desc_price")
    val priceDesc: String,

    @ColumnInfo(name = "descDesc_id")
    val idSecDesc:String,

)