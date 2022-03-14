package co.za.giantpanda.letshike

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import co.za.giantpanda.letshike.R.id
import co.za.giantpanda.letshike.ui.login_and_register.login.LoginFragment

class MainActivity : AppCompatActivity() {



  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    addFragment(LoginFragment())

  }

  fun addFragment(fragment: Fragment?) {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.add(id.fragmentContainer, fragment!!).addToBackStack(fragmentTransaction.javaClass.name).commit()
  }

  fun replaceFragment(fragment: Fragment?) {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.add(id.fragmentContainer, fragment!!).addToBackStack(fragmentTransaction.javaClass.name).commit()
  }



}