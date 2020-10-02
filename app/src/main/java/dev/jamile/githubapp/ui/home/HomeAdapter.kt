package dev.jamile.githubapp.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.jamile.githubapp.R
import dev.jamile.githubapp.models.Repository
import kotlinx.android.synthetic.main.repo_item_layout.view.*

class HomeListAdapter(
    private val context: Context,
    private val reposList: List<Repository>
) : RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListAdapter.ViewHolder =
        ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.repo_item_layout, parent, false)
        )

    override fun onBindViewHolder(holder: HomeListAdapter.ViewHolder, position: Int) {
        val repo = reposList[position]
        holder.bind(repo)
    }

    override fun getItemCount(): Int = reposList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(repo: Repository) {
            itemView.apply {
                Glide
                    .with(itemView)
                    .load(repo.owner.avatarUrl)
                    .placeholder(R.drawable.octocat)
                    .into(image)
                repoName.text = repo.name
                repoOwner.text = repo.owner.login
                starsCount.text = repo.startGazersCount.toString()
                languageName.text = repo.language
            }
        }
    }

}