package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview.models.Team;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView logo = findViewById(R.id.detailLogo);
        TextView name = findViewById(R.id.detailName);
        TextView division = findViewById(R.id.detailDivision);
        TextView record = findViewById(R.id.detailRecord);

        Object extra = getIntent().getSerializableExtra("team");
        if (!(extra instanceof Team)) {
            Toast.makeText(this, "No team provided", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        Team team = (Team) extra;

        name.setText(team.getName());
        division.setText(team.getDivision());
        record.setText("Record: " + team.getRecord());
        logo.setImageResource(team.getLogoResId());
    }
}
