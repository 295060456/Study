package example.mall.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

// Fragment 反向传值到 Activity
public class MainActivity extends AppCompatActivity implements ListFragment.OnTitleClickListener {

    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("qqqq");

//        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        findViewById(R.id.textView).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,StaticloadFragmentActivity.class));
        });

        // 1、container  2、fragment  3、fragment --> container
        ListFragment fragment = new ListFragment();

        // Activity 向Fragment 传值
        listFragment = ListFragment.newInstance("List");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.listContainer, listFragment)
                .add(R.id.detailContainer,ListFragment.newInstance("detail"))
                .commit();

        listFragment.setmOnTitleClickListener(this);
    }

    @Override
    public void onClick(String title) {
        setTitle(title);
    }
}