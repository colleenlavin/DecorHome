package me.colleenlavin.decorhome;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daprlabs.aaron.swipedeck.SwipeDeck;

import java.util.ArrayList;

public class Swipe extends AppCompatActivity {

    private SwipeDeck  cardStack;
    private SwipeDeckAdapter adapter;
    ArrayList<String> testData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        ArrayList<Integer> swipeImages = new ArrayList<>();
        swipeImages.add(R.drawable.bluecouch);
        swipeImages.add(R.drawable.krakentable);
        swipeImages.add(R.drawable.lamp);
        swipeImages.add(R.drawable.leavescouch);
        swipeImages.add(R.drawable.moderntable);
        swipeImages.add(R.drawable.swirltable);
        swipeImages.add(R.drawable.ornaterug);
        swipeImages.add(R.drawable.rug);


        ArrayList<String> testData = new ArrayList<>();
        testData.add("Nautical Table");
        testData.add("Kraken Table");
        testData.add("Modern Table");
        testData.add("Fish Rug");
        testData.add("Round Sea Rug");
        testData.add("Royalty Rug");
        testData.add("Cinderella Rug");
        testData.add("Leaves Couch");
        testData.add("Blue Couch");
        testData.add("Gray Couch");


        adapter = new SwipeDeckAdapter(swipeImages, this);
        if(cardStack != null){
            cardStack.setAdapter(adapter);
        }
        cardStack.setCallback(new SwipeDeck.SwipeDeckCallback() {
            @Override
            public void cardSwipedLeft(long stableId) {

            }

            @Override
            public void cardSwipedRight(long stableId) {

            }
        });
//
//        cardStack.setLeftImage(R.id.left_image);
//        cardStack.setRightImage(R.id.right_image);

        //example of buttons triggering events on the deck
//        Button btn = (Button) findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cardStack.swipeTopCardLeft(180);
//            }
//        });
//        Button btn2 = (Button) findViewById(R.id.button2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cardStack.swipeTopCardRight(180);
//            }
//        });
//
//        Button btn3 = (Button) findViewById(R.id.button3);
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                testData.add("a sample string.");
//                adapter.notifyDataSetChanged();
//            }
//        });
    }
}
