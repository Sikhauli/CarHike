package co.za.giantpanda.letshike.ui.login_and_register.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import co.za.giantpanda.letshike.R
import co.za.giantpanda.letshike.R.layout
import co.za.giantpanda.letshike.R.string
import co.za.giantpanda.letshike.ui.login_and_register.register.RegisterFragment

class LoginFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(layout.fragment_login, container, false)

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val registerButton = view.findViewById<TextView>(R.id.register_textView)
    val login = view.findViewById<TextView>(R.id.login_button)

    val phoneNUmberEdit = view.findViewById<EditText>(R.id.login_phone_number_editText)
    val loginPasswordEdit = view.findViewById<EditText>(R.id.login_password_editText)



    login.setOnClickListener {
      var username: String = phoneNUmberEdit.text.toString()
      var loginPassword: String = loginPasswordEdit.text.toString()

      if (username.isNotEmpty() and loginPassword.isNotEmpty()) {
       // if (username ==  and loginPassword ==  )



      } else if(username.isEmpty() ) {
        phoneNUmberEdit.error = getString(string.error_message)
      } else if (loginPassword.isEmpty() ) {
        loginPasswordEdit.error = getString(string.error_message)
    }
    }


    registerButton.setOnClickListener() {
      val t: FragmentTransaction = this.requireFragmentManager().beginTransaction()
      val mFrag: Fragment = RegisterFragment()
      t.replace(R.id.fragmentContainer, mFrag)
      t.commit()
    }
  }
  }
