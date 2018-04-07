package com.frangoudes.trialmediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer = null;

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view) {
        if(mMediaPlayer == null){
            mMediaPlayer = MediaPlayer.create(this, R.raw.if_i_fell);
            mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
        }
        mMediaPlayer.start();
    }

    public void pause(View view){
        if(mMediaPlayer != null) {
            mMediaPlayer.pause();
        }
    }

    public void stop(View view){
        if(mMediaPlayer != null){
            mMediaPlayer.stop();
            releaseMediaPlayer();
        }
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
