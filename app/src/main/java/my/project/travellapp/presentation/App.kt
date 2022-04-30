package my.project.travellapp.presentation

import android.app.Application
import my.project.travellapp.presentation.di.description
import my.project.travellapp.presentation.di.tours
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) org.koin.core.logger.Level.ERROR else org.koin.core.logger.Level.NONE)
            androidContext(this@App)
            modules(tours, description)
        }
    }
}

