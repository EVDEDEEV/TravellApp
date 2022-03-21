package my.project.travellapp.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.travellapp.data.models.ToursModel
import my.project.travellapp.domain.repository.ToursCall

class ToursUseCase (private val toursCall: ToursCall) {

    fun loadTours(): LiveData<List<ToursModel>> {

        return toursCall.loadTours()

    }

    suspend fun startMigration (context: Context) {

        toursCall.startMigration(context)

    }

}