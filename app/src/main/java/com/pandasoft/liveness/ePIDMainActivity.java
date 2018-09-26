package com.pandasoft.liveness;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.kony.sdk.callback.InitCallback;
import com.kony.sdk.callback.LoginCallback;
import com.kony.sdk.client.KonyClient;
import com.kony.sdk.common.IdentityServiceException;
import com.kony.sdk.common.KonyException;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.StringReader;
import java.security.Key;
import java.security.KeyStore;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import sg.nec.com.epid_sdk_master.c;
import sg.nec.com.epid_sdk_master.data.ResultResponse;
import sg.nec.com.epid_sdk_master.data.ePIDModel;
import sg.nec.com.epid_sdk_master.services.ePIDResponseListener;
import sg.nec.com.epid_sdk_master.utils.XMLParser;
import sg.nec.com.epid_sdk_master.utils.XMLParser_RetrieveBiometrics;
import sg.nec.com.epid_sdk_master.utils.d;
import sg.nec.com.epid_sdk_master.utils.e;
import sg.nec.com.epid_sdk_master.utils.f;
import sg.nec.com.epid_sdk_master.utils.g;
import sg.nec.com.epid_sdk_master.utils.h;

public class ePIDMainActivity extends Activity implements sg.nec.com.epid_sdk_master.b, c, sg.nec.com.epid_sdk_master.utils.c {
    private static String TAG = ePIDMainActivity.class.getSimpleName();
    private String hb;
    private String iB;
    private String gm;
    private byte[] iC;
    private byte[] iD;
    private byte[] iE;
    private String gP;
    private String firstName;
    private String lastName;
    private String middleName;
    private String gf;
    private String gg;
    private String fb;
    private String fc;
    private String hE;
    private String hF;
    private String iF;
    private String iG;
    private String hJ;
    private String sessionId;
    private String hK;
    private int hy = 90;
    private boolean hf;
    private boolean hg;
    private boolean hh;
    private boolean iH;
    private boolean iI;
    private boolean iJ;
    private boolean iK;
    private boolean iL;
    private boolean iM;
    private boolean iN;
    private boolean iO;
    private boolean iP;
    private boolean ho;
    private sg.nec.com.epid_sdk_master.b.a iQ;
    private sg.nec.com.epid_sdk_master.b.b iR;
    private sg.nec.com.epid_sdk_master.b.c iS;
    private ePIDMainActivity.b iT;
    public static ePIDMainActivity.a screenOrientation;
    private int hz;
    private int iU;
    public static SecretKeySpec secretKeySpec;
    private KeyStore iV;
    sg.nec.com.epid_sdk_master.a.b<byte[], byte[], Key> iW = new sg.nec.com.epid_sdk_master.a.c();
    boolean iX;
    boolean iY;
    boolean iZ;
    RelativeLayout ja;
    sg.nec.com.epid_sdk_master.services.a jb = new sg.nec.com.epid_sdk_master.services.a();
    String jc = "";
    String error = null;
    String jd = "";
    private Handler mHandler = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message var1) {
            Intent var2 = new Intent();
            switch(var1.what) {
                case 0:
                    if (ePIDModel.getInstance().get_ePIDWorkflow() == sg.nec.com.epid_sdk_master.data.ePIDModel.b.ij && ePIDModel.getInstance().isFaceSpoofDetection() && ePIDModel.getInstance().getOperation() == 0) {
                        if (ePIDMainActivity.this.iX && !ePIDMainActivity.this.iY) {
                            ePIDMainActivity.this.iY = true;
                            Log.e(ePIDMainActivity.TAG, "face detection success with dataResult=" + ePIDMainActivity.this.jc);
                            if (ePIDModel.getInstance().isCaptureOnly()) {
                                var2.putExtra("captureOnlyImage", ePIDModel.getInstance().getImageCapture());
                                ePIDMainActivity.this.setResult(-1, var2);
                                ePIDMainActivity.this.finish();
                            } else {
                                Log.d("onSuccess DataResult", ePIDMainActivity.this.jc);
                                var2.putExtra("result", ePIDMainActivity.this.jc);
                                ePIDMainActivity.this.setResult(-1, var2);
                                ePIDMainActivity.this.finish();
                            }
                        } else {
                            Log.e(ePIDMainActivity.TAG, "face detection fails with dataResult=" + ePIDMainActivity.this.jc);
                        }
                    } else if (ePIDModel.getInstance().isCaptureOnly()) {
                        var2.putExtra("captureOnlyImage", ePIDModel.getInstance().getImageCapture());
                        ePIDMainActivity.this.setResult(-1, var2);
                        ePIDMainActivity.this.finish();
                    } else {
                        Log.d("onSuccess DataResult", ePIDMainActivity.this.jc);
                        var2.putExtra("result", ePIDMainActivity.this.jc);
                        ePIDMainActivity.this.setResult(-1, var2);
                        ePIDMainActivity.this.finish();
                    }
                    break;
                case 1:
                    if (ePIDModel.getInstance().get_ePIDWorkflow() == sg.nec.com.epid_sdk_master.data.ePIDModel.b.ij && ePIDModel.getInstance().isFaceSpoofDetection() && ePIDModel.getInstance().getOperation() == 0) {
                        if (ePIDMainActivity.this.iX && !ePIDMainActivity.this.iY) {
                            Log.e(ePIDMainActivity.TAG, "face detection success with error=" + ePIDMainActivity.this.error);
                            ePIDMainActivity.this.iY = true;
                            var2.putExtra("error", ePIDMainActivity.this.error);
                            ePIDMainActivity.this.setResult(0, var2);
                            ePIDMainActivity.this.finish();
                        } else {
                            Log.e(ePIDMainActivity.TAG, "face detection fails with error=" + ePIDMainActivity.this.error);
                        }
                    } else {
                        var2.putExtra("error", ePIDMainActivity.this.error);
                        ePIDMainActivity.this.setResult(0, var2);
                        ePIDMainActivity.this.finish();
                    }
            }

            return false;
        }
    });

    public ePIDMainActivity() {
    }

    public Intent getIntent() {
        return super.getIntent();
    }

    public void onSaveInstanceState(Bundle var1) {
        super.onSaveInstanceState(var1);
        var1.putInt("currentScreen", this.iT.ordinal());
    }

    protected void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.setContentView(sg.nec.com.epid_sdk_master.R.layout.activity_necepid_main);
        this.ja = (RelativeLayout)this.findViewById(sg.nec.com.epid_sdk_master.R.id.progresbarRelativeLayout);
        this.initEPIDData();
        Bundle var2 = this.getIntent().getExtras();
        if (var2 != null) {
            if (this.getIntent().hasExtra("UpdateWithExistingPhoto")) {
                Log.e("update with photo", "");
                this.iC = var2.getByteArray("UpdateWithExistingPhoto");
                ePIDModel.getInstance().setUpdateWithPhoto(this.iC);
                this.hb = var2.getString("SubjectID");
                this.iB = var2.getString("BiometricOperation");
                this.gP = var2.getString("URLServer");
                this.hf = var2.getBoolean("isFace_Spoof_Detection");
                ePIDModel.getInstance().setFaceSpoofDetection(Boolean.valueOf(this.hf));
                ePIDModel.getInstance().setWorkstationName(var2.getString("workstation"));
                ePIDModel.getInstance().setCertificateName(var2.getString("certificateName"));
                h.B(this.gP);
                this.a(ePIDMainActivity.b.jo);
                this.b(this.hb, this.iB);
                this.a(ePIDMainActivity.b.jo);
                this.ja.setVisibility(View.VISIBLE);
            } else if (this.getIntent().hasExtra("DeleteWithExistingPhoto")) {
                Log.d("delete with photo", "");
                this.iD = var2.getByteArray("DeleteWithExistingPhoto");
                ePIDModel.getInstance().setDeleteWithPhoto(this.iD);
                this.hb = var2.getString("SubjectID");
                this.iB = var2.getString("BiometricOperation");
                this.gP = var2.getString("URLServer");
                ePIDModel.getInstance().setFaceSpoofDetection(Boolean.valueOf(var2.getString("IsFaceSpoofDetection")));
                ePIDModel.getInstance().setWorkstationName(var2.getString("workstation"));
                ePIDModel.getInstance().setCertificateName(var2.getString("certificateName"));
                if (TextUtils.isEmpty(this.gP)) {
                    this.gP = "https://gis.nec.com.sg/bdo/epid-webservices/api/epidService?wsdl";
                }

                h.B(this.gP);
                this.b(this.hb, this.iB);
                this.ja.setVisibility(View.VISIBLE);
            } else if (this.getIntent().hasExtra("RequestToken")) {
                this.gP = var2.getString("URLServer");
                ePIDModel.getInstance().setFaceSpoofDetection(Boolean.valueOf(var2.getString("IsFaceSpoofDetection")));
                if (TextUtils.isEmpty(this.gP)) {
                    this.gP = "https://gis.nec.com.sg/bdo/epid-webservices/api/epidService?wsdl";
                }

                h.B(this.gP);
                this.jb.a(new ePIDResponseListener<String>() {
                    public void u(String var1) {
                        Log.d(ePIDMainActivity.TAG, var1.toString());
                        if (var1 != null) {
                            ePIDMainActivity.this.jc = var1;
                            System.out.println(var1.toString());
                            ePIDMainActivity.this.mHandler.sendEmptyMessage(0);
                            XMLParser var2 = new XMLParser(var1);

                            try {
                                ResultResponse var3 = var2.parseResultResponse();
                                if (!var3.getErrorCode().equals("0")) {
                                    Log.d(ePIDMainActivity.TAG, ePIDMainActivity.this.getString(sg.nec.com.epid_sdk_master.R.string.connectionError));
                                } else {
                                    Log.d(ePIDMainActivity.TAG, "Request Token Successfully");
                                }
                            } catch (Exception var4) {
                                var4.printStackTrace();
                            }
                        } else {
                            Log.d(ePIDMainActivity.TAG, ePIDMainActivity.this.getString(sg.nec.com.epid_sdk_master.R.string.connectionError));
                        }

                    }

                    @Override
                    public void onResponse(String s) {

                    }

                    public void onResponse(byte[] var1) {
                    }

                    public void onError(Exception var1) {
                        ePIDMainActivity.this.error = var1.toString();
                        ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                        var1.printStackTrace();
                    }

                    public void onError(String var1) {
                        ePIDMainActivity.this.error = var1.toString();
                        ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                    }
                });
            } else if (this.getIntent().hasExtra("RetrieveBiometricOperation")) {
                this.hb = var2.getString("SubjectID");
                this.gP = var2.getString("URLServer");
                if (TextUtils.isEmpty(this.gP)) {
                    this.gP = "http://172.16.2.50:8380/epid-webservices/api/epidService?wsdl";
                }

                h.B(this.gP);
                this.jb.a(this, this.hb, new ePIDResponseListener<String>() {
                    public void u(String var1) {
                        Log.e("retrieve Response", var1.toString());

                        try {
                            BufferedReader var2 = new BufferedReader(new StringReader(var1));
                            InputSource var3 = new InputSource(var2);
                            XMLParser_RetrieveBiometrics var4 = new XMLParser_RetrieveBiometrics();
                            SAXParserFactory var5 = SAXParserFactory.newInstance();
                            SAXParser var6 = var5.newSAXParser();
                            XMLReader var7 = var6.getXMLReader();
                            var7.setContentHandler(var4);
                            var7.parse(var3);
                        } catch (Exception var8) {
                            ;
                        }

                        ePIDMainActivity.this.mHandler.sendEmptyMessage(0);
                    }

                    @Override
                    public void onResponse(String s) {

                    }

                    public void onResponse(byte[] var1) {
                    }

                    public void onError(Exception var1) {
                        ePIDMainActivity.this.error = var1.getMessage();
                        ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                    }

                    public void onError(String var1) {
                        ePIDMainActivity.this.error = var1;
                        ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                    }
                });
            } else {
                Log.d("start main activity", "");
                this.hb = var2.getString("SubjectID");
                this.iB = var2.getString("BiometricOperation");
                this.gP = var2.getString("URLServer");
                this.firstName = var2.getString("firstName");
                this.lastName = var2.getString("lastName");
                this.middleName = var2.getString("middleName");
                this.gf = var2.getString("dob");
                this.gg = var2.getString("suffixOrComplement");
                this.hf = var2.getBoolean("isFace_Spoof_Detection");
                this.hg = var2.getBoolean("isIncludeImage");
                this.hh = var2.getBoolean("isIncludeVoice");
                this.hz = var2.getInt("Timer");
                this.hy = var2.getInt("JPEGQuality");
                this.iP = var2.getBoolean("isKonyMobileFabric");
                this.iO = var2.getBoolean("isFaceFirst");
                this.iH = var2.getBoolean("isSmile");
                Log.e(TAG, "isSmile from bundel " + String.valueOf(var2.getBoolean("isSmile")));
                this.iI = var2.getBoolean("isBlink");
                Log.e(TAG, "isBlink from bundel " + String.valueOf(var2.getBoolean("isBlink")));
                Log.e(TAG, "isNothing from bundel " + String.valueOf(var2.getBoolean("isNothing")));
                this.iJ = var2.getBoolean("isMoveHeadLeft");
                this.iK = var2.getBoolean("isMoveHeadRight");
                this.iL = var2.getBoolean("isCloseLeftEye");
                this.iM = var2.getBoolean("isCloseRightEye");
                this.iN = var2.getBoolean("isCaptureAutomatic");
                this.ho = var2.getBoolean("isCaptureOnly");
                this.iU = var2.getInt("ContinuousSuccess");
                this.gm = var2.getString("institution");
                Log.i(TAG, "FaceSpoofDetection Default Value " + var2.getBoolean("isFace_Spoof_Detection"));
                ePIDModel.getInstance().setFirstName(this.firstName);
                ePIDModel.getInstance().setLastName(this.lastName);
                ePIDModel.getInstance().setMiddleName(this.middleName);
                ePIDModel.getInstance().setDob(this.gf);
                ePIDModel.getInstance().setSuffixOrComplement(this.gg);
                ePIDModel.getInstance().setFaceSpoofDetection(this.hf);
                ePIDModel.getInstance().setEnableImage(this.hg);
                ePIDModel.getInstance().setEnableVoice(this.hh);
                ePIDModel.getInstance().setKonyMobileFabric(this.iP);
                ePIDModel.getInstance().set_ePIDCaptureAutomatic(this.iN);
                ePIDModel.getInstance().setCaptureOnly(this.ho);
                ePIDModel.getInstance().setInstitution(this.gm);
                ePIDModel.getInstance().setWorkstationName(var2.getString("workstation"));
                ePIDModel.getInstance().setCertificateName(var2.getString("certificateName"));
                ePIDModel.getInstance().setFaceConsistencyCheck(var2.getBoolean("isFaceConsistencyCheck"));
                ePIDModel.getInstance().setGettingActionSuccessImages(var2.getBoolean("getActionImage"));
                ePIDModel.getInstance().setGettingActionSuccessVideos(var2.getBoolean("getActionVideo"));
                if (this.getIntent().hasExtra("isFaceFirst")) {
                    this.iO = var2.getBoolean("isFaceFirst");
                    if (this.iO) {
                        ePIDModel.getInstance().set_ePIDWorkflow(sg.nec.com.epid_sdk_master.data.ePIDModel.b.ij);
                    } else {
                        ePIDModel.getInstance().set_ePIDWorkflow(sg.nec.com.epid_sdk_master.data.ePIDModel.b.ii);
                    }
                }

                if (this.hz == 0) {
                    this.hz = 5;
                    ePIDModel.getInstance().setTimer(this.hz);
                } else {
                    ePIDModel.getInstance().setTimer(this.hz);
                }

                if (this.hy == 0) {
                    this.hy = 90;
                    ePIDModel.getInstance().setJPEGQuality(this.hy);
                } else {
                    Log.e(TAG, "JPEG Quality " + String.valueOf(this.hy));
                    ePIDModel.getInstance().setJPEGQuality(this.hy);
                }

                if (this.iU == 0) {
                    this.iU = 1;
                    ePIDModel.getInstance().setContinueSuccessActionCount(this.iU);
                } else {
                    ePIDModel.getInstance().setContinueSuccessActionCount(this.iU);
                }

                int var3 = var2.getInt("ChallengeCount");
                if (var3 == 0) {
                    ePIDModel.getInstance().setRequiredActionCount(1);
                } else {
                    ePIDModel.getInstance().setRequiredActionCount(var2.getInt("ChallengeCount"));
                }

                Log.e(TAG, "Timer " + String.valueOf(ePIDModel.getInstance().getTimer()));
                Log.e(TAG, "JPEGQuality " + String.valueOf(ePIDModel.getInstance().getJPEGQuality()));
                Log.e(TAG, "ContinuousSuccess " + String.valueOf(ePIDModel.getInstance().getContinueSuccessActionCount()));
                if (!this.iH && !this.iI && !this.iJ && !this.iK && !this.iL && !this.iM) {
                    ePIDModel.getInstance().get_ePIDAcitons().clear();
                    ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.ie);
                    ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.ib);
                    ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.ig);
                   // ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.if);
                    ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.ic);
                    ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.id);
                    Log.i("Default Detections", String.valueOf(ePIDModel.getInstance().get_ePIDAcitons().size()));
                } else {
                    ePIDModel.getInstance().get_ePIDAcitons().clear();
                    if (this.iH) {
                        ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.ib);
                    }

                    if (this.iI) {
                        ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.ie);
                    }

                    if (this.iJ) {
                        ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.ig);
                    }

                    if (this.iK) {
                        //ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.if);
                    }

                    if (this.iL) {
                        ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.ic);
                    }

                    if (this.iM) {
                        ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.id);
                    }
                }

                Log.i("Actions array sizes", String.valueOf(ePIDModel.getInstance().get_ePIDAcitons().size()));

                for(int var4 = 0; var4 < ePIDModel.getInstance().get_ePIDAcitons().size(); ++var4) {
                    Log.i("Actions array", ((sg.nec.com.epid_sdk_master.data.ePIDModel.a)ePIDModel.getInstance().get_ePIDAcitons().get(var4)).toString());
                }

                if (ePIDModel.getInstance().isKonyMobileFabric()) {
                    this.fb = var2.getString("appkey");
                    this.fc = var2.getString("appsecret");
                    this.hE = var2.getString("konyurl");
                    this.hF = var2.getString("konyservicename");
                    this.iF = var2.getString("KonyRequestTokenOperationName");
                    this.iG = var2.getString("KonySubmitBiometricOperationName");
                    this.hJ = var2.getString("clientId");
                    this.hK = var2.getString("loginId");
                    this.sessionId = var2.getString("sessionId");
                    ePIDModel.getInstance();
                    ePIDModel.setAppKey(this.fb);
                    ePIDModel.getInstance();
                    ePIDModel.setAppSecret(this.fc);
                    ePIDModel.getInstance();
                    ePIDModel.setKonyUrl(this.hE);
                    ePIDModel.getInstance();
                    ePIDModel.setKonyServiceName(this.hF);
                    ePIDModel.getInstance().setRequestTokenoperationName(this.iF);
                    ePIDModel.getInstance().setSubmitBiometricoperationName(this.iG);
                    ePIDModel.getInstance();
                    ePIDModel.setClientId(this.hJ);
                    ePIDModel.getInstance();
                    ePIDModel.setLoginId(this.hK);
                    ePIDModel.getInstance();
                    ePIDModel.setSessionId(this.sessionId);
                    if (!TextUtils.isEmpty(var2.getString("konyloginservicename")) && !TextUtils.isEmpty(var2.getString("konyloginusername")) && !TextUtils.isEmpty(var2.getString("konyloginpassword"))) {
                        ePIDModel.getInstance().setIdentifyService(true);
                        ePIDModel.getInstance().setLoginServiceName(var2.getString("konyloginservicename"));
                        ePIDModel.getInstance().setLoginUserName(var2.getString("konyloginusername"));
                        ePIDModel.getInstance().setLoginPassword(var2.getString("konyloginpassword"));
                    } else {
                        ePIDModel.getInstance().setIdentifyService(false);
                    }
                }

                h.B(this.gP);
                if (this.getIntent().hasExtra("imageOnly")) {
                    this.ja.setVisibility(View.VISIBLE);
                    this.iE = var2.getByteArray("imageOnly");
                    ePIDModel.getInstance().setImageCapture(this.iE);
                    this.a(ePIDMainActivity.b.jo);
                    this.b(this.hb, this.iB);
                } else if (var1 == null) {
                    Log.e(TAG, " call show capture");
                    this.showCaptureFragment();
                } else {
                    Log.e(TAG, " reviveFragments");
                    this.ap(var1.getInt("currentScreen"));
                }
            }
        } else {
            ePIDModel.getInstance().setInputStreamKeyStore(this.getResources().openRawResource(sg.nec.com.epid_sdk_master.R.raw.epidrsa_new));
            ePIDModel.getInstance().setSslSocketFactory(this.getResources().openRawResource(sg.nec.com.epid_sdk_master.R.raw.epid));
            Log.i("No Bundle data found", "");
            this.hb = "TamND_NECAPAC";
            this.iB = "ENROLLMENT_WITH_DUP_CHECK";
            this.gP = "https://gis.nec.com.sg/bdo/epid-webservices/api/epidService?wsdl";
            h.B(this.gP);
            ePIDModel.getInstance().setFaceSpoofDetection(true);
            ePIDModel.getInstance().set_ePIDWorkflow(sg.nec.com.epid_sdk_master.data.ePIDModel.b.ij);
            ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.ib);
            ePIDModel.getInstance().get_ePIDAcitons().add(sg.nec.com.epid_sdk_master.data.ePIDModel.a.ig);
            ePIDModel.getInstance().setJPEGQuality(90);
            ePIDModel.getInstance().set_ePIDCaptureAutomatic(false);
            ePIDModel.getInstance().setWorkstationName("Test");
            ePIDModel.getInstance().setUrlServer(this.gP);
            if (var1 == null) {
                this.showCaptureFragment();
            } else {
                this.ap(var1.getInt("currentScreen"));
            }
        }

    }

    public void initializeKonyMobileFabric() {
        KonyClient var1 = new KonyClient();
        ePIDModel.getInstance();
        String var10002 = ePIDModel.getAppKey();
        ePIDModel.getInstance();
        String var10003 = ePIDModel.getAppSecret();
        ePIDModel.getInstance();
        var1.initAsync(this, var10002, var10003, ePIDModel.getKonyUrl(), new InitCallback() {
            public void onSuccess(JSONObject var1) {
                Log.e(ePIDMainActivity.TAG, "Kony Initialize success");
                KonyClient var2 = new KonyClient();

                try {
                    sg.nec.com.epid_sdk_master.a.eV = var2.getIdentityService(ePIDModel.getInstance().getLoginServiceName());
                    sg.nec.com.epid_sdk_master.a.eV.loginInBackground(ePIDModel.getInstance().getLoginUserName(), ePIDModel.getInstance().getLoginPassword(), new LoginCallback() {
                        public void onSuccess() {
                            Log.e(ePIDMainActivity.TAG, "login success");
                        }

                        public void onFailure(IdentityServiceException var1) {
                            Log.e(ePIDMainActivity.TAG, "login fail");
                            ePIDMainActivity.this.error = var1.toString();
                            ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                        }
                    });
                } catch (Exception var4) {
                    var4.printStackTrace();
                    ePIDMainActivity.this.error = var4.toString();
                    ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                }

            }

            public void onFailure(KonyException var1) {
                Log.e(ePIDMainActivity.TAG, "Kony Initialize fail");
                ePIDMainActivity.this.error = var1.toString();
                ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
            }
        });

    }

    public void setCertificate(InputStream var1) {
        ePIDModel.setInstance((ePIDModel)null);
        ePIDModel.getInstance().setInputStreamKeyStore(var1);
    }

    public void initEPIDData() {
        ePIDModel.getInstance().setContext(this);
        ePIDModel.getInstance().setRsaKeyAlgorithm(this.getResources().getString(sg.nec.com.epid_sdk_master.R.string.rsaKeyAlgorithm));
        ePIDModel.getInstance().setProviderName(this.getResources().getString(sg.nec.com.epid_sdk_master.R.string.providerName));
    }

    public void initEPIDData(Context var1) {
        ePIDModel.getInstance().setContext(var1);
        ePIDModel.getInstance().setSslSocketFactory(var1.getResources().openRawResource(sg.nec.com.epid_sdk_master.R.raw.epid));
        ePIDModel.getInstance().setRsaKeyAlgorithm(var1.getResources().getString(sg.nec.com.epid_sdk_master.R.string.rsaKeyAlgorithm));
        ePIDModel.getInstance().setProviderName(var1.getResources().getString(sg.nec.com.epid_sdk_master.R.string.providerName));
        Log.i("finish InitEPID()", "");
    }

    public String generateSessionKey(String var1) {
        ePIDModel.getInstance().setCertificateName(var1);
        this.iV = f.getKeyStore();
        secretKeySpec = new SecretKeySpec("1234567890123456".getBytes(), "AES");
        byte[] var2 = secretKeySpec.getEncoded();
        byte[] var3 = sg.nec.com.epid_sdk_master.utils.a.k(var2.length, 4);
        byte[] var4 = sg.nec.com.epid_sdk_master.utils.a.b(var3, var2);
        byte[] var5 = this.encryptRSAData(var4, "EPID.RSA.ENC.001");
        Log.i("sessionkey", e.l(var5) + " " + var5);
        return e.l(var5);
    }

    public byte[] encryptRSAData(byte[] var1, String var2) {
        Log.d(TAG, "encryptRSAData():");
        byte[] var3 = null;

        try {
            Cipher var4 = Cipher.getInstance(ePIDModel.getInstance().getRsaKeyAlgorithm(), ePIDModel.getInstance().getProviderName());
            var4.init(1, this.iV.getCertificate("ca").getPublicKey());
            Log.d(TAG, "public key https = " + ePIDModel.getInstance().getPublicKey());
            Log.d(TAG, "public key http = " + this.iV.getCertificate("ca").getPublicKey());
            var3 = var4.doFinal(var1);
        } catch (Exception var5) {
            Log.d(TAG, "Exception occurred", var5);
            var5.printStackTrace();
        }

        Log.d(TAG, "encryptRSAData(): Done.");
        return var3;
    }

    public String decrypt(String var1) {
        byte[] var2 = null;
        byte[] var3 = Base64.decodeBase64(var1.getBytes());

        try {
            SecretKeySpec var4 = new SecretKeySpec("1234567890123456".getBytes(), "AES");
            var2 = (byte[])this.iW.b(var3, var4);
        } catch (Exception var5) {
            ;
        }

        return new String(var2);
    }

    private void b(String var1, String var2) {
        Log.d(TAG, "call action isServerCallbackisCalled=" + ePIDModel.getInstance().isServerCallbackisCalled());
        this.jb.a(g.c(var2, var1), (String)null, new ePIDResponseListener<String>() {
            public void u(String var1) {
                Log.d(ePIDMainActivity.TAG, " Server Response " + var1);
                if (ePIDMainActivity.this.ho) {
                    ePIDMainActivity.this.mHandler.sendEmptyMessage(0);
                } else {
                    ePIDMainActivity.this.jc = var1;
                    XMLParser var2;
                    ResultResponse var3;
                    if (ePIDModel.getInstance().get_ePIDWorkflow() == sg.nec.com.epid_sdk_master.data.ePIDModel.b.ij && ePIDModel.getInstance().isFaceSpoofDetection() && ePIDModel.getInstance().getOperation() == 0) {
                        ePIDModel.getInstance().setServerCallbackisCalled(true);
                        if (ePIDMainActivity.this.iZ) {
                            Log.e(ePIDMainActivity.TAG, " Face Detection finish first!");
                            var2 = new XMLParser(var1);

                            try {
                                var3 = var2.parseResultResponse();
                                Log.d("result errorCode", var3.getErrorCode());
                                if (!var3.getErrorCode().equals("0")) {
                                    Log.d(ePIDMainActivity.TAG, ePIDMainActivity.this.getString(sg.nec.com.epid_sdk_master.R.string.connectionError));
                                } else {
                                    Log.d(ePIDMainActivity.TAG, "Request Token Successfully");
                                }

                                ePIDMainActivity.this.mHandler.sendEmptyMessage(0);
                            } catch (Exception var5) {
                                ePIDMainActivity.this.error = var5.toString();
                                ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                                var5.printStackTrace();
                            }
                        }
                    } else {
                        var2 = new XMLParser(var1);

                        try {
                            var3 = var2.parseResultResponse();
                            Log.d("result errorCode", var3.getErrorCode());
                            if (!var3.getErrorCode().equals("0")) {
                                Log.d(ePIDMainActivity.TAG, ePIDMainActivity.this.getString(sg.nec.com.epid_sdk_master.R.string.connectionError));
                            } else {
                                Log.d(ePIDMainActivity.TAG, "Request Token Successfully");
                            }

                            ePIDMainActivity.this.mHandler.sendEmptyMessage(0);
                        } catch (Exception var4) {
                            ePIDMainActivity.this.error = var4.toString();
                            ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                            var4.printStackTrace();
                        }
                    }
                }

            }

            @Override
            public void onResponse(String s) {

            }

            public void onResponse(byte[] var1) {
                Log.e(ePIDMainActivity.TAG, "Action Bypte OnResponse");
            }

            public void onError(Exception var1) {
                ePIDMainActivity.this.error = var1.toString();
                Log.d(ePIDMainActivity.TAG + " onError", ePIDMainActivity.this.error);
                if (ePIDModel.getInstance().get_ePIDWorkflow() == sg.nec.com.epid_sdk_master.data.ePIDModel.b.ij && ePIDModel.getInstance().isFaceSpoofDetection() && ePIDModel.getInstance().getOperation() == 0) {
                    ePIDModel.getInstance().setServerCallbackisCalled(true);
                    if (ePIDMainActivity.this.iZ) {
                        ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                    }
                } else {
                    ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                }

            }

            public void onError(String var1) {
                ePIDMainActivity.this.error = var1.toString();
                Log.d(ePIDMainActivity.TAG + " onError", ePIDMainActivity.this.error);
                if (ePIDModel.getInstance().get_ePIDWorkflow() == sg.nec.com.epid_sdk_master.data.ePIDModel.b.ij && ePIDModel.getInstance().isFaceSpoofDetection() && ePIDModel.getInstance().getOperation() == 0) {
                    ePIDModel.getInstance().setServerCallbackisCalled(true);
                    if (ePIDMainActivity.this.iZ) {
                        ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                    }
                } else {
                    ePIDMainActivity.this.mHandler.sendEmptyMessage(1);
                }

            }
        });
    }

    public void faceDetectionCallback(boolean var1) {
        Log.e(TAG, "faceDetectionCallback: isServerCallbackisCalled=" + ePIDModel.getInstance().isServerCallbackisCalled());
        this.iZ = true;
        this.iX = var1;
        if (ePIDModel.getInstance().isServerCallbackisCalled()) {
            if (this.jc.length() != 0) {
                Log.e(TAG, " Calling server finish first!");
                XMLParser var2 = new XMLParser(this.jc);

                try {
                    ResultResponse var3 = var2.parseResultResponse();
                    Log.d("result errorCode", var3.getErrorCode());
                    if (!var3.getErrorCode().equals("0")) {
                        Log.d(TAG, this.getString(sg.nec.com.epid_sdk_master.R.string.connectionError));
                    } else {
                        Log.d(TAG, "Request Token Successfully");
                    }

                    this.mHandler.sendEmptyMessage(0);
                } catch (Exception var4) {
                    this.error = var4.toString();
                    this.mHandler.sendEmptyMessage(1);
                    var4.printStackTrace();
                }
            } else {
                this.mHandler.sendEmptyMessage(1);
            }
        }

    }

    public void GetActionImagesSuccessListener(ArrayList<byte[]> var1) {
        try {
            Log.e(TAG, "GetActionImagesSuccessFailListener=" + var1.size());
            ArrayList var2 = new ArrayList();
            if (var1.size() > 0) {
                int var3 = 0;

                while(true) {
                    if (var3 >= var1.size()) {
                        ePIDModel.getInstance().setActionImages(var2);
                        Log.e(TAG, "actionImagesize=" + ePIDModel.getInstance().getActionImages().size());
                        break;
                    }

                    var2.add(var1.get(var3));
                    ++var3;
                }
            }

            Intent var5 = new Intent();
            this.setResult(-1, var5);
            this.finish();
        } catch (Exception var4) {
            this.error = var4.toString();
            this.mHandler.sendEmptyMessage(1);
            var4.printStackTrace();
        }

    }

    public void GetActionBitmapImagesSuccessListener(ArrayList<Bitmap> var1) {
        try {
            Log.e(TAG, "GetActionBitmaImagesSuccessFailListener=" + var1.size());
            ArrayList var2 = new ArrayList();
            if (var1.size() > 0) {
                for(int var3 = 0; var3 < var1.size(); ++var3) {
                    var2.add(var1.get(var3));
                }

                ePIDModel.getInstance().setActionBitmapImages(var2);
                Log.e(TAG, "actionBitmapImagesize=" + ePIDModel.getInstance().getActionBitmapImages().size());
                Intent var5 = new Intent();
                this.setResult(-1, var5);
                this.finish();
            }
        } catch (Exception var4) {
            this.error = var4.toString();
            this.mHandler.sendEmptyMessage(1);
            var4.printStackTrace();
        }

    }

    private void ap(int var1) {
        FragmentManager var2 = this.getFragmentManager();
        this.iQ = (sg.nec.com.epid_sdk_master.b.a)var2.findFragmentByTag("captureFragment");
        this.iR = (sg.nec.com.epid_sdk_master.b.b)var2.findFragmentByTag("confirmationFragment");
        this.iT = ePIDMainActivity.b.values()[var1];
        Log.e(TAG, "receiveFragments captureFragment " + this.iQ);
    }

    private void a(ePIDMainActivity.b var1) {
        this.iT = var1;
    }

    public void onConfigurationChanged(Configuration var1) {
        super.onConfigurationChanged(var1);
        @SuppressLint("WrongConstant") Display var2 = ((WindowManager)this.getSystemService("window")).getDefaultDisplay();
        int var3 = var2.getRotation();
        ePIDMainActivity.a var10000;
        switch(var3) {
            case 0:
            case 2:
            default:
                var10000 = screenOrientation;
                screenOrientation = ePIDMainActivity.a.jg;
                break;
            case 1:
                var10000 = screenOrientation;
                screenOrientation = ePIDMainActivity.a.jh;
                break;
            case 3:
                var10000 = screenOrientation;
                screenOrientation = ePIDMainActivity.a.ji;
        }

    }

    @SuppressLint("WrongConstant")
    public void onBackPressed() {
        Log.i("Call ", " OnBackPressed");
        ePIDModel.getInstance().setIsFirstCapture("true");
        Log.e(TAG, " isFinishCaptureAutomaticFaceFirst OBP" + String.valueOf(ePIDModel.getInstance().isFinishCaptureAutomaticFaceFirst()));
        if (this.iT == ePIDMainActivity.b.jl) {
            super.onBackPressed();
        } else if (this.iT == ePIDMainActivity.b.jn) {
            this.closeResultFragment();
        } else {
            super.onBackPressed();
        }

    }

    public void closeResultFragment() {
        FragmentTransaction var1 = this.getFragmentManager().beginTransaction();
        var1.remove(this.iS);
        var1.commit();
        this.iS = null;
        this.a(ePIDMainActivity.b.jm);
    }

    public void closeConfirmationFragment() {
        this.iQ = new sg.nec.com.epid_sdk_master.b.a();
        this.iQ.d(this);
        this.iQ.e(this);
        FragmentTransaction var1 = this.getFragmentManager().beginTransaction();
        var1.remove(this.iR);
        this.iR = null;
        var1.add(sg.nec.com.epid_sdk_master.R.id.container, this.iQ, "captureFragment");
        var1.show(this.iQ);
        var1.commit();
        this.a(ePIDMainActivity.b.jk);
    }

    public void showCaptureFragment() {
        Log.e(TAG, " show capture fragment");
        this.iQ = new sg.nec.com.epid_sdk_master.b.a();
        this.iQ.d(this);
        this.iQ.c(this);
        this.iQ.e(this);
        Log.e(TAG, " capture fragment" + this.iQ);
        FragmentTransaction var1 = this.getFragmentManager().beginTransaction();
        var1.add(sg.nec.com.epid_sdk_master.R.id.container, this.iQ, "captureFragment");
        var1.show(this.iQ);
        var1.commit();
        this.a(ePIDMainActivity.b.jk);
        this.b(this.hb, this.iB);
    }

    public void reloadCaptureFragment() {
        Log.e(TAG, " reload capture fragment");
        this.iQ = new sg.nec.com.epid_sdk_master.b.a();
        FragmentTransaction var1 = this.getFragmentManager().beginTransaction();
        var1.remove(this.iQ);
        var1.add(sg.nec.com.epid_sdk_master.R.id.container, this.iQ, "captureFragment");
        var1.show(this.iQ);
        var1.commit();
        this.a(ePIDMainActivity.b.jk);
    }

    public void showConfirmationFragment(Bitmap var1, ePIDMainActivity.a var2, sg.nec.com.epid_sdk_master.b var3) {
        this.iR = new sg.nec.com.epid_sdk_master.b.b();
        Log.e(TAG, "showConfirmationFragment Bitmap=" + var1);
        if (var3 != null) {
            this.iR.d(var3);
        }

        //this.iR.ls = var2;
        Log.e(TAG, "start FragmentTransaction with capture " + this.iQ);
        FragmentTransaction var4 = this.getFragmentManager().beginTransaction();
        var4.remove(this.iQ);
        Log.e(TAG, "start FragmentTransaction capture remove " + this.iQ);
        this.iQ = null;
        Log.e(TAG, "start FragmentTransaction before confirm add " + this.iR);
        var4.add(sg.nec.com.epid_sdk_master.R.id.container, this.iR, "confirmationFragment");
        Log.e(TAG, "start FragmentTransaction finish confirm add " + this.iR);
        var4.show(this.iR);
        var4.commit();
        this.a(ePIDMainActivity.b.jl);
        Log.e(TAG, "finish FragmentTransaction");
    }

    public void finishAndRestart() {
        Log.i("finish and restart", "");
        FragmentTransaction var1 = this.getFragmentManager().beginTransaction();
        var1.remove(this.iS);
        var1.remove(this.iR);
        var1.commit();
        this.iS = null;
        this.iR = null;
        Log.i("show capture", "");
        this.showCaptureFragment();
    }

    public void writeToSharedPrefs(String var1) {
        SharedPreferences var2 = this.getPreferences(0);
        SharedPreferences.Editor var3 = var2.edit();
        var3.putString("serverIP", var1);
        var3.commit();
    }

    public String getSharedPrefs() {
        SharedPreferences var1 = this.getPreferences(0);
        return var1.getString("serverIP", "https://gis.nec.com.sg");
    }

    public void callBack(d var1) {
        if (var1 == d.mm) {
            this.finish();
        } else {
            Log.e(TAG, "do nth");
        }

    }

    static {
        screenOrientation = ePIDMainActivity.a.jg;
    }

    public static enum a {
        jg,
        jh,
        ji;

        private a() {
        }
    }

    private static enum b {
        jk,
        jl,
        jm,
        jn,
        jo;

        private b() {
        }
    }
}