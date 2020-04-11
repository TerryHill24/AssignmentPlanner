package edu.rvc.student.assignmentplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btnBack = findViewById<Button>(R.id.btnMainMenu)
        val button1 = findViewById <Button>(R.id.btnAddTo)
        val txtTemp = findViewById<TextView>(R.id.txtTemp)
        val txtAssign = findViewById<EditText>(R.id.txtAssign)
        val txtCourse = findViewById<EditText>(R.id.txtCourse)
        var rbToday = findViewById<RadioButton>(R.id.rbToday)
        var rbTomorrow = findViewById<RadioButton>(R.id.rbTomorrow)

        val preferences = getSharedPreferences ("data", Context.MODE_PRIVATE)

        button1.setOnClickListener {
            val editor = preferences.edit()

            if (rbToday.isChecked){

                txtTemp.setText(preferences.getString("task1", ""))
            if (txtTemp.text == "") {
                editor.putString("task1", txtCourse.text.toString())
                editor.putString("task2", txtAssign.text.toString())
                editor.commit()
            } else {
                txtTemp.setText(preferences.getString("task3", ""))
                if (txtTemp.text == "") {
                    editor.putString("task3", txtCourse.text.toString())
                    editor.putString("task4", txtAssign.text.toString())
                    editor.commit()
                } else {
                    txtTemp.setText(preferences.getString("task5", ""))
                    if (txtTemp.text == "") {
                        editor.putString("task5", txtCourse.text.toString())
                        editor.putString("task6", txtAssign.text.toString())
                        editor.commit()
                    }
                }
            }
                //Intent is used to send data between activities
                val intent = Intent(this, Main2Activity::class.java)
                //Go to second activity
                startActivity(intent)
        }

            if (rbTomorrow.isChecked) {

                txtTemp.setText(preferences.getString("task7", ""))
                if (txtTemp.text == "") {
                    editor.putString("task7", txtCourse.text.toString())
                    editor.putString("task8", txtAssign.text.toString())
                    editor.commit()
                } else {
                    txtTemp.setText(preferences.getString("task9", ""))
                    if (txtTemp.text == "") {
                        editor.putString("task9", txtCourse.text.toString())
                        editor.putString("task10", txtAssign.text.toString())
                        editor.commit()
                    } else {
                        txtTemp.setText(preferences.getString("task11", ""))
                        if (txtTemp.text == "") {
                            editor.putString("task11", txtCourse.text.toString())
                            editor.putString("task12", txtAssign.text.toString())
                            editor.commit()
                        }
                    }
                }
                //Intent is used to send data between activities
                val intent = Intent(this, Main5Activity::class.java)
                //Go to next activity
                startActivity(intent)
            }
        }

        btnBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        //Fire hidekeyboard when user taps outside any text object
//Place below code right before last right bracket in function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }
    }

    //function to hide keyboard goes right before the last right bracket of Class MainActivity
//should auto import android.content.Context
//should auto add import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}
