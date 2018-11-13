package mx.mediomelon.testapp.flow.main.list;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.mediomelon.testapp.R;
import mx.mediomelon.testapp.adapter.ListItemsAdapter;
import mx.mediomelon.testapp.databinding.FragmentListFragmentViewBinding;
import mx.mediomelon.testapp.flow.BaseActivity;

public class ListFragmentView extends Fragment implements ListFragmentContract.Vista {

    private ListFragmentContract.Presenter presenter;
    private BaseActivity activity;
    private FragmentListFragmentViewBinding binding;
    private ListItemsAdapter listAdapter;

    public ListFragmentView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView(inflater, R.layout.fragment_list_fragment_view, container);
    }

    private View initView(LayoutInflater inflater, int layout, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, layout, container, false);
        activity = (BaseActivity) getActivity();
        presenter = new ListFragmentPresenter(activity,this);
        binding.listView.setAdapter(presenter.getAdapter());
        return binding.getRoot();
    }

    @Override
    public void updateList() {
        binding.listView.setAdapter(presenter.getAdapter());
    }
}
