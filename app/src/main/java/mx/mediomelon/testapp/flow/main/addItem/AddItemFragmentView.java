package mx.mediomelon.testapp.flow.main.addItem;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.mediomelon.testapp.R;
import mx.mediomelon.testapp.databinding.FragmentAddItemViewBinding;
import mx.mediomelon.testapp.flow.BaseActivity;

/**
 * Created by FranckLB on 13/11/2018.
 */
public class AddItemFragmentView extends Fragment implements AddItemFragmentContract.Vista {

    private BaseActivity activity;
    private AddItemFragmentContract.Presenter presenter;
    private FragmentAddItemViewBinding binding;


    public AddItemFragmentView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(inflater, R.layout.fragment_add_item_view, container);
    }

    private View initView(LayoutInflater inflater, int layout, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, layout, container, false);
        activity = (BaseActivity) getActivity();
        presenter = new AddItemFragmentPresenter(activity, this);
        return binding.getRoot();
    }

    @Override
    public AddItemFragmentContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public String getItemName() {
        return binding.edtxtItemName.getText().toString();
    }

    @Override
    public void clearItemName() {
        binding.edtxtItemName.getEditableText().clear();
    }
}
