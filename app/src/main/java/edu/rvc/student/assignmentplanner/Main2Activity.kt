package edu.rvc.student.assignmentplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class Main2Activity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnAdd2 = findViewById<Button>(R.id.btnAdd2)
        val txtToday = findViewById<TextView>(R.id.txtDateToday)
        val task1 = findViewById<TextView>(R.id.txtTask1)
        val task2 = findViewById<TextView>(R.id.txtTask2)
        val task3 = findViewById<TextView>(R.id.txtTask3)
        val task4 = findViewById<TextView>(R.id.txtTask4)
        val task5 = findViewById<TextView>(R.id.txtTask5)
        val task6 = findViewById<TextView>(R.id.txtTask6)
        val preferences = getSharedPreferences("data", Context.MODE_PRIVATE)

        var dateTime = LocalDateTime.now()
        txtToday.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        task1.setText(preferences.getString("task1", ""))
        task2.setText(preferences.getString("task2", ""))
        task3.setText(preferences.getString("task3", ""))
        task4.setText(preferences.getString("task4", ""))
        task5.setText(preferences.getString("task5", ""))
        task6.setText(preferences.getString("task6", ""))

        btnMenu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        btnAdd2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        })
        btnNext.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Main5Activity::class.java)
            startActivity(intent)
        })
    }
}

