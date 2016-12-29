package com.github.okwrtdsh.mailtest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import butterknife.bindView

class Test2Activity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
    /*
     * OnTouchListener(Down)
     * OnLongClickListener
     * OnTouchListener(Up)
     * OnClickListener
     */

    val buttonSend: Button by bindView(R.id.button_send)
    val editText: EditText by bindView(R.id.edit_text)

    private fun send(text: String): Unit = Intent(Intent.ACTION_SEND, Uri.parse("mailto:"))
        .setType("text/plain")
        .putExtra(Intent.EXTRA_EMAIL, arrayOf(resources.getString(R.string.mail_to)))
        .putExtra(Intent.EXTRA_SUBJECT, editText.text.toString())
        .putExtra(Intent.EXTRA_TEXT, text)
        .let { startActivity(Intent.createChooser(it, "Send mail...")) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        buttonSend.setOnClickListener(this)
        buttonSend.setOnLongClickListener(this)
    }

    override fun onClick(v: View?) {
        send("Click!!")
    }

    override fun onLongClick(v: View?): Boolean {
        send("LongClick!!")
        return true // false: call onClick
    }
}
