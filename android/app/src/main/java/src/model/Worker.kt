package src.model


data class Worker(
    val id: Int,
    val first_name: String,
    val last_name: String,
    val rating: Int,
    val date_created: String,
    val service_radius: Int,
    val price_per_hour: Double,
    val location_lon: Double,
    val location_lat: Double,
    val worker_categoy: String
    )