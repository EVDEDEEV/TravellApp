package my.project.travellapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.project.travellapp.data.models.DescriptionModel
import my.project.travellapp.data.models.ToursModel
import my.project.travellapp.domain.useCase.DescriptionUseCase

class DescriptionViewModel(private val descriptionUseCase: DescriptionUseCase) : ViewModel() {

    fun startInsert(
        name: String,
        description: String,
        image: String,
        price: String,
        idSecDesc: String
    ) {
        insert(
            DescriptionModel(0, name, description, image, price, idSecDesc)
        )
    }

//    fun updateProductToCard(descriptionModel: DescriptionModel) = viewModelScope.launch{
//
//        descriptionUseCase.updateProductToCard(descriptionModel)
//    }

    val loadDescriptionFromTours = descriptionUseCase.loadDescriptionFromTours()

//    fun loadCoffeeToCardFromCardProduct(idProduct:String): LiveData<List<DescriptionModel>> {
//        return descriptionUseCase.loadCoffeeToCardFromCardProduct(idProduct)
//    }

   private fun insert(descriptionModel: DescriptionModel) = viewModelScope.launch{
        descriptionUseCase.insertDescription(descriptionModel)
   }

    fun clearDescription() = viewModelScope.launch{
        descriptionUseCase.clearDescription()
    }
}
