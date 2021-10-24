package com.example.freebiesir;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopsFragment extends Fragment {

    private Button sub,sub1,sub2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ShopsFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopsFragment newInstance(String param1, String param2) {
        ShopsFragment fragment = new ShopsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shops, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sub = (Button) view.findViewById(R.id.sub);
        sub1 = (Button) view.findViewById(R.id.sub_tav);
        sub2 = (Button) view.findViewById(R.id.sub_kop);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MarkerOptions.setVisible(true);

              //  Intent resultIntent = new Intent();
               // resultIntent.MarkerOptions().setVisible(true);


            }
        });


        sub1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(),"Подписка на Таврию В офромлена успешно!",Toast.LENGTH_SHORT).show();

               // App.getInstance(b = true);
                App.isActive = true;

                boolean isActive = true;




            }
        });

        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Подписка на Клпейку офромлена успешно!",Toast.LENGTH_SHORT).show();
                boolean isActive = true;

            }
        });

    }

}