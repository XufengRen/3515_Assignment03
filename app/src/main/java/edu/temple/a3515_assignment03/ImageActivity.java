package edu.temple.a3515_assignment03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    ListView listView;
    ImageView imageView;
    Spinner spinner;
    int[] dogs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //listView = findViewById(R.id.listView);
        imageView = findViewById(R.id.imageView);
        spinner = findViewById(R.id.spinner);

        //String[] dogArray = new String[]{"dog1","dog2","dog3","dog4","dog5"};
        ArrayList dogList = new ArrayList<String>();
        dogList.add("select one of the items");
        dogList.add("dog1");
        dogList.add("dog2");dogList.add("dog3");dogList.add("dog4");dogList.add("dog5");

        dogs = new int[]{R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,R.drawable.dog4,R.drawable.dog5};

        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,dogArray);
        myAdapter adapter = new myAdapter(this,dogList,dogs);
        //listView.setAdapter(adapter);
        spinner.setAdapter(adapter);
        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                imageView.setImageResource(dogs[position]);
            }
        });*/
//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?>parent, View view, int position,long id){
//                imageView.setVisibility(View.INVISIBLE);
//            }
//        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0){
                    showPicture(position-1);
                }else{}

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                //imageView.setVisibility(View.GONE);
            }
        });


    }
    public void showPicture (int position){
        imageView.setImageResource(dogs[position]);
    }
}