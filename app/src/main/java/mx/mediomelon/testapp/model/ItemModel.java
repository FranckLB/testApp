package mx.mediomelon.testapp.model;

/**
 * Created by FranckLB on 09/11/2018.
 */
public class ItemModel {

    public boolean checked;
    public String name;

    ItemModel(String name, boolean checked) {
        this.name = name;
        this.checked = checked;
    }
}
