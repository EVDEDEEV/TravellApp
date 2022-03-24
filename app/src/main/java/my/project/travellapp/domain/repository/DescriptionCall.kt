package my.project.travellapp.domain.repository

import androidx.lifecycle.LiveData
import my.project.travellapp.data.models.DescriptionModel

interface DescriptionCall {

    suspend fun insertDescription(descriptionModel: DescriptionModel)

//    suspend fun updateProductToCard(cardModel: DescriptionModel)

    fun loadDescriptionFromTours(): LiveData<List<DescriptionModel>>

//    fun loadCoffeeToCardFromCardProduct(idProduct:String): LiveData<List<DescriptionModel>>

    suspend fun clearDescription()
}