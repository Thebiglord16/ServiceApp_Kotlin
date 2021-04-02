package src.model

class WorkerApi {
    fun getWorkers(): List<Worker>{
        return listOf(
            Worker("pepito perez", "pepe1", "12345678", 4),
            Worker("juanito perez", "juan1", "12345678", 4),
            Worker("ramon perez", "ramon1", "12345678", 4),
            Worker("esteban perez", "este1", "12345678", 4),
            Worker("daniel perez", "dan1", "12345678", 4),
            Worker("laura perez", "lau1", "12345678", 4),
            Worker("camilo perez", "cami", "12345678", 4)
            )
    }
}