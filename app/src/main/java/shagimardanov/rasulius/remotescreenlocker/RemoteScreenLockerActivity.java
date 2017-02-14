package shagimardanov.rasulius.remotescreenlocker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;


// Главная функция приложения здесь стартуем сервис LockScreen который отвечает за
// обновление информации о блокировке
// и запускаем сервис слушателя Сервера


public class RemoteScreenLockerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
             finish();
    }
}
