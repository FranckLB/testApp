package mx.mediomelon.testapp.flow.main.addItem;

/**
 * Created by FranckLB on 13/11/2018.
 */
public interface AddItemFragmentContract {

    interface Vista {

        Presenter getPresenter();

        String getItemName();

        void clearItemName();
    }

    interface Presenter {

        void addItem();
    }
}
