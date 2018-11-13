package mx.mediomelon.testapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

import mx.mediomelon.testapp.R;
import mx.mediomelon.testapp.flow.BaseActivity;
import mx.mediomelon.testapp.flow.main.MainActivityContract;
import mx.mediomelon.testapp.model.ItemModel;

/**
 * Created by FranckLB on 13/11/2018.
 */
public class ListItemsAdapter extends BaseAdapter{

    private BaseActivity context; //context
    private List<ItemModel> items; //data source of the list adapter

    public ListItemsAdapter(BaseActivity context, List<ItemModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        ItemModel item = (ItemModel) getItem(position);
        vh.chbxItem.setText(item.name);
        vh.chbxItem.setChecked(item.checked);
        vh.chbxItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // TODO: 13/11/2018 Agregar todo lo que tengas que hacer si esta chequeado
                }
            }
        });
        vh.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityContract.Vista mainVista = (MainActivityContract.Vista) context;
                mainVista.getPresenter().removeItem(position);
            }
        });

        return convertView;
    }

    private class ViewHolder {
        CheckBox chbxItem;
        Button btnDelete;

        public ViewHolder(View view) {
            chbxItem = (CheckBox) view.findViewById(R.id.chbx_item);
            btnDelete = (Button) view.findViewById(R.id.btn_delete);
        }
    }
}
