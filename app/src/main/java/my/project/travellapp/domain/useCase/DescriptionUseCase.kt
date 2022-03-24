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
        descriptionCall.insertDescription(descriptionModel)    }

//    suspend fun updateProductToCard(cardModel: DescriptionModel) {
//        CoroutineScope(Dispatchers.IO).launch {
//            descriptionCall.updateProductToCard(cardModel)}
//    }

    fun loadDescriptionFromTours(): LiveData<List<DescriptionModel>> {
        return descriptionCall.loadDescriptionFromTours()    }

//    fun loadCoffeeToCardFromCardProduct(idProduct:String): LiveData<List<DescriptionModel>> {
//        return descriptionCall.loadCoffeeToCardFromCardProduct(idProduct)    }

    suspend fun clearDescription() {
        descriptionCall.clearDescription()    }
}