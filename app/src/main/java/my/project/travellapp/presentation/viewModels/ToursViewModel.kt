package my.project.travellapp.presentation.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.project.travellapp.domain.useCase.ToursUseCase


class ToursViewModel(private val toursUseCase: ToursUseCase) : ViewModel() {
    val loadTours = toursUseCase.loadTours()

    fun migration(context: Context) = viewModelScope.launch {
        toursUseCase.startMigration(context)
    }
}