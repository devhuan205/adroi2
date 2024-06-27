package foply.ph52222.huanph52222.lab1_adr2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class adapter extends ArrayAdapter<model> {
    // khoi thao
    public adapter(@NonNull Context context, List<model> objects) {
        super(context, 0   , objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {//chua co view
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        model item = getItem(position);// lay du liue tren 1 item
        // anh xa
        TextView tvName = convertView.findViewById(R.id.item_txt1);
        TextView tvname2 = convertView.findViewById(R.id.item_txt2);
        // dua du liue vao tung thanh phan
        tvName.setText(item.getTilte());
        tvname2.setText(item.getDes());
        return convertView;
    }
}

