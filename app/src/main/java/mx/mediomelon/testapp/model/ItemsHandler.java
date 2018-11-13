package mx.mediomelon.testapp.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mx.mediomelon.testapp.utils.Logs;
import mx.mediomelon.testapp.TestApp;
import mx.mediomelon.testapp.utils.Preffs;

/**
 * Created by FranckLB on 09/11/2018.
 */
public class ItemsHandler {
    private static final ItemsHandler instance = new ItemsHandler();
    private List<ItemModel> items;

    public static ItemsHandler getInstance() {
        return instance;
    }

    private ItemsHandler() {
    }

    public void initList() {
        Map<String, ?> savedItems = Preffs.getAll();
        items = new ArrayList<>();
        for (Map.Entry<String, ?> pair : savedItems.entrySet()) {
            items.add(new ItemModel(pair.getKey(), Preffs.getBoolPref(pair.getKey())));
        }

        Logs.d("ItemsCount : " + items.size());
        for (ItemModel item : items) {
            Logs.i("key : " + item.name + " value : " + item.checked);
        }
    }

    public void addItem(String itemName) {
        items.add(new ItemModel(itemName, false));
        Logs.d("itemsCount : " + items.size());
        for (ItemModel item : items) {
            Logs.i("item : " + item.name + " checked : " + item.checked);
        }
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void removeItem(ItemModel item) {
        items.remove(item);
    }
}
