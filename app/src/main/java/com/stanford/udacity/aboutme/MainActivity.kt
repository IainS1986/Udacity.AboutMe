package com.stanford.udacity.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hook up done button
        findViewById<Button>(R.id.doneButton).setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(button: View) {
        val editText = findViewById<EditText>(R.id.nicknameEdit)
        val nicknameText = findViewById<TextView>(R.id.nicknameText)

        nicknameText.text = editText.text
        editText.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE
        button.visibility = View.GONE

        // HideKeyboard (Util class?)
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(button.windowToken, 0)
    }
}
