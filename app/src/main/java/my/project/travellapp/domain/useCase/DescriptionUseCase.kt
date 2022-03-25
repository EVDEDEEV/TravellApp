package my.project.travellapp.domain.useCase

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.project.travellapp.data.models.DescriptionModel
import my.project.travellapp.domain.repository.DescriptionCall
import my.project.travellapp.domain.repository.ToursCall

class DescriptionUseCase(private val descriptionCall: DescriptionCall) {

    suspend fun insertDescription(descriptionModel: DescriptionModel) {
        descriptionCall.insertDescription(descriptionModel)
    }

    fun loadDescriptionFromTours(): LiveData<List<DescriptionModel>> {
        return descriptionCall.loadDescriptionFromTours()
    }


    suspend fun clearDescription() {
        descriptionCall.clearDescription()
    }
}