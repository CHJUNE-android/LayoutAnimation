package com.example.animationexercise

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.animationexercise.recycler.Poster
import com.skydoves.transformationlayout.TransformationLayout
import com.skydoves.transformationlayout.onTransformationEndContainer
import kotlinx.android.synthetic.main.activity_detail2.*

class Detail2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationEndContainer(intent.getParcelableExtra(parmasName))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)
        init()
    }
    private fun init(){
        intent.getParcelableExtra<Poster>(posterName)?.let {
            Glide.with(this).load(it.poster).into(imageView2)
        }
    }

    companion object {
        const val parmasName = "parmasName"
        const val posterName = "posterName"
        fun startActivity(
            context: Context,
            transformationLayout: TransformationLayout,
            poster: Poster
        ) {
            if (context is Activity) {
                val bundle = transformationLayout.withView(transformationLayout, poster.name)
                val intent = Intent(context, Detail2Activity::class.java)
                intent.putExtra(parmasName, transformationLayout.getParcelableParams())
                intent.putExtra(posterName, poster)
                context.startActivity(intent, bundle)
            }
        }
    }
}
