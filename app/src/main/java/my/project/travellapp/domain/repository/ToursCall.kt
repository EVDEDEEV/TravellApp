package my.project.travellapp.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.travellapp.data.models.DescriptionModel
import my.project.travellapp.data.models.ToursModel

interface ToursCall {
    fun loadTours(): LiveData<List<ToursModel>>
    suspend fun startMigration(context: Context)


}

