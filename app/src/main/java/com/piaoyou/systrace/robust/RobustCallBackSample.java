package com.piaoyou.systrace.robust;

import com.blankj.utilcode.util.LogUtils;
import com.meituan.robust.Patch;
import com.meituan.robust.RobustCallBack;

import java.util.List;

/**
 * @Author zhan
 * @Date 2/24/21 6:48 PM
 * @Desc
 */
public class RobustCallBackSample implements RobustCallBack {
    @Override
    public void onPatchListFetched(boolean result, boolean isNet, List<Patch> patches) {
        LogUtils.d("RobustCallBack", "onPatchListFetched result: " + result);
        LogUtils.d("RobustCallBack", "onPatchListFetched isNet: " + isNet);
        for (Patch patch : patches) {
            LogUtils.d("RobustCallBack", "onPatchListFetched patch: " + patch.getName());
        }
    }

    @Override
    public void onPatchFetched(boolean result, boolean isNet, Patch patch) {
        LogUtils.d("RobustCallBack", "onPatchFetched result: " + result);
        LogUtils.d("RobustCallBack", "onPatchFetched isNet: " + isNet);
        LogUtils.d("RobustCallBack", "onPatchFetched patch: " + patch.getName());
    }

    @Override
    public void onPatchApplied(boolean result, Patch patch) {
        LogUtils.d("RobustCallBack", "onPatchApplied result: " + result);
        LogUtils.d("RobustCallBack", "onPatchApplied patch: " + patch.getName());

    }

    @Override
    public void logNotify(String log, String where) {
        LogUtils.d("RobustCallBack", "logNotify log: " + log);
        LogUtils.d("RobustCallBack", "logNotify where: " + where);
    }

    @Override
    public void exceptionNotify(Throwable throwable, String where) {
        LogUtils.e("RobustCallBack", "exceptionNotify where: " + where, throwable);
    }
}
