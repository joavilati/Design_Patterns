package com.example.design_patterns.template_method;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design_patterns.databinding.ItemLocadoraBinding;
import com.example.design_patterns.template_method.locadoras.Locadora;
import com.example.design_patterns.util.Contract;

import java.util.ArrayList;

public class LocadorasAdapter extends RecyclerView.Adapter<LocadorasAdapter.ItemContratoViewHolder> {

    private ItemLocadoraBinding binding;
    private ArrayList<Locadora> locadoras;
    private Contract contract;

    LocadorasAdapter(ArrayList<Locadora> locadoras, Contract contract) {
        this.locadoras = locadoras;
        this.contract = contract;
    }

    @NonNull
    @Override
    public ItemContratoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemLocadoraBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemContratoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemContratoViewHolder holder, final int position) {
        holder.bind(locadoras.get(position));
        holder.binding.cvLocadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToContractActivity(position);
            }
        });
    }

    private void goToContractActivity(int position) {
        contract.startContratActivity(locadoras.get(position));
    }
    @Override
    public int getItemCount() {
        return locadoras.size();
    }

    class ItemContratoViewHolder extends RecyclerView.ViewHolder {
        ItemLocadoraBinding binding;
        public ItemContratoViewHolder(ItemLocadoraBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Locadora locadora) {
            binding.tvTituloLocadora.setText(locadora.getName());
            binding.tvDescricaoLocadora.setText(locadora.getDescricao());
        }
    }
}


