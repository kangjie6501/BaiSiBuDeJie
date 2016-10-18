package atguigu.com.budejie.childpager.creamdetailpager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;

import atguigu.com.budejie.MainActivity;
import atguigu.com.budejie.R;
import atguigu.com.budejie.childpager.basepager.ChildBasePager;
import atguigu.com.budejie.domain.CreamTalkBean;
import atguigu.com.budejie.utils.CacheUtils;
import atguigu.com.budejie.utils.ConnectUtils;

/**
 * Created by Administrator on 2016/1/12.
 */
public class Talk extends ChildBasePager{

    private ListView lv_cream_talk;
    private ArrayList<CreamTalkBean.ListEntity> list;
    private ImageLoader universeImageLoader;
    private DisplayImageOptions options;

    public Talk(Activity activity) {
        super((MainActivity) activity);
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.cream_talk, null);
        lv_cream_talk= (ListView) view.findViewById(R.id.lv_cream_talk);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        initOptions();
        if(!TextUtils.isEmpty(CacheUtils.getString(mActivity,ConnectUtils.CREAM_TALK_URL))){
            processData(CacheUtils.getString(mActivity,ConnectUtils.CREAM_TALK_URL));
        }
        getDataFromNet();
    }
    private void initOptions() {
        universeImageLoader=ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.icon_new) //设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.drawable.icon_new)//设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.icon_new)  //设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
                .considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型//
                        //.decodingOptions(android.graphics.BitmapFactory.Options decodingOptions)//设置图片的解码配置
                        //.delayBeforeLoading(int delayInMillis)//int delayInMillis为你设置的下载前的延迟时间
                        //设置图片加入缓存前，对bitmap进行设置
                        //.preProcessor(BitmapProcessor preProcessor)
                //8.resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
                .displayer(new RoundedBitmapDisplayer(18))//是否设置为圆角，弧度为多少
                //.displayer(new FadeInBitmapDisplayer(100))//是否图片加载好后渐入的动画时间
                .build();//构建完成
    }
    private void getDataFromNet() {
        RequestQueue requestQueue= Volley.newRequestQueue(mActivity);
        StringRequest request=new StringRequest(StringRequest.Method.GET, ConnectUtils.CREAM_TALK_URL,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CacheUtils.putString(mActivity,ConnectUtils.CREAM_TALK_URL,response);
                processData(response);
                Log.e("TAG","Talk联网成功！");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG","Talk联网失败！");
            }
        });
        requestQueue.add(request);
    }

    private void processData(String json) {
        Gson gson=new Gson();
        CreamTalkBean creamTalkBean = gson.fromJson(json, CreamTalkBean.class);
        list= (ArrayList<CreamTalkBean.ListEntity>) creamTalkBean.getList();
        lv_cream_talk.setAdapter(new TalkAdapter());
        Log.e("TAG",".....1");
    }
    class TalkAdapter extends BaseAdapter{

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
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder viewHolder;
            if(convertView==null){
                viewHolder=new ViewHolder();
                convertView=View.inflate(mActivity,R.layout.cream_talk_item,null);
                viewHolder.iv_cream_talk_lable= (ImageView) convertView.findViewById(R.id.iv_cream_talk_lable);
                viewHolder.tv_cream_talk_name= (TextView) convertView.findViewById(R.id.tv_cream_talk_name);
                viewHolder.tv_cream_talk_date= (TextView) convertView.findViewById(R.id.tv_cream_talk_date);
                viewHolder.tv_cream_talk_content= (TextView) convertView.findViewById(R.id.tv_cream_talk_content);
                viewHolder.tv_cream_talk_hot= (TextView) convertView.findViewById(R.id.tv_cream_talk_hot);
                viewHolder.ll_cream_talk_hot= (LinearLayout) convertView.findViewById(R.id.ll_cream_talk_hot);
                viewHolder.tv_cream_talk_field= (TextView) convertView.findViewById(R.id.tv_cream_talk_field);
                viewHolder.tv_cream_talk_up= (TextView) convertView.findViewById(R.id.tv_cream_talk_up);
                viewHolder.tv_cream_talk_down= (TextView) convertView.findViewById(R.id.tv_cream_talk_down);
                viewHolder.tv_cream_talk_share= (TextView) convertView.findViewById(R.id.tv_cream_talk_share);
                viewHolder.tv_cream_talk_comment= (TextView) convertView.findViewById(R.id.tv_cream_talk_comment);
                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }
            universeImageLoader.displayImage(list.get(position).getProfile_image(), viewHolder.iv_cream_talk_lable, options, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String s, View view) {
                    Log.e("TAG", ".....启动");
                }
                @Override
                public void onLoadingFailed(String s, View view, FailReason failReason) {
                    Log.e("TAG", ".....失败");
                }
                @Override
                public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                    if(bitmap!=null){
                        viewHolder.iv_cream_talk_lable.setImageBitmap(bitmap);
                        Log.e("TAG", ".....完成");
                    }else{
                        viewHolder.iv_cream_talk_lable.setImageResource(R.drawable.icon_new);
                    }
                }
                @Override
                public void onLoadingCancelled(String s, View view) {
                }
            });
            viewHolder.tv_cream_talk_name.setText(list.get(position).getName());
            viewHolder.tv_cream_talk_date.setText(list.get(position).getCreate_time());
            viewHolder.tv_cream_talk_content.setText(list.get(position).getText().trim());
            viewHolder.ll_cream_talk_hot.setVisibility(View.GONE);
            viewHolder.tv_cream_talk_up.setText(list.get(position).getDing());
            viewHolder.tv_cream_talk_down.setText(list.get(position).getCai());
            viewHolder.tv_cream_talk_share.setText(list.get(position).getFavourite());
            viewHolder.tv_cream_talk_comment.setText(list.get(position).getComment());
            return convertView;
        }

    }
    class ViewHolder{
        public ImageView iv_cream_talk_lable;
        public TextView tv_cream_talk_name;
        public TextView tv_cream_talk_date;
        public TextView tv_cream_talk_content;
        public TextView tv_cream_talk_hot;
        public LinearLayout ll_cream_talk_hot;
        public TextView tv_cream_talk_field;
        public TextView tv_cream_talk_up;
        public TextView tv_cream_talk_down;
        public TextView tv_cream_talk_share;
        public TextView tv_cream_talk_comment;
    }
}
