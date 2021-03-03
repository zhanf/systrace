package com.piaoyou.systrace.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * @Author zhan
 * @Date 2/25/21 7:35 PM
 * @Desc
 */
public class RouterExt {
    public static void startActivity(Context context, Class<Object> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }
}
