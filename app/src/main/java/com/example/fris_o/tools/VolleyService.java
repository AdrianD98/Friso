package com.example.fris_o.tools;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class VolleyService {

    IResult mResultCallback = null;
    Context mContext;
    RequestQueue queue;

    public VolleyService(IResult resultCallback, Context context){
        mResultCallback = resultCallback;
        mContext = context;
        this.queue = Volley.newRequestQueue(mContext);
    }


    public void postDataVolley(final String requestType, String url, JSONObject sendObj){

        try {
            queue.getCache().clear();
            JsonObjectRequest jsonObj = new JsonObjectRequest(Request.Method.POST, url,sendObj, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(mResultCallback != null)
                        mResultCallback.ObjSuccess(requestType,response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if(mResultCallback != null)
                        mResultCallback.notifyError(requestType,error);
                }
            });
            jsonObj.setShouldCache(false);

            queue.add(jsonObj);

        }catch(Exception e){

        }
    }

    public void postDataVolleyArrayResp(final String requestType, String url, JSONArray sendObj){

        try {
            queue.getCache().clear();
            JsonArrayRequest jsonObj = new JsonArrayRequest(Request.Method.POST, url,sendObj, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    if(mResultCallback != null)
                        mResultCallback.ArrSuccess(requestType,response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if(mResultCallback != null)
                        mResultCallback.notifyError(requestType,error);
                }
            });

            jsonObj.setShouldCache(false);
            queue.add(jsonObj);

        }catch(Exception e){

        }
    }

    public void getDataVolley(final String requestType, String url){

        try {

            queue.getCache().clear();
            JsonObjectRequest jsonObj = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(mResultCallback != null)
                        mResultCallback.ObjSuccess(requestType, response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if(mResultCallback != null)
                        mResultCallback.notifyError(requestType, error);
                }
            });
            jsonObj.setShouldCache(false);
            queue.add(jsonObj);

        }catch(Exception e){

        }
    }

    public void getDataArrayVolley(final String requestType, String url){

        try {
            queue.getCache().clear();
            JsonArrayRequest jsonObj = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    if(mResultCallback != null)
                        mResultCallback.ArrSuccess(requestType, response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if(mResultCallback != null)
                        mResultCallback.notifyError(requestType, error);
                }
            });
            jsonObj.setShouldCache(false);
            queue.add(jsonObj);

        }catch(Exception e){

        }
    }

    public void putDataVolley(final String requestType, String url, JSONObject sendObj){

        try {
            queue.getCache().clear();
            JsonObjectRequest jsonObj = new JsonObjectRequest(Request.Method.PUT, url,sendObj, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(mResultCallback != null)
                        mResultCallback.ObjSuccess(requestType,response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if(mResultCallback != null)
                        mResultCallback.notifyError(requestType,error);
                }
            });
            jsonObj.setShouldCache(false);
            queue.add(jsonObj);

        }catch(Exception e){

        }
    }




}
