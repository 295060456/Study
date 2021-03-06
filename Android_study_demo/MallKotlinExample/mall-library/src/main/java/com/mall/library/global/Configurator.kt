package com.mall.library.global

import android.os.Looper
import com.mall.library.storage.MemoryStore
import android.os.Handler
import java.security.Key

/**
 * Created By Jobs Who was an iOS Developor
 * 全局控制类
 */
class Configurator private constructor() {

    private object Holder {
        internal val INSTANCE = Configurator()
    }

    companion object {
        // 这里获取到全局的存储容器
        private var mStore: MemoryStore = MemoryStore.instance

        // Hander 需要反复使用，不妨提前创建
        private val mHander = Handler(Looper.getMainLooper())

        internal val instance: Configurator
            get() = Holder.INSTANCE
    }

    init {
        // 加一个标签，判断是否配置完成，现在还没开始配置
        mStore.addData(GlobalKeys.IS_CONFIGURE_READY, false);
        mStore.addData(GlobalKeys.HANDLER, mHander)
    }
    // 访问服务器的Api设置
    fun withApiHost(host: String): Configurator {
        mStore.addData(GlobalKeys.API_HOST, host)
        return this
    }
    // 结束配置
    fun configure () {
        mStore.addData(GlobalKeys.IS_CONFIGURE_READY,true)
        // 下面可以做一些回收动作
    }

    private fun checkConfiguration() {
        var isReady : Boolean =
            mStore.getData<Boolean>(GlobalKeys.IS_CONFIGURE_READY)
        if(!isReady){
            throw RuntimeException("config is not ready")
        }
    }

    fun <T>getConfiguration (key : String) : T {
        return mStore.getData(key)
    }

    fun <T>getConfiguration (key : Enum<*>) : T {
        return getConfiguration(key.name)
    }

}


































