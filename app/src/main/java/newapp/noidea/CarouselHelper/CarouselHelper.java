package newapp.noidea.CarouselHelper;

import android.graphics.drawable.GradientDrawable;

public class CarouselHelper {

    int img;
    String title;


    public CarouselHelper(int img,String title){
        this.img=img;
        this.title=title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
