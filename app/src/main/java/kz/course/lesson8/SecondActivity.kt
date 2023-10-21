package kz.course.lesson8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var btnFirstActivity: Button
    private lateinit var btnThirdActivity: Button
    private lateinit var quoteTextview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initViews()
        initListeners()
    }

    private fun initViews() {
        btnThirdActivity = findViewById(R.id.btnThirdActivity)
        btnFirstActivity = findViewById(R.id.btnFirstActivity)
        quoteTextview = findViewById(R.id.quoteTextview)
        quoteTextview.text = intent.getStringExtra(SECOND_ACTIVITY_EXTRA)
    }

    companion object {
        const val SECOND_ACTIVITY_EXTRA = "Second Activity Extra"
    }

    private fun initListeners() {
        btnFirstActivity.setOnClickListener {
            goToFirstActivity()
        }

        btnThirdActivity.setOnClickListener() {
            goToThirdActivity()
        }

    }

    private fun goToFirstActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun goToThirdActivity() {
        val intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra(
            ThirdActivity.THIRD_ACTIVITY_EXTRA,
            resources.getText(R.string.textView_quote)
        )
        startActivity(intent)
    }
}