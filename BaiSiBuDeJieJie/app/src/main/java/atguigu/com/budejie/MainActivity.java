package atguigu.com.budejie;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import atguigu.com.budejie.fragment.MyFragment;
import atguigu.com.budejie.listvideo.MediaHelp;

public class MainActivity extends FragmentActivity {

    public static String CONTENT_FRAGMENT="myFragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //加载contentFragment
        loadFragment();
    }

    private void loadFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_main, new MyFragment(), CONTENT_FRAGMENT).commit();
    }

    @Override
    protected void onDestroy() {
        MediaHelp.release();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        MediaHelp.resume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        MediaHelp.pause();
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MediaHelp.getInstance().seekTo(data.getIntExtra("position", 0));
    }
}
