package com.xiaomi.account.ui;

import android.os.Bundle;
import com.xiaomi.account.utils.FriendlyFragmentUtils;
import com.xiaomi.account.utils.SysHelper;
import miui.app.Activity;
import miui.os.Build;

public class UserAvatarUpdateActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserAvatarUpdateFragment f = new UserAvatarUpdateFragment();
        f.setArguments(getIntent().getExtras());
        FriendlyFragmentUtils.addFragment(getFragmentManager(), 16908290, f);
    }

    protected void onResume() {
        super.onResume();
        if (!Build.IS_TABLET) {
            SysHelper.setOrientationPortrait(this);
        }
    }
}
