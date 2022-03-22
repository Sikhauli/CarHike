package co.za.giantpanda.letshike.ui.login_and_register.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.za.giantpanda.letshike.R
import co.za.giantpanda.letshike.R.string
import co.za.giantpanda.letshike.db.entity.RegisterEntity
import co.za.giantpanda.letshike.mvvm.factory.AuthViewModelFactory
import co.za.giantpanda.letshike.mvvm.model.AuthModel
import co.za.giantpanda.letshike.mvvm.repository.RegisterRepository
import co.za.giantpanda.letshike.ui.login_and_register.feeds.FeedsFragment
import co.za.giantpanda.letshike.ui.login_and_register.login.LoginFragment

open class RegisterFragment : Fragment() {

  private val register: RegisterEntity? = null
  private var authModel: AuthModel? = null


  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    val registerRepository = RegisterRepository()
    authModel = AuthViewModelFactory(registerRepository).create(AuthModel::class.java)

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

      if (phoneNUmber.length() != 10 || registerPassword.length() < 5 || registerPasswordConfirm.length() < 5
          || nickName.length() < 2 || name.length() < 1 || surname.length() < 1 ) {

        phoneNUmber.error = getString(string.phone_number_error)
        registerPassword.error = getString(string.error_message)
        registerPasswordConfirm.error = getString(string.error_message)
        nickName.error = getString(string.error_message)
        name.error = getString(string.error_message)
        surname.error = getString(string.error_message)
      }

        else {
        Toast.makeText(requireContext(),"else here", Toast.LENGTH_LONG).show()

        if(registerPassword.text.toString() == registerPasswordConfirm.text.toString()){

            Toast.makeText(requireContext(),"Password Pass", Toast.LENGTH_LONG).show()

            register?.confirmPassword = registerPasswordConfirm.text.toString()
            register?.cellPhone = phoneNUmber.text.toString().toInt()
            register?.password = registerPassword.text.toString()
            register?.userName = nickName.text.toString()
            register?.firstName = name.text.toString()
            register?.lastName = surname.text.toString()
            authModel?.insertUserDetail(register)
            registerPassword.setText("")
            nickName.setText("")
            name.setText("")
            surname.setText("")
            phoneNUmber.setText("")
            Toast.makeText(requireContext(),"Saved to DB", Toast.LENGTH_LONG).show()

            val fr = parentFragmentManager.beginTransaction()
            fr.replace(R.id.fragmentContainer, FeedsFragment())
            fr.commit()


          }
        }
      }
    userLoginButton.setOnClickListener{
      Toast.makeText(requireContext(),"button to LoginFragment", Toast.LENGTH_LONG).show()

      val fr = parentFragmentManager.beginTransaction()
      fr.replace(R.id.fragmentContainer, LoginFragment())
      fr.commit()
    }
  }
}
