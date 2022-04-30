package my.project.travellapp.presentation.tabs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import my.project.travellapp.R
import my.project.travellapp.data.models.DescriptionModel
import my.project.travellapp.databinding.DescriptionItemBinding

class DescriptionAdapter :
    RecyclerView.Adapter<DescriptionAdapter.DescriptionHolder>() {
    private val productsFromTours = ArrayList<DescriptionModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: DescriptionItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.description_item, parent, false)
        return DescriptionHolder(binding)
    }

    override fun getItemCount(): Int {
        return productsFromTours.size
    }


    override fun onBindViewHolder(holder: DescriptionHolder, position: Int) {
        holder.bind(productsFromTours[position])
    }

    fun setList(cardList: List<DescriptionModel>) {
        productsFromTours.clear()
        productsFromTours.addAll(cardList)
    }


    class DescriptionHolder(val binding: DescriptionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            descriptionModel: DescriptionModel,
        ) {

            val getImages = descriptionModel.desc
            Picasso.get().load(getImages).into(binding.imageDescription)
            binding.nameDescription.text = descriptionModel.name
            binding.shortDescription.text = descriptionModel.image
        }

    }
}