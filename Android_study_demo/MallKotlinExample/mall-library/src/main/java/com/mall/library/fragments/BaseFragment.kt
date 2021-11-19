package com.mall.library.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import me.yokeyword.fragmentation.SupportFragment
import java.lang.NullPointerException
import java.time.ZoneId

/**
 * Created By Jobs Who was an iOS Developor
 */
abstract class BaseFragment : SupportFragment(){

    private var mRootView : View = null
    abstract fun setLayout():Any
    abstract fun onBindView(savedInstanceState:Bundle?,rootView: View)
    fun<T:View> findView(@IdRes viewId: Int): T {
        if (mRootView!=null){
            return mRootView?.findViewById(viewId)!!
        }
        throw NullPointerException("rootView is null")
    }
}