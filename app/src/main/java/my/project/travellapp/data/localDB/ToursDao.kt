package my.project.travellapp.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import my.project.travellapp.data.models.ToursModel

@Dao
interface ToursDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(toursModel: ToursModel)

    @Query("SELECT * FROM tours_data_table")
    fun loadTours(): LiveData<List<ToursModel>>

    @Query("DELETE FROM tours_data_table")
    suspend fun clear()
}

//suspend clear