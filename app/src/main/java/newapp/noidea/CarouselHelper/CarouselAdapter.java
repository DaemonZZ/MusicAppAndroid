package newapp.noidea.CarouselHelper;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import newapp.noidea.R;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {
    ArrayList<CarouselHelper> cardLocation;
    final private  ListItemClickListener listItemClickListener;

   public CarouselAdapter(ArrayList<CarouselHelper> cardLocation,ListItemClickListener listItemClickListener){

       this.cardLocation = cardLocation;
       this.listItemClickListener = listItemClickListener;
   }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        return new CarouselViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        CarouselHelper helper = cardLocation.get(position);
        holder.img.setImageResource(helper.getImg());
        holder.img.setClipToOutline(true);
        holder.tv.setText(helper.getTitle());
    }

    @Override
    public int getItemCount() {
        return cardLocation.size();
    }


    public interface  ListItemClickListener {
        void onCardListClick(int index);
    }

    public class CarouselViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;
        TextView tv;

        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            img = itemView.findViewById(R.id.playlist_cover);
            tv = itemView.findViewById(R.id.playlist_title);
        }

        @Override
        public void onClick(View v) {

        }
    }
}


