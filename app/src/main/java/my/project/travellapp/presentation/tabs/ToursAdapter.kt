package my.project.travellapp.presentation.tabs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import my.project.travellapp.R
import my.project.travellapp.data.models.DescriptionModel
import my.project.travellapp.data.models.ToursModel
import my.project.travellapp.databinding.ToursItemBinding

class ToursAdapter() :
    RecyclerView.Adapter<ToursAdapter.ToursHolder>() {

//    private val addToCard:(ToursModel)->Unit
    private val tours = ArrayList<ToursModel>()
//    private var description: DescriptionBinding()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToursHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ToursItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.tours_item, parent, false)
        return ToursHolder(binding)

    }

    override fun getItemCount(): Int {
        return tours.size
    }

    override fun onBindViewHolder(holder: ToursHolder, position: Int) {
        holder.bind(tours[position])

    }


    fun setList(toursList: List<ToursModel>) {
        tours.clear()
        tours.addAll(toursList)

    }


    class ToursHolder(val binding: ToursItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
//            descriptionModel: ToursModel,
            toursModel: ToursModel,
//            addToCard: (ToursModel) -> Unit
        ) {

            val getImage = toursModel.image
            Picasso.get().load(getImage).into(binding.imageTours)
            binding.nameTours.text = toursModel.name
            binding.shortDescription.text = toursModel.shortDescription
            binding.button.text = toursModel.shortDescription
            binding.price.text = toursModel.price


//            binding?.button?.setOnClickListener(View.OnClickListener {
//                addToCard(toursModel)

//            })







        }



    }
}