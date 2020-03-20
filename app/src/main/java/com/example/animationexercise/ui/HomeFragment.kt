package com.example.animationexercise.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.animationexercise.ui.MockUtil.getMockPosters
import com.example.animationexercise.R
import com.example.animationexercise.recycler.PosterAdapter
import com.example.animationexercise.recycler.PosterMenuAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = PosterAdapter()
            .apply { addPosterList(getMockPosters()) }
        recyclerView_menu.adapter = PosterMenuAdapter()
            .apply { addPosterList(getMockPosters()) }

        fab.setOnClickListener {
            if (!transformationLayout.isTransforming) {
                backgroundView.visibility = View.VISIBLE
            }
            transformationLayout.startTransform()
        }

        menu_home.setOnClickListener {
            if (!transformationLayout.isTransforming) {
                backgroundView.visibility = View.GONE
            }
            transformationLayout.finishTransform()
            Toast.makeText(context, "Compose New", Toast.LENGTH_SHORT).show()
        }
    }
}