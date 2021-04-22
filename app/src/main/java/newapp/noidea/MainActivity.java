package newapp.noidea;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioButton btnHome, btnUser,btnBxh;
    RadioGroup menu;
    Fragment frHome,frUser,frBxh;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(Color.BLACK);
        setContentView(R.layout.activity_main);

        frHome = new HomeFragment();
        frUser = new UserFragment();
        frBxh = new BxhFragment();

        menu = findViewById(R.id.main_menu);
        btnHome = findViewById(R.id.btn_home);
        btnUser = findViewById(R.id.btn_user);
        btnBxh = findViewById(R.id.btn_bxh);
        menu.setOnCheckedChangeListener(this);
        btnHome.setChecked(true);

        initFragment();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(btnHome.isChecked()){
            btnHome.setBackgroundColor(Color.RED);
            replaceFragment(frHome);
        }
        else {
            btnHome.setBackgroundResource(R.color.menu_gray);
        }
        if(btnUser.isChecked()){
            btnUser.setBackgroundColor(Color.RED);
            replaceFragment(frUser);
        }
        else {
            btnUser.setBackgroundResource(R.color.menu_gray);
        }
        if(btnBxh.isChecked()){
            btnBxh.setBackgroundColor(Color.RED);
            replaceFragment(frBxh);
        }
        else {
            btnBxh.setBackgroundResource(R.color.menu_gray);
        }

    }

    public void initFragment(){
        FragmentManager frm = getSupportFragmentManager();
        FragmentTransaction ft = frm.beginTransaction();
        ft.replace(R.id.fr,frHome);
        ft.commit();
    }

    public  void replaceFragment(Fragment fr){
        if(fr!=null){
            FragmentManager frm = getSupportFragmentManager();
            FragmentTransaction ft = frm.beginTransaction();
            ft.replace(R.id.fr,fr);
            ft.commit();
        }
    }
}