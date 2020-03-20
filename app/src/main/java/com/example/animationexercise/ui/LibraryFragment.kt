package com.example.animationexercise.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.animationexercise.ui.MockUtil.getMockPosters
import com.example.animationexercise.R
import com.example.animationexercise.recycler.PosterLineAdapter
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = PosterLineAdapter()
            .apply { addPosterList(getMockPosters()) }

        fab.setOnClickListener {
            transformationLayout.startTransform()
        }

        menu_card.setOnClickListener {
            transformationLayout.finishTransform()
            Toast.makeText(context, "Play", Toast.LENGTH_SHORT).show()
        }
    }
}