package mx.mediomelon.testapp.flow.main.list;

import mx.mediomelon.testapp.adapter.ListItemsAdapter;
import mx.mediomelon.testapp.flow.BaseActivity;
import mx.mediomelon.testapp.model.ItemsHandler;

/**
 * Created by FranckLB on 13/11/2018.
 */
public class ListFragmentPresenter implements ListFragmentContract.Presenter {

    private BaseActivity activity;
    private ListFragmentContract.Vista vista;

    ListFragmentPresenter(BaseActivity activity, ListFragmentContract.Vista vista) {
        this.activity = activity;
        this.vista = vista;
    }

    @Override
    public ListItemsAdapter getAdapter() {
        return new ListItemsAdapter(activity, ItemsHandler.getInstance().getItems());
    }
}
