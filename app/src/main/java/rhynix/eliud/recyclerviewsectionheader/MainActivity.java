package rhynix.eliud.recyclerviewsectionheader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView sectionHeader;
    private SectionedRecyclerViewAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionHeader = (RecyclerView)findViewById(R.id.add_header);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        sectionHeader.setLayoutManager(linearLayoutManager);
        sectionHeader.setHasFixedSize(true);

        HeaderRecyclerViewSection firstSection = new HeaderRecyclerViewSection("First Section",getDataSource());
        HeaderRecyclerViewSection secondSection = new HeaderRecyclerViewSection("Second Section",getDataSource());
        HeaderRecyclerViewSection thirdSection = new HeaderRecyclerViewSection("Third Section",getDataSource());
        sectionAdapter = new SectionedRecyclerViewAdapter();
        sectionAdapter.addSection(firstSection);
        sectionAdapter.addSection(secondSection);
        sectionAdapter.addSection(thirdSection);
        sectionHeader.setAdapter(sectionAdapter);

    }

    private List<ItemObject> getDataSource() {
        List<ItemObject> data = new ArrayList<ItemObject>();
        data.add(new ItemObject("This is the item content in the first position"));
        data.add(new ItemObject("This is the item content in the second position"));
        data.add(new ItemObject("This is the item cotent in the Third position"));
        return data;
    }
}
