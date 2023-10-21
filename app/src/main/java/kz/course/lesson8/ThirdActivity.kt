package kz.course.lesson8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    private lateinit var btnFirstActivity: Button
    private lateinit var btnSecondActivity: Button
    private lateinit var btnSetImage: Button
    private lateinit var quoteTextview: TextView
    private lateinit var quoteImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        initViews()
        initListeners()
    }

    private fun initViews() {
        btnFirstActivity = findViewById(R.id.btnFirstActivity)
        btnSecondActivity = findViewById(R.id.btnSecondActivity)
        btnSetImage = findViewById(R.id.btnSetImage)
        quoteImage = findViewById(R.id.quoteImageView)
        quoteTextview = findViewById(R.id.quoteTextview)
        quoteTextview.text = intent.getStringExtra(THIRD_ACTIVITY_EXTRA)
    }

    private fun initListeners() {
        btnFirstActivity.setOnClickListener {
            goToFirstActivity()
        }

        btnSecondActivity.setOnClickListener {
            goToSecondActivity()
        }

        btnSetImage.setOnClickListener {
            showImage()
        }
    }

    private fun goToFirstActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun goToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.SECOND_ACTIVITY_EXTRA,
            resources.getText(R.string.textView_quote)
        )
        startActivity(intent)
    }

    private fun showImage() {
        quoteImage.setBackgroundResource(R.drawable.statham_quote)
    }

    companion object {
        const val THIRD_ACTIVITY_EXTRA = "Third Activity Extra"
    }
}