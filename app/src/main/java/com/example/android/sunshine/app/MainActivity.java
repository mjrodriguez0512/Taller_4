/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            // Es necesario definir una información dummy para la prueba, por favor agregue
            String[] data = {
                    getString(R.string.lunes)+" 6/03/2017 "+getString(R.string.Bruma)+" 10/24",
                    getString(R.string.martes)+" 7/03/2017 "+getString(R.string.soleado)+" 21/8",
                    getString(R.string.miercoles)+" 8/03/2017 "+getString(R.string.Bruma)+" 22/17",
                    getString(R.string.jueves)+" 9/03/2017 "+getString(R.string.lluvia)+"  8/11",
                    getString(R.string.viernes)+" 10/03/2017 "+getString(R.string.soleado)+" 24/9",
                    getString(R.string.sabado)+" 11/03/2017 "+getString(R.string.lluvia)+" 5/8",
                    getString(R.string.domingo)+" 12/03/2017 "+getString(R.string.lluvia)+" 6/9",
                    getString(R.string.lunes)+"	13/03/2017 "+getString(R.string.Bruma)+" 24/16",
                    getString(R.string.martes)+" 14/03/2017 "+getString(R.string.nublado)+" 26/8",
                    getString(R.string.miercoles)+" 15/03/2017 "+getString(R.string.soleado)+" 25/6",
                    getString(R.string.jueves)+" 16/03/2017 "+getString(R.string.Bruma)+" 25/10",
                    getString(R.string.viernes)+" 17/03/2017 "+getString(R.string.soleado)+" 25/12",
                    getString(R.string.sabado)+" 18/03/2017 "+getString(R.string.nublado)+" 27/10",
                    getString(R.string.domingo)+" 19/03/2017 "+getString(R.string.Bruma)+" 23/8",
                    getString(R.string.lunes)+"	20/03/2017 "+getString(R.string.soleado)+" 20/15",
                    getString(R.string.martes)+" 21/03/2017 "+getString(R.string.lluvia)+" 23/8",
                    getString(R.string.miercoles)+" 22/-03/2017 "+getString(R.string.nublado)+" 27/15",
                    getString(R.string.jueves)+" 23/03/2017 "+getString(R.string.soleado)+" 24/14",
                    getString(R.string.viernes)+" 24/-03/2017 "+getString(R.string.nublado)+" 22/3",
                    getString(R.string.sabado)+" 25/03/2017 "+getString(R.string.Bruma)+" 35/5",
                    getString(R.string.domingo)+" 26/03/2017 "+getString(R.string.soleado)+" 23/12",
                    getString(R.string.lunes)+"	27/03/2017 "+getString(R.string.Bruma)+" 9/3",
                    getString(R.string.martes)+" 28/03/2017 "+getString(R.string.soleado)+" 21/15",
                    getString(R.string.miercoles)+" 29/-03/2017 "+getString(R.string.Bruma)+" 8/14",
                    getString(R.string.jueves)+" 30/03/2017 "+getString(R.string.nublado)+" 24/10",
                    getString(R.string.viernes)+" 31/03/2017 "+getString(R.string.soleado)+" 24/15",
                    getString(R.string.sabado)+" 1/04/2017 "+getString(R.string.Bruma)+" 3/10",
                    getString(R.string.domingo)+" 2/04/2017 "+getString(R.string.soleado)+" 24/16",
                    getString(R.string.lunes)+"	3/04/2017 "+getString(R.string.lluvia)+" 14/8",
                    getString(R.string.martes)+" 4/04/2017 "+getString(R.string.nublado)+" 20/7",
            };
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));


            // Now that we have some dummy forecast data, create an ArrayAdapter.
            // The ArrayAdapter will take data from a source (like our dummy forecast) and
            // use it to populate the ListView it's attached to.
            mForecastAdapter =
                new ArrayAdapter<String>(
                    getActivity(), // The current context (this activity)
                    R.layout.list_item_forecast, // The name of the layout ID.
                    R.id.list_item_forecast_textview, // The ID of the textview to populate.
                    weekForecast);

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Get a reference to the ListView, and attach this adapter to it.
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
