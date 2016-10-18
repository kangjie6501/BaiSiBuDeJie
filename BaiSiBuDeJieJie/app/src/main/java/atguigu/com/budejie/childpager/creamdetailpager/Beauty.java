package atguigu.com.budejie.childpager.creamdetailpager;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

import atguigu.com.budejie.MainActivity;
import atguigu.com.budejie.domain.CreamRadioBean;
import atguigu.com.budejie.utils.ConnectUtils;
import atguigu.com.budejie.childpager.basepager.ChildBasePager;

/**
 * Created by Administrator on 2016/1/12.
 */
public class Beauty extends ChildBasePager{

    private ArrayList<CreamRadioBean.ListEntity> list;

    public Beauty(Activity activity) {
        super((MainActivity) activity);
    }

    @Override
    public View initView() {
        TextView textView=new TextView(mActivity);
        textView.setText("美女！！！");
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
       // getDataFromNet();

    }

    private void getDataFromNet() {
        RequestQueue requestQueue= Volley.newRequestQueue(mActivity);
        StringRequest request=new StringRequest(StringRequest.Method.GET, ConnectUtils.CREAM_VADIO_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
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
        CreamRadioBean radioBean = gson.fromJson(json, CreamRadioBean.class);
        list= (ArrayList<CreamRadioBean.ListEntity>) radioBean.getList();
    }

}
