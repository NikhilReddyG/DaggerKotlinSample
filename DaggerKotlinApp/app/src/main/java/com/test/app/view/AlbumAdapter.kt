package com.test.app.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.test.app.R
import com.test.app.model.Album
import java.util.ArrayList

class AlbumAdapter(var mClickListener: ClickListener) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    private val mAlbum = ArrayList<Album>()

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_row, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(albumViewHolder: AlbumViewHolder, i: Int) {
        albumViewHolder.mTxtUserID.text = mAlbum[i].title
        albumViewHolder.mTxtUserID.setOnClickListener {
            mClickListener.launchIntent(mAlbum[i].id.toString())
        }
    }

    override fun getItemCount(): Int {
        return mAlbum.size
    }

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var mTxtUserID: TextView = itemView.findViewById(R.id.txtUserID)
    }

    interface ClickListener {
        fun launchIntent(albumsName: String)
    }

    fun setData(albums: List<Album>) {
        this.mAlbum.addAll(albums)
        notifyDataSetChanged()
    }
}