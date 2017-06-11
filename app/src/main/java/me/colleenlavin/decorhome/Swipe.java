package me.colleenlavin.decorhome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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


        testData.add("Nautical Table");
        testData.add("1");
        testData.add("2");
        testData.add("3");
        testData.add("4");

        adapter = new SwipeDeckAdapter(testData, this);
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
