package com.zeretto4210.mapexercisearica;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderAdaptador> {

    ArrayList<Marker> list;

    public Adapter(ArrayList<Marker> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderAdaptador onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marker_layout, null, false);
        return new ViewHolderAdaptador(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdaptador holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.latitude.setText(""+list.get(position).getLatitude());
        holder.longitude.setText(""+list.get(position).getLongitude());
        holder.showmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MapsActivity.class);
                i.putExtra("save",false);
                i.putExtra("nom",list.get(position).getName());
                i.putExtra("lat",list.get(position).getLatitude());
                i.putExtra("long",list.get(position).getLongitude());
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() { //entregar la cantidad de contactos que tenemos
        return list.size();
    }

    public class ViewHolderAdaptador extends RecyclerView.ViewHolder {
        TextView name, latitude, longitude;
        Button showmap;
        public ViewHolderAdaptador(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.temp_name);
            latitude = (TextView) itemView.findViewById(R.id.temp_latitude);
            longitude = (TextView)itemView.findViewById(R.id.temp_longitude);
            showmap = (Button) itemView.findViewById(R.id.temp_button);
        }
    }
}
