package com.example.android.bloodbank20;


import android.content.Intent;
import android.view.WindowManager;

import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashScreenActivity extends AwesomeSplash {
    @Override
    public void initSplash(ConfigSplash configSplash) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        configSplash.setBackgroundColor(R.color.red);
        configSplash.setAnimCircularRevealDuration(2000);
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
        configSplash.setRevealFlagX(Flags.REVEAL_BOTTOM);

        // for picture
        configSplash.setLogoSplash(R.drawable.heart);
        configSplash.setAnimLogoSplashDuration(1000);

        //
       configSplash.setTitleSplash("G.V.R");


    }

    @Override
    public void animationsFinished() {
        finish();
        startActivity(new Intent(SplashScreenActivity.this,FirstScreenActivity.class));

    }
}
