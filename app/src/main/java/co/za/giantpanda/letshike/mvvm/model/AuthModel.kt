package co.za.giantpanda.letshike.mvvm.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import co.za.giantpanda.letshike.mvvm.repository.RegisterRepository
import co.za.giantpanda.letshike.db.entity.RegisterEntity
import java.util.concurrent.Executors

class AuthModel(registerRepository: RegisterRepository?) : ViewModel() {

  private val executor = Executors.newSingleThreadExecutor()
  private var registerRepository: RegisterRepository? = null
  var messageLiveData: LiveData<List<RegisterEntity?>?>? = null


  fun insertUserDetail(registerEntity: RegisterEntity?) {
    executor.execute { registerRepository?.sendUserDetail(registerEntity) }
  }

  fun fetchPhoneNumber() {
    messageLiveData = registerRepository?.fetchPhoneNUmber()
  }

  fun fetchUserPassword() {
    messageLiveData = registerRepository?.fetchUserPassword()
  }

}