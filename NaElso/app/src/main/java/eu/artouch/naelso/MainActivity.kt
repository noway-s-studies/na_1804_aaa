package eu.artouch.naelso

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import eu.artouch.naelso.model.UserWrapper
import eu.artouch.naelso.service.HandleResponse
import eu.artouch.naelso.service.UserController

class MainActivity : AppCompatActivity() {
    @JvmField
    @BindView(R.id.main_list)
    var mainList: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        setAdapter()
        getUsers()
    }
    private fun setAdapter() {
        mainList!!.layoutManager = LinearLayoutManager(this)
        mainList!!.setHasFixedSize(true)
        mainList!!.adapter = UserAdapter(this, ArrayList())
    }
    private fun getUsers() {
        UserController().getUsers(object : HandleResponse<UserWrapper> {
            override fun onResponse(response: UserWrapper) {
                if (response.users.isNotEmpty()) {
                    (mainList!!.adapter as UserAdapter).setDataSet(response.users)
                    mainList!!.adapter.notifyDataSetChanged()
                }
            }
            override fun onError(error: Throwable) {
                Toast.makeText(this@MainActivity, "Hiba történt!", Toast.LENGTH_LONG).show()
            }
        })
    }
}