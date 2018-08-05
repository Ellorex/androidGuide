package com.aston_ecole.guide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.aston_ecole.guide.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class ListingActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private ListView listViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        textViewTitle = findViewById(R.id.textViewTitle);
        listViewData = findViewById(R.id.listViewData);

        if(getIntent().getExtras() != null) {
            boolean isRestaurant = getIntent().getExtras().getBoolean("isRestaurant");
            if(isRestaurant) {
                textViewTitle.setText("Les Restaurants");
                final List<Restaurant> restaurantList = new ArrayList<>();
                restaurantList.add(new Restaurant("Mac do",
                                                  "Fast Food",
                                                  "mac@do.com",
                                                  "0665181667",
                                                  "https://www.mcdo.com",
                                                  "https://cap.img.pmdstatic.net/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fcap.2F2017.2F05.2F10.2F95673471-9020-44d4-8e13-b02de101203a.2Ejpeg/750x375/background-color/ffffff/quality/70/picture.jpg"));
                restaurantList.add(new Restaurant("Burger King",
                                                  "Fast Food",
                                                  "burger@king.com",
                                                  "0102010201",
                                                  "https://www.burgerking.com",
                                                  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUzXzN07KvWpUQjz5U0vbdk0iYLD_MwAvUjy7k6GhAhVZTQvFrRg"));
                listViewData.setAdapter(new RestaurantAdapter(ListingActivity.this, R.layout.item_restaurant, restaurantList));

                listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intentRestaurant = new Intent(ListingActivity.this, DetailsActivity.class);
                        intentRestaurant.putExtra("objet", restaurantList.get(position));
                        startActivity(intentRestaurant);
                    }
                });
            } else {
                textViewTitle.setText("Les Hôtels");
            }
        }
    }
}
