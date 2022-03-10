package co.za.giantpanda.letshike.ui.login_and_register

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
import co.za.giantpanda.letshike.ui.FeedsFragment

class RegisterFragment : Fragment() {

  private var mainActivity: MainActivity? = null
  private var viewModelClass: ViewModelClass? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val registerRepository = RegisterRepository(requireContext())
//    viewModelClass = RegisterViewModelFactory(viewModelClass).create(viewModelClass)

  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    return inflater.inflate(R.layout.fragment_register, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val signIn = view.findViewById<TextView>(R.id.register_button)
    val toLogin = view.findViewById<TextView>(R.id.register_to_log_in_button)

    val phoneNUmber = view.findViewById<EditText>(R.id.register_phone_number_editText)
    val registerPassword = view.findViewById<EditText>(R.id.register_password_editText)
    val registerPasswordConfirm = view.findViewById<EditText>(R.id.register_password_confirm_editText)
    val userName = view.findViewById<EditText>(R.id.register_username_input_Textview)
    val firstName = view.findViewById<EditText>(R.id.register_firstName_input)
    val lastName = view.findViewById<EditText>(R.id.register_lastName_input)


    signIn.setOnClickListener {
      val contact: String = phoneNUmber.text.toString()
      val password: String = registerPassword.text.toString()
      val passwordConfirm: String = registerPasswordConfirm.text.toString()
      val name: String = userName.text.toString()
      val name1: String = firstName.text.toString()
      val name2: String = lastName.text.toString()

      if (name.isNotEmpty() and contact.isNotEmpty() and password.isNotEmpty() and passwordConfirm.isNotEmpty() and name1.isNotEmpty() and name2.isNotEmpty()) {
        if (password == passwordConfirm) {
//          if(name is viewModelClass. ){
//
//          }

          mainActivity?.replaceFragment(FeedsFragment())
        }
      } else if (contact.isEmpty()) {
        phoneNUmber.error = getString(string.error_message)
      } else if (password.isEmpty()) {
        registerPassword.error = getString(string.error_message)
      } else if (passwordConfirm.isEmpty()) {
        registerPasswordConfirm.error = getString(string.error_message)
      } else if (name.isEmpty()) {
        userName.error = getString(string.error_message)
      } else if (name1.isEmpty()) {
        firstName.error = getString(string.error_message)
      } else if (name2.isEmpty()) {
        lastName.error = getString(string.error_message)
      }
    }
      toLogin.setOnClickListener() {
//        val t: FragmentTransaction = this.requireFragmentManager().beginTransaction()
//        val mFrag: Fragment = LoginFragment()
//        t.replace(R.id.fragmentContainer, mFrag)
//        t.commit()

        mainActivity?.replaceFragment(LoginFragment())

      }

    }

  }

