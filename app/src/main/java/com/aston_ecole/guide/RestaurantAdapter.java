package com.aston_ecole.guide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.aston_ecole.guide.models.Restaurant;
import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<Restaurant>{

    private int resId;
    private LayoutInflater layoutInflater;

    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull List<Restaurant> objects) {
        super(context, resource, objects);

        resId = resource;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = layoutInflater.inflate(resId, null);

        TextView textViewTitle = convertView.findViewById(R.id.textViewTitle);
        TextView textViewCategory = convertView.findViewById(R.id.textViewCategory);

        Restaurant item = getItem(position);

        textViewTitle.setText(item.getName());
        textViewCategory.setText(item.getCategory());
        return convertView;
    }
}
