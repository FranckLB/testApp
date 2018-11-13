package mx.mediomelon.testapp.flow.main.addItem;

import android.widget.Toast;

import mx.mediomelon.testapp.flow.BaseActivity;
import mx.mediomelon.testapp.model.ItemModel;
import mx.mediomelon.testapp.model.ItemsHandler;
import mx.mediomelon.testapp.utils.Preffs;

/**
 * Created by FranckLB on 13/11/2018.
 */
public class AddItemFragmentPresenter implements AddItemFragmentContract.Presenter {

    private BaseActivity activity;
    private AddItemFragmentContract.Vista vista;

    AddItemFragmentPresenter(BaseActivity activity, AddItemFragmentContract.Vista vista) {
        this.activity = activity;
        this.vista = vista;
    }

    @Override
    public void addItem() {
        validateItemName(vista.getItemName());
    }

    private void validateItemName(String itemName) {
        if (!itemName.trim().isEmpty() && (!isDuplicated(itemName) || ItemsHandler.getInstance().getItems().isEmpty())) {
            ItemsHandler.getInstance().addItem(itemName);
            Preffs.setBoolPref(itemName, false);
            activity.onBackPressed();
        } else {
            Toast.makeText(activity, "The item name is empty or already exists", Toast.LENGTH_SHORT).show();
            vista.clearItemName();
        }
    }

    private boolean isDuplicated(String itemName) {
        for (int i = 0; i < ItemsHandler.getInstance().getItems().size(); i++) {
            if (ItemsHandler.getInstance().getItems().get(i).name.equals(itemName)) {
                return true;
            }
        }
        return false;
    }
}
