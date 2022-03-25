package my.project.travellapp.presentation.tabs

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import my.project.travellapp.R
import my.project.travellapp.data.models.ToursModel
import my.project.travellapp.databinding.DescriptionBinding
import my.project.travellapp.databinding.ToursBinding
import my.project.travellapp.presentation.viewModels.DescriptionViewModel
import my.project.travellapp.presentation.viewModels.ToursViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Tours : Fragment() {


    private var binding: ToursBinding? = null
    private var toursAdapter: ToursAdapter? = null
    private val toursViewModel: ToursViewModel by viewModel()
    private val descriptionViewModel: DescriptionViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.tours, container, false)

        loadTours()
        initRecyclerTours()

        return binding?.root

    }


    private fun initRecyclerTours() {

        binding?.recyclerTours?.layoutManager =
            LinearLayoutManager(context)

        toursAdapter = ToursAdapter { toursModel: ToursModel ->
            addToDescription(
                toursModel
            )
        }

        binding?.recyclerTours?.adapter = toursAdapter

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun loadTours() {

        toursViewModel.loadTours.observe(viewLifecycleOwner, Observer {
            toursAdapter?.setList(it)
            toursAdapter?.notifyDataSetChanged()
        })


    }

    private fun addToDescription(toursModel: ToursModel) {
        descriptionViewModel.startInsert(toursModel.name, toursModel.image, toursModel.price,
            toursModel.id.toString(), "1")
    }


}


