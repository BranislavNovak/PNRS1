package inc.company.list2_my_application;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CharacterAdapter adapter = new CharacterAdapter(this);

        adapter.AddCharacter(new Model(("Stevan"), getResources().getDrawable(R.drawable.stan_marsh)));
        adapter.AddCharacter(new Model(("Bojan"), getResources().getDrawable(R.drawable.jimmy_valmer)));

        ListView list = (ListView) findViewById(R.id.lista1);
        list.setAdapter(adapter);

    }


//    adapter.AddCharacter(new Model("Stevan"), getResources().getDrawable(R.drawable.stan_marsh)));



}
