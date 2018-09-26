/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Paint
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.preference.PreferenceManager
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  sg.nec.com.epid_sdk_master.R
 *  sg.nec.com.epid_sdk_master.R$id
 *  sg.nec.com.epid_sdk_master.R$layout
 */
package com.pandasoft.liveness.epid_sdk_master.b;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import sg.nec.com.epid_sdk_master.R;
import sg.nec.com.epid_sdk_master.data.ePIDModel;
import sg.nec.com.epid_sdk_master.ePIDMainActivity;
import sg.nec.com.epid_sdk_master.services.a;
import sg.nec.com.epid_sdk_master.services.a.e;
import sg.nec.com.epid_sdk_master.services.ePIDResponseListener;

public class b
extends Fragment {
    private View jq;
    private boolean lq = true;
    private String lr;
    public ePIDMainActivity.a ls;
    private ePIDResponseListener<String> lt;
    private static final String TAG = b.class.getName();
    private a jb = new a();
    private ImageView lu;
    private ImageView lv;
    private ePIDMainActivity lw;
    private ProgressBar kt;
    private TextView lx;
    private RelativeLayout ly;
    ImageView lz;
    private SharedPreferences lA;
    Context ha;
    public static String lB = "/";
    int lC;
    public boolean lD = false;
    private Activity ft;
    sg.nec.com.epid_sdk_master.b jX;
    Paint fo = new Paint();
    float left = 0.0f;
    float top = 0.0f;
    float right = 0.0f;
    float bottom = 0.0f;
    private Handler mHandler = new Handler(new Handler.Callback(){

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0: {
                    b.this.lq = false;
                    b.this.ly.setVisibility(8);
                    b.this.lr = "Verification error, please try again";
                    b.this.x(b.this.lr);
                }
            }
            return false;
        }
    });

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Log.e((String)TAG, (String)"OnCreateView ");
        this.lw = (ePIDMainActivity)this.getActivity();
        this.lA = PreferenceManager.getDefaultSharedPreferences((Context)this.getActivity());
        this.ft = this.getActivity();
        if (this.jq == null) {
            this.jq = layoutInflater.inflate(R.layout.confirmation_fragment, viewGroup, false);
            this.kt = (ProgressBar)this.jq.findViewById(R.id.progressBar);
            this.lx = (TextView)this.jq.findViewById(R.id.myTextProgress);
            this.ly = (RelativeLayout)this.jq.findViewById(R.id.progressBarRelativeLayout);
            this.lu = (ImageView)this.jq.findViewById(R.id.backBtn);
            this.lz = (ImageView)this.jq.findViewById(R.id.capturedImg);
            this.ha = this.getActivity().getApplicationContext();
            this.lu.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    b.this.lu.performHapticFeedback(1);
                    if (ePIDModel.getInstance().get_ePIDWorkflow() == ePIDModel.b.ij) {
                        ePIDModel.getInstance().setIsFirstCapture(null);
                    }
                    b.this.lw.closeConfirmationFragment();
                }
            });
            this.lv = (ImageView)this.jq.findViewById(R.id.nextBtn);
            this.lv.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    b.this.lv.performHapticFeedback(1);
                    ePIDModel.getInstance().setIsFirstCapture("true");
                    ++b.this.lC;
                    Log.i((String)"Click Submit Button ", (String)String.valueOf(b.this.lC));
                    if (b.this.lq) {
                        Log.i((String)" flagFaceSuccess", (String)" True");
                        b.this.lq = false;
                        b.this.ly.setVisibility(0);
                        if (ePIDModel.getInstance().isCaptureOnly()) {
                            Log.e((String)TAG, (String)"Capture Only Next Button Call");
                            b.this.lt = ePIDModel.getInstance().getePIDResponseListener();
                            Log.e((String)TAG, (String)("Capture Only ImageData " + ePIDModel.getInstance().getImageCapture().toString()));
                            b.this.lt.onResponse("Pass Image as String");
                        } else if (ePIDModel.getInstance().get_ePIDWorkflow() == ePIDModel.b.ij && ePIDModel.getInstance().isFaceSpoofDetection()) {
                            if (ePIDModel.getInstance().getOperation() == 0) {
                                b.this.jX.faceDetectionCallback(true);
                            } else {
                                e e2 = new e(b.this.ft, "", "", "", "", "", "", "", ePIDModel.getInstance().getImageCapture(), ePIDModel.getInstance().getePIDResponseListener(), null);
                                e2.execute((Object[])new Void[0]);
                            }
                        } else {
                            Log.d((String)TAG, (String)(">>>>> currentImageCapture " + ePIDModel.getInstance().getImageCapture()));
                            e e3 = new e(b.this.ft, "", "", "", "", "", "", "", ePIDModel.getInstance().getImageCapture(), ePIDModel.getInstance().getePIDResponseListener(), null);
                            e3.execute((Object[])new Void[0]);
                        }
                    } else if (!TextUtils.isEmpty((CharSequence)b.this.lr)) {
                        b.this.x(b.this.lr);
                    }
                    Log.i((String)" After Clickcount", (String)String.valueOf(b.this.lC));
                }
            });
            if (ePIDModel.getInstance().getImageCapture() != null) {
                Log.e((String)TAG, (String)"ImageCapture not null");
            } else {
                Log.e((String)TAG, (String)"ImageCapture null");
            }
            Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])ePIDModel.getInstance().getImageCapture(), (int)0, (int)ePIDModel.getInstance().getImageCapture().length);
            this.lz.setImageBitmap(bitmap);
            if (ePIDModel.getInstance().is_ePIDCaptureAutomatic()) {
                this.lu.setVisibility(8);
                this.lv.setVisibility(8);
                this.lv.callOnClick();
            }
        }
        return this.jq;
    }

    public void d(Object object) {
        this.jX = (sg.nec.com.epid_sdk_master.b)object;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.e((String)TAG, (String)("OnAttach " + this.jX));
        this.ft = activity;
    }

    public void onStart() {
        super.onStart();
        Log.e((String)TAG, (String)"onStart created");
    }

    private void x(final String string2) {
        new Thread(){

            @Override
            public void run() {
                b.this.ft.runOnUiThread(new Runnable(){

                    @Override
                    public void run() {
                        Toast.makeText((Context)b.this.ha, (CharSequence)string2, (int)0).show();
                    }
                });
            }

        }.start();
    }

    public void onResume() {
        Log.e((String)TAG, (String)(" call OnResume" + this.jX));
        this.ft.setRequestedOrientation(1);
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        Log.e((String)TAG, (String)("OnPause " + this.jX));
        this.ft.setRequestedOrientation(10);
    }

}

