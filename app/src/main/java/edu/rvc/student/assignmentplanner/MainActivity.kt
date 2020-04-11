package edu.rvc.student.assignmentplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //bind objects
        val btnCal = findViewById<Button>(R.id.btnCalendar)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnCal.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        })
        btnAdd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        })
        btnSearch.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Main4Activity::class.java)
            startActivity(intent)
        })
        btnExit.setOnClickListener(View.OnClickListener {
            this.finish()
        })
    }
}

