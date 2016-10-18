package atguigu.com.budejie.childpager.basepager;

import android.view.View;

import atguigu.com.budejie.MainActivity;

/**
 * Created by Administrator on 2016/1/11.
 */
public abstract class ChildBasePager {

    public MainActivity mActivity;
    public View mView;

    public ChildBasePager(MainActivity activity){
        mActivity=activity;
        mView=initView();
    }
    //加载并初始化布局
    public abstract View initView();
    //初始化数据
    public void initData(){

    }
}
