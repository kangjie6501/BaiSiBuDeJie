package atguigu.com.budejie.childpager.creamdetailpager;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

import atguigu.com.budejie.MainActivity;
import atguigu.com.budejie.R;
import atguigu.com.budejie.childpager.basepager.ChildBasePager;
import atguigu.com.budejie.domain.CreamVadioBean;
import atguigu.com.budejie.listvideo.FullVideoActivity;
import atguigu.com.budejie.listvideo.MediaHelp;
import atguigu.com.budejie.listvideo.VideoSuperPlayer;
import atguigu.com.budejie.utils.CacheUtils;
import atguigu.com.budejie.utils.ConnectUtils;
import atguigu.com.budejie.utils.ImageLoaderUtils;

/**
 * Created by Administrator on 2016/1/12.
 */
public class Vadio extends ChildBasePager{

    private ListView lv_cream_talk;
    private ArrayList<CreamVadioBean.ListEntity> list;
    public Vadio(Activity activity) {
        super((MainActivity) activity);
    }
    private ImageLoaderUtils loaderUtils;
    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.cream_talk, null);
        lv_cream_talk= (ListView) view.findViewById(R.id.lv_cream_talk);
        loaderUtils=new ImageLoaderUtils();
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        if(!TextUtils.isEmpty(CacheUtils.getString(mActivity,ConnectUtils.CREAM_RADIO_URL))){
            processData(CacheUtils.getString(mActivity,ConnectUtils.CREAM_RADIO_URL));
        }
        getDataFromNet();
    }

    private void getDataFromNet() {
        RequestQueue requestQueue= Volley.newRequestQueue(mActivity);
        StringRequest request=new StringRequest(StringRequest.Method.GET, ConnectUtils.CREAM_RADIO_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CacheUtils.putString(mActivity,ConnectUtils.CREAM_RADIO_URL,response);
                processData(response);
                Log.e("TAG","Vadio联网成功！");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG","Vadio联网失败！");
            }
        });
        requestQueue.add(request);
    }
    private boolean isPlaying;
    private int indexPostion = -1;
    private void processData(String json) {
        Gson gson=new Gson();
        CreamVadioBean radioBean = gson.fromJson(json, CreamVadioBean.class);
        list= (ArrayList<CreamVadioBean.ListEntity>) radioBean.getList();
        final MyVadioAdapter adapter=new MyVadioAdapter();
        lv_cream_talk.setAdapter(new MyVadioAdapter());
        lv_cream_talk.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if ((indexPostion < lv_cream_talk.getFirstVisiblePosition() || indexPostion > lv_cream_talk
                        .getLastVisiblePosition()) && isPlaying) {
                    indexPostion = -1;
                    isPlaying = false;
                    adapter.notifyDataSetChanged();
                    MediaHelp.release();
                }
            }
        });
    }

    class MyVadioAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final VadioHolder vadioHolder;
            if(convertView==null){
                vadioHolder=new VadioHolder();
                convertView=View.inflate(mActivity,R.layout.cream_radio_item,null);
                vadioHolder.iv_cream_radio_lable= (ImageView) convertView.findViewById(R.id.iv_cream_radio_lable);
                vadioHolder.tv_cream_radio_name= (TextView) convertView.findViewById(R.id.tv_cream_radio_name);
                vadioHolder.tv_cream_radio_date= (TextView) convertView.findViewById(R.id.tv_cream_radio_date);
                vadioHolder.iv_cream_radio_back= (ImageView) convertView.findViewById(R.id.iv_cream_radio_back);
                vadioHolder.iv_cream_radio_operate= (ImageView) convertView.findViewById(R.id.iv_cream_radio_operate);
                vadioHolder.iv_cream_radio_play= (ImageView) convertView.findViewById(R.id.iv_cream_radio_play);
                vadioHolder.tv_cream_radio_content= (TextView) convertView.findViewById(R.id.tv_cream_radio_content);
                vadioHolder.tv_cream_radio_hot= (TextView) convertView.findViewById(R.id.tv_cream_radio_hot);
                vadioHolder.tv_cream_radio_up= (TextView) convertView.findViewById(R.id.tv_cream_radio_up);
                vadioHolder.tv_cream_radio_down= (TextView) convertView.findViewById(R.id.tv_cream_radio_down);
                vadioHolder.tv_cream_radio_share= (TextView) convertView.findViewById(R.id.tv_cream_radio_share);
                vadioHolder.tv_cream_radio_comment= (TextView) convertView.findViewById(R.id.tv_cream_radio_comment);
                vadioHolder.svp_cream_radio_play= (VideoSuperPlayer) convertView.findViewById(R.id.svp_cream_radio_play);
                convertView.setTag(vadioHolder);
            }else{
                vadioHolder= (VadioHolder) convertView.getTag();
            }
            //加载图片
            loaderUtils.setUrlBitmap(list.get(position).getProfile_image(), vadioHolder.iv_cream_radio_lable);
            loaderUtils.setUrlBitmap(list.get(position).getBimageuri(), vadioHolder.iv_cream_radio_back);
            //初始化属性
            vadioHolder.tv_cream_radio_name.setText(list.get(position).getName());
            vadioHolder.tv_cream_radio_date.setText(list.get(position).getCreate_time());
            vadioHolder.tv_cream_radio_content.setText(list.get(position).getText());
            vadioHolder.tv_cream_radio_up.setText(list.get(position).getLove());
            vadioHolder.tv_cream_radio_down.setText(list.get(position).getHate());
            vadioHolder.tv_cream_radio_share.setText(list.get(position).getRepost());
            vadioHolder.tv_cream_radio_comment.setText(list.get(position).getComment());
            //
            vadioHolder.iv_cream_radio_play.setOnClickListener(new MyOnclick(
                    vadioHolder.iv_cream_radio_play, vadioHolder.svp_cream_radio_play, position));
            if (indexPostion == position) {
                vadioHolder.svp_cream_radio_play.setVisibility(View.VISIBLE);
            } else {
                vadioHolder.svp_cream_radio_play.setVisibility(View.GONE);
                vadioHolder.svp_cream_radio_play.close();
            }
            return convertView;
        }
        class MyOnclick implements View.OnClickListener {
            VideoSuperPlayer mSuperVideoPlayer;
            ImageView mPlayBtnView;
            int position;

            public MyOnclick(ImageView mPlayBtnView,
                             VideoSuperPlayer mSuperVideoPlayer, int position) {
                this.position = position;
                this.mSuperVideoPlayer = mSuperVideoPlayer;
                this.mPlayBtnView = mPlayBtnView;
            }

            @Override
            public void onClick(View v) {
                MediaHelp.release();
                indexPostion = position;
                isPlaying = true;
                mSuperVideoPlayer.setVisibility(View.VISIBLE);
                mSuperVideoPlayer.loadAndPlay(MediaHelp.getInstance(), list
                        .get(position).getVideouri(), 0, false);
                mSuperVideoPlayer.setVideoPlayCallback(new MyVideoPlayCallback(
                        mPlayBtnView, mSuperVideoPlayer, position));
                notifyDataSetChanged();
            }
        }

        class MyVideoPlayCallback implements VideoSuperPlayer.VideoPlayCallbackImpl {
            ImageView mPlayBtnView;
            VideoSuperPlayer mSuperVideoPlayer;
            int mPosition;

            public MyVideoPlayCallback(ImageView mPlayBtnView,
                                       VideoSuperPlayer mSuperVideoPlayer, int position) {
                this.mPlayBtnView = mPlayBtnView;
                this.mPosition = position;
                this.mSuperVideoPlayer = mSuperVideoPlayer;
            }

            @Override
            public void onCloseVideo() {
                closeVideo();
            }

            @Override
            public void onSwitchPageType() {
                if (mActivity.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
                    Intent intent = new Intent(mActivity,
                            FullVideoActivity.class);
                    intent.putExtra("video", list.get(mPosition).getVideouri());
                    intent.putExtra("position",
                            mSuperVideoPlayer.getCurrentPosition());
                    mActivity.startActivityForResult(intent, 1);
                }
            }

            @Override
            public void onPlayFinish() {
                closeVideo();
            }

            private void closeVideo() {
                isPlaying = false;
                indexPostion = -1;
                mSuperVideoPlayer.close();
                MediaHelp.release();
                mPlayBtnView.setVisibility(View.VISIBLE);
                mSuperVideoPlayer.setVisibility(View.GONE);
            }

        }

        class VadioHolder{
            public ImageView iv_cream_radio_lable;
            public TextView tv_cream_radio_name;
            public TextView tv_cream_radio_date;
            public ImageView iv_cream_radio_back;
            public ImageView iv_cream_radio_operate;
            public ImageView iv_cream_radio_play;
            public TextView tv_cream_radio_content;
            public TextView tv_cream_radio_hot;
            public TextView tv_cream_radio_up;
            public TextView tv_cream_radio_down;
            public TextView tv_cream_radio_share;
            public TextView tv_cream_radio_comment;
            public VideoSuperPlayer svp_cream_radio_play;
        }
    }
}
