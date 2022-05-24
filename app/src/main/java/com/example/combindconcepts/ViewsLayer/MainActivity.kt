package com.example.combindconcepts.ViewsLayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.combindconcepts.DataLayer.ShopItems
import com.example.combindconcepts.DataLayer.Shopper
import com.example.combindconcepts.DataLayer.VolleyHandler
import com.example.combindconcepts.PresentLayer.login.LoginMVP
import com.example.combindconcepts.PresentLayer.login.LoginPresent
import com.example.combindconcepts.PresentLayer.register.RegisterMVP
import com.example.combindconcepts.PresentLayer.register.RegisterPresent
import com.example.combindconcepts.R
import com.example.combindconcepts.databinding.ActivityMainBinding
import com.example.combindconcepts.databinding.RegisterDialogBinding

class MainActivity : AppCompatActivity(), LoginMVP.LoginView ,RegisterMVP.RegistrationView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var present: RegisterPresent
    private lateinit var presenter: LoginPresent
    private lateinit var shopItems: ShopItems


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val volleyHandler = VolleyHandler(this@MainActivity)
        present = RegisterPresent(volleyHandler, this)
        presenter = LoginPresent(volleyHandler,this@MainActivity)
        setUpEvents()
        binding.regDialogBtn.setOnClickListener {
            openRegisterDialog()
        }
    }
    override fun onLoad(isLoading: Boolean) {
        binding.apply {
            if (isLoading) {
                spinner.visibility = View.VISIBLE
            } else {
                spinner.visibility = View.GONE
            }
        }
    }

    private fun openRegisterDialog(){
        val dialogBinding: RegisterDialogBinding = RegisterDialogBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(this).apply {
            setView(dialogBinding.root)
            setCancelable(false)
        }

        val dialog = builder.create()
        dialog.window?.setGravity(Gravity.BOTTOM)
        dialogBinding.cancleDialogBtn.setOnClickListener {
            dialog.dismiss()
        }

        dialogBinding.apply {
            registerBtn.setOnClickListener {
                val intent = Intent(this@MainActivity,HomeScreenActivity::class.java)
                startActivity(intent)
                present.registerUser(
                    Shopper(
                        username.text.toString(),
                        phone.text.toString(),
                        email.text.toString(),
                        password.text.toString()
                    )
                )
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.sucess),
                    Toast.LENGTH_SHORT
                ).show()
                dialog.dismiss()
            }
        }
        dialog.show()

        val params = dialog.window?.attributes
        params?.height = WindowManager.LayoutParams.MATCH_PARENT
        params?.width = WindowManager.LayoutParams.MATCH_PARENT
        dialog.window?.attributes = params
    }

    override fun setResult(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        binding.apply {
            email.text!!.clear()
            password.text!!.clear()
        }
    }

    private fun setUpEvents() {
        binding.apply {
            logBtn.setOnClickListener {
                presenter.logUserIn(
                    email.text.toString(),
                    password.text.toString()
                )
                startActivity(Intent(this@MainActivity,HomeScreenActivity::class.java))
                Toast.makeText(
                    this@MainActivity,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }





}