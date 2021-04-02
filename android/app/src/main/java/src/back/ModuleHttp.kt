package src.back

import okhttp3.OkHttpClient
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import src.model.WorkerApi
import src.viewmodel.WorkerViewModel

val httpModule= module{
    fun httpClient() : OkHttpClient{
        return OkHttpClient.Builder().build()
    }

    fun retrofit(client: OkHttpClient): Retrofit{
        return Retrofit.Builder().baseUrl("http://ec2-52-90-6-21.compute-1.amazonaws.com/")
            .addConverterFactory(MoshiConverterFactory.create())
                .client(client).build()
    }

    single{ httpClient() }
    single { retrofit(get()) }
}

val workerViewModelScope = module{
    viewModel { WorkerViewModel(get()) }
}

val workerApiModule = module {
    fun getWorkerApi(retrofit: Retrofit) : WorkerApi{
        return retrofit.create(WorkerApi::class.java)
    }

    single { getWorkerApi(get()) }
}