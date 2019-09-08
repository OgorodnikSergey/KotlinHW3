package ru.ogorodnik.kotlinhomework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.ogorodnik.kotlinhomework3.dto.Post

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testData() // тестовые данные
    }

    fun testData(){
        //--------------------тестовый пример---------------------
        val post = Post(
            1,
            "Vasya",
            "01 сентября 2019",
            "First post in our network!!!!",
            1,
            true,
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
        } else {
            likeBtn.setImageResource(R.drawable.ic_favorite_inactive_24dp)
        }

        if (post.likes > 0) {
            likeTv.text = post.likes.toString()
        } else {
            likeTv.text =""
        }

        if (post.commentedByMe) {
            commentBtn.setImageResource(R.drawable.ic_mode_comment_active_24dp)
        } else {
            commentBtn.setImageResource(R.drawable.ic_mode_comment_inactive_24dp)
        }

        if (post.comments > 0) {
            commentTv.text = post.comments.toString()
        } else {
            commentTv.text = ""
        }

        if (post.sharedByMe) {
            shareBtn.setImageResource(R.drawable.ic_share_active_24dp)
        } else {
            shareBtn.setImageResource(R.drawable.ic_share_inactive_24dp)
        }
        if (post.shares > 0) {
            shareTv.text = post.shares.toString()
        } else {
            shareTv.text =""
        }
    }
}
