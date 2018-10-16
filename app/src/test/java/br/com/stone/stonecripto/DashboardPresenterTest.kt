package br.com.stone.stonecripto

import br.com.stone.stonecripto.dashboard.DashboardContract
import br.com.stone.stonecripto.dashboard.DashboardPresenter
import br.com.stone.stonecripto.manager.UserManager
import br.com.stone.stonecripto.manager.UserRepository
import io.realm.Realm
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import io.realm.RealmConfiguration



class DashboardPresenterTest {
    @Mock lateinit var view: DashboardContract.View
    @Mock lateinit var userManager: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun buyFieldIsEmpty() {
        val presenter = DashboardPresenter(view, userManager)
        presenter.clickBuy("")
        Mockito.verify(view).showAlert("Falha na compra", "Digite um valor a ser comprado")
    }

    @Test
    fun sellFieldIsEmpty() {
        val presenter = DashboardPresenter(view, userManager)
        presenter.clickSell("")
        Mockito.verify(view).showAlert("Falha na venda", "Digite um valor a ser vendido")
    }
}