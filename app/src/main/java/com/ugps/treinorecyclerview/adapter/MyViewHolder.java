package com.ugps.treinorecyclerview.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ugps.treinorecyclerview.R;

import org.w3c.dom.Text;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textoDoAdapter;

    // ========== CONSTRUCTOR ===========
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        textoDoAdapter = itemView.findViewById(R.id.textoDoRecycler);

    }
}
