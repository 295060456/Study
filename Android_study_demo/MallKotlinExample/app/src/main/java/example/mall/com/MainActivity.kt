package example.mall.com

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mall.library.global.GlobalKeys
import com.mall.library.global.Mall

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Mall.getConfiguration<Context>(GlobalKeys.APPLICATION_CONTEXT)
    }
}