package icsd.aegean.aegeannews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mUrls = new ArrayList<>();

    //Η συνάρτηση που καλεί το RecyclerView για την προβολή του μενού
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();

        initRecyclerView();
    }

    //Καθορισμός των ονομάτων των νησιών και των εικόνων για το μενού καθώς και του link του feed εμφανιστεί
    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mNames.add("Αιγαίο");
        mImageUrls.add("https://i.imgur.com/0sWOiy1.png");
        mUrls.add("https://feed.rssunify.com/5e3d858548bc1/rss.xml");

        mNames.add("Κάλυμνος");
        mImageUrls.add("https://i.imgur.com/mKKZ6EO.png");
        mUrls.add("https://feed.rssunify.com/5e3d82975b92f/rss.xml");

        mNames.add("Λέσβος");
        mImageUrls.add("https://i.imgur.com/HSZKjtd.png");
        mUrls.add("https://feed.rssunify.com/5e3d815552aa3/rss.xml");

        mNames.add("Λήμνος");
        mImageUrls.add("https://i.imgur.com/LvabKLw.png");
        mUrls.add("https://feed.rssunify.com/5e36ecd967505/rss.xml");

        mNames.add("Μύκονος");
        mImageUrls.add("https://i.imgur.com/DgANKE5.png");
        mUrls.add("https://feed.rssunify.com/5e3b279b14b0a/rss.xml");

        mNames.add("Νάξος");
        mImageUrls.add("https://i.imgur.com/yPZMpVz.png");
        mUrls.add("https://feed.rssunify.com/5e3b27c23d305/rss.xml");

        mNames.add("Πάρος");
        mImageUrls.add("https://i.imgur.com/bGbPSYX.png");
        mUrls.add("https://feed.rssunify.com/5e3b26f8cfb9b/rss.xml");

        mNames.add("Ρόδος");
        mImageUrls.add("https://i.imgur.com/l18LUdp.png");
        mUrls.add("https://feed.rssunify.com/5e36f2ac1ee07/rss.xml");

        mNames.add("Σάμος");
        mImageUrls.add("https://i.imgur.com/PdM6dA5.png");
        mUrls.add("https://feed.rssunify.com/5e3b25f80f8f1/rss.xml");

        mNames.add("Σαντορίνη");
        mImageUrls.add("https://i.imgur.com/6CXUMBK.png");
        mUrls.add("https://feed.rssunify.com/5e3b27dbe298d/rss.xml");

        mNames.add("Σύρος");
        mImageUrls.add("https://i.imgur.com/Sl6KeRP.png");
        mUrls.add("https://feed.rssunify.com/5e36f6a5ef471/rss.xml");

        mNames.add("Τήνος");
        mImageUrls.add("https://i.imgur.com/tDjW9Wy.png");
        mUrls.add("https://feed.rssunify.com/5e3b2751afe14/rss.xml");

        mNames.add("Χίος");
        mImageUrls.add("https://i.imgur.com/9zjmtFR.png");
        mUrls.add("https://feed.rssunify.com/5e3d81a7a7dd3/rss.xml");

        initRecyclerView();
    }

    //Δημιουργία του RecyclerView
    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);
    }

    //Δημιουργία του κουμπιού στο ActionBar για "Πληροφορίες"
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_info, menu);
        return true;
    }

    //Οι λειτουργίες που ενεργοποιούνται πατώντας το κουμπί για "Πληροφορίες"
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                Intent intent = new Intent(this, Info.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return super.onOptionsItemSelected(item);
    }
}