package inc.company.list_my_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener {

    private ListView lv;
    private Button buttonAdd;
    private String text;
    private EditText editText1;

    // (u koji aktiviti, koji tip(layout), sta je parametar)
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.list1);
        buttonAdd = findViewById(R.id.buttonAdd);
        editText1 = findViewById(R.id.text1);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lv.setAdapter(mAdapter);

        buttonAdd.setOnClickListener(this);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        text = editText1.getText().toString();
        mAdapter.add(text);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // jumping on another activity
        //Intent j = new Intent(this, Main2Activity.class);
        //startActivity(j);

        // deleting a one element from list
        String item = mAdapter.getItem(i);
        mAdapter.remove(item);
    }
}
