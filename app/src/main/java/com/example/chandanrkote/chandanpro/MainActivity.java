package com.example.chandanrkote.chandanpro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarMain);
        listView = (ListView)findViewById(R.id.lvMain);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CSE-A Section");
    }

    private void setupListView(){

        String[] title = getResources().getStringArray(R.array.Main);
        String[] description = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0: {
                        Intent intent = new Intent(MainActivity.this, WeekActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent = new Intent(MainActivity.this, SubjectActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 2: {
                        Intent intent = new Intent(MainActivity.this, FacultyActivity.class);
                        startActivity(intent);
                        break;

                    }
                    case 3: {
                        Intent intent = new Intent(MainActivity.this, ResourceActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 4: {
                        Intent intent = new Intent(MainActivity.this, CalenderActivity.class);
                        startActivity(intent);
                        break;
                    }
                }
            }
        });
    }

    public class SimpleAdapter extends BaseAdapter{

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] title, String[] description){
            mContext = context;
            titleArray = title;
            descriptionArray = description;
            layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.activitysingleitem, null);
            }

            title = (TextView)convertView.findViewById(R.id.tvMain);
            description = (TextView)convertView.findViewById(R.id.tvDescription);
            imageView = (ImageView)convertView.findViewById(R.id.ivMain);

            title.setText(titleArray[position]);
            try{
                description.setText(descriptionArray[position]);
            }catch (Exception exception){

                Log.e("error", String.valueOf(description));
            }



            if(titleArray[position].equalsIgnoreCase("Timetable")){
                imageView.setImageResource(R.drawable.firsttheme);
            }else if(titleArray[position].equalsIgnoreCase("Subjects")){
                imageView.setImageResource(R.drawable.su);
            }else if(titleArray[position].equalsIgnoreCase("Faculty")){
                imageView.setImageResource(R.drawable.faculty);
            }
            else if(titleArray[position].equalsIgnoreCase("Resources")){
                imageView.setImageResource(R.drawable.re);
            }
            else
            {
                imageView.setImageResource(R.drawable.ca);
            }

            return convertView;

        }
    }

}