package shagimardanov.rasulius.remotescreenlocker;

import android.os.AsyncTask;

/**
 * Created by Rasul on 31.07.2016.
 */
public class LongOperationTask extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... noargs) {
        return  "4444";//doLongAndComplicatedTask();
    }

    @Override
    protected void onPostExecute(String result) {
        //txtResult.setText(result);
    }
}

