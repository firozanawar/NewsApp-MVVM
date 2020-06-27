package com.firozanwar.newsapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.firozanwar.newsapp.NewsActivity
import com.firozanwar.newsapp.R

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ((activity) as NewsActivity).viewModel
    }
}