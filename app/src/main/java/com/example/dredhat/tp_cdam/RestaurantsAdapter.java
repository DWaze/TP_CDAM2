package com.example.dredhat.tp_cdam;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dredhat.tp_cdam.Models.Restaurant;

import java.util.ArrayList;

/**
 * Created by lhadj on 10/21/2017.
 */

public class RestaurantsAdapter extends ArrayAdapter<Restaurant> {

    ArrayList<Restaurant> mRestaurants;
    private final int layoutResource;
    private final LayoutInflater mLayoutInflater;

    public RestaurantsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Restaurant> objects) {
        super(context, resource, objects);
        mRestaurants=objects;
        this.layoutResource = resource;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mRestaurants.size() ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(layoutResource,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        Restaurant restaurant = mRestaurants.get(position);
        viewHolder.lName.setText(restaurant.getRestaurantName());
        viewHolder.lAddress.setText(restaurant.getRestaurantAddress());
        return convertView;
    }

    private class ViewHolder {

        final TextView lName ;
        final TextView lAddress ;

        public ViewHolder(View v) {
            this.lName = (TextView)v.findViewById(R.id.Name);
            this.lAddress = (TextView)v.findViewById(R.id.Address);
        }
    }
}
