package com.yoloridelondon.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yoloridelondon.myapplication.R;
import com.yoloridelondon.myapplication.model.Trip;
import com.yoloridelondon.myapplication.services.ItemClickListener;

import java.util.List;

import xyz.hasnat.sweettoast.SweetToast;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    private List<Trip> tripList;
    private Context context;
    private ItemClickListener itemClickListener;

    public TripAdapter(List<Trip> tripList, Context context, ItemClickListener itemClickListener) {
        this.tripList = tripList;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TripViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.single_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final TripViewHolder holder, final int position) {
        Trip trip = tripList.get(position);
        holder.date.setText(trip.getJourneyDateTime());
        holder.start_address.setText(trip.getPickupLocation());
        holder.end_address.setText(trip.getDropoffLocation());

        holder.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tripList.get(position).getPolyline().isEmpty()){
                    SweetToast.success(context, new StringBuffer(tripList.get(position).getPolyline().substring(0, 25)).append("....").toString());
                } else {
                    SweetToast.success(context, "No polyline added");
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }


    class TripViewHolder extends RecyclerView.ViewHolder{
        TextView date, start_address, end_address;
        TripViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.dateTv);
            start_address = itemView.findViewById(R.id.start_address);
            end_address = itemView.findViewById(R.id.end_address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onItemClick(view, getAdapterPosition());
                }
            });
        }
    }
}
