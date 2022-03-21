package my.project.travellapp.presentation

import android.app.Application
import my.project.travellapp.presentation.di.tours
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.logging.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) org.koin.core.logger.Level.ERROR else org.koin.core.logger.Level.NONE)
            androidContext(this@App)
            modules(tours)
        }
    }
}

//startKoin {
//    // Koin Android logger
//    androidLogger()
//    //inject Android context
//    androidContext(this@App)
//
//    modules(tours)
//}