package foply.ph52222.huanph52222.lab1_adr2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
        private adapter adapter;
        private List<model> list;
        private EditText txt1, txt2;
        database database;
        private Button add;
        private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        add = findViewById(R.id.btnadd);
        listview = findViewById(R.id.listview);
        database = new database(this);// goi ham tao database
        list = database.getAll();//load du lieu
        adapter = new adapter(this, list);
        listview.setAdapter(adapter);
        add.setOnClickListener(v-> {
            String name = txt1.getText().toString();
            String name2 = txt2.getText().toString();
            if (!name.isEmpty() || !name2.isEmpty()) {// neu du ieu khong dong
                model model = new model(name, name2);
                database.them(model);// them du liue
                adapter.notifyDataSetChanged();// cap nhat du lieu
                txt1.setText("");
                txt2.setText("");
            }
        });
    }
}