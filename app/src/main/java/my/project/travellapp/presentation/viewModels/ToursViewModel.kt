package my.project.travellapp.presentation.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.project.travellapp.data.models.DescriptionModel
import my.project.travellapp.data.models.ToursModel
import my.project.travellapp.domain.useCase.DescriptionUseCase
import my.project.travellapp.domain.useCase.ToursUseCase


class ToursViewModel(private val toursUseCase: ToursUseCase) : ViewModel() {

    //    , private val descriptionUseCase: DescriptionUseCase
    val loadTours = toursUseCase.loadTours()


    fun migration(context: Context) = viewModelScope.launch {
        toursUseCase.startMigration(context)

    }

//    fun loadTours(name: String, image: String, price: String, toString: String, s: String) {
//
//    }


}