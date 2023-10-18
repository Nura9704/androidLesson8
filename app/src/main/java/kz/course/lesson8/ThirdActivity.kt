package kz.course.androidlesson8

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kz.course.lesson8.R


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
        changeActivity()
        setImage()
    }

    private fun initViews() {
        btnFirstActivity = findViewById(R.id.btnFirstActivity)
        btnSecondActivity = findViewById(R.id.btnSecondActivity)
        quoteTextview = findViewById(R.id.quoteTextview)
        quoteTextview.text = intent.getStringExtra(THIRD_ACTIVITY_KEY)
    }

    //change Activities when click Buttons
    private fun changeActivity() {
        btnFirstActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(
                SecondActivity.SECOND_ACTIVITY_KEY,
                resources.getText(R.string.textView_quote)
            )
            startActivity(intent)
        }
    }

    //set Image to ImageView when click Button
    private fun setImage() {
        btnSetImage = findViewById(R.id.btnSetImage)
        quoteImage = findViewById(R.id.quoteImageView)
        btnSetImage.setOnClickListener {
            quoteImage.setBackgroundResource(R.drawable.statham_quote)
        }
    }

    companion object {
        const val THIRD_ACTIVITY_KEY = ""
    }
}