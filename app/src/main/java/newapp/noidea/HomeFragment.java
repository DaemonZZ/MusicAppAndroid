package newapp.noidea;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

import newapp.noidea.CarouselHelper.CarouselAdapter;
import newapp.noidea.CarouselHelper.CarouselHelper;
import newapp.noidea.sliderhelper.SliderAdapter;
import newapp.noidea.sliderhelper.SliderHelper;


public class HomeFragment extends Fragment   {

    private RecyclerView hotlist,list2,list3;
    private RecyclerView.Adapter rvAdpt;
    private SliderAdapter sldAdpt;
    private SliderView slider;
    Context context = this.getContext();


    public HomeFragment() {
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home,container,false);
        hotlist = view.findViewById(R.id.rv_playlist);
        list2 = view.findViewById(R.id.rv_playlist2);
        list3 = view.findViewById(R.id.rv_playlist3);
        slider = view.findViewById(R.id.slider);

        createSlider();
        createRecycler(hotlist);
        createRecycler(list2);
        createRecycler(list3);
        return view;
    }

    void createSlider(){

        ArrayList<SliderHelper> listItem = new ArrayList<>();
        listItem.add(new SliderHelper(R.drawable.ex,"Item1"));
        listItem.add(new SliderHelper(R.drawable.ex2,"Item2"));
        listItem.add(new SliderHelper(R.drawable.ex3,"Item3"));
        listItem.add(new SliderHelper(R.drawable.ex4,"Item4"));

        sldAdpt = new SliderAdapter(listItem,sldEvent);
        slider.setSliderAdapter(sldAdpt);

        slider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        slider.startAutoCycle();
    }

    void createRecycler(RecyclerView rv){

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<CarouselHelper> listItem = new ArrayList<>();
        listItem.add(new CarouselHelper(R.drawable.pl1,"Item1"));
        listItem.add(new CarouselHelper(R.drawable.pl2,"Item2"));
        listItem.add(new CarouselHelper(R.drawable.pl3,"Item3"));
        listItem.add(new CarouselHelper(R.drawable.pl4,"Item4"));

        rvAdpt = new CarouselAdapter(listItem,rvEvent);
        rv.setAdapter(rvAdpt);
    }

    private CarouselAdapter.ListItemClickListener rvEvent = new CarouselAdapter.ListItemClickListener() {
        @Override
        public void onCardListClick(int index) {

        }
    };

    private SliderAdapter.SliderClickListener sldEvent = new SliderAdapter.SliderClickListener() {
        @Override
        public void onSliderClick(int index) {

        }
    };
}