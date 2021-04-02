package src.model

import retrofit2.http.GET

interface WorkerApi {

    @GET("api/workers")
    suspend fun getWorkers() : List<Worker>
}