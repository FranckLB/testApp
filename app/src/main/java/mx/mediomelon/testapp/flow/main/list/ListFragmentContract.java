package mx.mediomelon.testapp.flow.main.list;

import mx.mediomelon.testapp.adapter.ListItemsAdapter;

/**
 * Created by FranckLB on 12/11/2018.
 */
public interface ListFragmentContract {

    interface Vista {

        void updateList();
    }

    interface Presenter {

        ListItemsAdapter getAdapter();
    }
}
