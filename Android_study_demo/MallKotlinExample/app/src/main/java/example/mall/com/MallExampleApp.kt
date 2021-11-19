package example.mall.com

import android.app.Application
import com.mall.library.global.Mall

/**
 * Created By Jobs Who was an iOS Developor
 */
class MallExampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Mall.init(this).withApiHost("http://dewd.com").configure()
    }
}