package kg.geektech.homework340;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder> {
    private ArrayList<Continent> continents;
    private OnItemClick onItemClick;

    public ContinentAdapter(ArrayList<Continent> continents, OnItemClick onItemClick) {
        this.continents = continents;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.continent_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(continents.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemClick(continents.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return continents.size();
    }

    public class ContinentViewHolder extends RecyclerView.ViewHolder {
        private TextView nameContinentTV;
        private ImageView flagContinentIV;

        public ContinentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameContinentTV = itemView.findViewById(R.id.continent_name_tv);
            flagContinentIV = itemView.findViewById(R.id.continent_image);
        }


        public void bind(Continent continent) {
            this.nameContinentTV.setText(continent.getNameContinent());
            Glide.with(itemView.getContext()).load(continent.getImageURL()).into(flagContinentIV);
        }
    }
}
