/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.CountDownTimer
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  sg.nec.com.epid_sdk_master.R
 *  sg.nec.com.epid_sdk_master.R$id
 *  sg.nec.com.epid_sdk_master.R$layout
 *  sg.nec.com.epid_sdk_master.R$string
 */
package com.pandasoft.liveness.epid_sdk_master.b;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import sg.nec.com.epid_sdk_master.R;
import sg.nec.com.epid_sdk_master.ePIDMainActivity;

public class c
extends Fragment {
    private View jq;
    private TextView lH;
    private TextView lI;
    private String errorCode;
    private String gC;
    private CountDownTimer lJ;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.jq == null) {
            this.jq = layoutInflater.inflate(R.layout.result_fragment, viewGroup, false);
            this.lH = (TextView)this.jq.findViewById(R.id.resultNameTxt);
            this.lI = (TextView)this.jq.findViewById(R.id.helloTxt);
            LinearLayout linearLayout = (LinearLayout)this.jq.findViewById(R.id.resultLayout);
            linearLayout.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    c.this.km();
                }
            });
            this.kn();
        }
        this.lJ = new CountDownTimer(10000L, 1000L){

            public void onTick(long l2) {
            }

            public void onFinish() {
                c.this.km();
            }
        }.start();
        return this.jq;
    }

    private void km() {
        this.lJ.cancel();
        if (this.errorCode.equals("0")) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)"http://sg.nec.com"));
            this.startActivity(intent);
            this.getActivity().finish();
        } else {
            ePIDMainActivity ePIDMainActivity2 = (ePIDMainActivity)this.getActivity();
            ePIDMainActivity2.finishAndRestart();
        }
    }

    private void kn() {
        Bundle bundle = this.getArguments();
        this.errorCode = bundle.getString("errorCode");
        this.gC = bundle.getString("clearResult");
        if (this.errorCode.equals("0")) {
            if (this.gC.equals("1")) {
                this.lI.setText((CharSequence)this.getString(R.string.hello));
                this.lH.setText((CharSequence)bundle.getString("name"));
            } else {
                this.lH.setText((CharSequence)this.getString(R.string.noMatch));
            }
        } else {
            this.lH.setText((CharSequence)bundle.getString("errorDescription"));
        }
    }

    public void onPause() {
        super.onPause();
        this.lJ.cancel();
    }

}

