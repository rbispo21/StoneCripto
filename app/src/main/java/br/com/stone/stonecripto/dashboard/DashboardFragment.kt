package br.com.stone.stonecripto.dashboard

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import br.com.stone.stonecripto.R
import br.com.stone.stonecripto.di.component.DaggerDashboardComponent
import br.com.stone.stonecripto.di.module.DashboardModule
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


class DashboardFragment : Fragment(), DashboardContract.View {
    @Inject lateinit var presenter: DashboardContract.Presenter

    companion object {
        @JvmStatic
        fun newInstance() =
            DashboardFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerDashboardComponent.builder()
            .dashboardModule(DashboardModule(this))
            .build().inject(this)
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onResume() {
        super.onResume()
        configuteTitle()
        configureButton()
        presenter.load()
    }

    fun configuteTitle() {
        (activity as AppCompatActivity).supportActionBar?.title = "Dashboard"
    }

    fun configureButton() {
        btnBuy.setOnClickListener {
            presenter.clickBuy(edtAmountBuy.text.toString())
        }

        btnSell.setOnClickListener {
            presenter.clickSell(edtAmountSell.text.toString())
        }

        btnChangeCoin.setOnClickListener {
            presenter.clickChangeCoin()
        }
    }

    override fun setFriendlyMessage(text: String) {
        txtFriendlyMessage.text = text
    }

    override fun setBalanceReal(text: String) {
        txtBalance.text = text
    }

    override fun setBalanceCripto(text: String) {
        txtBalanceCripto.text = text
    }

    override fun setPriceBuy(text: String) {
        txtPriceBuy.text = text
    }

    override fun setPriceSell(text: String) {
        txtPriceSeller.text = text
    }

    override fun setNameCoin(text: String) {
        txtCoin.text = text
    }

    override fun hideKeyboard() {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    override fun showAlert(title: String, message: String) {
        val alert = AlertDialog.Builder(context, R.style.AlertDialogTheme)
        alert.setTitle(title)
        alert.setMessage(message)
        alert.setNeutralButton("Fechar", null)
        alert.show()
    }

    override fun clearEdit() {
        edtAmountBuy.setText("")
        edtAmountSell.setText("")
    }
}
