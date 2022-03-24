package my.project.travellapp.domain.useCase

import my.project.travellapp.data.models.DescriptionModel
import my.project.travellapp.domain.repository.DescriptionCall
import my.project.travellapp.domain.repository.ToursCall

class DescriptionUseCase(private val descriptionCall: DescriptionCall) {

    suspend fun insertDescription(descriptionModel: DescriptionModel) {
        descriptionCall.insertDescription(descriptionModel)    }
}