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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
            }
        });

        String[] urls = {
                "https://ak1.ostkcdn.com/images/products/11414287/Christopher-Knight-Home-Dejon-Chevron-Fabric-Loveseat-8dc9ae4c-caff-419b-981f-80881d4504b6_600.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/71%2BXPZ46fRL._SL1500_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/91e1LHLXwdL._SL1500_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/61oPkpaZ%2BcL._SL1500_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/B1VoYn1GrmS._SL1500_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/A1DOAupb-DL._SL1500_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/81Ssno0WAGL._SL1500_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/81J-QzYfNYL._SL1024_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/91-OVWs9J1L._SL1500_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/51C7oosxV4L.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/61XUivx0UqL._SL1100_.jpg",
                "https://www.amazon.com/Best-Choice-Products-Leather-Convertible/dp/B00VQYBTNQ/ref=sr_1_23?s=home-garden&ie=UTF8&qid=1497142354&sr=1-23&keywords=couch",
                "https://target.scene7.com/is/image/Target/52071004?wid=2000&qlt=70&fmt=pjpeg",
                "https://images-na.ssl-images-amazon.com/images/I/A1ZdadlhsvL._SL1500_.jpg",
                "https://images-na.ssl-images-amazon.com/images/I/61jvnU1AOHL._SL1001_.jpg"
        };

        RecyclerView recView = (RecyclerView)findViewById(R.id.showroom_chooser_recview);
        ArrayList<ProductItem> items = new ArrayList<>();
        for(int i = 0; i < 15; i++){
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
