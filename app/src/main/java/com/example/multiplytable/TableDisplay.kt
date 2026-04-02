package com.example.multiplytable

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TableDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_display)

        //assigning data from main page to variables
        val bundle: Bundle? = intent.extras
        //getting the number entered by the user as a string
        val tableString: String? = bundle?.getString("tableNumber")
        //converting the string back into a number ready for multiplication
        val tableNumber = tableString!!.toInt()
        val multiplyTable = findViewById<TextView>(R.id.tableDisplayTxt)
        var timesDisplay: String = "$tableNumber x tables\n\n"

        //Creating counter for while loop
        var count = 1

        //displaying the number the user entered on the second page next to the text "x tables"
        multiplyTable.text = timesDisplay

        while (count <= 10){

            //Adding a continue
            if (count == 4){
                count++
                continue
            }

            //example: user enters 5 and count is 1 SO: 5 x 1 = 5 (answer)
            val answer = tableNumber * count
                /*displays as:
                5 x tables

                5 x 1 = 5
                */
            timesDisplay += "$tableNumber x $count = ${answer}\n"
            //increasing the count
            count++
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}