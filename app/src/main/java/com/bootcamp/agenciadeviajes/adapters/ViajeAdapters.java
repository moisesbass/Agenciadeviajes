package com.bootcamp.agenciadeviajes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bootcamp.agenciadeviajes.R;
import com.bootcamp.agenciadeviajes.Viajes;
import java.util.List;

public class ViajeAdapters extends
            RecyclerView.Adapter<ViajeAdapter.ViajesViewHolder> {
        private final Context mContext;
        private List<Viaje> viajes;
        private final ViajeAdapterOnClickHandler clickHandler;
        public interface ViajeAdapterOnClickHandler {
            void onClick(Viaje viaje);
        }
          public ViajeAdapter(Context context, ViajeAdapterOnClickHandler
                clickHandler, List<Viaje> viajes) {
            this.mContext = context;
            this.clickHandler = clickHandler;
            this.viajes = viajes;
        }
        @NonNull
        @Override
        public ViajeAdapter.ViajeViewHolder onCreateViewHolder(@NonNull
                                                             ViewGroup parent, int viewType) {
            View v =
                    LayoutInflater.from(mContext).inflate(R.layout.hm_card_landscape,
                            parent, false);
            return new ViajeViewHolder(v);
        }
        @Override
        public void onBindViewHolder(@NonNull ViajeAdapter.ViajeViewHolder
                                             holder, int position) {
            Viaje viaje = viajes.get(position);
            holder.imageViewPicture.setImageResource(viaje.getPicture());
            holder.textViewName.setText(viaje.getName());
        }
        @Override
        public int getItemCount() {
            return viajes.size();
        }
        class ViajeViewHolder extends RecyclerView.ViewHolder implements
                View.OnClickListener{
            // Elementos de UI a rellenar
            public TextView textViewName;
            public ImageView imageViewPicture;
            public ViajeViewHolder(@NonNull View itemView) {
                super(itemView);
                textViewName =
                        itemView.findViewById(R.id.textViewCardViaje);
                imageViewPicture =
                        itemView.findViewById(R.id.imageViewCardViaje);
                        itemView.setOnClickListener(this);
            }
            @Override
            public void onClick(View view) {
                // Obtiene la posición de la vista en el adapter
                int mItemSelected = getAdapterPosition();
                // Envia el parque a través del clic
                clickHandler.onClick(viajes.get(mItemSelected));
            }
        }
    }

}
