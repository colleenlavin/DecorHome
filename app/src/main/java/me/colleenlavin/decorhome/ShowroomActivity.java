package me.colleenlavin.decorhome;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;
import com.noelchew.sparkpostutil.library.EmailListener;
import com.noelchew.sparkpostutil.library.SparkPostEmailUtil;
import com.noelchew.sparkpostutil.library.SparkPostRecipient;
import com.noelchew.sparkpostutil.library.SparkPostSender;

import java.util.ArrayList;

public class ShowroomActivity extends AppCompatActivity {

    private String SP_API_KEY = "6407c42892096df6c3db61e204047bb84a44c7bb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showroom);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                SparkPostEmailUtil.sendEmail(ShowroomActivity.this,
                        SP_API_KEY,
                        "Your recent Furnished set!",
                        "This is just a test",
                        new SparkPostSender("developer@aymlab.com", "Furnished LLC"),
                        new SparkPostRecipient("themastrgamr@gmail.com"),
                        new EmailListener() {
                            @Override
                            public void onSuccess() {
                                // do something here
                                System.out.println("hann");
                                Snackbar.make(view, "Sent Set to your email!", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }

                            @Override
                            public void onError(String errorMessage) {
                                // do something here
                                System.out.println("awww " + errorMessage);
                            }
                        });

//                Client client = new Client(SP_API_KEY);
//                try {
//                    client.sendMessage(
//                            "stuartsmith@outlook.com", // from
//                            "themastrgamr@gmail.com", // to
//                            "Your recent Furnished set!",
//                            "This is just a test",
//                            "<b>The HTML part of the email</b>");
//                } catch (SparkPostException e) {
//                    e.printStackTrace();
//                }
            }
        });

        RecyclerView recView = (RecyclerView)findViewById(R.id.showroom_chooser_recview);
        ArrayList<SimpleItem> items = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            items.add(new SimpleItem().withName("Showroom #" + i));
        }
        //create our FastAdapter which will manage everything
        FastItemAdapter fastAdapter = new FastItemAdapter();
        //set the items to your ItemAdapter
        fastAdapter.add(items);
        fastAdapter.withOnClickListener(new FastAdapter.OnClickListener<SimpleItem>() {
            @Override
            public boolean onClick(View v, IAdapter<SimpleItem> adapter, SimpleItem item, int position) {
                Toast.makeText(v.getContext(), (item).name, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //set our adapters to the RecyclerView
        //we wrap our FastAdapter inside the ItemAdapter -> This allows us to chain adapters for more complex useCases
        recView.setAdapter(fastAdapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setItemAnimator(new DefaultItemAnimator());
    }

}
