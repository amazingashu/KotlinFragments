package com.acrony.kotlinfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
     var IsFragmentLoader=true

    val manager=supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val FragmentChanger=findViewById<Button>(R.id.btnChange)

        DisplayFragmentOne()

        FragmentChanger.setOnClickListener {
            if(IsFragmentLoader)
                DisplayFragmentTwo()
            else
                DisplayFragmentOne()
        }
    }

   fun DisplayFragmentOne()
   {
       val transaction=manager.beginTransaction()
       val fragment=Frag_One()
       transaction.replace(R.id.FragHolder,fragment)
       transaction.addToBackStack(null)
       transaction.commit()
       IsFragmentLoader=true
   }

    fun DisplayFragmentTwo()
    {
        val transaction=manager.beginTransaction()
        val fragment=Frag_Two()
        transaction.replace(R.id.FragHolder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        IsFragmentLoader=false
    }
}
