package hk.ust.cse.comp107x.greetfriend;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends ListActivity {

    Button greetButton;
    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        names = getResources().getStringArray(R.array.friends);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.friend_item, names));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent in = new Intent(this, ShowMessage.class);
        in.putExtra("message", getString(R.string.greetString) + names[(int) id] + "!");
        startActivity(in);
    }
}
