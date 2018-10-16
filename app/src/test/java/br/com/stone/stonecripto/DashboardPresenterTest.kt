package br.com.stone.stonecripto

import br.com.stone.stonecripto.dashboard.DashboardContract
import br.com.stone.stonecripto.dashboard.DashboardPresenter
import br.com.stone.stonecripto.manager.CoinRepository
import br.com.stone.stonecripto.manager.UserManager
import br.com.stone.stonecripto.manager.UserRepository
import br.com.stone.stonecripto.model.CoinType
import io.realm.Realm
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations



class DashboardPresenterTest {
    @Mock lateinit var view: DashboardContract.View
    @Mock lateinit var userManager: UserRepository
    @Mock lateinit var coinManager: CoinRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun buyFieldIsEmpty() {
        val presenter = DashboardPresenter(view, userManager, coinManager)
        presenter.clickBuy("")
        Mockito.verify(view).showAlert("Falha na compra", "Digite um valor a ser comprado")
    }

    @Test
    fun buyWithAmountInvalid() {
        Mockito.`when`(coinManager.getBalance(CoinType.BTC)).thenReturn(0.0)

        val presenter = DashboardPresenter(view, userManager, coinManager)
        presenter.clickBuy("10")
        Mockito.verify(view).showAlert("Falha na compra", "Você não possui saldo para fazer essa operação")
    }

    @Test
    fun buyWithAmountValid() {
        Mockito.`when`(coinManager.buyCoin(CoinType.BTC, 10.0)).thenReturn(true)

        val presenter = DashboardPresenter(view, userManager, coinManager)
        presenter.clickBuy("10.0")
        Mockito.verify(view).showAlert("Compra realizada", "Compra realizada com sucesso")
    }

    @Test
    fun sellFieldIsEmpty() {
        val presenter = DashboardPresenter(view, userManager, coinManager)
        presenter.clickSell("")
        Mockito.verify(view).showAlert("Falha na venda", "Digite um valor a ser vendido")
    }
}