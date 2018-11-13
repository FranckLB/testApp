package mx.mediomelon.testapp.flow.splash;

import android.widget.ImageView;

/**
 * Created by FranckLB on 09/11/2018.
 */
public interface SplashActivityContract {

    interface Vista {
        void makeLogoVisible();
    }

    interface Presenter {
        void showLogo(ImageView imgSplashLogo);
    }
}
