package my.project.travellapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.project.travellapp.data.models.DescriptionModel
import my.project.travellapp.data.models.ToursModel
import my.project.travellapp.domain.useCase.DescriptionUseCase

class DescriptionViewModel(private val descriptionUseCase: DescriptionUseCase) : ViewModel() {

    fun startInsert(nameProduct:String, descriptionProduct:String, imageProduct:String, priceDesc: String, idSecDesc:String) {
        insert(
            DescriptionModel(0, nameProduct, descriptionProduct, imageProduct, priceDesc,idSecDesc)
        )
    }

   private fun insert(descriptionModel: DescriptionModel) = viewModelScope.launch{

        descriptionUseCase.insertDescription(descriptionModel)
   }
}
