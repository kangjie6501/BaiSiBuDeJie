package atguigu.com.budejie.autoview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/1/12.
 */
public class NoScrollViewpager extends ViewPager{
    public NoScrollViewpager(Context context) {
        super(context);
    }

    public NoScrollViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //return super.onInterceptTouchEvent(ev);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //return super.onTouchEvent(ev);
        return true;
    }
}
