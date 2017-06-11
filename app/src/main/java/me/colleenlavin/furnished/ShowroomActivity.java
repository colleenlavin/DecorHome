package me.colleenlavin.furnished;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                SparkPostEmailUtil.sendEmail(ShowroomActivity.this,
                        SP_API_KEY,
                        "Your recent Furnished set!",
                        "Dear Taylor, " +
                                "Hope you enjoyed picking out your room! We noticed there " +
                                "were some items left in your cart and would like to offer you a " +
                                "10% off coupon if you fill out this quick survey on your " +
                                "experience!" +
                                "- Your friends at Furnished",
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
            }
        });

        String[] urls = {
                "https://jetimages.azureedge.net/md5/afebd88fe96575e204a939fdaaea853d.500",
                "https://images-na.ssl-images-amazon.com/images/I/71icNQUKVJL._SL1500_.jpg",
                "https://jetimages.azureedge.net/md5/e5c6d9ca0c79c713f2b0dadbe67b6ae1.500",
                "https://images-na.ssl-images-amazon.com/images/I/81VT9i9zZhL._SL1500_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/61XUivx0UqL._SL1100_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/91e1LHLXwdL._SL1500_.jpg",
                "https://jetimages.azureedge.net/md5/0a126dead135463dc853876c7fa212e1.500",
                "https://images-na.ssl-images-amazon.com/images/I/A1ZdadlhsvL._SL1500_.jpg"
        };

        RecyclerView recView = (RecyclerView)findViewById(R.id.showroom_chooser_recview);
        ArrayList<ProductItem> items = new ArrayList<>();
        for(int i = 0; i < urls.length; i++) {
            items.add(new ProductItem().withName("Showroom Piece #" + i)
                            .withDescription("$" + i)
                            .withImgUrl(urls[i]));
        }
        //create our FastAdapter which will manage everything
        FastItemAdapter fastAdapter = new FastItemAdapter();
        //set the items to your ItemAdapter
        fastAdapter.add(items);
        fastAdapter.withOnClickListener(new FastAdapter.OnClickListener<ProductItem>() {
            @Override
            public boolean onClick(View v, IAdapter<ProductItem> adapter, ProductItem item, int position) {
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
