package com.example.jean_yann.test;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;

/**
 * Created by jean-yann on 15/11/16.
 */

public class BieresAdapter extends RecyclerView.Adapter<BieresAdapter.BiereHolder> {

    JSONArray bieres;
    public BieresAdapter(JSONArray Json){
        this.bieres = bieres;
    }

    @Override
    public BiereHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BiereHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BiereHolder extends RecyclerView.ViewHolder {


        public BiereHolder(View itemView) {
            super(itemView);
        }
    }

}
