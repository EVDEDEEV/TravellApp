package my.project.travellapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "desc_data_table")
class DescriptionModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "desc_id")
    val id: Int,

    @ColumnInfo(name = "desc_name")
    val name: String,

    @ColumnInfo(name = "desc_description")
    val desc: String,

    @ColumnInfo(name = "desc_image")
    val image: String,

    @ColumnInfo(name = "desc_price")
    val price: String,

    @ColumnInfo(name = "descDesc_id")
    val idSecDesc: String,
)