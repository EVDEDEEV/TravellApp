package my.project.travellapp.presentation.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import my.project.travellapp.R
import my.project.travellapp.databinding.TestBinding


class Test : Fragment() {

    private var binding: TestBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

    binding = DataBindingUtil.inflate(inflater, R.layout.test, container, false)


        return binding?.cardCoffee
    }
}