package co.za.giantpanda.letshike.ui.login_and_register.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.za.giantpanda.letshike.MainActivity
import co.za.giantpanda.letshike.R
import co.za.giantpanda.letshike.R.layout
import co.za.giantpanda.letshike.R.string
import co.za.giantpanda.letshike.mvvm.model.AuthModel
import co.za.giantpanda.letshike.ui.login_and_register.feeds.FeedsFragment
import co.za.giantpanda.letshike.ui.login_and_register.register.RegisterFragment

class LoginFragment : Fragment() {

  private var mainActivity : MainActivity? = null
  private var authModel : AuthModel? = null

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(layout.fragment_login, container, false)

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val toRegisterButton = view.findViewById<TextView>(R.id.register_textView)
    val login = view.findViewById<TextView>(R.id.login_button)

    val phoneNUmberEdit = view.findViewById<EditText>(R.id.login_phone_number_editText)
    val loginPasswordEdit = view.findViewById<EditText>(R.id.login_password_editText)

    login.setOnClickListener {
      val phoneNumber: String = phoneNUmberEdit.text.toString()
      val loginPassword: String = loginPasswordEdit.text.toString()

      if (phoneNumber.isNotEmpty() and loginPassword.isNotEmpty()) {
          if (phoneNumber == authModel?.fetchPhoneNumber()?.toString() && loginPassword == authModel?.fetchUserPassword()?.toString()){
            mainActivity?.replaceFragment(FeedsFragment())
          }
          else{
            Toast.makeText(mainActivity?.applicationContext,"Incorrect Login Info",Toast.LENGTH_SHORT).show()
          }

        } else if(phoneNumber.isEmpty() ) {
        phoneNUmberEdit.error = getString(string.error_message)
        } else if (loginPassword.isEmpty() ) {
        loginPasswordEdit.error = getString(string.error_message)
      }
    }

    toRegisterButton.setOnClickListener {
      mainActivity?.addFragment(RegisterFragment())

    }
  }
}
