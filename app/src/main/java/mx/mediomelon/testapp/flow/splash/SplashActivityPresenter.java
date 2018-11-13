package mx.mediomelon.testapp.flow.splash;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import mx.mediomelon.testapp.flow.BaseActivity;
import mx.mediomelon.testapp.flow.main.MainActivityView;

/**
 * Created by FranckLB on 09/11/2018.
 */
public class SplashActivityPresenter implements SplashActivityContract.Presenter {

    private SplashActivityContract.Vista vista;
    private BaseActivity activity;
    private Handler timer = new Handler();
    private boolean isLogoVisible;

    SplashActivityPresenter(BaseActivity activity, SplashActivityContract.Vista vista) {
        this.activity = activity;
        this.vista = vista;
    }

    @Override
    public void showLogo(ImageView imgSplashLogo) {
        isLogoVisible = imgSplashLogo.getVisibility() == View.VISIBLE;
        timer.postDelayed(logoChange, 3000);
    }

    private Runnable logoChange = new Runnable() {
        @Override
        public void run() {
            if (isLogoVisible) {
                Intent intent = new Intent(activity, MainActivityView.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(intent);
                activity.finish();
            } else {
                vista.makeLogoVisible();
            }
        }
    };
}
