package mx.mediomelon.testapp.flow.main;

/**
 * Created by FranckLB on 09/11/2018.
 */
public interface MainActivityContract {

    interface Vista {

        Presenter getPresenter();

        void updateList();
    }

    interface Presenter {

        void removeItem(int position);
    }
}
