package com.test.app.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.test.app.R
import com.test.app.api.APIInterface
import com.test.app.app.BaseApplication
import com.test.app.di.components.AlbumComponent
import com.test.app.di.components.DaggerAlbumComponent
import com.test.app.di.module.AlbumActivityModule
import com.test.mvvmsample.viewmodel.AlbumViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class AlbumActivity : AppCompatActivity(), AlbumAdapter.ClickListener {

    //The @Inject annotation can be used for method, constructor, or field

   /* It is important to remember that Java code will be generated from this Kotlin code and for one statement
    in Kotlin you can have multiple Java elements and that is why
    @set:Inject explicitly specifies that the @Inject annotation should be applied
    to the setter that will be generated in Java.*/

    @set:Inject
    var mApiInterface: APIInterface? = null

    @set:Inject
    var mAlbumAdapter: AlbumAdapter? = null

    private lateinit var mAlbumViewModel: AlbumViewModel
    private lateinit var mAlbumComponent: AlbumComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        initSetUpDagger()
        initSetUpViews()
    }

    private fun initSetUpDagger() {

        val mApplicationComponent = BaseApplication.get(this).getApplicationComponent()

        mAlbumComponent = DaggerAlbumComponent.builder()
                .albumActivityModule(AlbumActivityModule(this))
                .applicationComponent(mApplicationComponent).build()
        mAlbumComponent.injectAlbumActivity(this)
    }

    private fun initSetUpViews() {

        val mTest = ArrayList<String>()
        mTest.add("Test")
        mTest.add("Test 2")
        mTest.add("Test 3")

        var i = 0
        while (i < mTest.size) {
            println("Test 222::>"+mTest[i])
            i++
        }

        for (test in mTest) {
            println("Test 111::>"+test)
        }

        val mLinearLayoutManger = LinearLayoutManager(this)
        mLinearLayoutManger.orientation = LinearLayoutManager.VERTICAL
        albumRecyclerView.layoutManager = mLinearLayoutManger
        albumRecyclerView.adapter = mAlbumAdapter

        mAlbumViewModel = ViewModelProviders.of(this).get(AlbumViewModel::class.java)
        mAlbumViewModel.albumListResponse().observe(this, Observer {
            it?.let {
                mAlbumAdapter!!.setData(it)
            }
        })
    }


    override fun launchIntent(ablumsName: String) {
        Toast.makeText(this,ablumsName,Toast.LENGTH_SHORT).show()
    }
}