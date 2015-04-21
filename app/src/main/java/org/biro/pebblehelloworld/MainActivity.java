package org.biro.pebblehelloworld;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import org.biro.pebble.Pebble;
import org.biro.pebble.PebbleTextLayer;
import org.biro.pebble.PebbleWindow;


public class MainActivity extends ActionBarActivity {

    Pebble mPebble;
    PebbleWindow mPebbleWindow;
    PebbleTextLayer mPebbleTextLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPebble = new Pebble();
        mPebble.setUUID("9312d524-6e77-47e4-96ed-e67bd11ce1d5");
        mPebble.registerHandlers(getApplicationContext());

        // Set up the pebbles stuff and turn it on.
        mPebbleWindow = PebbleWindow.getRootWindow();
        mPebbleTextLayer = new PebbleTextLayer();

        mPebbleWindow.setParent(mPebble);
        mPebbleTextLayer.setText("Hello, World!");

        mPebbleWindow.addLayer(mPebbleTextLayer);
        mPebbleWindow.update(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
