package mx.mediomelon.testapp.flow.splash;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import mx.mediomelon.testapp.flow.BaseActivity;
import mx.mediomelon.testapp.R;
import mx.mediomelon.testapp.databinding.ActivitySplashViewBinding;

public class SplashActivityView extends BaseActivity implements SplashActivityContract.Vista {

    private SplashActivityContract.Presenter presenter;
    private ActivitySplashViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVista();
    }

    @Override
    protected void initVista() {
        super.initVista();
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash_view);
        presenter = new SplashActivityPresenter(this, this);
        presenter.showLogo(binding.imgSplashLogo);
    }

    @Override
    public void makeLogoVisible() {
        binding.imgSplashLogo.setVisibility(View.VISIBLE);
        presenter.showLogo(binding.imgSplashLogo);
    }
}
