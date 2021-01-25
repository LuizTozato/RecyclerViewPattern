package com.ugps.treinorecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ugps.treinorecyclerview.R;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private List<String> lista;

    public TextAdapter( List<String> lista ) {
        this.lista = lista;
    }

    //================ METODOS ==============
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //AQUI ESTOU TRANSFORMANDO O XML (lista_adapter) EM VIEW.
        View itemLista = LayoutInflater.from(parent.getContext())
                                       .inflate(R.layout.lista_adapter,parent,false);

        return new MyViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder itemLista, int position) {

        String textoDigitado = lista.get(position);
        itemLista.textoDoAdapter.setText(textoDigitado);

    }

    @Override
    public int getItemCount() {
        //QUANTOS ITENS TEM NA LISTA?
        return this.lista.size();
    }
}
