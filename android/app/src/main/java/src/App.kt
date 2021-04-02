package src

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin

import org.koin.dsl.module
import src.model.WorkerApi
import src.viewmodel.WorkerViewModel

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        configureKoin()
    }

    private fun configureKoin() {
        startKoin {
            androidContext(this@App)
            val viewModelScope = module {
                viewModel{WorkerViewModel(get())}
            }
            val apiModule = module {
                fun provideUserApi(): WorkerApi {
                    return WorkerApi()
                }

                single { provideUserApi() }
            }
            modules(apiModule, viewModelScope)
        }
    }
}