package my.project.travellapp.data.dataSourceIMPL

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.project.travellapp.data.dataSource.ToursDataSource
import my.project.travellapp.data.localDB.ToursDao
import my.project.travellapp.data.models.ToursModel

class ToursDataSourceIMPL(private val dao: ToursDao) :
    ToursDataSource {


    override fun insert(toursModel: ToursModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(toursModel)
        }
    }

    override fun loadTours(): LiveData<List<ToursModel>> {
        return dao.loadTours()
    }


    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()
        }
    }


}
//override suspend fun clear() {
//    CoroutineScope(Dispatchers.IO).launch {
//        dao.clear()}