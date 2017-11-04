package com.example.dredhat.tp_cdam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.dredhat.tp_cdam.Models.Restaurant;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first, container,false);

        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        for(int i=1;i<18;i++){
            restaurants.add(new Restaurant("Le Grand Bleu","cite 1051 khroub"));
        }
        GridView restaurantViews;
        restaurantViews = rootView.findViewById(R.id.listRestaurant);
        RestaurantsAdapter restaurantsAdapter = new RestaurantsAdapter(getActivity(),R.layout.item_restaurant,restaurants);
        restaurantViews.setAdapter(restaurantsAdapter);

        restaurantViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "Restaurant numero"+i, Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
