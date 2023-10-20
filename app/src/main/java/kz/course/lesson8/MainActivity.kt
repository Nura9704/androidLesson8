package kz.course.lesson8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import kz.course.lesson8.SecondActivity.Companion.SECOND_ACTIVITY_EXTRA
import kz.course.lesson8.ThirdActivity.Companion.THIRD_ACTIVITY_EXTRA

class MainActivity : AppCompatActivity() {

    private lateinit var btnSetStyleRed: Button
    private lateinit var btnSetStyleBlue: Button
    private lateinit var btnSecondActivity: Button
    private lateinit var btnThirdActivity: Button
    private lateinit var firstMainTextview: TextView
    private lateinit var secondMainTextview: TextView
    private lateinit var quoteTextview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListeners()
    }

    private fun initViews() {
        btnSetStyleRed = findViewById(R.id.btnSetStyleRed)
        btnSetStyleBlue = findViewById(R.id.btnSetStyleBlue)
        btnSecondActivity = findViewById(R.id.btnSecondActivity)
        btnThirdActivity = findViewById(R.id.btnThirdActivity)
        firstMainTextview = findViewById(R.id.firstMainTextview)
        secondMainTextview = findViewById(R.id.secondMainTextview)
        quoteTextview = findViewById(R.id.quoteTextview)
    }

    private fun initListeners() {
        btnSetStyleRed.setOnClickListener {
            makeStyleRed()
        }

        btnSetStyleBlue.setOnClickListener {
            makeStyleBlue()
        }

        btnSecondActivity.setOnClickListener {
            goToSecondActivity()
        }

        btnThirdActivity.setOnClickListener {
            goToThirdActivity()
        }
    }

    private fun makeStyleRed() {
        TextViewCompat.setTextAppearance(firstMainTextview, R.style.style_red)
        TextViewCompat.setTextAppearance(secondMainTextview, R.style.style_red)
    }

    private fun makeStyleBlue() {
        TextViewCompat.setTextAppearance(firstMainTextview, R.style.style_blue)
        TextViewCompat.setTextAppearance(secondMainTextview, R.style.style_blue)
    }

    private fun goToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SECOND_ACTIVITY_EXTRA, resources.getText(R.string.textView_quote))
        startActivity(intent)
    }

    private fun goToThirdActivity() {
        val intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra(THIRD_ACTIVITY_EXTRA, resources.getText(R.string.textView_quote))
        startActivity(intent)
    }
}