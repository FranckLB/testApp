package mx.mediomelon.testapp.flow.main;

import mx.mediomelon.testapp.flow.BaseActivity;
import mx.mediomelon.testapp.model.ItemModel;
import mx.mediomelon.testapp.model.ItemsHandler;
import mx.mediomelon.testapp.utils.Preffs;

/**
 * Created by FranckLB on 09/11/2018.
 */
public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.Vista vista;
    private BaseActivity activity;

    MainActivityPresenter(BaseActivity activity, MainActivityView vista) {
        this.activity = activity;
        this.vista = vista;
    }

    @Override
    public void removeItem(int position) {
        ItemModel item = ItemsHandler.getInstance().getItems().get(position);
        ItemsHandler.getInstance().removeItem(item);
        Preffs.removePrefference(item.name);
        vista.updateList();
    }
}
