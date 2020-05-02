package com.example.tinnews.ui.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinnews.R;
import com.example.tinnews.databinding.FragmentSavedNewsDetailBinding;
import com.example.tinnews.model.Article;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedNewsDetailFragment extends Fragment {
    private FragmentSavedNewsDetailBinding binding;

    public SavedNewsDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_saved_news_detail, container, false);
        binding = FragmentSavedNewsDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getArguments() == null) {
            return;
        }
        Article article = SavedNewsDetailFragmentArgs.fromBundle(getArguments()).getArticle();
        if (article == null) {
            return;
        }
        Log.d("SaveNewsDetailFragment", article.toString());
        binding.title.setText(article.title);
        binding.author.setText(article.author);
        binding.timeStamp.setText(article.publishedAt);
        if (article.urlToImage == null || article.urlToImage.isEmpty()) {
            binding.image.setImageResource(R.drawable.ic_empty_image);
        } else {
            Picasso.get().load(article.urlToImage).into(binding.image);
        }
        binding.description.setText(article.description);
        binding.content.setText(article.content);

    }

}
