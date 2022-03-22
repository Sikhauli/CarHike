package co.za.giantpanda.letshike.mvvm.repository

import androidx.lifecycle.LiveData
import co.za.giantpanda.letshike.db.AppDao
import co.za.giantpanda.letshike.db.entity.RegisterEntity

class RegisterRepository {

  private var appDao: AppDao? = null

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