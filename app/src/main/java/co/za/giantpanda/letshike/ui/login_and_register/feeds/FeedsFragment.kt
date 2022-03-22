package co.za.giantpanda.letshike.ui.login_and_register.feeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import co.za.giantpanda.letshike.R
import co.za.giantpanda.letshike.ui.login_and_register.login.LoginFragment

class FeedsFragment : Fragment() {


  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_feeds, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

   var logout = view.findViewById<Button>(R.id.register_button)

    logout.setOnClickListener{

      val fr = parentFragmentManager.beginTransaction()
      fr.replace(R.id.fragmentContainer, LoginFragment())
      fr.commit()

    }

  }
}