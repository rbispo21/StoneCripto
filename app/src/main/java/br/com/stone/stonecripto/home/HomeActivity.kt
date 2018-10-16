package br.com.stone.stonecripto.home

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.stone.stonecripto.R
import br.com.stone.stonecripto.di.component.DaggerHomeComponent
import br.com.stone.stonecripto.di.module.HomeModule
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeContract.View {
    @Inject lateinit var presenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerHomeComponent.builder().homeModule(HomeModule(this)).build().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onResume() {
        super.onResume()
        presenter.create()
    }

    override fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_dashboard -> {
                presenter.clickDashboard()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                presenter.clickHistory()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
