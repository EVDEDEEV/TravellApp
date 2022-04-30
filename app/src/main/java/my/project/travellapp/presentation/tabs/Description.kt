package my.project.travellapp.presentation.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import my.project.travellapp.R
import my.project.travellapp.databinding.DescriptionBinding
import my.project.travellapp.presentation.viewModels.DescriptionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class Description : Fragment(), View.OnClickListener {

    private var binding: DescriptionBinding? = null
    private var descriptionAdapter: DescriptionAdapter? = null
    private val descriptionViewModel: DescriptionViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.description, container, false)

        initRecyclerDescription()
        loadDescriptionFromTours()

        binding?.clearDescription?.setOnClickListener(this)

        return binding?.root
    }

    private fun initRecyclerDescription() {

        binding?.recyclerDescription?.layoutManager =
            LinearLayoutManager(context)

        descriptionAdapter = DescriptionAdapter()
        binding?.recyclerDescription?.adapter = descriptionAdapter

    }

    private fun loadDescriptionFromTours() {

        descriptionViewModel.loadDescriptionFromTours.observe(viewLifecycleOwner, Observer {
            descriptionAdapter?.setList(it)
            descriptionAdapter?.notifyDataSetChanged()


        })


    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.clearDescription -> descriptionViewModel.clearDescription()
        }
    }
}


//    private fun deleteFromCard(descriptionModel: DescriptionModel){
//
//        descriptionViewModel.deleteProductFromCard(descriptionModel.id)
//    }

//    override fun onClick(view: View) {
//        when(view.id) {
//            R.id.clearCard -> cardViewModel.clearCard()
//
//            R.id.checkoutCard -> {
//
//                val checkout = Checkout()
//                checkout.show((context as FragmentActivity).supportFragmentManager, "checkout")
//
//            }
//        }
//    }

//    private fun lessCount(cardModel:CardModel) {
//
//        var count: Int = cardModel.count.toInt()
//        count--
//
//        if (count<1) {
//            cardViewModel.updateProductToCard(
//                CardModel(cardModel.id, cardModel.name,
//                    cardModel.image, cardModel.price, cardModel.idProduct, "1",
//                    (cardModel.price.toInt()*1).toString())
//            )
//
//        }
//        else {
//
//            cardViewModel.updateProductToCard(
//                CardModel(cardModel.id, cardModel.name,
//                    cardModel.image, cardModel.price, cardModel.idProduct, count.toString(),
//                    (cardModel.price.toInt()*count).toString())
//            )
//
//        }
//
//
//
//
//    }
//
//    private fun moreCount(cardModel:CardModel) {
//
//        var count: Int = cardModel.count.toInt()
//        count++
//
//
//
//        cardViewModel.updateProductToCard(
//            CardModel(cardModel.id, cardModel.name,
//                cardModel.image, cardModel.price, cardModel.idProduct, count.toString(),
//                (cardModel.price.toInt()*count).toString())
//        )
//
//
//
//    }
//
//
//} {

//    private var binding: DescriptionBinding? = null
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?,
//    ): View? {
//        binding = DataBindingUtil.inflate(inflater, R.layout.description, container, false)
//
//
//        return binding?.root
//    }

