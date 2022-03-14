package co.za.giantpanda.letshike.mvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.za.giantpanda.letshike.mvvm.repository.RegisterRepository
import co.za.giantpanda.letshike.mvvm.model.AuthModel
import java.lang.IllegalArgumentException

class AuthViewModelFactory(registerRepository: RegisterRepository) : ViewModelProvider.Factory {

  private var registerRepository: RegisterRepository? = null

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(AuthModel::class.java)) {
      return AuthModel(registerRepository) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }

}