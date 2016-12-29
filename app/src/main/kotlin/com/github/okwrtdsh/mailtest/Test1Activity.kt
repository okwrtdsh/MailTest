package com.github.okwrtdsh.mailtest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import butterknife.bindView


class Test1Activity : AppCompatActivity() {
    val buttonSend: Button by bindView(R.id.button_send)
    val radioGroup: RadioGroup by bindView(R.id.radio_group)
    val editText: EditText by bindView(R.id.edit_text)

    private fun checkedRadioButtonString(checkedRadioButtonId: Int): String {
        val checkedRadioButton = findViewById(checkedRadioButtonId) as RadioButton
        return checkedRadioButton.text.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)

        buttonSend.setOnClickListener {
            Intent(Intent.ACTION_SEND, Uri.parse("mailto:"))
                .setType("text/plain")
                .putExtra(Intent.EXTRA_EMAIL, arrayOf(resources.getString(R.string.mail_to)))
                .putExtra(Intent.EXTRA_SUBJECT, editText.text.toString())
                .putExtra(Intent.EXTRA_TEXT, checkedRadioButtonString(radioGroup.checkedRadioButtonId))
                .let { startActivity(Intent.createChooser(it, "Send mail...")) }
        }
    }
}
