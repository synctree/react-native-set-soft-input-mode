package io.github.mr03web.softinputmode;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by Administrator on 2018/1/4.
 */

public class SoftInputModeModule extends ReactContextBaseJavaModule {


    private static final String SOFT_INPUT_ADJUST_NOTHING = "ADJUST_NOTHING";
    private static final String SOFT_INPUT_ADJUST_PAN = "ADJUST_PAN";
    private static final String SOFT_INPUT_ADJUST_RESIZE = "ADJUST_RESIZE";
    private static final String SOFT_INPUT_ADJUST_UNSPECIFIED = "ADJUST_UNSPECIFIED";
    private static final String SOFT_INPUT_STATE_ALWAYS_HIDDEN = "STATE_ALWAYS_HIDDEN";
    private static final String SOFT_INPUT_STATE_ALWAYS_VISIBLE = "STATE_ALWAYS_VISIBLE";

    public SoftInputModeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "SoftInputMode";
    }

    private Handler mHandler = new Handler(getReactApplicationContext().getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Activity activity = getCurrentActivity();
            if (activity != null) {  // check activity
                activity.getWindow().setSoftInputMode(msg.what);
            }
        }
    };

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(SOFT_INPUT_ADJUST_NOTHING, WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        constants.put(SOFT_INPUT_ADJUST_PAN, WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        constants.put(SOFT_INPUT_ADJUST_RESIZE, WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        constants.put(SOFT_INPUT_ADJUST_UNSPECIFIED, WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED);
        constants.put(SOFT_INPUT_STATE_ALWAYS_HIDDEN, WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        constants.put(SOFT_INPUT_STATE_ALWAYS_VISIBLE, WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        return constants;
    }

    @ReactMethod
    public void set(int type) {
        Message msg = Message.obtain();
        msg.what = type;
        mHandler.sendMessageDelayed(msg, 0);
    }
}
