package com.example.design_patterns.template_method;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design_patterns.databinding.ItemContratoBinding;
import com.example.design_patterns.template_method.locadoras.Locadora;

import java.util.ArrayList;

public class ContratosAdapter extends RecyclerView.Adapter<ContratosAdapter.ItemContratoViewHolder> {
    private ItemContratoBinding binding;
    private ArrayList<Locadora> locadoras;

    ContratosAdapter(ArrayList<Locadora> locadoras) {
        this.locadoras = locadoras;
    }

    @NonNull
    @Override
    public ItemContratoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemContratoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemContratoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemContratoViewHolder holder, int position) {
        holder.bind(locadoras.get(position));
        holder.binding.cvContract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo()
            }
        });
    }

    @Override
    public int getItemCount() {
        return locadoras.size();
    }

    class ItemContratoViewHolder extends RecyclerView.ViewHolder {
        ItemContratoBinding binding;
        public ItemContratoViewHolder(ItemContratoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Locadora locadora) {
            binding.tvTituloContrato.setText(locadora.getName());
            binding.tvDescricaoContrato.setText(locadora.getDescricao());
        }
    }
}


