package me.colleenlavin.decorhome;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StyleChooserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StyleChooserFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private CheckBox checkBox8;
    private Button goToProductsBtn;

    private int numberChecked = 0;

    public StyleChooserFragment() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment StyleChooserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StyleChooserFragment newInstance(String param1) {
        StyleChooserFragment fragment = new StyleChooserFragment();
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
        View v = inflater.inflate(R.layout.fragment_style_chooser, container, false);

        checkBox1 = (CheckBox) v.findViewById(R.id.checkBox);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2 = (CheckBox) v.findViewById(R.id.checkBox2);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3 = (CheckBox) v.findViewById(R.id.checkBox3);
        checkBox3.setOnCheckedChangeListener(this);
        checkBox4 = (CheckBox) v.findViewById(R.id.checkBox4);
        checkBox4.setOnCheckedChangeListener(this);
        checkBox5 = (CheckBox) v.findViewById(R.id.checkBox5);
        checkBox5.setOnCheckedChangeListener(this);
        checkBox6 = (CheckBox) v.findViewById(R.id.checkBox6);
        checkBox6.setOnCheckedChangeListener(this);
        checkBox7 = (CheckBox) v.findViewById(R.id.checkBox7);
        checkBox7.setOnCheckedChangeListener(this);
        checkBox8 = (CheckBox) v.findViewById(R.id.checkBox8);
        checkBox8.setOnCheckedChangeListener(this);
        goToProductsBtn = (Button) v.findViewById(R.id.goToProducts);
        goToProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragmentTo(SwiperFragment.newInstance("Oi"));
            }
        });

        return v;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView.isChecked())
            numberChecked++;
        else
            numberChecked--;

        if(numberChecked > 0)
            goToProductsBtn.setVisibility(View.VISIBLE);
    }
}
