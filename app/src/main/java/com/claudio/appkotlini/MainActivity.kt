package com.claudio.appkotlini

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var btOk: Button
    private lateinit var tvName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edtName)
        btOk = findViewById(R.id.btOk)
        tvName = findViewById(R.id.tvName)

        btOk.setOnClickListener {
            var name = edtName.text.toString().trim()
            if(name.isEmpty()) {
                Toast.makeText(this, "Preencha o campo", Toast.LENGTH_LONG).show()
            } else {
                System.out.println("Cliquei no botao OK")
                println("Clique no botao")
                //var name = edtName.text.toString()
                tvName.text = name
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("keyName", name)
                startActivity(intent)
            }

        }
    }
}