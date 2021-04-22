package newapp.noidea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadingActivity extends AppCompatActivity {
    private static final String STATE = "Trạng thái";
    ImageView nen,meo,moon;
    Animation top,bot, aniMoon, fade_in_tap_here,fade_out,flyaway,fade_in,endSplash;
    TextView tapHere,loading;
    ConstraintLayout root;
    Button btnForget,btnLogin, btnSignUp;

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(STATE,"On Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(STATE,"On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(STATE,"On Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(STATE,"On Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(STATE,"On Resume");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        top= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bot= AnimationUtils.loadAnimation(this,R.anim.bot_anim);
        aniMoon =  AnimationUtils.loadAnimation(this,R.anim.moon);
        fade_in_tap_here =  AnimationUtils.loadAnimation(this,R.anim.fade_in_tap_here);
        fade_out= AnimationUtils.loadAnimation(this,R.anim.fade_out);
        fade_in= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        flyaway =AnimationUtils.loadAnimation(this,R.anim.bird_fly_away);
        endSplash = AnimationUtils.loadAnimation(this,R.anim.end_splash);


        root = findViewById(R.id.root);
        setupUI(root);
        nen = findViewById(R.id.nen);
        meo = findViewById(R.id.meo);
        moon = findViewById(R.id.moon);
        tapHere = findViewById(R.id.taptext);
        loading = findViewById(R.id.loadText);
        btnForget = findViewById(R.id.btnForget);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignup);

        loading.setVisibility(View.INVISIBLE);

        nen.setAnimation(top);
        meo.setAnimation(bot);
        moon.setAnimation(aniMoon);
        tapHere.setAnimation(fade_in_tap_here);
        tapHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(fade_out);
                ((ViewManager)v.getParent()).removeView(v);
                meo.startAnimation(endSplash);
                loading.setVisibility(View.VISIBLE);
                loading.setAnimation(fade_in);
                //Main activity load after animation finish
                loading.animate().setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        Intent intent = new Intent(LoadingActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                }).setDuration(6000).start();
            }
        });
    }
        //toggle keyboard off

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isAcceptingText()){
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(),
                    0
            );
        }
    }
    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(LoadingActivity.this);
                    return false;
                }
            });
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

}