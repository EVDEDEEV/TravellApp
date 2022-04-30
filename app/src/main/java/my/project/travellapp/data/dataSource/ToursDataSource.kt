package my.project.travellapp.data.dataSource

import androidx.lifecycle.LiveData
import my.project.travellapp.data.models.ToursModel

interface ToursDataSource {
    fun insert(toursModel: ToursModel)
    fun loadTours(): LiveData<List<ToursModel>>
    suspend fun clear()
}

