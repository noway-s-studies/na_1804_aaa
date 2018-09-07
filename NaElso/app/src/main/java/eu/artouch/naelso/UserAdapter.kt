package eu.artouch.naelso

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import eu.artouch.naelso.model.User

class UserAdapter(private var context: Context, private var users: List<User>) : RecyclerView.Adapter<UserAdapter.UserHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_element, parent, false)
        return UserHolder(view)
    }
    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val dynamicPosition: Int = holder.adapterPosition
        val user: User = users[dynamicPosition]
        setTexts(holder, user)
        setImage(holder, user)
    }
    private fun setTexts(holder: UserAdapter.UserHolder, user: User) {
        holder.firstName!!.text = user.name.first
        holder.lastName!!.text = user.name.last
        holder.email!!.text = user.email
    }
    private fun setImage(holder: UserAdapter.UserHolder, user: User) {
        Glide.with(context).load(user.picture.picture).into(holder.profilePicture!!)
    }
    override fun getItemCount(): Int {
        return users.size
    }
    fun setDataSet(users: List<User>) {
        this.users = users
    }
    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @JvmField
        @BindView(R.id.first_name)
        var firstName: TextView? = null
        @JvmField
        @BindView(R.id.last_name)
        var lastName: TextView? = null
        @JvmField
        @BindView(R.id.email)
        var email: TextView? = null
        @JvmField
        @BindView(R.id.profile_picture)
        var profilePicture: ImageView? = null
        init {
            ButterKnife.bind(this, itemView)
        }
    }
}