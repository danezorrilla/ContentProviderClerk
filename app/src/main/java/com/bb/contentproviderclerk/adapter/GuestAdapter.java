package com.bb.contentproviderclerk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.contentproviderclerk.R;
import com.bb.contentproviderclerk.model.Guest;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.GuestViewHolder>{

    private List<Guest> guestList;

    public GuestAdapter(List<Guest> guestList) {
        this.guestList = guestList;
    }

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.guest_list_layout, parent, false);
        return new GuestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestAdapter.GuestViewHolder holder, int position) {
        holder.guestNameTextView.setText(guestList.get(position).getGuestName());
        holder.guestRoomNumTextView.setText(guestList.get(position).getGuestRoomNumber()
        );
    }

    @Override
    public int getItemCount() {
        return guestList.size();
    }

    public class GuestViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.guest_list_name)
        TextView guestNameTextView;

        @BindView(R.id.guest_list_room_num)
        TextView guestRoomNumTextView;

        public GuestViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
