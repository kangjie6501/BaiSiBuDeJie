package atguigu.com.budejie.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import atguigu.com.budejie.R;
import atguigu.com.budejie.childpager.Attention;
import atguigu.com.budejie.childpager.Cream;
import atguigu.com.budejie.childpager.Mine;
import atguigu.com.budejie.childpager.Post;
import atguigu.com.budejie.childpager.basepager.ChildBasePager;

/**
 * Created by Administrator on 2016/1/11.
 */
public class MyFragment extends Fragment{

    private Activity mActivity;

    private RelativeLayout rl_mainActivity;
    private LinearLayout ll_mainActivity_upload;
    private ImageButton ib_mainActivity_upload;
    private ImageButton ib_mainActivity_game;
    private ImageView iv_mainActivity_title;
    private TextView tv_mainActivity_title;
    private ImageButton iv_mainActivity_refresh;
    private ImageButton ib_mainActivity_setBack;
    private ImageButton ib_mainActivity_through;
    private atguigu.com.budejie.autoview.NoScrollViewpager vp_mainActivity;
    private RadioGroup rg_mainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private View initView() {
        View view=View.inflate(mActivity,R.layout.content_fragment,null);
        rl_mainActivity = (RelativeLayout) view.findViewById(R.id.rl_mainActivity);
        ll_mainActivity_upload = (LinearLayout) view.findViewById(R.id.ll_mainActivity_upload);
        ib_mainActivity_upload = (ImageButton) view.findViewById(R.id.ib_mainActivity_upload);
        ib_mainActivity_game = (ImageButton) view.findViewById(R.id.ib_mainActivity_game);
        iv_mainActivity_title = (ImageView) view.findViewById(R.id.iv_mainActivity_title);
        tv_mainActivity_title = (TextView) view.findViewById(R.id.tv_mainActivity_title);
        iv_mainActivity_refresh = (ImageButton) view.findViewById(R.id.iv_mainActivity_refresh);
        ib_mainActivity_setBack = (ImageButton) view.findViewById(R.id.ib_mainActivity_setBack);
        ib_mainActivity_through = (ImageButton) view.findViewById(R.id.ib_mainActivity_through);
        vp_mainActivity = (atguigu.com.budejie.autoview.NoScrollViewpager) view.findViewById(R.id.vp_mainActivity);
        rg_mainActivity = (RadioGroup) view.findViewById(R.id.rg_mainActivity);
        return view;
    }

    //子页面集合
    private ArrayList<ChildBasePager> list;
    private void initData() {
        list=new ArrayList<>();
        list.add(new Cream(mActivity));
        list.add(new Post(mActivity));
        list.add(new Attention(mActivity));
        list.add(new Mine(mActivity));
        MyPagerAdapter adapter=new MyPagerAdapter();
        vp_mainActivity.setAdapter(adapter);
        //默认加载第一页数据
        list.get(0).initData();
        //ViewPager设置页面改变监听
        vp_mainActivity.setOnPageChangeListener(new MyOnPageChangeListener());
        //RadioGroup设置点击监听
        rg_mainActivity.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //ImageButton等点击监听
        setOnClickListener();
    }

    private void setOnClickListener() {
        ib_mainActivity_game.setOnClickListener(new MyOnClickListener());
        tv_mainActivity_title.setOnClickListener(new MyOnClickListener());
        iv_mainActivity_refresh.setOnClickListener(new MyOnClickListener());
        ib_mainActivity_setBack.setOnClickListener(new MyOnClickListener());
        ib_mainActivity_through.setOnClickListener(new MyOnClickListener());
        ib_mainActivity_upload.setOnClickListener(new MyOnClickListener());
    }
    private class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ib_mainActivity_game:
                    if(vp_mainActivity.getCurrentItem()==2){

                    }else if(vp_mainActivity.getCurrentItem()==3){

                    }else{

                    }
                    break;
                case R.id.iv_mainActivity_title:
                    if(vp_mainActivity.getCurrentItem()==0){

                    }else if(vp_mainActivity.getCurrentItem()==1){

                    }
                    break;
                case R.id.iv_mainActivity_refresh:
                    if(vp_mainActivity.getCurrentItem()==0){

                    }else if(vp_mainActivity.getCurrentItem()==1){

                    }
                    break;
                case R.id.ib_mainActivity_setBack:
                    break;
                case R.id.ib_mainActivity_through:
                    if(vp_mainActivity.getCurrentItem()==0){

                    }else if(vp_mainActivity.getCurrentItem()==3){

                    }
                    break;
                case R.id.ib_mainActivity_upload:
                    break;
            }
        }
    }
    class MyPagerAdapter extends PagerAdapter{
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = list.get(position).mView;
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            list.get(position).initData();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_mainActivity_cream:
                    vp_mainActivity.setCurrentItem(0, true);
                    rl_mainActivity.setBackgroundColor(Color.RED);
                    ib_mainActivity_game.setImageResource(R.drawable.top_games_btn);
                    iv_mainActivity_title.setVisibility(View.VISIBLE);
                    tv_mainActivity_title.setVisibility(View.GONE);
                    iv_mainActivity_refresh.setVisibility(View.VISIBLE);
                    ib_mainActivity_through.setVisibility(View.VISIBLE);
                    ib_mainActivity_through.setImageResource(R.drawable.top_suiji_btn_pressed);
                    ib_mainActivity_setBack.setVisibility(View.GONE);
                    break;
                case R.id.rb_mainActivity_post:
                    vp_mainActivity.setCurrentItem(1, true);
                    rl_mainActivity.setBackgroundColor(Color.RED);
                    ib_mainActivity_game.setImageResource(R.drawable.top_games_btn);
                    iv_mainActivity_title.setVisibility(View.VISIBLE);
                    tv_mainActivity_title.setVisibility(View.GONE);
                    iv_mainActivity_refresh.setVisibility(View.VISIBLE);
                    ib_mainActivity_through.setVisibility(View.GONE);
                    ib_mainActivity_setBack.setVisibility(View.GONE);
                    break;
                case R.id.rb_mainActivity_attention:
                    vp_mainActivity.setCurrentItem(2,true);
                    rl_mainActivity.setBackgroundColor(Color.RED);
                    ib_mainActivity_game.setImageResource(R.drawable.post_right_follow);
                    iv_mainActivity_title.setVisibility(View.GONE);
                    tv_mainActivity_title.setVisibility(View.VISIBLE);
                    tv_mainActivity_title.setText("我的关注");
                    tv_mainActivity_title.setTextColor(Color.WHITE);
                    iv_mainActivity_refresh.setVisibility(View.GONE);
                    ib_mainActivity_through.setVisibility(View.GONE);
                    ib_mainActivity_setBack.setVisibility(View.GONE);
                    break;
                case R.id.rb_mainActivity_mine:
                    vp_mainActivity.setCurrentItem(3, true);
                    rl_mainActivity.setBackgroundColor(Color.WHITE);
                    ib_mainActivity_game.setImageResource(R.drawable.my_coins_normal);
                    iv_mainActivity_title.setVisibility(View.GONE);
                    tv_mainActivity_title.setVisibility(View.VISIBLE);
                    tv_mainActivity_title.setText("我的");
                    tv_mainActivity_title.setTextColor(Color.BLACK);
                    iv_mainActivity_refresh.setVisibility(View.GONE);
                    ib_mainActivity_through.setVisibility(View.VISIBLE);
                    ib_mainActivity_setBack.setVisibility(View.VISIBLE);
                    ib_mainActivity_through.setImageResource(R.drawable.myinfo_setting_normal);
                    break;
            }
        }
    }
}
