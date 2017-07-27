package me.dmdev.rxpm.android.support

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import me.dmdev.rxpm.PmView
import me.dmdev.rxpm.PresentationModel

/**
 * @author Dmitriy Gorbunov
 */
abstract class PmAppCompatActivity<out PM : PresentationModel> : AppCompatActivity(), PmView<PM> {

    private lateinit var delegate: PmAppCompatActivityDelegate<PM>
    final override val compositeDisposable = CompositeDisposable()

    final override val pm get() = delegate.pm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        delegate = PmAppCompatActivityDelegate(this, this)
        delegate.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        delegate.onStart()
    }

    override fun onResume() {
        super.onResume()
        delegate.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        delegate.onSaveInstanceState(outState)
    }

    override fun onPause() {
        super.onPause()
        delegate.onPause()
    }

    override fun onStop() {
        super.onStop()
        delegate.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        delegate.onDestroy()
    }
}