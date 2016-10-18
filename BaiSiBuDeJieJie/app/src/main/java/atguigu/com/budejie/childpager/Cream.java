package atguigu.com.budejie.childpager;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;

import atguigu.com.budejie.MainActivity;
import atguigu.com.budejie.R;
import atguigu.com.budejie.childpager.basepager.ChildBasePager;
import atguigu.com.budejie.childpager.creamdetailpager.Artycle;
import atguigu.com.budejie.childpager.creamdetailpager.Beauty;
import atguigu.com.budejie.childpager.creamdetailpager.Picture;
import atguigu.com.budejie.childpager.creamdetailpager.Queue;
import atguigu.com.budejie.childpager.creamdetailpager.Society;
import atguigu.com.budejie.childpager.creamdetailpager.Talk;
import atguigu.com.budejie.childpager.creamdetailpager.Total;
import atguigu.com.budejie.childpager.creamdetailpager.Vadio;

/**
 * Created by Administrator on 2016/1/11.
 */
public class Cream extends ChildBasePager {

    private TabPageIndicator tpi_vadio;
    private ViewPager vp_vadio;
    private String[] titles;
    private ArrayList<ChildBasePager> pagers;

    public Cream(Activity activity) {
        super((MainActivity) activity);
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.cream, null);
        tpi_vadio = (TabPageIndicator) view.findViewById(R.id.tpi_vadio);
        vp_vadio = (ViewPager) view.findViewById(R.id.vp_vadio);
        return view;
    }
    @Override
    public void initData() {
        super.initData();
        titles=new String[]{"全部","视频","图片","段子","排行","社会","长文","美女"};
        pagers=new ArrayList();
        pagers.add(new Total(mActivity));
        pagers.add(new Vadio(mActivity));
        pagers.add(new Picture(mActivity));
        pagers.add(new Talk(mActivity));
        pagers.add(new Queue(mActivity));
        pagers.add(new Society(mActivity));
        pagers.add(new Artycle(mActivity));
        pagers.add(new Beauty(mActivity));

        vp_vadio.setAdapter(new CreamPagerAdapter());
        tpi_vadio.setViewPager(vp_vadio);
        tpi_vadio.setOnPageChangeListener(new MyOnPageChangeListener());
    }
    class CreamPagerAdapter extends PagerAdapter{

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = pagers.get(position).mView;
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return pagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            pagers.get(msg.arg1).initData();
        }
    };
    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Message obtain = Message.obtain();
            obtain.arg1=position;
            handler.sendMessageDelayed(obtain,500);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
