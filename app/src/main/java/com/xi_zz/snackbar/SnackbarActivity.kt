package com.xi_zz.snackbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
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

        snackbar = Snackbar.make(rootLayout, "Hello Snackbar", Snackbar.LENGTH_INDEFINITE)

        toggleSnackbarBtn.setOnClickListener {
            if (snackbar.isShown)
                snackbar.dismiss()
            else
                snackbar.show()
        }
    }
}

