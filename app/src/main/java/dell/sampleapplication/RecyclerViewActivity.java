package dell.sampleapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Created by dell on 10-12-2017.
 */

public class RecyclerViewActivity  extends AppCompatActivity {
    private static RecyclerView recyclerView;

    //String and Integer array for Recycler View Items
    public static final String[] TITLES= {"Hood","Full Sleeve Shirt","Shirt","Jean Jacket","Jacket"};
    public static final Integer[] IMAGES= {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,};


    private static String navigateFrom;//String to get Intent Value
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        initViews();
        populatRecyclerView();
    }

    // Initialize the view
    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Set Back Icon on Activity

        navigateFrom = getIntent().getStringExtra("navigateFrom");//Get Intent Value in String

        recyclerView = (RecyclerView)
                findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        //Set RecyclerView type according to intent value
        if (navigateFrom.equals("horizontal")) {
            getSupportActionBar().setTitle("Horizontal Recycler View");
            recyclerView
                    .setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this, LinearLayoutManager.HORIZONTAL, false));
        } else {
            getSupportActionBar().setTitle("Staggered GridLayout Manager");
            recyclerView
                    .setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));// Here 2 is no. of columns to be displayed

        }
    }


    // populate the list view by adding data to arraylist
    private void populatRecyclerView() {
        ArrayList<DataModel> arrayList = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            arrayList.add(new DataModel(TITLES[i],IMAGES[i]));
        }
        RecyclerAdapter  adapter = new RecyclerAdapter(RecyclerViewActivity.this, arrayList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
