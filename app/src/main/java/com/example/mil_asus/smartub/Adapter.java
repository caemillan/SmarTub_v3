package com.example.mil_asus.smartub;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mil_ASUS on 12/2/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.SmartubHolder>{

    List<SmartubeData> smartubeDatos;

    public Adapter(List<SmartubeData> smartubeDatos) {
        this.smartubeDatos = smartubeDatos;
    }

    @Override
    public SmartubHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,parent,false);
        SmartubHolder holder = new SmartubHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(SmartubHolder holder, int position) {
        SmartubeData smartubeData = smartubeDatos.get(position);

        holder.textViewFecha.setText(smartubeData.getHora());
        holder.textViewValue.setText(smartubeData.getSmartub1());

    }

    @Override
    public int getItemCount() {
        return smartubeDatos.size();
    }

    public static class SmartubHolder extends RecyclerView.ViewHolder {

        TextView textViewFecha, textViewValue;
        public SmartubHolder(View itemView) {
            super(itemView);
            textViewFecha = itemView.findViewById(R.id.textView_Date);
            textViewValue = itemView.findViewById(R.id.textView_Data);

        }
    }
}
