package org.thecosmicfrog.luasataglance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.thecosmicfrog.luasataglance.R;

public class RedLineActivity extends Activity {

    private ArrayAdapter<CharSequence> redLineAdapterStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_line);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                redLineAdapterStop = ArrayAdapter.createFromResource(
                      getApplicationContext(),
                        R.array.red_line_stops_array,
                        R.layout.listview_stops
                );

                ListView listView = (ListView) stub.findViewById(
                        R.id.listview_red_line);
                listView.setAdapter(redLineAdapterStop);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(
                            AdapterView<?> parent, View view, int position, long id) {
                        String stopName = redLineAdapterStop.getItem(position).toString();

                        startActivity(new Intent(
                                getApplicationContext(),
                                StopForecastActivity.class)
                                .putExtra("stopName", stopName)
                        );
                    }
                });
            }
        });
    }
}