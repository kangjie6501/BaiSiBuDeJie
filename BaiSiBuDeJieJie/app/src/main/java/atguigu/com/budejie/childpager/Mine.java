package atguigu.com.budejie.childpager;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import atguigu.com.budejie.MainActivity;
import atguigu.com.budejie.childpager.basepager.ChildBasePager;

/**
 * Created by Administrator on 2016/1/11.
 */
public class Mine extends ChildBasePager {

    public Mine(Activity activity) {
        super((MainActivity) activity);
    }

    @Override
    public View initView() {
        TextView textView=new TextView(mActivity);
        textView.setText("我的");
        textView.setTextSize(25);
        textView.setTextColor(Color.BLACK);
        return textView;
    }
    @Override
    public void initData() {
        super.initData();
    }
}
