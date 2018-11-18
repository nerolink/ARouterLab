package com.nerolink.arouterlab;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 7)
public class DialogInterceptor implements IInterceptor {
    private Context context;
    @Override
    public void process(final Postcard postcard, final InterceptorCallback callback) {
        if (postcard.getPath().equals("/test/empty")) {
            AlertDialog.Builder ab = new AlertDialog.Builder(context);
            ab.setCancelable(false);
            ab.setTitle("来自拦截器");
            ab.setMessage("Alert Dialog!!");
            ab.setNeutralButton("neutral", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    callback.onInterrupt(null);
                }
            });
            ab.setPositiveButton("positive", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    postcard.withLong("interceptorMessage", 10L);

                }
            });
        }
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
