package mx.mediomelon.testapp.flow.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;

import mx.mediomelon.testapp.flow.BaseActivity;
import mx.mediomelon.testapp.R;
import mx.mediomelon.testapp.databinding.ActivityMainViewBinding;
import mx.mediomelon.testapp.flow.main.addItem.AddItemFragmentContract;
import mx.mediomelon.testapp.flow.main.addItem.AddItemFragmentView;
import mx.mediomelon.testapp.flow.main.list.ListFragmentContract;
import mx.mediomelon.testapp.flow.main.list.ListFragmentView;

public class MainActivityView extends BaseActivity implements MainActivityContract.Vista, View.OnClickListener {

    private MainActivityContract.Presenter presenter;
    private ActivityMainViewBinding binding;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVista();
    }

    @Override
    protected void initVista() {
        super.initVista();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_view);
        presenter = new MainActivityPresenter(this, this);
        binding.btnAddItem.setOnClickListener(this);
        binding.btnNext.setOnClickListener(this);
        binding.btnPrevious.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(binding.frameContent.getId(), new ListFragmentView(), "ListFragmentView").commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_item && fragmentManager.findFragmentByTag("ListFragmentView").isVisible()) {
            fragmentManager.beginTransaction().replace(binding.frameContent.getId(), new AddItemFragmentView(), "AddItemFragmentView").addToBackStack("AddItemFragmentView").commit();
        } else if (v.getId() == R.id.btn_add_item) {
            AddItemFragmentContract.Vista addItemPresenter = (AddItemFragmentContract.Vista) fragmentManager.findFragmentByTag("AddItemFragmentView");
            addItemPresenter.getPresenter().addItem();
        }
    }

    @Override
    public MainActivityContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void updateList() {
        if (fragmentManager.findFragmentByTag("ListFragmentView").isVisible()) {
            ListFragmentContract.Vista listVista = (ListFragmentContract.Vista) fragmentManager.findFragmentByTag("ListFragmentView");
            listVista.updateList();
        }
    }
}
