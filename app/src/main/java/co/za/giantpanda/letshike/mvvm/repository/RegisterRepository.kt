package co.za.giantpanda.letshike.mvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import co.za.giantpanda.letshike.db.AppDao
import co.za.giantpanda.letshike.db.AppDatabase
import co.za.giantpanda.letshike.db.entity.RegisterEntity

class RegisterRepository(requireContext: Context) {

  private var appDao: AppDao? = null

  fun RegisterEntity( context: Context?) {
    appDao = AppDatabase.getDatabaseInstance(context).appDao()
  }

  fun sendUserDetail(registerEntity: RegisterEntity?) {
    appDao?.insertUserDetail(registerEntity)
  }

  fun fetchPhoneNUmber(): LiveData<List<RegisterEntity?>?>? {
    return appDao?.fetchPhoneNUmber()
  }
  fun fetchUserPassword(): LiveData<List<RegisterEntity?>?>? {
    return appDao?.fetchUserPassword()
  }


}