package example.mall.dadishu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;
import java.util.Random;

/**
 * Created By Jobs Who was an iOS Developor
 */
public class DiglettActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mstartButton;
    private ImageView mDiglettImageView;
    private TextView mResultTextView;
    public int CODE = 123;

    public int[][] mPosition = new int[][]{
            {342, 180}, {432, 880},
            {521, 256}, {329, 780},
            {456, 976}, {145, 665},
            {123, 678}, {564, 567}
    };

    private int mTotalCount;
    private int mSuccessCount;
    private static int RANDOM_NUMBER = 500;

    public static final int MAX_COUNT = 10;

    public DiglettHander mHander = new DiglettHander(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diglett);

        mResultTextView = (TextView) findViewById(R.id.text_View);
        mDiglettImageView = (ImageView) findViewById(R.id.imageView);
        mstartButton = (Button) findViewById(R.id.start_button);

        mstartButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_button: {
                start();
                break;
            }
        }
    }

    private void start() {
        // 发送消息
        mResultTextView.setText("开始啦");
        mstartButton.setText("游戏中...");
        mstartButton.setEnabled(false);
        next(0);
    }

    private void next(int delayTime) {
        int position = new Random().nextInt(mPosition.length);

        Message message = Message.obtain();
        message.what = CODE;
        message.arg1 = position;

        mHander.sendMessageDelayed(message, delayTime);
        mTotalCount++;
    }

    public static class DiglettHander extends Handler {

        public final WeakReference<DiglettActivity> mWeakReference;

        public DiglettHander(DiglettActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }


        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            DiglettActivity activity = mWeakReference.get();

            switch (msg.what) {
                case 123:

                    if (activity.mTotalCount > MAX_COUNT) {
                        activity.clear();
                        Toast.makeText(activity, "地鼠打完了！", Toast.LENGTH_LONG).show();
                    }

                    int position = msg.arg1;
                    activity.mDiglettImageView.setX(activity.mPosition[position][0]);
                    activity.mDiglettImageView.setX(activity.mPosition[position][1]);
                    activity.mDiglettImageView.setVisibility(View.VISIBLE);

                    int randomTime = new Random().nextInt(RANDOM_NUMBER) + RANDOM_NUMBER;
                    activity.next(randomTime);
                    break;
            }

        }
    }

    private void clear() {


    }
}



















