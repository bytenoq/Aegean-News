package icsd.aegean.aegeannews;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Info extends AppCompatActivity {

    //Προβολή πληροφοριών με το άνοιγμα της σελίδας
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}