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
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class Main5Activity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnNext2 = findViewById<Button>(R.id.btnNext2)
        val btnAdd3 = findViewById<Button>(R.id.btnAdd3)
        val txtTomorrow = findViewById<TextView>(R.id.txtDateTomorrow)
        val task7 = findViewById<TextView>(R.id.txtTask7)
        val task8 = findViewById<TextView>(R.id.txtTask8)
        val task9 = findViewById<TextView>(R.id.txtTask9)
        val task10 = findViewById<TextView>(R.id.txtTask10)
        val task11 = findViewById<TextView>(R.id.txtTask11)
        val task12 = findViewById<TextView>(R.id.txtTask12)
        val preferences = getSharedPreferences ("data", Context.MODE_PRIVATE)

        var dateTime = LocalDateTime.now()
        dateTime += Period.ofDays(1)
        txtTomorrow.text = dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        task7.setText(preferences.getString ("task7", ""))
        task8.setText(preferences.getString ("task8", ""))
        task9.setText(preferences.getString ("task9", ""))
        task10.setText(preferences.getString ("task10", ""))
        task11.setText(preferences.getString ("task11", ""))
        task12.setText(preferences.getString ("task12", ""))

        btnNext2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        btnAdd3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        })
        btnBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        })
    }
}
