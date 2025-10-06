package com.example.listview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.R;
import com.example.listview.models.Team;

import java.util.List;

public class TeamListAdapter extends ArrayAdapter<Team> {

    private final LayoutInflater inflater;

    public TeamListAdapter(Context context, List<Team> data) {
        super(context, 0, data);
        this.inflater = LayoutInflater.from(context);
    }

    static class ViewHolder {
        View root;
        ImageView imgLogo;
        TextView tvName;
        TextView tvDivision;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Team team = getItem(position);
        ViewHolder vh = new ViewHolder();
        convertView = inflater.inflate(R.layout.row_item, parent, false);
        vh.root = convertView.findViewById(R.id.rowRoot);
        vh.imgLogo = convertView.findViewById(R.id.imgLogo);
        vh.tvName = convertView.findViewById(R.id.tvName);
        vh.tvDivision = convertView.findViewById(R.id.tvDivision);
        convertView.setTag(vh);

        if (team != null) {
            vh.tvName.setText(team.getName());
            vh.tvDivision.setText(team.getDivision());
            vh.imgLogo.setImageResource(team.getLogoResId());
        }
        return convertView;
    }
}
