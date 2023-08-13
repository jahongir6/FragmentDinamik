package com.example.fragmentstatik_and_dinamik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentstatik_and_dinamik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var blankFragment: BlankFragment
    private lateinit var blankFragment2: BlankFragment2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentManager = supportFragmentManager
        blankFragment = BlankFragment()
        blankFragment2 = BlankFragment2()
        binding.apply {
            btnAdd.setOnClickListener {
                fragmentManager.beginTransaction()
                    .add(R.id.my_container, blankFragment)
                    .commit()
            }
            btnRemove.setOnClickListener {
                fragmentManager.beginTransaction()
                    .remove(blankFragment)
                    .commit()
            }
            btnReplase.setOnClickListener {
                fragmentManager.beginTransaction()
                    .replace(R.id.my_container,blankFragment2)
                    .addToBackStack(blankFragment2.toString())
                    .commit()
            }
            btnHide.setOnClickListener {
                fragmentManager.beginTransaction()
                    .hide(blankFragment)
                    .commit()
            }
            btnShow.setOnClickListener {
                fragmentManager.beginTransaction()
                    .show(blankFragment)
                    .commit()
            }
        }

    }
    /*statik holati activitini fragment orqali 2 ga bolib uni bacground ti boshqa boshqa bolishi
   deb misol keltirgan domla*/

    /*dinamik holatda yasash
    * Transaction metodlar
    * add()->activity ga fragment qoshish
    * remove()->activity dan fragment ochiradi
    * replase()->bir fragmentni boshqasi bilan alishtiradi
    * hide()->fragmenti yashiradi
    * show()->yashirin fragmentni namoyish etadi
    * commit()->operatsiyani bajarish jadvalini tuzadi
    * addToBackStack()->ushbu operatsiyani orqa stekka qoshadi
    * */
}