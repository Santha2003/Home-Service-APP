package com.example.homeserviceapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class mechanic_Adaptor extends RecyclerView.Adapter<mechanic_Adaptor.MyViewHolder> {
    private static Context context;
    private ArrayList name_id,phno_id,rating_id,amount_id;

    public mechanic_Adaptor(Context context, ArrayList name_id, ArrayList phno_id, ArrayList rating_id, ArrayList amount_id) {
        this.context=context;
        this.name_id = name_id;
        this.phno_id = phno_id;
        this.rating_id = rating_id;
        this.amount_id = amount_id;
    }

    @NonNull
    @Override
    public mechanic_Adaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.phno_id.setText(String.valueOf(phno_id.get(position)));
        holder.rating_id.setText(String.valueOf(rating_id.get(position)));
        holder.amount_id.setText(String.valueOf(amount_id.get(position)));
    }



    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name_id,phno_id,rating_id,amount_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id=itemView.findViewById(R.id.textname);
            phno_id=itemView.findViewById(R.id.textphno);
            rating_id=itemView.findViewById(R.id.textrating);
         amount_id=itemView.findViewById(R.id.textamount);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            String name= name_id.getText().toString();
            String phno=phno_id.getText().toString();
            String rating=rating_id.getText().toString();
            String  amount=amount_id.getText().toString();
            Intent intent=new Intent(context,mechanic_booking.class);
            intent.putExtra("keyname",name);
            intent.putExtra("keyphno",phno);
            intent.putExtra("keyrating",rating);
            intent.putExtra("keyamount",amount);



            context.startActivity(intent);

        }
    }
}

