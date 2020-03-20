package com.example.animationexercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.animationexercise.recycler.Poster
import kotlinx.android.synthetic.main.activity_example.*

class ExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        init()
    }
    private fun init(){
        Glide.with(this).load("https://cdn.pixabay.com/photo/2020/03/14/11/22/ace-frame-4930290__340.png").into(imageView)
        imageView.setOnClickListener {
            Detail2Activity.startActivity(this,
                transformLayout1,
                Poster(
                    name = "s",
                    description = "dd",
                    poster = "https://cdn.pixabay.com/photo/2020/03/14/11/22/ace-frame-4930290__340.png",
                    release = "df",
                    playtime = "ds"
                ))
        }
    }
}
