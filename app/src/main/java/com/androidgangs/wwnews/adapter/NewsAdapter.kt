package com.iti.mad41.taqs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.androidgangs.wwnews.data.model.ArticlesItem
import com.androidgangs.wwnews.databinding.ArticleCardItemBinding
import com.androidgangs.wwnews.ui.news.NewsViewModel
import java.text.SimpleDateFormat

class NewsAdapter(private val viewModel: NewsViewModel):
    ListAdapter<ArticlesItem, NewsAdapter.ArticaleItemHolder>(ArticalesDiffCallback()) {

    class ArticaleItemHolder(var binding: ArticleCardItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(viewModel: NewsViewModel, articlesItem: ArticlesItem){
            binding.newsViewModel = viewModel
            binding.articleCard = articlesItem
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ArticaleItemHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ArticleCardItemBinding.inflate(layoutInflater, parent, false)

                return ArticaleItemHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticaleItemHolder {
        val viewBinding = ArticleCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticaleItemHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ArticaleItemHolder, position: Int) {
        val article = getItem(position)

        holder.bind(viewModel, article)
    }
}

class ArticalesDiffCallback: DiffUtil.ItemCallback<ArticlesItem>(){
    override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
        return oldItem.publishedAt == newItem.publishedAt
    }

    override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
        return oldItem == newItem
    }

}