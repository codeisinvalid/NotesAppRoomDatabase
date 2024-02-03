package com.example.notesapproomdatabase.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapproomdatabase.Models.Notes;
import com.example.notesapproomdatabase.NotesClick;
import com.example.notesapproomdatabase.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder>{

    Context context;
    List<Notes> list;
    NotesClick notesClick;

    public NotesListAdapter(Context context, List<Notes> list, NotesClick notesClick) {
        this.context = context;
        this.list = list;
        this.notesClick = notesClick;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_title.setSelected(true);

        holder.tv_notes.setText(list.get(position).getNotes());
        holder.tv_date.setText(list.get(position).getDate());
        holder.tv_date.setSelected(true);

        if (list.get(position).isPinned()){
            holder.pin_image.setImageResource(R.drawable.baseline_push_pin_24);
        }
        else holder.pin_image.setImageResource(0);


        int color_code = getRandomColor();
        holder.notes_container.setBackgroundColor(color_code);

    }

    private int getRandomColor(){
        List<Integer> colorCode = new ArrayList<>();

        colorCode.add(R.color.color1);
        colorCode.add(R.color.color2);
        colorCode.add(R.color.color3);
        colorCode.add(R.color.color4);
        colorCode.add(R.color.color5);

        Random random = new Random();
        int random_color = random.nextInt(colorCode.size());
        return random_color;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class NotesViewHolder extends RecyclerView.ViewHolder {

    CardView notes_container;
    TextView tv_title, tv_notes, tv_date;
    ImageView pin_image;
    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);

        notes_container = itemView.findViewById(R.id.notes_card_container);
        tv_title = itemView.findViewById(R.id.title_text);
        tv_notes = itemView.findViewById(R.id.textview_notes);
        tv_date = itemView.findViewById(R.id.textview_date);
        pin_image = itemView.findViewById(R.id.image_view_pin);
    }
}
