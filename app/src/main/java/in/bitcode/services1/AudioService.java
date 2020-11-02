package in.bitcode.services1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;

import androidx.annotation.Nullable;

public class AudioService extends Service {

    private MediaPlayer mMediaPlayer;
    public static final String ACTION_AUDIO = "in.bitcode.media.service.AUDIO";

    @Override
    public void onCreate() {
        super.onCreate();
        mt("onCreate");

        //mMediaPlayer = new MediaPlayer();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mt("onStartCommand " + startId);

        //Thread.currentThread().getName();

        //mMediaPlayer = MediaPlayer.create(this, R.raw.dil_chahata_hai);
        /*try {
            mMediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer.setVolume(50,50);
                mediaPlayer.start();
            }
        });*/

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mt("onDestroy");
        super.onDestroy();
        /*mMediaPlayer.release();
        mMediaPlayer = null;*/
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
