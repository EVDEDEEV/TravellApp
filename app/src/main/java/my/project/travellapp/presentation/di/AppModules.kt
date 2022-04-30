package my.project.travellapp.presentation.di

import androidx.room.Room
import my.project.travellapp.data.dataSource.ToursApiDataSource
import my.project.travellapp.data.dataSource.ToursDataSource
import my.project.travellapp.data.dataSourceIMPL.ToursApiDataSourceIMPL
import my.project.travellapp.data.dataSourceIMPL.ToursDataSourceIMPL
import my.project.travellapp.data.localDB.LocalDataBase
import my.project.travellapp.data.repository.DescriptionRepository
import my.project.travellapp.data.repository.ToursRepository
import my.project.travellapp.domain.repository.DescriptionCall
import my.project.travellapp.domain.repository.ToursCall
import my.project.travellapp.domain.useCase.DescriptionUseCase
import my.project.travellapp.domain.useCase.ToursUseCase
import my.project.travellapp.presentation.viewModels.DescriptionViewModel
import my.project.travellapp.presentation.viewModels.ToursViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val tours = module {

    single {
        Room.databaseBuilder(androidContext(), LocalDataBase::class.java,
            "dbT").build()
    }

    single { get<LocalDataBase>().toursDao }


    single<ToursDataSource> {
        ToursDataSourceIMPL(
            get()
        )
    }

    single<ToursApiDataSource> {
        ToursApiDataSourceIMPL(
            get()
        )
    }

    single<ToursCall> { ToursRepository(get(), get()) }

    single { ToursUseCase(get()) }

    viewModel { ToursViewModel(get()) }

}
val description = module {

    single {
        Room.databaseBuilder(androidContext(), LocalDataBase::class.java,
            "dbD").build()
    }

    single { get<LocalDataBase>().descriptionDao }
    single<DescriptionCall> { DescriptionRepository(get()) }
    single { DescriptionUseCase(get()) }
    viewModel { DescriptionViewModel(get()) }
}
