package newapp.noidea.sliderhelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

import newapp.noidea.R;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {
    ArrayList<SliderHelper> listItem = new ArrayList<>();
    final private SliderClickListener listItemClickListener;

    public SliderAdapter(ArrayList<SliderHelper> listItem,SliderClickListener listItemClickListener) {
        this.listItemClickListener = listItemClickListener;
        this.listItem = listItem;
    }


    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_card,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {

        viewHolder.img.setImageResource(listItem.get(position).getImg());
    }

    @Override
    public int getCount() {
        return listItem.size();
    }
    public interface  SliderClickListener {
        void onSliderClick(int index);
    }

    public class SliderViewHolder extends SliderViewAdapter.ViewHolder implements View.OnClickListener {

        ImageView img;
        public SliderViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            img = itemView.findViewById(R.id.card_image);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
