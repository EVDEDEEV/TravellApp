package my.project.travellapp.data.api


import my.project.travellapp.data.models.ToursApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("loadTravel.php")
    fun loadToursApi(): Call<ArrayList<ToursApiModel>>
}