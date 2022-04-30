package my.project.travellapp.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.travellapp.data.dataSource.ToursApiDataSource
import my.project.travellapp.data.dataSource.ToursDataSource
import my.project.travellapp.data.models.ToursModel
import my.project.travellapp.domain.repository.ToursCall

class ToursRepository(
    private val toursApiDataSource: ToursApiDataSource,
    private val toursDataSource: ToursDataSource,
) : ToursCall {

    override fun loadTours(): LiveData<List<ToursModel>> {
        return toursDataSource.loadTours()
    }

    override suspend fun startMigration(context: Context) {
        toursDataSource.clear()
        toursApiDataSource.startMigration(context)
    }
}


