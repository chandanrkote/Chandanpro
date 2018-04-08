package com.example.chandanrkote.chandanpro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SubjectActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private ListView listView;
    private  String[] subjects;
    public static SharedPreferences subjectPreferences;
    public static String SUB_PRE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);


        setupUIViews();
        initToolbar();
        setupListViews();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarSubject);
        listView = (ListView)findViewById(R.id.lvSubject);
        subjectPreferences=getSharedPreferences("Subjects",MODE_PRIVATE);


    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Subjects");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void setupListViews(){
        subjects=getResources().getStringArray(R.array.Subjects);

        SubjectAdapter subjectAdapter=new SubjectAdapter(this,R.layout.subject_single_item,subjects);

        listView.setAdapter(subjectAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                               subjectPreferences.edit().putString(SUB_PRE,"networks").apply();
                                Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                                startActivity(intent);
                                break;
                    }
                    case 1:{
                        subjectPreferences.edit().putString(SUB_PRE,"cd").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:{
                        subjectPreferences.edit().putString(SUB_PRE,"me").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:{
                        subjectPreferences.edit().putString(SUB_PRE,"wt").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 4:{
                        subjectPreferences.edit().putString(SUB_PRE,"unix").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 5:{
                        subjectPreferences.edit().putString(SUB_PRE,"cgv").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 6:{
                        subjectPreferences.edit().putString(SUB_PRE,"cgvlab").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 7:{
                        subjectPreferences.edit().putString(SUB_PRE,"wtlab").apply();
                        Intent intent=new Intent(SubjectActivity.this,SubjectDetails.class);
                        startActivity(intent);
                        break;
                    }
                    default:break;

                }
            }
        });
    }


    public class SubjectAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] subjects =new String[]{};

        public SubjectAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.subjects = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            SubjectActivity.SubjectAdapter.ViewHolder holder;
            if(convertView == null){
                holder = new SubjectActivity.SubjectAdapter.ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetterSubject);
                holder.tvSubject = (TextView)convertView.findViewById(R.id.tvSubject);
                convertView.setTag(holder);
            }else{
                holder = (SubjectActivity.SubjectAdapter.ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(subjects[position].charAt(0));
            holder.tvSubject.setText(subjects[position]);

            return convertView;
        }

        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvSubject;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
