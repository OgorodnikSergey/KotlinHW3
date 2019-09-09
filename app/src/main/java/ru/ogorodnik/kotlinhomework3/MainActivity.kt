package ru.ogorodnik.kotlinhomework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.*
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import ru.ogorodnik.kotlinhomework3.dto.Post

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testData() // тестовые данные
    }

//--------------------тестовый пример---------------------
    fun testData(){
        val post = Post(
            1,
            "Vasya",
            "01 сентября 2019",
            "First post in our network!!!!",
            0,
            false,
            2,
            true,
            3,
            true
        )

        authorTv.text = post.author
        createdTv.text = post.created
        postTxt.text = post.content
        shareTv.text = post.shares.toString()

        if (post.likedByMe) {
            likeBtn.setImageResource(R.drawable.ic_favorite_active_24dp)
            likeTv.setTextColor(ContextCompat.getColor(this, R.color.colorRed))
        } else {
            likeBtn.setImageResource(R.drawable.ic_favorite_inactive_24dp)
            likeTv.setTextColor(ContextCompat.getColor(this, R.color.colorGrey))
        }

        if (post.likes > 0) {
            likeTv.text = post.likes.toString()
            likeTv.visibility = VISIBLE
        } else {
            likeTv.visibility = GONE
        }

        if (post.commentedByMe) {
            commentBtn.setImageResource(R.drawable.ic_mode_comment_active_24dp)
            commentTv.setTextColor(ContextCompat.getColor(this, R.color.colorRed))

        } else {
            commentBtn.setImageResource(R.drawable.ic_mode_comment_inactive_24dp)
            commentTv.setTextColor(ContextCompat.getColor(this, R.color.colorGrey))
        }

        if (post.comments > 0) {
            commentTv.text = post.comments.toString()
            commentTv.visibility = VISIBLE
        } else {
            commentTv.visibility = GONE
        }

        if (post.sharedByMe) {
            shareBtn.setImageResource(R.drawable.ic_share_active_24dp)
            shareTv.setTextColor(ContextCompat.getColor(this, R.color.colorRed))
        } else {
            shareBtn.setImageResource(R.drawable.ic_share_inactive_24dp)
            shareTv.setTextColor(ContextCompat.getColor(this, R.color.colorGrey))
        }
        if (post.shares > 0) {
            shareTv.text = post.shares.toString()
            shareTv.visibility = VISIBLE
        } else {
            shareTv.visibility = GONE
        }
    }
}
