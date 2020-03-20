package com.example.animationexercise.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.animationexercise.R
import com.example.animationexercise.recycler.PosterCircleAdapter
import kotlinx.android.synthetic.main.fragment_radio.*

class RadioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = PosterCircleAdapter()
            .apply { addPosterList(MockUtil.getMockPosters()) }

        fab.setOnClickListener {
            DetailActivity.startActivity(requireContext(), transformationLayout_fab,
                MockUtil.getMockPoster())
        }
    }
}
