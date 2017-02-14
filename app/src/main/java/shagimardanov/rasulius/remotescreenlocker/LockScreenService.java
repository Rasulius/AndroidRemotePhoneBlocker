package shagimardanov.rasulius.remotescreenlocker; /**
 * Created by Rasul on 27.07.2016.
 */
import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class LockScreenService  extends Service {

    BroadcastReceiver mReceiver;

    @Override
    public IBinder onBind(Intent arg0) {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {

        KeyguardManager.KeyguardLock k1;
        KeyguardManager km = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
        k1 = km.newKeyguardLock("IN");
        k1.disableKeyguard();
        // проверяем в фоне все время работы экрана
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        // фильтруем на появление флага выключения экрана
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        // если это так то запускаем рессивер
        mReceiver = new lockScreenReciver();
        registerReceiver(mReceiver, filter);
        super.onCreate();
    }

    @Override
    public void onDestroy() {

        unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}
