package my.project.travellapp.presentation.tabs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import my.project.travellapp.R
import my.project.travellapp.data.models.DescriptionModel
import my.project.travellapp.databinding.DescriptionItemBinding

class DescriptionAdapter :
    RecyclerView.Adapter<DescriptionAdapter.DescriptionHolder>() {
    private val productsFromCard = ArrayList<DescriptionModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: DescriptionItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.description_item, parent, false)
        return DescriptionHolder(binding)
    }

    override fun getItemCount(): Int {
        return productsFromCard.size
    }



    override fun onBindViewHolder(holder: DescriptionHolder, position: Int) {
        holder.bind(productsFromCard[position])

    }

    fun setList(cardList: List<DescriptionModel>) {
        productsFromCard.clear()
        productsFromCard.addAll(cardList)

    }



    class DescriptionHolder(val binding: DescriptionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            descriptionModel: DescriptionModel
        ) {

            val getImage = descriptionModel.imageDesc
            Picasso.get().load(getImage).into(binding.imageDescription)
            binding.nameDescription.text = descriptionModel.nameDesc
            binding.shortDescription.text = descriptionModel.descDescription
            binding.priceDescription.text = descriptionModel.priceDesc
//            binding.totalPriceProductCard.text = descriptionModel.totalPrice

        }



    }

}
