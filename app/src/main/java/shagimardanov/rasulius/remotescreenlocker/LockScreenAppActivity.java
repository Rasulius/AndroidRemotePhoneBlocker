package shagimardanov.rasulius.remotescreenlocker;

/**
 * Created by Rasul on 27.07.2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;

public class LockScreenAppActivity extends Activity {

    // наши часы
    private TextView clock;
    // наши картинки
    private ImageView droid, home;
    // отслеживаем в этот массив координаты пальца
    private int[] droidpos;
    // и передаем в этим переменные
    private int home_x, home_y;
    // лайот на котором находится весь лок скрин
    private LayoutParams layoutParams;
    // размеры экрана
    private int windowheight;
    private int windowwidth;


    final Handler uiHandler = new Handler();

    private void ShowBlockWindows()
    {

        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                        | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                        | WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_remote_screen_locker);


        droid = (ImageView) findViewById(R.id.apple);
        if ((getIntent() != null) && getIntent().hasExtra("kill")
                && (getIntent().getExtras().getInt("kill") == 1)) {
            finish();
        }
        try {

            // узнаем все сервисы которые есть
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

            // хватаем размеры экрана и растягиваем под него локскрин
            windowwidth = getWindowManager().getDefaultDisplay().getWidth();
            windowheight = getWindowManager().getDefaultDisplay().getHeight();
            MarginLayoutParams marginParams2 = new MarginLayoutParams(droid.getLayoutParams());
            marginParams2.setMargins((windowwidth / 24) * 10, ((windowheight / 32) * 8), 0, 0);
            RelativeLayout.LayoutParams layoutdroid = new RelativeLayout.LayoutParams(marginParams2);
            droid.setLayoutParams(layoutdroid);
            clock = (TextView) findViewById(R.id.textView1);
            LinearLayout homelinear = (LinearLayout) findViewById(R.id.homelinearlayout);
            homelinear.setPadding(0, 0, 0, 0);
            home = (ImageView) findViewById(R.id.droid);
            MarginLayoutParams marginParams1 = new MarginLayoutParams(home.getLayoutParams());
            marginParams1.setMargins((windowwidth / 24) * 10, 0, (windowheight / 32) * 8, 0);
            LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(marginParams1);
            home.setLayoutParams(layout);

            Calendar c = Calendar.getInstance();
            // выводим время
            clock.setText("Time: " + c.get(Calendar.HOUR_OF_DAY) + " : " + c.get(Calendar.MINUTE));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ShowBlockWindows();
        Timer myTimer = new Timer(); // Создаем таймер


    }

}
