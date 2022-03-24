package my.project.travellapp.data.repository

import androidx.lifecycle.LiveData
import my.project.travellapp.data.localDB.DescriptionDao
import my.project.travellapp.data.models.DescriptionModel
import my.project.travellapp.domain.repository.DescriptionCall
import my.project.travellapp.domain.repository.ToursCall

class DescriptionRepository(private val oad: DescriptionDao) : DescriptionCall {

    override suspend fun insertDescription(descriptionModel: DescriptionModel) {
        oad.insertDescription(descriptionModel)
    }
//    override suspend fun updateProductToCard(cardModel: DescriptionModel){
//        oad.updateProductToCard(cardModel)
//    }

    override fun loadDescriptionFromTours(): LiveData<List<DescriptionModel>> {
        return oad.loadDescriptionFromTours()    }

//    override fun loadCoffeeToCardFromCardProduct(idProduct:String): LiveData<List<DescriptionModel>> {
//        return oad.loadCoffeeToCardFromCardProduct(idProduct)    }

    override suspend fun clearDescription() {
        oad.clearDescription()    }

}