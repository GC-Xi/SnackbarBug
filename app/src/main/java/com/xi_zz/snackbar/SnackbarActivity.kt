package com.xi_zz.snackbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_snackbar.*

class SnackbarActivity : AppCompatActivity() {

    companion object {
        fun start(ctx: Context) {
            Intent(ctx, SnackbarActivity::class.java).also {
                ctx.startActivity(it)
            }
        }
    }

    private lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        toggleSnackbarBtn.setOnClickListener {
            if (!::snackbar.isInitialized)
                snackbar = Snackbar.make(rootLayout, "Hello Snackbar", Snackbar.LENGTH_INDEFINITE)

            if (snackbar.isShown)
                snackbar.dismiss()
            else
                snackbar.show()
        }
    }
}

