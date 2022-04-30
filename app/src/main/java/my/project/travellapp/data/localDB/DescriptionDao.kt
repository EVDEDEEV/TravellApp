package my.project.travellapp.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import my.project.travellapp.data.models.DescriptionModel


@Dao
interface DescriptionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDescription(descriptionModel: DescriptionModel)

    @Query("SELECT * FROM desc_data_table")
    fun loadDescriptionFromTours(): LiveData<List<DescriptionModel>>

    @Query("DELETE FROM desc_data_table")
    suspend fun clearDescription()
}