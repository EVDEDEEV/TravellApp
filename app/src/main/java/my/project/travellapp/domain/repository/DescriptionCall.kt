package my.project.travellapp.domain.repository

import androidx.lifecycle.LiveData
import my.project.travellapp.data.models.DescriptionModel

interface DescriptionCall {

    suspend fun insertDescription(descriptionModel: DescriptionModel)

    fun loadDescriptionFromTours(): LiveData<List<DescriptionModel>>

    suspend fun clearDescription()
}