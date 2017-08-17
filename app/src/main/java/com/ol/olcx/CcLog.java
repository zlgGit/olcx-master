package com.ol.olcx;

import android.util.Log;

/**
 * Created by gw00070468 on 2017/8/17.
 */

public class CcLog {

    public static final boolean isCanLog=true;
    public static void i(String tag,String info)
    {
        if (isCanLog){
            Log.i(tag,info);
        }
    }
}
