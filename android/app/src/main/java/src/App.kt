package src

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin

import org.koin.dsl.module
import src.back.httpModule
import src.back.userViewModelScope
import src.back.workerApiModule
import src.back.workerViewModelScope
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
            modules(httpModule, workerViewModelScope, workerApiModule, userViewModelScope)
            }
        }
    }
