package atguigu.com.budejie.childpager.creamdetailpager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;

import java.util.List;

import atguigu.com.budejie.MainActivity;
import atguigu.com.budejie.R;
import atguigu.com.budejie.childpager.basepager.ChildBasePager;
import atguigu.com.budejie.domain.CreamArtycleBean;
import atguigu.com.budejie.utils.CacheUtils;
import atguigu.com.budejie.utils.ConnectUtils;
import atguigu.com.budejie.utils.ImageLoaderUtils;

/**
 * Created by Administrator on 2016/1/12.
 */
public class Artycle extends ChildBasePager{

    private ListView lv_cream_talk;
    private List<CreamArtycleBean.ListEntity> list;
    private ImageLoaderUtils loaderUtils;
    public Artycle(Activity activity) {
        super((MainActivity) activity);
    }

    @Override
    public View initView() {
        View view=View.inflate(mActivity, R.layout.cream_talk,null);
        lv_cream_talk= (ListView) view.findViewById(R.id.lv_cream_talk);
        loaderUtils=new ImageLoaderUtils();
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        if(!TextUtils.isEmpty(CacheUtils.getString(mActivity,ConnectUtils.CREAM_ARTYCLE_URL))){
            processData(CacheUtils.getString(mActivity,ConnectUtils.CREAM_ARTYCLE_URL));
        }

        getDataFromNet();
    }

    private void getDataFromNet() {
        RequestQueue requestQueue= Volley.newRequestQueue(mActivity);
        StringRequest request=new StringRequest(StringRequest.Method.GET, ConnectUtils.CREAM_ARTYCLE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CacheUtils.putString(mActivity,ConnectUtils.CREAM_ARTYCLE_URL,response);
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

    private void processData(String json) {
        Gson gson=new Gson();
        CreamArtycleBean artycleBean = gson.fromJson(json, CreamArtycleBean.class);
        list=artycleBean.getList();
        lv_cream_talk.setAdapter(new MyArtycleAdapter());
    }
    class MyArtycleAdapter extends BaseAdapter{
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
                convertView=View.inflate(mActivity,R.layout.cream_artycle_item,null);
                viewHolder.iv_cream_artycle_lable= (ImageView) convertView.findViewById(R.id.iv_cream_artycle_lable);
                viewHolder.tv_cream_artycle_name= (TextView) convertView.findViewById(R.id.tv_cream_artycle_name);
                viewHolder.tv_cream_artycle_date= (TextView) convertView.findViewById(R.id.tv_cream_artycle_date);
                viewHolder.iv_cream_artycle_content= (ImageView) convertView.findViewById(R.id.iv_cream_artycle_content);
                viewHolder.iv_cream_artycle_operate= (ImageView) convertView.findViewById(R.id.iv_cream_artycle_operate);
                viewHolder.tv_cream_artycle_content= (TextView) convertView.findViewById(R.id.tv_cream_artycle_content);
                viewHolder.tv_cream_artycle_jump= (TextView) convertView.findViewById(R.id.tv_cream_artycle_jump);
                viewHolder.tv_cream_artycle_hot= (TextView) convertView.findViewById(R.id.tv_cream_artycle_hot);
                viewHolder.tv_cream_artycle_up= (TextView) convertView.findViewById(R.id.tv_cream_artycle_up);
                viewHolder.tv_cream_artycle_down= (TextView) convertView.findViewById(R.id.tv_cream_artycle_down);
                viewHolder.tv_cream_artycle_share= (TextView) convertView.findViewById(R.id.tv_cream_artycle_share);
                viewHolder.tv_cream_artycle_comment= (TextView) convertView.findViewById(R.id.tv_cream_artycle_comment);
                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }
            loaderUtils.universeImageLoader.displayImage(list.get(position).getU().getHeader().get(0), viewHolder.iv_cream_artycle_lable,
                    loaderUtils.options, new ImageLoadingListener() {
                        @Override
                        public void onLoadingStarted(String s, View view) {
                            Log.e("TAG","成功");
                        }

                        @Override
                        public void onLoadingFailed(String s, View view, FailReason failReason) {
                            Log.e("TAG","失败");
                        }

                        @Override
                        public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                            if(bitmap!=null){
                                viewHolder.iv_cream_artycle_lable.setImageBitmap(bitmap);
                            }else{
                                viewHolder.iv_cream_artycle_lable.setImageResource(R.drawable.icon_new);
                            }
                        }

                        @Override
                        public void onLoadingCancelled(String s, View view) {

                        }
                    });
            loaderUtils.universeImageLoader.displayImage(list.get(position).getHtml().getThumbnail().get(0), viewHolder.iv_cream_artycle_content,
                    loaderUtils.options, new ImageLoadingListener() {
                        @Override
                        public void onLoadingStarted(String s, View view) {
                            Log.e("TAG", "成功");
                        }

                        @Override
                        public void onLoadingFailed(String s, View view, FailReason failReason) {
                            Log.e("TAG", "失败");
                        }

                        @Override
                        public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                            if (bitmap != null) {
                                viewHolder.iv_cream_artycle_content.setImageBitmap(bitmap);
                            } else {
                                viewHolder.iv_cream_artycle_content.setImageResource(R.drawable.love_tip);
                            }
                        }

                        @Override
                        public void onLoadingCancelled(String s, View view) {

                        }
                    });
            viewHolder.tv_cream_artycle_name.setText(list.get(position).getU().getName());
            viewHolder.tv_cream_artycle_date.setText(list.get(position).getPasstime());
            viewHolder.tv_cream_artycle_content.setText(list.get(position).getHtml().getTitle());
            viewHolder.tv_cream_artycle_up.setText(list.get(position).getUp());
            viewHolder.tv_cream_artycle_down.setText(list.get(position).getDown());
            viewHolder.tv_cream_artycle_share.setText(list.get(position).getForward());
            viewHolder.tv_cream_artycle_comment.setText(list.get(position).getComment());
            return convertView;
        }
    }
    class ViewHolder{
        public ImageView iv_cream_artycle_lable;
        public TextView tv_cream_artycle_name;
        public TextView tv_cream_artycle_date;
        public ImageView iv_cream_artycle_content;
        public ImageView iv_cream_artycle_operate;
        public TextView tv_cream_artycle_content;
        public TextView tv_cream_artycle_jump;
        public TextView tv_cream_artycle_hot;
        public TextView tv_cream_artycle_up;
        public TextView tv_cream_artycle_down;
        public TextView tv_cream_artycle_share;
        public TextView tv_cream_artycle_comment;
    }
}
