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

class UserAdapter(private var context: Context) : RecyclerView.Adapter<UserAdapter.UserHolder>(){
    /**
     * Létrehozza az egyes elemek nézetét
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        /**
         * Az XML nézeteinket fel tudjuk fújni
         */
        var view = LayoutInflater.from(context).inflate(R.layout.layout_element, parent, false)
        return UserHolder(view)
    }

    /**
     * Hány elemünk lesz a listában
     */
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * A létrehozott listaelemeket tölti fel adatokkal
     */
    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class  UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        @JvmField
        @BindView(R.id.first_name)
        var firstName : TextView? = null

        @JvmField
        @BindView(R.id.last_name)
        var lastName : TextView? = null

        @JvmField
        @BindView(R.id.email)
        var email : TextView? = null

        @JvmField
        @BindView(R.id.profile_picture)
        var profilePicture : ImageView? = null

        init {
            ButterKnife.bind(this, itemView)
        }

    }
}