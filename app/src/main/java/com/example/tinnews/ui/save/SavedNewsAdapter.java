package com.example.tinnews.ui.save;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinnews.R;
import com.example.tinnews.model.Article;

import java.util.ArrayList;
import java.util.List;

public class SavedNewsAdapter extends RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder> {
    private List<Article> articles = new ArrayList<>();

    public void setArticles(List<Article> articles) {
        this.articles.clear();
        this.articles.addAll(articles);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public SavedNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_news_item, parent, false);
        return new SavedNewsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SavedNewsViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.author.setText(article.author);
        holder.description.setText(article.description);
        if (article.favorite) {
            holder.icon.setImageResource(R.drawable.ic_favorite_black_24dp);
        } else {
            holder.icon.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


    public static class SavedNewsViewHolder extends RecyclerView.ViewHolder {
        TextView author;
        TextView description;
        ImageView icon;

        public SavedNewsViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.description);
            icon = itemView.findViewById(R.id.image);
        }
    }

}
