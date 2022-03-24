package my.project.travellapp.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.*
import my.project.travellapp.data.models.DescriptionModel


@Dao
interface DescriptionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDescription(descriptionModel: DescriptionModel)

    @Query("SELECT * FROM desc_data_table")
    fun loadDescriptionFromTours(): LiveData<List<DescriptionModel>>

//    @Query("SELECT * FROM desc_data_table WHERE desc_description = :idDescription")
//    fun loadDescriptionFromTours(idDescription: String): LiveData<List<DescriptionModel>>

//    @Update
//    suspend fun updateProductToCard(descriptionModel: DescriptionModel)

    @Query("DELETE FROM desc_data_table")
    suspend fun clearDescription()
}