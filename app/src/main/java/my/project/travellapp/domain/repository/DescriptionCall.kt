package my.project.travellapp.domain.repository

import my.project.travellapp.data.models.DescriptionModel

interface DescriptionCall {

    suspend fun insertDescription(descriptionModel: DescriptionModel)
}