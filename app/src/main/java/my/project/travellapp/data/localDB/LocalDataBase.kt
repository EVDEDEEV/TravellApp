package my.project.travellapp.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import my.project.travellapp.data.models.DescriptionModel
import my.project.travellapp.data.models.ToursModel

@Database(entities = [ToursModel::class], version = 1)
abstract class LocalDataBase: RoomDatabase() {
    abstract val toursDao: ToursDao

//    DescriptionModel::class,
}
