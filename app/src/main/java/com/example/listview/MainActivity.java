package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.adapters.TeamListAdapter;
import com.example.listview.models.Team;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView teamListView;
    private ArrayList<Team> teams;
    private boolean wentToDetail = false;
    private Team lastViewedTeam = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamListView = findViewById(R.id.teamListView);

        teams = new ArrayList<>();
        int football = R.drawable.sports_football_24dp_000000;

        // NFL Teams
        teams.add(new Team("Buffalo Bills", "AFC East", "4-0", football));
        teams.add(new Team("New England Patriots", "AFC East", "2-0-2", football));
        teams.add(new Team("Miami Dolphins", "AFC East", "1-0-3", football));
        teams.add(new Team("New York Jets", "AFC East", "0-0-4", football));

        teams.add(new Team("Pittsburgh Steelers", "AFC North", "3-1", football));
        teams.add(new Team("Cincinnati Bengals", "AFC North", "2-1", football));
        teams.add(new Team("Baltimore Ravens", "AFC North", "1-3", football));
        teams.add(new Team("Cleveland Browns", "AFC North", "1-3", football));

        teams.add(new Team("Indianapolis Colts", "AFC South", "3-1", football));
        teams.add(new Team("Jacksonville Jaguars", "AFC South", "3-1", football));
        teams.add(new Team("Houston Texans", "AFC South", "1-3", football));
        teams.add(new Team("Tennessee Titans", "AFC South", "0-4", football));

        teams.add(new Team("Los Angeles Chargers", "AFC West", "3-1", football));
        teams.add(new Team("Denver Broncos", "AFC West", "2-2", football));
        teams.add(new Team("Kansas City Chiefs", "AFC West", "2-2", football));
        teams.add(new Team("Las Vegas Raiders", "AFC West", "1-3", football));

        teams.add(new Team("Philadelphia Eagles", "NFC East", "4-0", football));
        teams.add(new Team("Washington Commanders", "NFC East", "2-0-2", football));
        teams.add(new Team("Dallas Cowboys", "NFC East", "1-2-1", football));
        teams.add(new Team("New York Giants", "NFC East", "1-3", football));

        teams.add(new Team("Detroit Lions", "NFC North", "3-1", football));
        teams.add(new Team("Green Bay Packers", "NFC North", "2-1-1", football));
        teams.add(new Team("Minnesota Vikings", "NFC North", "2-2", football));
        teams.add(new Team("Chicago Bears", "NFC North", "2-2", football));

        teams.add(new Team("Tampa Bay Buccaneers", "NFC South", "3-1", football));
        teams.add(new Team("Atlanta Falcons", "NFC South", "2-2", football));
        teams.add(new Team("Carolina Panthers", "NFC South", "1-3", football));
        teams.add(new Team("New Orleans Saints", "NFC South", "0-4", football));

        teams.add(new Team("San Francisco 49ers", "NFC West", "3-1", football));
        teams.add(new Team("Seattle Seahawks", "NFC West", "3-1", football));
        teams.add(new Team("Los Angeles Rams", "NFC West", "3-1", football));
        teams.add(new Team("Arizona Cardinals", "NFC West", "2-2", football));

        TeamListAdapter adapter = new TeamListAdapter(this, teams);
        teamListView.setAdapter(adapter);

        teamListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Team selected = teams.get(position);
                lastViewedTeam = selected;
                wentToDetail = true;
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("team", selected);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Dynamic message after returning from activity
        if (wentToDetail && lastViewedTeam != null) {
            String msg = "Viewed \"" + lastViewedTeam.getName() + "\" successfully";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            wentToDetail = false;
            lastViewedTeam = null;
        }
    }
}
