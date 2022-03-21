package my.project.travellapp.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ToursApiModel(
    @SerializedName("id") @Expose
    var id: Int? = null,
    @SerializedName("name") @Expose
    var name: String? = null,
    @SerializedName("shortDescription") @Expose
    var shortDescription: String? = null,
    @SerializedName("image") @Expose
    var image: String? = null,
    @SerializedName("price") @Expose
    var price: String? = null,

    )