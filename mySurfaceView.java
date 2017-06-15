package ...

import android.content.Context;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by evan_lou on 17-5-31.
 * create surfaceview and manager camera
 */


public class mySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = mySurfaceView.class.getSimpleName();
    private SurfaceHolder mSurfaceHolder;
    //子线程标志位
    private Context mContext;

    private Camera mCamera = null;
    private Handler mMainUiHandler = null;

    public mySurfaceView(Context context) {
        this(context, null);
    }

    public mySurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public mySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.i(TAG, "surfaceCreated");
        openCamera();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i(TAG, "surfaceDestroyed");
        closeCamera();
    }

    /**
     * 初始化View
     */
    private void initView() {
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        setFocusable(true);
        setKeepScreenOn(true);
        setFocusableInTouchMode(true);
    }

    public void setHandler(Handler handler) {
        mMainUiHandler = handler;
    }

    private boolean openCamera() {
        try {
            String path = getAssetPath("haarcascade_frontalface_alt.xml");
            String pathDat = getAssetPath("shape_predictor_68_face_landmarks.dat");
            Log.d(TAG, " path is " + path);
            Log.d(TAG, " pathDat is " + pathDat);

            INativeLiveness.init(path, pathDat);

            mCamera = Camera.open();
            Camera.Parameters camPara = mCamera.getParameters();
            camPara.setPictureFormat(ImageFormat.NV21);
            camPara.setPreviewFpsRange(5, 10);
            camPara.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
            mCamera.setParameters(camPara);
            mCamera.setDisplayOrientation(90);

            mCamera.setPreviewDisplay(mSurfaceHolder);
            mCamera.startPreview();

            mCamera.setPreviewCallback(new Camera.PreviewCallback() {
                @Override
                public void onPreviewFrame(byte[] data, Camera camera) {

                    Camera.Size size = camera.getParameters().getPreviewSize();
                    try {

                        if (mMainUiHandler != null) {
                            Message msg = Message.obtain();
                            msg.arg1 = MainActivity.MSG_UPDATE_RESULT_TEXT;
                            Bundle bundle = new Bundle();

                            msg.setData(bundle);

                            mMainUiHandler.sendMessage(msg);
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();

            mCamera.release();
            return false;
        }

        return true;
    }

    private void closeCamera(){

        mCamera.setPreviewCallback(null);
        mCamera.cancelAutoFocus();
        mCamera.stopPreview();
        try {
            mCamera.setPreviewDisplay(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mCamera.release();
    }

    private String getAssetPath(String filename) {

        try {
            InputStream is = mContext.getAssets().open(filename);

            File cascadeDir = mContext.getDir("myweights", Context.MODE_PRIVATE);
            File mCascadeFile = new File(cascadeDir, filename);
            FileOutputStream os = new FileOutputStream(mCascadeFile);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            is.close();
            os.close();
            return mCascadeFile.getPath();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
