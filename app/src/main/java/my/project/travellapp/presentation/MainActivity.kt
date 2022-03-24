package my.project.travellapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import my.project.travellapp.R
import my.project.travellapp.databinding.ActivityMainBinding
import my.project.travellapp.presentation.tabs.Description
import my.project.travellapp.presentation.tabs.Tours
import my.project.travellapp.presentation.viewModels.ToursViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel



class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val toursViewModel: ToursViewModel by viewModel()

    private fun addToDescription() {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)




        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        toursViewModel.migration(this)

        setSupportActionBar(binding?.topMainMenu)


        supportFragmentManager.beginTransaction().replace(R.id.mainContent, Tours()).commit()


        binding?.bottomMainMenu?.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.homeBottomMainMenu ->
                    supportFragmentManager.beginTransaction().replace(R.id.mainContent, Tours())
                        .commit()
                R.id.descriptionBottomMainMenu ->
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mainContent, Description()).commit()
            }

            return@setOnItemSelectedListener true
        }
        binding?.bottomMainMenu?.selectedItemId = R.id.homeBottomMainMenu

    }
}




