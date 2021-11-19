package com.mall.library.global

import android.content.Context
import com.mall.library.storage.MemoryStore

/**
 * Created By Jobs Who was an iOS Developor
 */
object Mall {
    val configurator: Configurator
        get() = Configurator.instance

    fun init(context: Context): Configurator {
        MemoryStore.instance.addData(GlobalKeys.APPLICATION_CONTEXT, context.applicationContext)
        return Configurator.instance
    }

    fun <T> getConfiguration (key:String):T{
        return configurator.getConfiguration(key)
    }

    fun <T> getConfiguration (key: Enum<GlobalKeys>):T{
        return getConfiguration(key.name)
    }

}