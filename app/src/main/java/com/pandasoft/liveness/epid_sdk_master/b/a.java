/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.app.Fragment
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.Matrix
 *  android.graphics.PointF
 *  android.graphics.drawable.Drawable
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$Parameters
 *  android.hardware.display.VirtualDisplay
 *  android.hardware.display.VirtualDisplay$Callback
 *  android.media.MediaRecorder
 *  android.media.projection.MediaProjection
 *  android.media.projection.MediaProjection$Callback
 *  android.media.projection.MediaProjectionManager
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.CountDownTimer
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.speech.tts.TextToSpeech
 *  android.speech.tts.TextToSpeech$OnInitListener
 *  android.support.v4.app.ActivityCompat
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.Display
 *  android.view.LayoutInflater
 *  android.view.Surface
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.WindowManager
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.images.Size
 *  com.google.android.gms.vision.CameraSource
 *  com.google.android.gms.vision.CameraSource$Builder
 *  com.google.android.gms.vision.CameraSource$PictureCallback
 *  com.google.android.gms.vision.CameraSource$ShutterCallback
 *  com.google.android.gms.vision.Detector
 *  com.google.android.gms.vision.Detector$Detections
 *  com.google.android.gms.vision.Detector$Processor
 *  com.google.android.gms.vision.Frame
 *  com.google.android.gms.vision.Frame$Builder
 *  com.google.android.gms.vision.Tracker
 *  com.google.android.gms.vision.face.Face
 *  com.google.android.gms.vision.face.FaceDetector
 *  com.google.android.gms.vision.face.FaceDetector$Builder
 *  com.google.android.gms.vision.face.LargestFaceFocusingProcessor
 *  com.google.android.gms.vision.face.LargestFaceFocusingProcessor$Builder
 *  org.jcodec.api.android.AndroidSequenceEncoder
 *  org.jcodec.common.io.NIOUtils
 *  org.jcodec.common.io.SeekableByteChannel
 *  org.jcodec.common.model.Rational
 *  sg.nec.com.epid_sdk_master.R
 *  sg.nec.com.epid_sdk_master.R$drawable
 *  sg.nec.com.epid_sdk_master.R$id
 *  sg.nec.com.epid_sdk_master.R$layout
 *  sg.nec.com.epid_sdk_master.R$string
 */
package com.pandasoft.liveness.epid_sdk_master.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.display.VirtualDisplay;
import android.media.MediaRecorder;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.LargestFaceFocusingProcessor;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Executor;
import org.jcodec.api.android.AndroidSequenceEncoder;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Rational;
import sg.nec.com.epid_sdk_master.R;
import sg.nec.com.epid_sdk_master.camera.CameraSourcePreview;
import sg.nec.com.epid_sdk_master.camera.GraphicOverlay;
import sg.nec.com.epid_sdk_master.data.ePIDModel;
import sg.nec.com.epid_sdk_master.ePIDMainActivity;
import sg.nec.com.epid_sdk_master.services.ePIDResponseListener;

public class a
extends Fragment
implements TextToSpeech.OnInitListener {
    View jq;
    private Camera jr = null;
    public ImageView js;
    private ImageView jt;
    private SurfaceHolder ju = null;
    private boolean jv = false;
    private String jw = "off";
    private Activity ft;
    private int jx;
    private CameraSource fs = null;
    private static final String TAG = a.class.getName();
    private TextView jy;
    private TextView jz;
    private CameraSourcePreview jA;
    private GraphicOverlay jB;
    private boolean jC;
    Context ha;
    TextToSpeech jD;
    Bitmap jE;
    float jF;
    float jG;
    float jH;
    float jI;
    double jJ;
    double w;
    double jK;
    double jL;
    double jM;
    double jN;
    double jO;
    boolean jP = false;
    sg.nec.com.epid_sdk_master.camera.b jQ;
    int jR;
    int jS;
    int jT;
    int jU;
    int jV;
    int jW;
    private int state = 0;
    int hz = ePIDModel.getInstance().getTimer();
    sg.nec.com.epid_sdk_master.b jX;
    sg.nec.com.epid_sdk_master.utils.c jY;
    b jZ;
    private ImageView ka;
    String kb = "";
    private boolean kc = false;
    AlertDialog kd;
    a ke = a.lb;
    private int kf;
    public ArrayList<byte[]> kg;
    public ArrayList<Bitmap> kh;
    byte[] ki;
    sg.nec.com.epid_sdk_master.c kj;
    private int kk;
    private MediaProjectionManager kl;
    private MediaProjection km;
    private VirtualDisplay kn;
    private d ko;
    private MediaRecorder kp;
    private static final SparseIntArray kq = new SparseIntArray();
    int kr;
    SeekableByteChannel out = null;
    private static String ks;
    RelativeLayout ja;
    ProgressBar kt;
    int ku;
    int kv;
    int kw;
    int kx;
    int ky;
    int kz;
    int kA;
    int kB;
    private int kC = -1;
    private boolean kD = false;
    private boolean kE = false;
    private Random kF = new Random();
    private int kG;
    private String fO = "";
    private Handler mHandler = new Handler(new Handler.Callback(){

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 99: {
                    Log.e((String)TAG, (String)"hide timer");
                    if (a.this.jy == null) break;
                    Log.e((String)TAG, (String)"hide txtCountDown");
                    a.this.jy.setVisibility(8);
                    break;
                }
                case 100: {
                    Log.i((String)TAG, (String)"start capture from handler");
                    new CountDownTimer(1000L, 1000L){

                        public void onTick(long l2) {
                        }

                        public void onFinish() {
                            if (a.this.fs != null) {
                                a.this.fs.takePicture(null, new CameraSource.PictureCallback(){

                                    public void onPictureTaken(byte[] arrby) {
                                        int n2 = 0;
                                        try {
                                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
                                            com.a.c.e e2 = com.a.a.c.a(byteArrayInputStream);
                                            com.a.c.c.d d2 = e2.b(com.a.c.c.d.class);
                                            try {
                                                n2 = d2.getInt(274);
                                            }
                                            catch (Exception exception) {
                                                Log.i((String)"io error", (String)exception.toString());
                                                exception.printStackTrace();
                                            }
                                            Log.i((String)" Orientation", (String)String.valueOf(n2));
                                            Matrix matrix = new Matrix();
                                            switch (n2) {
                                                case 1: {
                                                    break;
                                                }
                                                case 2: {
                                                    matrix.postScale(-1.0f, 1.0f);
                                                    break;
                                                }
                                                case 3: {
                                                    matrix.postRotate(-180.0f);
                                                    break;
                                                }
                                                case 4: {
                                                    matrix.postScale(1.0f, -1.0f);
                                                    break;
                                                }
                                                case 5: {
                                                    matrix.postRotate(90.0f);
                                                    matrix.postScale(-1.0f, 1.0f);
                                                    break;
                                                }
                                                case 6: {
                                                    matrix.postRotate(-90.0f);
                                                    matrix.postScale(-1.0f, 1.0f);
                                                    break;
                                                }
                                                case 7: {
                                                    matrix.postRotate(-90.0f);
                                                    matrix.postScale(-1.0f, 1.0f);
                                                    break;
                                                }
                                                case 8: {
                                                    matrix.postRotate(-90.0f);
                                                    break;
                                                }
                                            }
                                            Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length);
                                            Bitmap bitmap2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)matrix, (boolean)true);
                                            Log.e((String)TAG, (String)(" getConfig from Camera " + (Object)bitmap.getConfig()));
                                            ePIDMainActivity ePIDMainActivity2 = (ePIDMainActivity)a.this.ft;
                                            ePIDMainActivity2.showConfirmationFragment(bitmap2, ePIDMainActivity.screenOrientation, null);
                                        }
                                        catch (Exception exception) {
                                            exception.printStackTrace();
                                        }
                                    }
                                });
                            }
                        }

                    }.start();
                }
            }
            return false;
        }

    });
    private boolean kH = false;
    private boolean kI = false;
    private int kJ = 10;
    SurfaceHolder.Callback kK = new SurfaceHolder.Callback(){

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int n2, int n3, int n4) {
            a.this.ke();
            a.this.startPreview();
            Log.i((String)"Surface change", (String)"");
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    };
    private e kL;
    private int kM = 0;
    private int kN = 0;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int n2;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.ft = this.getActivity();
        this.ft.setRequestedOrientation(1);
        if (this.jq == null) {
            this.jq = layoutInflater.inflate(R.layout.capture_fragment, viewGroup, false);
            this.jA = (CameraSourcePreview)this.jq.findViewById(R.id.preview);
            this.jB = (GraphicOverlay)this.jq.findViewById(R.id.faceOverlay);
            this.ja = (RelativeLayout)this.jq.findViewById(R.id.progresbarRelativeLayout);
            this.kt = (ProgressBar)this.jq.findViewById(R.id.progressBar);
            Log.i((String)"Timer", (String)String.valueOf(this.hz));
            this.jy = (TextView)this.jq.findViewById(R.id.capture_fragment_txt_countdown);
            this.jz = (TextView)this.jq.findViewById(R.id.txtwarning);
            this.js = (ImageView)this.jq.findViewById(R.id.captureBtn);
            this.jt = (ImageView)this.jq.findViewById(R.id.mediaimage);
            this.ha = this.getActivity().getApplicationContext();
            this.kd = new AlertDialog.Builder((Context)this.ft).setTitle((CharSequence)"Error!").setPositiveButton((CharSequence)"OK", null).create();
            this.kd.setCanceledOnTouchOutside(false);
            this.kd.setCancelable(false);
            this.jD = new TextToSpeech((Context)this.getActivity(), (TextToSpeech.OnInitListener)this);
            this.jD.setLanguage(Locale.UK);
            if (ePIDModel.getInstance().getContinueSuccessActionCount() > 1) {
                this.kb = String.valueOf(ePIDModel.getInstance().getContinueSuccessActionCount()) + " times";
            }
            Log.e((String)TAG, (String)("is_ePIDCaptureAutomatic=" + ePIDModel.getInstance().is_ePIDCaptureAutomatic()));
            if (ePIDModel.getInstance().is_ePIDCaptureAutomatic()) {
                this.js.setVisibility(8);
            }
            if (ePIDModel.getInstance().isEnableImage()) {
                this.jt.setVisibility(0);
            }
            this.ka = (ImageView)this.jq.findViewById(R.id.noFaceFoundImageView);
            this.kg = new ArrayList();
            this.kh = new ArrayList();
            this.js.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    Log.i((String)TAG, (String)" FaceID: ImageBtn Call On Click");
                    a.this.kA = 0;
                    a.this.kB = 0;
                    a.this.jT = 0;
                    a.this.jU = 0;
                    a.this.jS = 0;
                    a.this.jV = 0;
                    a.this.jW = 0;
                    a.this.jR = 0;
                    if (a.this.js.getVisibility() == 0) {
                        a.this.js.setVisibility(8);
                    }
                    a.this.kD = true;
                    if (ePIDModel.getInstance().isFaceSpoofDetection()) {
                        a.this.kH = false;
                        a.this.kI = false;
                        a.this.kM = 0;
                        a.this.kN = 0;
                        if (ePIDModel.getInstance().get_ePIDWorkflow() == ePIDModel.b.ii) {
                            a.this.state = 0;
                            Log.e((String)TAG, (String)"captureImgBtn Challenge");
                            Log.e((String)TAG, (String)" FaceID: captureImgBtn FaceSpoof True");
                            a.this.kc = false;
                            Thread thread = new Thread(){

                                @Override
                                public void run() {
                                    super.run();
                                    try {
                                        a.this.kh();
                                        a.this.ka.post(new Runnable(){

                                            @Override
                                            public void run() {
                                                a.this.ka.setVisibility(8);
                                            }
                                        });
                                        a.this.kD = true;
                                        a.this.kC = -1;
                                        a.this.ke = a.lc;
                                        a.this.state = 0;
                                        a.this.kb();
                                    }
                                    catch (Exception exception) {
                                        exception.printStackTrace();
                                    }
                                }

                            };
                            thread.run();
                        } else {
                            a.this.kc = false;
                            Thread thread = new Thread(){

                                @Override
                                public void run() {
                                    super.run();
                                    try {
                                        a.this.kh();
                                        a.this.ka.post(new Runnable(){

                                            @Override
                                            public void run() {
                                                a.this.ka.setVisibility(8);
                                            }
                                        });
                                        a.this.jz.post(new Runnable(){

                                            @Override
                                            public void run() {
                                                a.this.jz.setVisibility(0);
                                            }
                                        });
                                        a.this.kD = false;
                                        a.this.kC = -1;
                                        a.this.state = 0;
                                        a.this.ke = a.ld;
                                    }
                                    catch (Exception exception) {
                                        exception.printStackTrace();
                                    }
                                }

                            };
                            thread.start();
                        }
                    } else {
                        Thread thread = new Thread(){

                            @Override
                            public void run() {
                                super.run();
                                a.this.ka.post(new Runnable(){

                                    @Override
                                    public void run() {
                                        a.this.jy.setText((CharSequence)"Please Look at the camera");
                                        a.this.ka.setVisibility(8);
                                    }
                                });
                                a.this.kh();
                                a.this.ke = a.ld;
                            }

                        };
                        thread.start();
                    }
                }

            });
        }
        if ((n2 = ActivityCompat.checkSelfPermission((Context)this.ft, (String)"android.permission.CAMERA")) == 0) {
            this.ar(1);
        } else {
            this.kg();
        }
        this.jz.setVisibility(8);
        if (ePIDModel.getInstance().isFaceSpoofDetection()) {
            if (ePIDModel.getInstance().is_ePIDCaptureAutomatic()) {
                if (ePIDModel.getInstance().get_ePIDWorkflow() == ePIDModel.b.ij) {
                    this.ke = a.ld;
                    this.jy.setText((CharSequence)"Please look at the camera");
                    this.jz.setVisibility(0);
                } else {
                    this.ke = a.lc;
                    this.kb();
                }
            }
        } else {
            this.jy.setText((CharSequence)"Please look at the camera");
            if (ePIDModel.getInstance().is_ePIDCaptureAutomatic()) {
                this.ke = a.ld;
            }
        }
        return this.jq;
    }

    private VirtualDisplay jY() {
        return this.km.createVirtualDisplay("MainActivity", 720, 1280, this.kk, 16, this.kp.getSurface(), null, null);
    }

    private void jZ() {
        if (this.kn == null) {
            return;
        }
        this.kn.release();
        this.ka();
    }

    private void ka() {
        if (this.km != null) {
            this.km.unregisterCallback((MediaProjection.Callback)this.ko);
            this.km.stop();
            this.km = null;
        }
        Log.i((String)TAG, (String)"MediaProjection Stopped");
    }

    public void onActivityResult(int n2, int n3, Intent intent) {
        Log.e((String)TAG, (String)"screen share activity Start");
        if (n2 != 1000) {
            Log.e((String)TAG, (String)("Unknown request code: " + n2));
            return;
        }
        if (n3 != -1) {
            sg.nec.com.epid_sdk_master.utils.b.a("", this.getString(R.string.screen_cast_permission_denied), sg.nec.com.epid_sdk_master.utils.d.ml, this.ft, this.jY);
            return;
        }
        Log.e((String)TAG, (String)"screen share start success");
        this.ko = new d();
        this.km = this.kl.getMediaProjection(n3, intent);
        this.km.registerCallback((MediaProjection.Callback)this.ko, null);
        this.kn = this.jY();
        this.kp.start();
    }

    public void c(Object object) {
        this.kj = (sg.nec.com.epid_sdk_master.c)object;
    }

    public void onInit(int n2) {
        Log.e((String)TAG, (String)"Oninit");
        if (ePIDModel.getInstance().get_ePIDWorkflow() == ePIDModel.b.ij || ePIDModel.getInstance().get_ePIDWorkflow() == ePIDModel.b.ii && !ePIDModel.getInstance().isFaceSpoofDetection()) {
            if (ePIDModel.getInstance().isEnableVoice()) {
                this.jD.speak("Please Look at the camera", 0, null);
            }
        } else if (ePIDModel.getInstance().isEnableVoice() && this.kC > 0) {
            this.jD.speak(ePIDModel.getInstance().get_ePIDAcitons().get(this.kC).toString(), 0, null);
        }
    }

    public void d(Object object) {
        this.jX = (sg.nec.com.epid_sdk_master.b)object;
    }

    public void e(Object object) {
        this.jY = (sg.nec.com.epid_sdk_master.utils.c)object;
    }

    private synchronized void kb() {
        ++this.kA;
        this.jx = 0;
        this.kG = this.kF.nextInt(ePIDModel.getInstance().get_ePIDAcitons().size());
        Log.i((String)TAG, (String)(" FaceID: random challenge size " + ePIDModel.getInstance().get_ePIDAcitons().size()));
        Log.i((String)TAG, (String)(" FaceID: firstChallenge1 " + this.kC));
        if (this.kC < 0) {
            this.kC = this.kG;
        } else {
            if (ePIDModel.getInstance().get_ePIDAcitons().size() > 1) {
                while (this.kC == this.kG) {
                    this.kG = this.kF.nextInt(ePIDModel.getInstance().get_ePIDAcitons().size());
                }
            }
            this.kC = this.kG;
        }
        Log.i((String)TAG, (String)(" FaceID: firstChallenge2 " + this.kC));
        if (this.kC > -1) {
            if (ePIDModel.getInstance().isEnableImage()) {
                if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.ie) {
                    this.jt.setImageDrawable(this.ft.getResources().getDrawable(R.drawable.closebotheyes));
                }
                if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.ic) {
                    this.jt.setImageDrawable(this.ft.getResources().getDrawable(R.drawable.closelefteye));
                }
                if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.id) {
                    this.jt.setImageDrawable(this.ft.getResources().getDrawable(R.drawable.closerighteye));
                }
                if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.ib) {
                    this.jt.setImageDrawable(this.ft.getResources().getDrawable(R.drawable.smile));
                }
                if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.ig) {
                    this.jt.setImageDrawable(this.ft.getResources().getDrawable(R.drawable.tilttoleft));
                }
                if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.if) {
                    this.jt.setImageDrawable(this.ft.getResources().getDrawable(R.drawable.tilttoright));
                }
            }
            this.ft.runOnUiThread(new Runnable(){

                @Override
                public void run() {
                    a.this.jz.setVisibility(8);
                }
            });
            if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.ie) {
                Log.e((String)TAG, (String)"  FaceID: call blink");
                this.fO = "blink";
                this.jy.post(new Runnable(){

                    @Override
                    public void run() {
                        a.this.jy.setText((CharSequence)("Blink " + a.this.kb));
                    }
                });
            }
            if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.ic) {
                this.fO = "closelefteye";
                this.jy.post(new Runnable(){

                    @Override
                    public void run() {
                        a.this.jy.setText((CharSequence)"Close left eye");
                    }
                });
            }
            if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.id) {
                this.fO = "closerighteye";
                this.jy.post(new Runnable(){

                    @Override
                    public void run() {
                        a.this.jy.setText((CharSequence)"Close right eye");
                    }
                });
            }
            if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.ib) {
                this.fO = "smile";
                this.jy.post(new Runnable(){

                    @Override
                    public void run() {
                        a.this.jy.setText((CharSequence)"Smile with teeth showing");
                    }
                });
            }
            if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.ig) {
                this.fO = "turnheadleft";
                this.jy.post(new Runnable(){

                    @Override
                    public void run() {
                        a.this.jy.setText((CharSequence)"Turn head to the left");
                    }
                });
            }
            if (ePIDModel.getInstance().get_ePIDAcitons().get(this.kC) == ePIDModel.a.if) {
                this.fO = "turnheadright";
                this.jy.post(new Runnable(){

                    @Override
                    public void run() {
                        a.this.jy.setText((CharSequence)"Turn head to the right");
                    }
                });
            }
        }
        Log.d((String)TAG, (String)(" FaceID: random Challenge OnChallenge1." + this.kC));
        this.kD = true;
        this.a(this.kC, false);
    }

    private void a(int n2, boolean bl) {
        if (this.getActivity() != null) {
            Log.d((String)TAG, (String)"media player start");
            Log.i((String)"random Challenge play2.", (String)String.valueOf(n2));
            if (ePIDModel.getInstance().isEnableVoice()) {
                Log.e((String)TAG, (String)(" start speaking=" + ePIDModel.getInstance().get_ePIDAcitons().get(n2).toString()));
                this.jD.speak(ePIDModel.getInstance().get_ePIDAcitons().get(n2).toString(), 0, null);
            }
            if (!bl) {
                Log.d((String)TAG, (String)"count timer start");
                this.kL = new e(ePIDModel.getInstance().getTimer() * 1000, 1000L);
                this.kL.start();
                this.kr = ePIDModel.getInstance().getTimer();
            }
        }
    }

    private synchronized void a(Face face, int n2) {
        Log.e((String)TAG, (String)("startChallenge value " + String.valueOf(n2)));
        Log.e((String)TAG, (String)("startChallenge with Action " + (Object)((Object)ePIDModel.getInstance().get_ePIDAcitons().get(n2))));
        Log.e((String)TAG, (String)("statusChallenge1 = " + this.kH + "statusChallenge2 = " + this.kI));
        if (ePIDModel.a.ie == ePIDModel.getInstance().get_ePIDAcitons().get(n2)) {
            this.jT = 0;
            this.jU = 0;
            this.jS = 0;
            this.jV = 0;
            this.jW = 0;
            Log.e((String)TAG, (String)(" left eye open posibility " + face.getIsLeftEyeOpenProbability()));
            if (face.getIsLeftEyeOpenProbability() == -1.0f && face.getIsRightEyeOpenProbability() == -1.0f) {
                return;
            }
            Log.e((String)TAG, (String)(" analyse blink " + face.getIsLeftEyeOpenProbability() + " " + face.getIsRightEyeOpenProbability()));
            Log.e((String)TAG, (String)(" state value " + String.valueOf(this.state)));
            switch (this.state) {
                case 0: {
                    if ((double)face.getIsLeftEyeOpenProbability() <= 0.85 || (double)face.getIsRightEyeOpenProbability() <= 0.85) break;
                    Log.e((String)TAG, (String)(" initially open " + face.getIsLeftEyeOpenProbability() + " " + face.getIsRightEyeOpenProbability()));
                    this.state = 1;
                    break;
                }
                case 1: {
                    if ((double)face.getIsLeftEyeOpenProbability() >= 0.35 || (double)face.getIsRightEyeOpenProbability() >= 0.35) break;
                    Log.e((String)TAG, (String)(" become close " + face.getIsLeftEyeOpenProbability() + " " + face.getIsRightEyeOpenProbability()));
                    this.state = 2;
                    if (this.jR != ePIDModel.getInstance().getContinueSuccessActionCount() - 1 || !ePIDModel.getInstance().isGettingActionSuccessImages()) break;
                    this.ki = this.jQ.jE();
                    break;
                }
                case 2: {
                    if ((double)face.getIsLeftEyeOpenProbability() <= 0.85 || (double)face.getIsRightEyeOpenProbability() <= 0.85) break;
                    Log.e((String)TAG, (String)(" blink occured " + face.getIsLeftEyeOpenProbability() + " " + face.getIsRightEyeOpenProbability()));
                    this.state = 3;
                }
            }
            if (this.state == 3) {
                Log.e((String)TAG, (String)" blink successed");
                this.state = 0;
                ++this.jR;
                if (this.jR == ePIDModel.getInstance().getContinueSuccessActionCount()) {
                    ++this.kB;
                    this.kv = ePIDModel.getInstance().getTimer() - this.kr;
                    Log.e((String)TAG, (String)("finishSecs=" + this.kv));
                    if (this.kr == 0) {
                        this.kv = ePIDModel.getInstance().getTimer();
                    }
                    Log.i((String)TAG, (String)(" success FACE_CLOSE_BOTH_EYES  " + face.getIsLeftEyeOpenProbability() + "  " + face.getIsRightEyeOpenProbability()));
                    Log.i((String)TAG, (String)("CountBlink " + String.valueOf(this.jR)));
                    this.jR = 0;
                    this.aq(n2);
                    this.kc();
                }
            }
        }
        if (ePIDModel.a.ic == ePIDModel.getInstance().get_ePIDAcitons().get(n2)) {
            this.jR = 0;
            this.jU = 0;
            this.jS = 0;
            this.jV = 0;
            this.jW = 0;
            Log.e((String)TAG, (String)(" left eye " + String.valueOf(face.getIsLeftEyeOpenProbability()) + " right eye " + String.valueOf(face.getIsRightEyeOpenProbability())));
            if ((double)face.getIsLeftEyeOpenProbability() < 0.35 && (double)face.getIsRightEyeOpenProbability() >= 0.85) {
                ++this.jT;
                if (this.jT == ePIDModel.getInstance().getContinueSuccessActionCount()) {
                    ++this.kB;
                    this.kw = ePIDModel.getInstance().getTimer() - this.kr;
                    Log.e((String)TAG, (String)("finishSecs=" + this.kw));
                    if (this.kr == 0) {
                        this.kw = ePIDModel.getInstance().getTimer();
                    }
                    Log.i((String)TAG, (String)("success FACE_WINK_LEFT_EYE  " + face.getIsLeftEyeOpenProbability()));
                    Log.i((String)TAG, (String)("CountCloseLeftEye " + String.valueOf(this.jT)));
                    this.jT = 0;
                    this.aq(n2);
                    this.kc();
                }
            }
        }
        if (ePIDModel.a.id == ePIDModel.getInstance().get_ePIDAcitons().get(n2)) {
            this.jR = 0;
            this.jT = 0;
            this.jS = 0;
            this.jV = 0;
            this.jW = 0;
            Log.e((String)TAG, (String)(" left eye " + String.valueOf(face.getIsLeftEyeOpenProbability()) + " right eye " + String.valueOf(face.getIsRightEyeOpenProbability())));
            if ((double)face.getIsRightEyeOpenProbability() < 0.35 && (double)face.getIsLeftEyeOpenProbability() >= 0.85) {
                ++this.jU;
                if (this.jU == ePIDModel.getInstance().getContinueSuccessActionCount()) {
                    ++this.kB;
                    this.kx = ePIDModel.getInstance().getTimer() - this.kr;
                    Log.e((String)TAG, (String)("finishSecs=" + this.kx));
                    if (this.kr == 0) {
                        this.kx = ePIDModel.getInstance().getTimer();
                    }
                    Log.i((String)TAG, (String)("success FACE_WINK_RIGHT_EYE  " + face.getIsRightEyeOpenProbability()));
                    Log.i((String)TAG, (String)("CountCloseRightEye " + String.valueOf(this.jU)));
                    this.jU = 0;
                    this.aq(n2);
                    this.kc();
                }
            }
        }
        if (ePIDModel.a.ib == ePIDModel.getInstance().get_ePIDAcitons().get(n2)) {
            this.jR = 0;
            this.jT = 0;
            this.jU = 0;
            this.jV = 0;
            this.jW = 0;
            Log.i((String)TAG, (String)(" Start Smile Challenge " + (Object)((Object)ePIDModel.getInstance().get_ePIDAcitons().get(n2))));
            if ((double)face.getIsSmilingProbability() > 0.6) {
                ++this.jS;
                if (this.jS == ePIDModel.getInstance().getContinueSuccessActionCount()) {
                    ++this.kB;
                    this.ku = ePIDModel.getInstance().getTimer() - this.kr;
                    Log.e((String)TAG, (String)("finishSecs=" + this.ku));
                    if (this.kr == 0) {
                        this.ku = ePIDModel.getInstance().getTimer();
                    }
                    Log.i((String)TAG, (String)"success FACE_SMILE  ");
                    Log.i((String)TAG, (String)(" CountSmile " + String.valueOf(this.jS)));
                    this.jS = 0;
                    this.aq(n2);
                    this.kc();
                }
            }
        }
        if (ePIDModel.a.ig == ePIDModel.getInstance().get_ePIDAcitons().get(n2)) {
            this.jR = 0;
            this.jT = 0;
            this.jU = 0;
            this.jS = 0;
            this.jW = 0;
            Log.i((String)TAG, (String)(" Start Head Left Challenge " + (Object)((Object)ePIDModel.getInstance().get_ePIDAcitons().get(n2))));
            if (face.getEulerY() >= 12.0f && face.getEulerY() <= 60.0f) {
                ++this.jV;
                if (this.jV == ePIDModel.getInstance().getContinueSuccessActionCount()) {
                    ++this.kB;
                    this.ky = ePIDModel.getInstance().getTimer() - this.kr;
                    Log.e((String)TAG, (String)("finishSecs=" + this.ky));
                    if (this.kr == 0) {
                        this.ky = ePIDModel.getInstance().getTimer();
                    }
                    Log.i((String)TAG, (String)"success FACE_MOVE_HEAD_LEFT ");
                    this.jV = 0;
                    this.aq(n2);
                    this.kc();
                }
            }
        }
        if (ePIDModel.a.if == ePIDModel.getInstance().get_ePIDAcitons().get(n2)) {
            this.jR = 0;
            this.jT = 0;
            this.jU = 0;
            this.jS = 0;
            this.jV = 0;
            if (face.getEulerY() >= -60.0f && face.getEulerY() <= -12.0f) {
                ++this.jW;
                if (this.jW == ePIDModel.getInstance().getContinueSuccessActionCount()) {
                    ++this.kB;
                    this.kz = ePIDModel.getInstance().getTimer() - this.kr;
                    Log.e((String)TAG, (String)("finishSecs=" + this.kz));
                    if (this.kr == 0) {
                        this.kz = ePIDModel.getInstance().getTimer();
                    }
                    Log.i((String)TAG, (String)("success FACE_MOVE_HEAD_RIGHT " + face.getEulerY()));
                    Log.i((String)TAG, (String)("CountMoveRight " + String.valueOf(this.jW)));
                    this.jW = 0;
                    this.aq(n2);
                    this.kc();
                }
            }
        }
    }

    private void aq(int n2) {
        if (ePIDModel.getInstance().isGettingActionSuccessImages()) {
            this.kg.add(this.jQ.jE());
        }
        this.ke = a.lb;
        this.kE = false;
        if (this.kL != null) {
            this.kL.cancel();
        }
        this.ke = a.le;
        this.jy.post(new Runnable(){

            @Override
            public void run() {
                a.this.jy.setText((CharSequence)a.this.getResources().getString(R.string.ok));
            }
        });
        if (ePIDModel.getInstance().isEnableVoice()) {
            this.jD.speak(this.getResources().getString(R.string.ok), 0, null);
        }
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException interruptedException) {
            Log.d((String)"YourApplicationName", (String)interruptedException.toString());
        }
    }

    public void kc() {
        if (this.kB >= ePIDModel.getInstance().getRequiredActionCount()) {
            Log.e((String)TAG, (String)"action Challenge success challengeSuccessCount >= requiredcount");
            this.ft.runOnUiThread(new Runnable(){

                @Override
                public void run() {
                    a.this.kd();
                }
            });
        } else if (this.kA >= ePIDModel.getInstance().getRequiredActionCount() + 1) {
            Log.e((String)TAG, (String)"action Challenge fail totalChallengeCount >= requiredcount+1");
            this.ft.runOnUiThread(new Runnable(){

                @Override
                public void run() {
                    int n2 = ePIDModel.getInstance().getTimer();
                    if (ePIDModel.getInstance().isGettingActionSuccessImages() || ePIDModel.getInstance().isGettingActionSuccessVideos()) {
                        if (ePIDModel.getInstance().isGettingActionSuccessImages()) {
                            a.this.kg.add(a.this.jQ.jE());
                            Log.e((String)TAG, (String)("actionImage Size=" + a.this.kg.size()));
                            if (!ePIDModel.getInstance().isGettingActionSuccessVideos()) {
                                a.this.kj.GetActionImagesSuccessListener(a.this.kg);
                            }
                        }
                        if (ePIDModel.getInstance().isGettingActionSuccessVideos()) {
                            ArrayList<Bitmap> arrayList = a.this.jQ.a(a.this.fO, n2);
                            if (a.this.fs != null && a.this.jA != null) {
                                Log.e((String)TAG, (String)"ConvertImagesToVideoTask PreviewStop1");
                                a.this.jA.post(new Runnable(){

                                    @Override
                                    public void run() {
                                        a.this.jA.stop();
                                    }
                                });
                            }
                            a.this.ja.post(new Runnable(){

                                @Override
                                public void run() {
                                    a.this.ja.setVisibility(0);
                                }
                            });
                            new c(arrayList, a.this.fO).execute((Object[])new Void[]{null, null, null});
                        }
                    } else {
                        if (a.this.jA != null) {
                            Log.e((String)TAG, (String)"stop preview from actionChallenge");
                            a.this.jA.stop();
                        }
                        a.this.jy.setText((CharSequence)a.this.getString(R.string.facedetection_tryagain));
                        if (ePIDModel.getInstance().getOperation() == 0 && ePIDModel.getInstance().get_ePIDWorkflow() == ePIDModel.b.ij) {
                            a.this.jZ.cancel(true);
                        }
                        a.this.jC = true;
                        a.this.kc = true;
                        a.this.kf = 0;
                        a.this.js.setVisibility(0);
                    }
                }

            });
        } else {
            this.ft.runOnUiThread(new Runnable(){

                @Override
                public void run() {
                    new Handler().post(new Runnable(){

                        @Override
                        public void run() {
                            a.this.kb();
                            a.this.ke = a.lc;
                        }
                    });
                }

            });
        }
    }

    public void kd() {
        Log.e((String)TAG, (String)"actionChallengeSuccess");
        int n2 = this.ku + this.kv + this.kw + this.kx + this.ky + this.kz;
        Log.e((String)TAG, (String)("finishSecs=" + n2));
        if (ePIDModel.getInstance().isGettingActionSuccessImages() || ePIDModel.getInstance().isGettingActionSuccessVideos()) {
            this.ke = a.le;
            if (ePIDModel.getInstance().isGettingActionSuccessVideos()) {
                ArrayList<Bitmap> arrayList = this.jQ.a(this.fO, n2);
                if (this.fs != null && this.jA != null) {
                    Log.e((String)TAG, (String)"ConvertImagesToVideoTask PreviewStop1");
                    this.jA.post(new Runnable(){

                        @Override
                        public void run() {
                            a.this.jA.stop();
                        }
                    });
                }
                this.ja.post(new Runnable(){

                    @Override
                    public void run() {
                        a.this.ja.setVisibility(0);
                    }
                });
                new c(arrayList, this.fO).execute((Object[])new Void[]{null, null, null});
            } else {
                this.kj.GetActionImagesSuccessListener(this.kg);
            }
        } else if (ePIDModel.getInstance().get_ePIDWorkflow() == ePIDModel.b.ij) {
            this.ke = a.le;
            this.ft.runOnUiThread(new Runnable(){

                @Override
                public void run() {
                    if (a.this.getActivity() == null) {
                        return;
                    }
                    if (ePIDModel.getInstance().getOperation() == 0) {
                        ePIDMainActivity ePIDMainActivity2 = (ePIDMainActivity)a.this.getActivity();
                        ePIDMainActivity2.showConfirmationFragment(null, ePIDMainActivity.screenOrientation, a.this.jX);
                    } else {
                        ePIDMainActivity ePIDMainActivity3 = (ePIDMainActivity)a.this.ft;
                        ePIDMainActivity3.showConfirmationFragment(null, ePIDMainActivity.screenOrientation, null);
                    }
                }
            });
        } else {
            this.ke = a.ld;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Log.e((String)TAG, (String)"onDestory");
        if (this.jD != null) {
            this.jD.shutdown();
        }
        if (this.kd != null) {
            this.kd.dismiss();
        }
        if (this.fs != null) {
            this.fs.release();
            this.fs = null;
        }
    }

    public void onRequestPermissionsResult(int n2, String[] arrstring, int[] arrn) {
        if (n2 != 2) {
            Log.d((String)TAG, (String)("Got unexpected permission result: " + n2));
            super.onRequestPermissionsResult(n2, arrstring, arrn);
            return;
        }
        if (arrn.length != 0 && arrn[0] == 0) {
            Log.d((String)TAG, (String)"Camera permission granted - initialize the camera source");
            this.ar(1);
            return;
        }
        Log.e((String)TAG, (String)("Permission not granted: results len = " + arrn.length + " Result code = " + (arrn.length > 0 ? Integer.valueOf(arrn[0]) : "(empty)")));
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                a.this.getActivity().finish();
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.getActivity());
        builder.setTitle((CharSequence)"ePID Client Demo").setMessage(R.string.no_camera_permission).setPositiveButton(17039370, onClickListener).show();
    }

    private void ar(int n2) {
        Log.d((String)TAG, (String)"create CameraSource");
        Context context = ePIDModel.getInstance().getContext();
        FaceDetector faceDetector = new FaceDetector.Builder(context).setClassificationType(1).setMode(1).setProminentFaceOnly(true).build();
        this.jQ = new sg.nec.com.epid_sdk_master.camera.b((Detector<Face>)faceDetector);
        this.jQ.setProcessor((Detector.Processor)new LargestFaceFocusingProcessor.Builder((Detector)this.jQ, (Tracker)new f(this.jB)).build());
        if (!this.jQ.isOperational()) {
            Log.w((String)TAG, (String)"Face detector dependencies are not yet available.");
        }
        this.fs = new CameraSource.Builder(context, (Detector)this.jQ).setRequestedPreviewSize(640, 480).setFacing(n2).setRequestedFps(30.0f).build();
    }

    private void ke() {
        if (this.jr != null && this.ju.getSurface() != null) {
            try {
                int n2 = 0;
                if (ePIDModel.getInstance().isFrontCamera()) {
                    n2 = 1;
                }
                a.a(this.getActivity(), n2, this.jr);
                this.jr.setPreviewDisplay(this.ju);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            this.kf();
        }
    }

    private static void a(Activity activity, int n2, Camera camera) {
        int n3;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo((int)n2, (Camera.CameraInfo)cameraInfo);
        int n4 = activity.getWindowManager().getDefaultDisplay().getRotation();
        int n5 = 0;
        switch (n4) {
            case 0: {
                n5 = 0;
                break;
            }
            case 1: {
                n5 = 90;
                break;
            }
            case 2: {
                n5 = 180;
                break;
            }
            case 3: {
                n5 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            n3 = (cameraInfo.orientation + n5) % 360;
            n3 = (360 - n3) % 360;
        } else {
            n3 = (cameraInfo.orientation - n5 + 360) % 360;
        }
        camera.setDisplayOrientation(n3);
    }

    private void kf() {
        Camera.Parameters parameters = this.jr.getParameters();
        parameters.setPreviewSize(1280, 720);
        parameters.setPictureSize(1280, 720);
        parameters.setPictureFormat(256);
        if (!ePIDModel.getInstance().isFrontCamera()) {
            parameters.setFocusMode("continuous-picture");
        } else {
            parameters.setFocusMode("macro");
        }
        parameters.setFlashMode(this.jw);
        this.jr.setParameters(parameters);
        this.jv = true;
    }

    private void startPreview() {
        if (this.jv && this.jr != null) {
            this.jr.startPreview();
        }
    }

    public void onPause() {
        if (this.jD != null) {
            this.jD.stop();
            this.jD.shutdown();
        }
        if (this.kL != null) {
            this.kL.cancel();
        }
        super.onPause();
        this.ft.setRequestedOrientation(10);
        if (this.jA != null) {
            this.jA.stop();
        }
    }

    public void onResume() {
        this.ft.setRequestedOrientation(1);
        super.onResume();
        Log.e((String)TAG, (String)"onresume");
        this.kh();
        Log.e((String)TAG, (String)("onresume ChallengeFinishSecs=" + this.kr));
        if (this.kL != null) {
            Log.e((String)TAG, (String)"onresume onTick");
            this.kL.cancel();
            if (this.kr == 0) {
                this.kL.onFinish();
            } else {
                this.kL = new e(this.kr * 1000, 1000L);
                this.kL.start();
            }
        }
        if (this.kd != null) {
            this.kd.dismiss();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.ft = activity;
    }

    private void kg() {
        Log.w((String)TAG, (String)"Camera permission is not granted. Requesting permission");
        final String[] arrstring = new String[]{"android.permission.CAMERA"};
        if (!ActivityCompat.shouldShowRequestPermissionRationale((Activity)this.ft, (String)"android.permission.CAMERA")) {
            ActivityCompat.requestPermissions((Activity)this.ft, (String[])arrstring, (int)2);
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener(){

            public void onClick(View view) {
                ActivityCompat.requestPermissions((Activity)a.this.ft, (String[])arrstring, (int)2);
            }
        };
        sg.nec.com.epid_sdk_master.utils.b.a("", this.getString(R.string.permission_camera_rationale), sg.nec.com.epid_sdk_master.utils.d.mm, this.ft, this.jY);
    }

    private void kh() {
        Log.d((String)TAG, (String)"start CameraSource");
        int n2 = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ePIDModel.getInstance().getContext());
        if (n2 != 0) {
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(this.ft, n2, 9001);
            dialog.show();
        }
        if (this.fs != null) {
            Log.e((String)TAG, (String)"camerasoure not null");
            try {
                this.jA.a(this.fs, this.jB, this.ft);
                if (ePIDModel.getInstance().isGettingActionSuccessVideos()) {
                    Log.e((String)TAG, (String)(" actionName for Video=" + this.fO));
                    Log.e((String)TAG, (String)("myFaceDetector=" + (Object)((Object)this.jQ)));
                    this.jQ.jD();
                }
            }
            catch (IOException iOException) {
                Log.e((String)TAG, (String)"Unable to start camera source.", (Throwable)iOException);
                this.fs.release();
                this.fs = null;
            }
        } else {
            Log.e((String)TAG, (String)"camerasoure null");
        }
    }

    public void ki() {
        Log.e((String)TAG, (String)"facefirst captureImage");
        this.ke = a.lb;
        this.fs.takePicture(null, new CameraSource.PictureCallback(){

            public void onPictureTaken(byte[] arrby) {
                int n2 = 0;
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
                    com.a.c.e e2 = com.a.a.c.a(byteArrayInputStream);
                    com.a.c.c.d d2 = e2.b(com.a.c.c.d.class);
                    try {
                        n2 = d2.getInt(274);
                    }
                    catch (Exception exception) {
                        Log.i((String)"io error", (String)exception.toString());
                        exception.printStackTrace();
                    }
                    Log.i((String)TAG, (String)(" Orientation facefirst capture(captureImage) " + String.valueOf(n2)));
                    Matrix matrix = new Matrix();
                    switch (n2) {
                        case 1: {
                            break;
                        }
                        case 2: {
                            matrix.postScale(-1.0f, 1.0f);
                            break;
                        }
                        case 3: {
                            matrix.postRotate(-180.0f);
                            break;
                        }
                        case 4: {
                            matrix.postScale(1.0f, -1.0f);
                            break;
                        }
                        case 5: {
                            matrix.postRotate(90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            break;
                        }
                        case 6: {
                            matrix.postRotate(-90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            break;
                        }
                        case 7: {
                            matrix.postRotate(-90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            break;
                        }
                        case 8: {
                            matrix.postRotate(-90.0f);
                            break;
                        }
                    }
                    Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length);
                    Bitmap bitmap2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)matrix, (boolean)true);
                    FaceDetector faceDetector = new FaceDetector.Builder(ePIDModel.getInstance().getContext()).setLandmarkType(1).setClassificationType(1).setTrackingEnabled(true).setMode(1).build();
                    Frame frame = new Frame.Builder().setBitmap(bitmap2).build();
                    SparseArray sparseArray = faceDetector.detect(frame);
                    Log.d((String)TAG, (String)(" FaceID: >>>>++ facesize() = " + sparseArray.size()));
                    if (sparseArray.size() == 1) {
                        a.this.a((SparseArray<Face>)sparseArray, bitmap2);
                    } else {
                        String string2 = sparseArray.size() > 1 ? "More than one face was detected" : "No face was detected";
                        if (a.this.kL != null) {
                            a.this.kL.cancel();
                        }
                        a.this.kc = true;
                        if (a.this.fs != null) {
                            a.this.jA.stop();
                            a.this.jC = true;
                            a.this.ka.setVisibility(0);
                            a.this.ka.setImageBitmap(bitmap2);
                        }
                        a.this.kd.setMessage((CharSequence)string2);
                        a.this.kd.show();
                        a.this.jy.setText((CharSequence)"");
                        a.this.js.setVisibility(0);
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public void kj() {
        Log.e((String)TAG, (String)"cropFaceFrame");
        final byte[] arrby = this.jQ.jE();
        final int n2 = this.jQ.jF();
        this.getActivity().runOnUiThread(new Runnable(){

            @Override
            public void run() {
                int n22 = n2;
                try {
                    Log.i((String)TAG, (String)(" Orientation facefirst capture(captureImage) " + String.valueOf(n22)));
                    Matrix matrix = new Matrix();
                    switch (n22) {
                        case 1: {
                            matrix.postRotate(90.0f);
                            break;
                        }
                        case 2: {
                            matrix.postRotate(180.0f);
                            break;
                        }
                        case 3: {
                            matrix.postRotate(270.0f);
                            break;
                        }
                    }
                    Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length);
                    Bitmap bitmap2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)matrix, (boolean)true);
                    Log.e((String)TAG, (String)(" getConfig from Camera2222 " + (Object)bitmap2.getConfig()));
                    FaceDetector faceDetector = new FaceDetector.Builder(ePIDModel.getInstance().getContext()).setLandmarkType(1).setClassificationType(1).setTrackingEnabled(true).setMode(1).build();
                    Frame frame = new Frame.Builder().setBitmap(bitmap2).build();
                    SparseArray sparseArray = faceDetector.detect(frame);
                    Log.d((String)TAG, (String)(" FaceID: >>>>++ facesize() = " + sparseArray.size()));
                    if (sparseArray.size() == 1) {
                        a.this.a((SparseArray<Face>)sparseArray, bitmap2);
                    } else {
                        String string2 = sparseArray.size() > 1 ? "More than one face was detected" : "No face was detected";
                        if (a.this.kL != null) {
                            a.this.kL.cancel();
                        }
                        a.this.kc = true;
                        if (a.this.fs != null) {
                            a.this.jA.stop();
                            a.this.jC = true;
                            a.this.ka.setVisibility(0);
                            a.this.ka.setImageBitmap(bitmap2);
                        }
                        a.this.kd.setMessage((CharSequence)string2);
                        a.this.kd.show();
                        a.this.jy.setText((CharSequence)"");
                        a.this.js.setVisibility(0);
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    private void a(SparseArray<Face> sparseArray, Bitmap bitmap) {
        Log.e((String)TAG, (String)"call drawFaceBox");
        Bitmap bitmap2 = bitmap;
        for (int i2 = 0; i2 < sparseArray.size(); ++i2) {
            Object object;
            byte[] arrby;
            Object object22;
            ePIDMainActivity ePIDMainActivity2;
            Face face = (Face)sparseArray.valueAt(i2);
            for (Object object22 : face.getLandmarks()) {
                switch (object22.getType()) {
                    case 4: {
                        object = object22.getPosition();
                        System.out.println(">>>left Eye x = " + object.x);
                        System.out.println(">>>left Eye  y = " + object.y);
                        if ((double)this.jG != 0.0) break;
                        this.jG = object.x;
                        this.jI = object.y;
                        Log.e((String)(TAG + "left eye position"), (String)String.valueOf(object));
                        break;
                    }
                    case 10: {
                        PointF pointF = object22.getPosition();
                        System.out.println(">>>right Eye x = " + pointF.x);
                        System.out.println(">>>right Eye  y = " + pointF.y);
                        if ((double)this.jF != 0.0) break;
                        this.jF = pointF.x;
                        this.jH = pointF.y;
                        Log.e((String)(TAG + "right eye position"), (String)String.valueOf((Object)pointF));
                        break;
                    }
                    case 0: {
                        arrby = object22.getPosition();
                        break;
                    }
                    case 5: {
                        break;
                    }
                    case 11: {
                        break;
                    }
                    case 6: {
                        break;
                    }
                    case 1: {
                        break;
                    }
                    case 7: {
                        break;
                    }
                    case 3: {
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 9: {
                        break;
                    }
                }
            }
            if (sparseArray.size() != 1) continue;
            float f2 = face.getIsLeftEyeOpenProbability();
            object22 = face.getIsRightEyeOpenProbability();
            Log.d((String)TAG, (String)(">>>>++leftEye = " + f2));
            Log.d((String)TAG, (String)(">>>>++rightEye = " + (float)object22));
            if ((double)f2 < 0.3 && (double)object22 < 0.3) {
                if (this.kL != null) {
                    this.kL.cancel();
                }
                this.kc = true;
                if (this.fs != null) {
                    this.jA.stop();
                    this.jC = true;
                    this.ka.setVisibility(0);
                    this.ka.setImageBitmap(bitmap2);
                }
                this.jy.setText((CharSequence)"");
                this.kd.setMessage((CharSequence)this.getString(R.string.facedetection_error_msg));
                this.kd.show();
                this.js.setVisibility(0);
                return;
            }
            if ((double)f2 < 0.3) {
                if (this.kL != null) {
                    this.kL.cancel();
                }
                this.kc = true;
                if (this.fs != null) {
                    this.jA.stop();
                    this.jC = true;
                    this.ka.setVisibility(0);
                    this.ka.setImageBitmap(bitmap2);
                }
                this.jy.setText((CharSequence)"");
                this.kd.setMessage((CharSequence)this.getString(R.string.facedetection_error_msg));
                this.kd.show();
                this.js.setVisibility(0);
                return;
            }
            if ((double)object22 < 0.3) {
                if (this.kL != null) {
                    this.kL.cancel();
                }
                this.kc = true;
                if (this.fs != null) {
                    this.jA.stop();
                    this.jC = true;
                    this.ka.setVisibility(0);
                    this.ka.setImageBitmap(bitmap2);
                }
                this.jy.setText((CharSequence)"");
                this.kd.setMessage((CharSequence)this.getString(R.string.facedetection_error_msg));
                this.kd.show();
                this.js.setVisibility(0);
                return;
            }
            if ((double)this.jG == 0.0 || (double)this.jF == 0.0) {
                Log.e((String)"Catcha", (String)"");
                if (this.kL != null) {
                    this.kL.cancel();
                }
                this.kc = true;
                if (this.fs != null) {
                    this.jA.stop();
                    this.jC = true;
                    this.ka.setVisibility(0);
                    this.ka.setImageBitmap(bitmap2);
                }
                this.jy.setText((CharSequence)"");
                this.kd.setMessage((CharSequence)this.getString(R.string.no_recognize_face_msg));
                this.kd.show();
                this.js.setVisibility(0);
                return;
            }
            this.jJ = (double)this.jG - (double)this.jF;
            this.w = this.jJ / 0.25;
            this.jK = this.w / 0.75;
            this.jL = (this.w - this.jJ) / 2.0;
            Log.d((String)TAG, (String)(">>>>> leftEyeX " + (int)this.jG));
            Log.d((String)TAG, (String)(">>>>> rightEyeX " + (int)this.jF));
            Log.d((String)TAG, (String)(">>>>> d " + (int)this.jJ));
            Log.d((String)TAG, (String)(">>>>> w  " + (int)this.w));
            Log.d((String)TAG, (String)(">>>>> top1  " + (int)this.jL));
            this.jM = 0.6 * this.w + 1.0;
            object = this.jN;
            Log.d((String)TAG, (String)(">>>>> bottom  " + (int)this.jM));
            if (this.jF < this.jG) {
                this.jN = (double)this.jF - this.jL;
                Log.e((String)TAG, (String)("rightEyeX x1 " + String.valueOf(this.jN)));
            } else if (this.jG < this.jF) {
                this.jN = (double)this.jG - this.jL;
                Log.e((String)TAG, (String)("leftEyeX x1 " + String.valueOf(this.jN)));
            }
            this.jO = (double)((this.jH + this.jI) / 2.0f) - (this.jK - this.jM);
            this.jN = this.jN < 0.0 ? 10.0 : (this.jN += 10.0);
            this.jO = this.jO < 0.0 ? 30.0 : (this.jO += 30.0);
            if (this.w + this.jN > (double)bitmap2.getWidth()) {
                this.w = (double)bitmap2.getWidth() - this.jN;
            }
            if (this.jK + this.jO > (double)bitmap2.getHeight()) {
                this.jK = (double)bitmap2.getHeight() - this.jO;
            }
            if (this.w < 0.0) {
                Log.e((String)"Catcha width <0", (String)"");
                if (this.kL != null) {
                    this.kL.cancel();
                }
                this.kc = true;
                if (this.fs != null) {
                    this.jA.stop();
                    this.jC = true;
                    this.ka.setVisibility(0);
                    this.ka.setImageBitmap(bitmap2);
                }
                this.jy.setText((CharSequence)"");
                this.kd.setMessage((CharSequence)this.getString(R.string.no_recognize_face_msg));
                this.kd.show();
                this.js.setVisibility(0);
                return;
            }
            bitmap2 = Bitmap.createBitmap((Bitmap)bitmap2, (int)((int)this.jN), (int)((int)this.jO), (int)((int)this.w), (int)((int)this.jK));
            bitmap2 = sg.nec.com.epid_sdk_master.utils.e.a(bitmap2, 480, 640, false);
            arrby = sg.nec.com.epid_sdk_master.utils.e.a(bitmap2, Bitmap.CompressFormat.JPEG);
            ePIDModel.getInstance().setImageCapture(arrby);
            Log.e((String)TAG, (String)"crop image done");
            if (ePIDModel.getInstance().isFaceSpoofDetection()) {
                if (ePIDModel.getInstance().get_ePIDWorkflow() == ePIDModel.b.ii) {
                    this.ke = a.le;
                    ePIDMainActivity2 = (ePIDMainActivity)this.ft;
                    ePIDMainActivity2.showConfirmationFragment(null, ePIDMainActivity.screenOrientation, null);
                    continue;
                }
                this.getActivity().runOnUiThread(new Runnable(){

                    @Override
                    public void run() {
                        a.this.kb();
                    }
                });
                this.ke = a.lc;
                if (ePIDModel.getInstance().getOperation() != 0 || ePIDModel.getInstance().isGettingActionSuccessImages() || ePIDModel.getInstance().isGettingActionSuccessVideos()) continue;
                Log.e((String)TAG, (String)"Operation is Verification");
                this.jZ = new b();
                Log.e((String)TAG, (String)("CaptureFragment: isServerCallbackisCalled=" + ePIDModel.getInstance().isServerCallbackisCalled()));
                ePIDModel.getInstance().setServerCallbackisCalled(false);
                this.jZ.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
                continue;
            }
            this.ke = a.le;
            ePIDMainActivity2 = (ePIDMainActivity)this.ft;
            ePIDMainActivity2.showConfirmationFragment(null, ePIDMainActivity.screenOrientation, null);
        }
    }

    private class b
    extends AsyncTask<Void, Void, Void> {
        b() {
        }

        protected void onPreExecute() {
        }

        protected /* varargs */ Void doInBackground(Void ... arrvoid) {
            this.log("doInBackground: entered, taskExecutionNumber = ");
            a.this.ft.runOnUiThread(new Runnable(){

                @Override
                public void run() {
                    Log.e((String)TAG, (String)("Image to submit server " + ePIDModel.getInstance().getImageCapture()));
                    sg.nec.com.epid_sdk_master.services.a.e e2 = new sg.nec.com.epid_sdk_master.services.a.e(a.this.ft, "", "", "", "", "", "", "", ePIDModel.getInstance().getImageCapture(), ePIDModel.getInstance().getePIDResponseListener(), null);
                    e2.execute((Object[])new Void[0]);
                }
            });
            this.log("doInBackground: is about to finish, taskExecutionNumber = ");
            return null;
        }

        protected void onPostExecute(Void void_) {
            super.onPostExecute((Object)void_);
            Log.e((String)TAG, (String)"onPostExecute");
        }

        private void log(String string2) {
            Log.d((String)"TestTask #", (String)string2);
        }

    }

    public class e
    extends CountDownTimer {
        public e(long l2, long l3) {
            super(l2, l3);
        }

        public void onFinish() {
            Log.e((String)TAG, (String)" MyCountDownTimer onFinish ");
            a.this.ke = a.le;
            if (a.this.kA >= ePIDModel.getInstance().getRequiredActionCount() + 1) {
                int n2 = ePIDModel.getInstance().getTimer();
                if (ePIDModel.getInstance().isGettingActionSuccessImages() || ePIDModel.getInstance().isGettingActionSuccessVideos()) {
                    if (ePIDModel.getInstance().isGettingActionSuccessImages()) {
                        a.this.kg.add(a.this.jQ.jE());
                        Log.e((String)TAG, (String)("actionImage Size=" + a.this.kg.size()));
                        if (!ePIDModel.getInstance().isGettingActionSuccessVideos()) {
                            a.this.kj.GetActionImagesSuccessListener(a.this.kg);
                        }
                    }
                    if (ePIDModel.getInstance().isGettingActionSuccessVideos()) {
                        ArrayList<Bitmap> arrayList = a.this.jQ.a(a.this.fO, n2);
                        if (a.this.fs != null && a.this.jA != null) {
                            Log.e((String)TAG, (String)"ConvertImagesToVideoTask PreviewStop1");
                            a.this.jA.post(new Runnable(){

                                @Override
                                public void run() {
                                    a.this.jA.stop();
                                }
                            });
                        }
                        a.this.ja.post(new Runnable(){

                            @Override
                            public void run() {
                                a.this.ja.setVisibility(0);
                            }
                        });
                        new c(arrayList, a.this.fO).execute((Object[])new Void[]{null, null, null});
                    }
                } else {
                    if (a.this.jA != null) {
                        a.this.jA.stop();
                    }
                    a.this.jy.setText((CharSequence)a.this.getString(R.string.facedetection_tryagain));
                    if (ePIDModel.getInstance().getOperation() == 0 && ePIDModel.getInstance().get_ePIDWorkflow() == ePIDModel.b.ij) {
                        a.this.jZ.cancel(true);
                    }
                    a.this.jC = true;
                    a.this.kc = true;
                    a.this.kf = 0;
                    a.this.js.setVisibility(0);
                }
            } else {
                Log.e((String)TAG, (String)("Failed Challenge requriedActionCount=" + ePIDModel.getInstance().getRequiredActionCount() + " totalChallengeCount=" + a.this.kA));
                if (ePIDModel.getInstance().isGettingActionSuccessImages()) {
                    a.this.kg.add(a.this.jQ.jE());
                }
                a.this.kb();
                a.this.ke = a.lc;
            }
        }

        public void onTick(long l2) {
            a.this.jy.setVisibility(0);
            Log.e((String)TAG, (String)("Timer ChallengeFinishSecs=" + l2 / 1000L));
            a.this.kr = (int)l2 / 1000;
        }

    }

    public class f
    extends Tracker<Face> {
        private GraphicOverlay fu;
        private sg.nec.com.epid_sdk_master.camera.a lm;
        private int ln = -1;

        f(GraphicOverlay graphicOverlay) {
            this.fu = graphicOverlay;
            this.lm = new sg.nec.com.epid_sdk_master.camera.a(graphicOverlay);
            a.this.kf = 0;
            this.ln = -1;
        }

        public void a(int n2, Face face) {
            this.lm.setId(n2);
            if (ePIDModel.getInstance().isFaceConsistencyCheck()) {
                Log.e((String)TAG, (String)(" FaceID: " + n2 + " Pre ID: " + this.ln));
                if (this.ln == -1) {
                    this.ln = n2;
                } else if (this.ln != n2) {
                    a.this.getActivity().runOnUiThread(new Runnable(){

                        @Override
                        public void run() {
                            if (a.this.kL != null) {
                                a.this.kL.cancel();
                            }
                            a.this.kc = true;
                            f.this.ln = -1;
                            a.this.kf = 0;
                            a.this.state = 0;
                            if (a.this.fs != null) {
                                Log.e((String)TAG, (String)"mCameraSource release");
                                a.this.jA.stop();
                                a.this.jC = true;
                                a.this.ka.setVisibility(0);
                                a.this.ka.setImageBitmap(a.this.jE);
                            }
                            a.this.jy.setText((CharSequence)"");
                            a.this.kd.setMessage((CharSequence)a.this.getString(R.string.stable_msg_on_camera));
                            a.this.kd.show();
                            a.this.js.setVisibility(0);
                        }
                    });
                }
            }
        }

        private void w(final String string2) {
            a.this.ft.runOnUiThread(new Runnable(){

                @Override
                public void run() {
                    a.this.jy.setText((CharSequence)string2);
                }
            });
        }

        public void a(Detector.Detections<Face> detections, Face face) {
            this.fu.a(this.lm);
            this.lm.a(face);
            Log.e((String)TAG, (String)(" FaceID: onUpdate actionState=" + (Object)((Object)a.this.ke)));
            switch (a.this.ke) {
                case lc: {
                    Log.d((String)TAG, (String)(" FaceID: firstChallenge before click play button " + a.this.kC));
                    Log.d((String)TAG, (String)("face.getEulerY() = " + face.getEulerY()));
                    a.this.a(face, a.this.kC);
                    Log.i((String)"random Challenge Track3", (String)String.valueOf(a.this.kC));
                    break;
                }
                case ld: {
                    Log.i((String)TAG, (String)" start capture 01");
                    PointF pointF = face.getPosition();
                    Size size = a.this.fs.getPreviewSize();
                    Log.e((String)(TAG + "myTracker:"), (String)"Preview width:1920 height:1080");
                    Log.e((String)(TAG + "myTracker:"), (String)("TopLeft x:" + pointF.x + " y:" + pointF.y));
                    Log.e((String)(TAG + "myTracker:"), (String)("Face w:" + (int)face.getWidth() + " y:" + (int)face.getHeight()));
                    int n2 = 20;
                    int n3 = 16;
                    int n4 = size.getWidth();
                    int n5 = size.getHeight();
                    if (n4 <= 1280) {
                        n2 = 12;
                        n3 = 8;
                    }
                    float f2 = face.getWidth() / (float)n5;
                    Log.e((String)(TAG + "myTracker:  face/width ratio"), (String)String.valueOf(f2));
                    Log.e((String)(TAG + "myTracker:  preview "), (String)("X: " + size.getWidth() + " Y:" + size.getHeight()));
                    if ((double)f2 > 0.8) {
                        this.w(a.this.getString(R.string.stable_msg_on_camera));
                        break;
                    }
                    if ((double)f2 < 0.25) {
                        this.w(a.this.getString(R.string.stable_msg_on_camera));
                        break;
                    }
                    if (pointF.x < (float)(n5 / n3)) {
                        String string2 = " <1>" + (int)pointF.x + ":" + n5 / n3;
                        this.w(a.this.getString(R.string.stable_msg_on_camera));
                        break;
                    }
                    if (pointF.x + face.getWidth() > (float)(n5 - n5 / n3)) {
                        String string3 = " <2>" + (int)(pointF.x + face.getWidth()) + ":" + (n5 - n5 / n3);
                        this.w(a.this.getString(R.string.stable_msg_on_camera));
                        break;
                    }
                    if (pointF.y < (float)(n4 / n2)) {
                        String string4 = " <3>" + (int)pointF.y + ":" + n4 / n2;
                        this.w(a.this.getString(R.string.stable_msg_on_camera));
                        break;
                    }
                    if (pointF.y + face.getHeight() > (float)(n4 - n4 / n2)) {
                        String string5 = " <4>" + (int)(pointF.y + face.getHeight()) + ":" + (n4 - n4 / n2);
                        this.w(a.this.getString(R.string.stable_msg_on_camera));
                        break;
                    }
                    if ((double)face.getIsLeftEyeOpenProbability() < 0.6 || (double)face.getIsRightEyeOpenProbability() < 0.6) break;
                    a.this.kf++;
                    if (a.this.kf < 3) {
                        this.w(a.this.getString(R.string.stable_msg_on_camera));
                        break;
                    }
                    a.this.kf = 0;
                    a.this.state = 0;
                    this.w("");
                    Log.i((String)TAG, (String)(" MyTarckerOnUpdate" + face.getIsLeftEyeOpenProbability() + " " + face.getIsRightEyeOpenProbability()));
                    a.this.ke = a.lb;
                    a.this.kj();
                    break;
                }
                case lf: {
                    if ((double)face.getIsLeftEyeOpenProbability() < 0.6 || (double)face.getIsRightEyeOpenProbability() < 0.6) break;
                    a.this.getActivity().runOnUiThread(new Runnable(){

                        @Override
                        public void run() {
                            a.this.ki();
                        }
                    });
                }
            }
        }

        public void onMissing(Detector.Detections<Face> detections) {
            this.fu.b(this.lm);
            if (ePIDModel.getInstance().isFaceConsistencyCheck()) {
                Log.e((String)TAG, (String)(" FaceID: onMissing Pre ID: " + this.ln));
                if (this.ln == -1) {
                    return;
                }
                a.this.getActivity().runOnUiThread(new Runnable(){

                    @Override
                    public void run() {
                        if (a.this.kL != null) {
                            a.this.kL.cancel();
                        }
                        a.this.kc = true;
                        f.this.ln = -1;
                        a.this.kf = 0;
                        a.this.state = 0;
                        if (a.this.fs != null) {
                            Log.e((String)TAG, (String)"mCameraSource release");
                            a.this.jA.stop();
                            a.this.jC = true;
                            a.this.ka.setVisibility(0);
                            a.this.ka.setImageBitmap(a.this.jE);
                        }
                        a.this.jy.setText((CharSequence)"");
                        a.this.kd.setMessage((CharSequence)a.this.getString(R.string.stable_msg_on_camera));
                        a.this.kd.show();
                        a.this.js.setVisibility(0);
                    }
                });
            }
        }

        public void onDone() {
            this.fu.b(this.lm);
        }

        public /* synthetic */ void onUpdate(Detector.Detections detections, Object object) {
            this.a((Detector.Detections<Face>)detections, (Face)object);
        }

        public /* synthetic */ void onNewItem(int n2, Object object) {
            this.a(n2, (Face)object);
        }

    }

    class c
    extends AsyncTask<Void, Void, Boolean> {
        ArrayList<Bitmap> li;
        String lj;
        int kr;

        public c(ArrayList<Bitmap> arrayList, String string2) {
            this.li = arrayList;
            this.lj = string2;
        }

        protected void onPreExecute() {
            a.this.jy.post(new Runnable(){

                @Override
                public void run() {
                    a.this.jy.setVisibility(0);
                    a.this.jy.setText((CharSequence)"Program is producing video.Please wait...");
                }
            });
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected /* varargs */ Boolean a(Void ... arrvoid) {
            this.kr = this.li.size() / 2;
            Log.e((String)TAG, (String)("ConvertImagesToVideoTask doInBackground BitmapSize=" + this.li.size() + " challengeFinishSecs=" + this.kr));
            ks = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_DOWNLOADS) + "/ePID.mp4";
            Log.e((String)TAG, (String)("outputFileName=" + ks));
            File file = new File(ks);
            try {
                file.delete();
                if (file.exists()) {
                    file.getCanonicalFile().delete();
                    if (file.exists()) {
                        a.this.ft.deleteFile(file.getName());
                    }
                }
                a.this.out = NIOUtils.writableFileChannel((String)ks);
                AndroidSequenceEncoder androidSequenceEncoder = new AndroidSequenceEncoder(a.this.out, Rational.R((int)this.li.size(), (int)this.kr));
                for (int i2 = 0; i2 < this.li.size(); ++i2) {
                    androidSequenceEncoder.encodeImage(this.li.get(i2));
                }
                androidSequenceEncoder.finish();
                Log.e((String)TAG, (String)"encoder Finish");
            }
            catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
                Boolean bl = false;
                return bl;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                Boolean bl = false;
                return bl;
            }
            finally {
                Log.e((String)TAG, (String)"encoder close");
                NIOUtils.closeQuietly((Closeable)a.this.out);
            }
            return true;
        }

        protected void a(Boolean bl) {
            Log.e((String)TAG, (String)("ConvertImagesToVideoTask onPostExecute result=" + bl));
            a.this.kj.GetActionImagesSuccessListener(a.this.kg);
        }

        protected /* synthetic */ void onPostExecute(Object object) {
            this.a((Boolean)object);
        }

        protected /* synthetic */ Object doInBackground(Object[] arrobject) {
            return this.a((Void[])arrobject);
        }

    }

    private class d
    extends MediaProjection.Callback {
        private d() {
        }

        public void onStop() {
            a.this.kp.stop();
            a.this.kp.reset();
            Log.v((String)TAG, (String)"Recording Stopped");
            a.this.km = null;
            a.this.jZ();
        }
    }

    public static enum a {
        lb,
        lc,
        ld,
        le,
        lf;
        

        private a() {
        }
    }

}

