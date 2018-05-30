package net.johnmo.datepicker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.johnmo.datepicker.R.id.*
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calendar = Calendar.getInstance()

        val thisYear = calendar.get(Calendar.YEAR)
        val month    = calendar.get(Calendar.MONTH)
        val day      = calendar.get(Calendar.DAY_OF_MONTH)
        val date     = calendar.get(Calendar.DATE)


        submit.setOnClickListener{
            // Get the date picker widget selected date
            val selectedDate = formatDate(date_picker.year,date_picker.month,date_picker.dayOfMonth)
            // Display the date picker selected formatted date
            date_text.text = "Selected Date : $selectedDate"
        }


    }

    private fun formatDate(year: Int, month: Int, day: Int):String{
        // Create a Date variable/object with user chosen date
        calendar.set(year, month, day,0, 0, 0)
        val chosenDate = calendar.time


        // Format the date picker selected date
        val df = DateFormat.getDateInstance(DateFormat.DATE_FIELD)
        return df.format(chosenDate)
    }

}

