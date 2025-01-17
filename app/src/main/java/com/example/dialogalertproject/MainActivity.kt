package com.example.dialogalertproject

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogalertproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.clickBtn.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Want Calculation")
                setMessage("Additon & Subtraction of Same Number")
                setPositiveButton("Add") { _, _ ->
                    val valu =
                        (binding.txtArea.text.toString().toInt() + binding.txtArea.text.toString()
                            .toInt()).toString()
                    binding.txtArea.setText(valu)
                }
                setNegativeButton("Sub") { _, _ ->
                    val valu1 =
                        (binding.txtArea.text.toString().toInt() - binding.txtArea.text.toString()
                            .toInt()).toString()
                    binding.txtArea.setText(valu1)
                }
                setNeutralButton("Reset") { _, _ ->
                    binding.txtArea.setText("0")
                }
                setCancelable(false)
                show()
            }
        }

        binding.layoutBtn.setOnClickListener {
            Dialog(this).apply {
                setContentView(R.layout.temp_layout)
                val add = findViewById<Button>(R.id.addBtn)
                val sub = findViewById<Button>(R.id.asubBtn)
                val mul = findViewById<Button>(R.id.multBtn)
                val div = findViewById<Button>(R.id.divBtn)
                val cancle = findViewById<Button>(R.id.cancleBtn)
                val txt = findViewById<TextView>(R.id.txtArea1)

                window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                show()
                add.setOnClickListener {
                    val variable = (txt.text.toString().toInt() + 2).toString()
                    txt.text = variable
                }
                sub.setOnClickListener {
                    val variable = (txt.text.toString().toInt() - 2).toString()
                    txt.text = variable
                }
                mul.setOnClickListener {
                    val variable = (txt.text.toString().toInt() * 2).toString()
                    txt.text = variable
                }
                div.setOnClickListener {
                    val variable = (txt.text.toString().toInt() / 2).toString()
                    txt.text = variable
                }
                cancle.setOnClickListener {
                    txt.text = "0"
                    dismiss()
                }
            }
        }

        binding.designpage.setOnClickListener {
            val intent = Intent(this, UiActivity::class.java)
            startActivity(intent)
            finish()
            }

    }
}
