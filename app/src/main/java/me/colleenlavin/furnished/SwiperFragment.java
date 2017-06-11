package me.colleenlavin.furnished;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daprlabs.aaron.swipedeck.SwipeDeck;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SwiperFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SwiperFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private int counter = 0;

    ArrayList<String> testData = new ArrayList<>();
    private String mParam1;

    private SwipeDeck cardStack;
    private SwipeDeckAdapter adapter;

    public SwiperFragment() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SwiperFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SwiperFragment newInstance(String param1) {
        SwiperFragment fragment = new SwiperFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_swiper, container, false);

        testData.add("Nautical Table");
        testData.add("1");
        testData.add("2");
        testData.add("3");
        testData.add("4");

        cardStack = (SwipeDeck) v.findViewById(R.id.swipe_deck);

        final ArrayList<Integer> swipeImages = new ArrayList<>();
        swipeImages.add(R.drawable.bluecouch);
        swipeImages.add(R.drawable.krakentable);
        swipeImages.add(R.drawable.lamp);
        swipeImages.add(R.drawable.leavescouch);
        swipeImages.add(R.drawable.moderntable);
        swipeImages.add(R.drawable.swirltable);
        swipeImages.add(R.drawable.ornaterug);
        swipeImages.add(R.drawable.rug);
        adapter = new SwipeDeckAdapter(swipeImages, getActivity());

        if(cardStack != null){
            cardStack.setAdapter(adapter);
        }
        // TODO -- after 10 Right swipes prompt user to see the showroom
        cardStack.setCallback(new SwipeDeck.SwipeDeckCallback() {
            @Override
            public void cardSwipedLeft(long stableId) {
//                Toast.makeText(getActivity(), "We didn't like that anyway!", Toast.LENGTH_SHORT).show();
                System.out.println("" + counter + " -- " + swipeImages.size());
                if(counter < swipeImages.size() - 1) {
                    counter++;
                    System.out.println("swiped right");
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SwiperFragment.this.getActivity());
                    builder.setMessage("View your room or keep swiping to get more nuanced options")
                            .setTitle("Your room has been generated!");
                    builder.setNegativeButton("Show Room", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            getActivity().startActivity(new Intent(SwiperFragment.this.getActivity(), ShowroomActivity.class));
                        }
                    });
                    builder.setPositiveButton("Swipe", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK button
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
            @Override
            public void cardSwipedRight(long stableId) {
//                Toast.makeText(getActivity(), "Nice choice!", Toast.LENGTH_SHORT).show();
                if(counter < swipeImages.size() - 1) {
                    counter++;
                    System.out.println("swiped left");
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SwiperFragment.this.getActivity());
                    builder.setMessage("View your room or keep swiping to get more nuanced options")
                            .setTitle("Your room has been generated!");
                    builder.setNegativeButton("Show Room", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            getActivity().startActivity(new Intent(SwiperFragment.this.getActivity(), ShowroomActivity.class));
                        }
                    });
                    builder.setPositiveButton("Swipe", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK button
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
        return v;
    }

}
