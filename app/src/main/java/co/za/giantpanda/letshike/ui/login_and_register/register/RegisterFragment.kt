package co.za.giantpanda.letshike.ui.login_and_register.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import co.za.giantpanda.letshike.MainActivity
import co.za.giantpanda.letshike.R
import co.za.giantpanda.letshike.R.string
import co.za.giantpanda.letshike.db.entity.RegisterEntity
import co.za.giantpanda.letshike.ui.login_and_register.feeds.FeedsFragment
import co.za.giantpanda.letshike.ui.login_and_register.login.LoginFragment

open class RegisterFragment : Fragment() {

  private var mainActivity: MainActivity? = null
  private val register: RegisterEntity? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    return inflater.inflate(R.layout.fragment_register, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)


    val userRegisterButton = view.findViewById<TextView>(R.id.register_button)
    val userLoginButton = view.findViewById<TextView>(R.id.register_to_log_in_button)

    val phoneNUmber = view.findViewById<EditText>(R.id.register_phone_number_editText)
    val registerPassword = view.findViewById<EditText>(R.id.register_password_editText)
    val registerPasswordConfirm = view.findViewById<EditText>(R.id.register_password_confirm_editText)
    val nickName = view.findViewById<EditText>(R.id.register_username_input_Textview)
    val name = view.findViewById<EditText>(R.id.register_firstName_input)
    val surname = view.findViewById<EditText>(R.id.register_lastName_input)


    userRegisterButton.setOnClickListener {

      register?.cellPhone = phoneNUmber.text.toString()
      register?.password = registerPassword.text.toString()
      register?.userName = nickName.text.toString()
      register?.firstName = name.text.toString()
      register?.lastName = surname.text.toString()



      val contact: String = phoneNUmber.text.toString()
      val password: String = registerPassword.text.toString()
      val passwordConfirm: String = registerPasswordConfirm.text.toString()
      val name1: String = nickName.text.toString()
      val name2: String = name.text.toString()
      val name3: String = surname.text.toString()


      if (name3.isNotEmpty() and contact.isNotEmpty() and password.isNotEmpty() and passwordConfirm.isNotEmpty() and name1.isNotEmpty() and name2.isNotEmpty()) {
        if (password == passwordConfirm && contact.length == 10) {
          mainActivity?.replaceFragment(FeedsFragment())
        }
      }
       else if (contact.isEmpty()) {
        phoneNUmber.error = getString(string.error_message)
      } else if (password.isEmpty()) {
        registerPassword.error = getString(string.error_message)
      } else if (passwordConfirm.isEmpty()) {
        registerPasswordConfirm.error = getString(string.error_message)
      } else if (name3.isEmpty()) {
        nickName.error = getString(string.error_message)
      } else if (name1.isEmpty()) {
        name.error = getString(string.error_message)
      } else if (name2.isEmpty()) {
        surname.error = getString(string.error_message)
      }
    }
    userLoginButton.setOnClickListener() {
        mainActivity?.replaceFragment(LoginFragment())
      }

    }

}

