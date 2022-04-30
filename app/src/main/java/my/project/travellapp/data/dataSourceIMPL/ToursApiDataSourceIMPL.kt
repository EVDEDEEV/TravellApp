package my.project.travellapp.data.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import my.project.travellapp.data.api.ApiClient
import my.project.travellapp.data.dataSource.ToursApiDataSource
import my.project.travellapp.data.dataSource.ToursDataSource
import my.project.travellapp.data.models.ToursApiModel
import my.project.travellapp.data.models.ToursModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ToursApiDataSourceIMPL(private val toursDataSource: ToursDataSource) :
    ToursApiDataSource {

    override fun startMigration(context: Context) {
        val call = ApiClient.instance?.api?.loadToursApi()
        call?.enqueue(object : Callback<ArrayList<ToursApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<ToursApiModel>>,
                response: Response<ArrayList<ToursApiModel>>,
            ) {
                var loadTours: ArrayList<ToursApiModel>? = null
                loadTours?.clear()
                loadTours = (response.body() as ArrayList<ToursApiModel>?)!!

                for (audit in loadTours) {

                    audit.id?.let {
                        ToursModel(
                            it,
                            audit.name.toString(),
                            audit.shortDescription.toString(),
                            audit.image.toString(),
                            audit.price.toString()
                        )
                    }?.let {
                        toursDataSource.insert(
                            it
                        )
                    }
                }

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ArrayList<ToursApiModel>>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

