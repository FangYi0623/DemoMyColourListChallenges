package sg.edu.rp.c346.id20019648.demomycolourlistchallenges;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement, etIndex;
    Button btnAdd, btnRemoveItem, btnUpdateItem;
    ListView lvColour;

    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndex = findViewById(R.id.etIndexElement);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemoveItem = findViewById(R.id.buttonRemoveItem);
        btnUpdateItem = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<String>();

        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                //alColours.add(text);
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.add(pos, colour);
                aaColour.notifyDataSetChanged();
            }
        });

        btnRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < alColours.size(); i++) {
                    alColours.remove(i);
                    aaColour.notifyDataSetChanged();
                }
            }
        });

        btnUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < alColours.size(); i++) {
                    String colour = alColours.get(i);
                    alColours.set(i, colour);
                    aaColour.notifyDataSetChanged();
                }

            }
        });
    }
}