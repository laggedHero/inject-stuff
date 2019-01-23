package com.example.myapplication.main

import com.example.myapplication.stuff.Dialogs
import com.example.myapplication.stuff.Navigator
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class MainFragmentPresenterTest {

    @Mock
    lateinit var navigator: Navigator
    @Mock
    lateinit var dialogs: Dialogs

    private lateinit var presenter: MainFragmentContract.Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainFragmentPresenter(navigator, dialogs)
    }

    @Test
    fun `should tell view to show message on load`() {
        val view = mock(MainFragmentContract.View::class.java)
        presenter.bind(view)

        presenter.load()

        verify(view, times(1))
            .show(anyString())
        verifyNoMoreInteractions(view)
    }

    @Test
    fun `should navigate to next screen`() {
        presenter.onNextScreen()

        verify(navigator, times(1))
            .showAnotherScreen()
        verifyNoMoreInteractions(navigator)
    }

    @Test
    fun `should show short lived message`() {
        presenter.onEphemeral()

        verify(dialogs, times(1))
            .showEphemeral(anyString())
        verifyNoMoreInteractions(dialogs)
    }

    @Test
    fun `should show long lived message`() {
        presenter.onNonEphemeral()

        verify(dialogs, times(1))
            .showNonEphemeral(anyString())
        verifyNoMoreInteractions(dialogs)
    }
}