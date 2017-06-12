package upward.tajwid.tajwid;

import upward.tajwid.main.R;
import upward.tajwid.widget.GifMovieView;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class TajwidDetailFragment extends Fragment implements OnClickListener{

	private GifMovieView gif, gif2, gif3;
	private ImageView play, play2, play3; 
	
	private TajwidSubMenu data;
	private MediaPlayer mp, mp2, mp3;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		data = (TajwidSubMenu) getArguments().getSerializable("data");
		int layout = data.getXml();
		
		View rootView = inflater.inflate(layout, container, false);
		
		gif = (GifMovieView) rootView.findViewById(R.id.gif);
		gif2 = (GifMovieView) rootView.findViewById(R.id.gif2);
		gif3 = (GifMovieView) rootView.findViewById(R.id.gif3);
		
		play = (ImageView) rootView.findViewById(R.id.play);
		play2 = (ImageView) rootView.findViewById(R.id.play2);
		play3 = (ImageView) rootView.findViewById(R.id.play3);
		
		return rootView;
	}

	public void onActivityCreated(Bundle b){
		super.onActivityCreated(b);
		
		if(gif != null){
			gif.setMovieResource(R.drawable.test);
			gif.setPaused(true);
		}
		
		if(gif2 != null){
			gif2.setMovieResource(R.drawable.test);
			gif2.setPaused(true);
		}
		
		if(gif3 != null){
			gif3.setMovieResource(R.drawable.test);
			gif3.setPaused(true);
		}
		
		if(play != null) play.setOnClickListener(this);
		if(play2 != null) play2.setOnClickListener(this);
		if(play3 != null) play3.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if(v == play){
			int[] sound = data.getExampleSounds();
			if(sound != null){
				if(mp == null){
					mp = MediaPlayer.create(getActivity(), sound[0]);
					
					mp.setOnCompletionListener(new OnCompletionListener() {
			            @Override
			            public void onCompletion(MediaPlayer mep) {
			            	mep.reset();
			                mep.release();
			                mp = null;
			                
			                play.setImageResource(R.drawable.btn_play);
			                gif.setPaused(!gif.isPaused());
			            }
			        });
				}
				
				if(!mp.isPlaying()){
					play.setImageResource(R.drawable.btn_stop);
					mp.start();
				}
				else{
					play.setImageResource(R.drawable.btn_play);
					mp.stop();
					mp.reset();
					mp.release();
	                mp = null;
				}
				
				if(play2 != null && mp2 != null){
					play2.setImageResource(R.drawable.btn_play);
					gif2.setPaused(!gif2.isPaused());
					mp2.stop();
					mp2.reset();
					mp2.release();
	                mp2 = null;
				}
				if(play3 != null && mp3 != null){
					play3.setImageResource(R.drawable.btn_play);
					gif3.setPaused(!gif3.isPaused());
					mp3.stop();
					mp3.reset();
					mp3.release();
	                mp3 = null;
				}
				
				gif.setPaused(!gif.isPaused());
			}
		}
		else if(v == play2){
			int[] sound = data.getExampleSounds();
			if(sound != null){
				if(mp2 == null){
					mp2 = MediaPlayer.create(getActivity(), sound[1]);
					
					mp2.setOnCompletionListener(new OnCompletionListener() {
			            @Override
			            public void onCompletion(MediaPlayer mep) {
			            	mep.reset();
			                mep.release();
			                mp2 = null;
			                
			                play2.setImageResource(R.drawable.btn_play);
			                gif2.setPaused(!gif2.isPaused());
			            }
			        }); 
				}
				
				if(!mp2.isPlaying()){
					play2.setImageResource(R.drawable.btn_stop);
					mp2.start();
				}
				else{
					play2.setImageResource(R.drawable.btn_play);
					mp2.stop();
					mp2.reset();
					mp2.release();
	                mp2 = null;
				}
				
				if(play != null && mp != null){
					play.setImageResource(R.drawable.btn_play);
					gif.setPaused(!gif.isPaused());
					mp.stop();
					mp.reset();
					mp.release();
	                mp = null;
				}
				if(play3 != null && mp3 != null){
					play3.setImageResource(R.drawable.btn_play);
					gif3.setPaused(!gif3.isPaused());
					mp3.stop();
					mp3.reset();
					mp3.release();
	                mp3 = null;
				}
				
				gif2.setPaused(!gif2.isPaused());
			}
		}
		else if(v == play3){
			int[] sound = data.getExampleSounds();
			if(sound != null){
				if(mp3 == null){
					mp3 = MediaPlayer.create(getActivity(), sound[2]);
					
					mp3.setOnCompletionListener(new OnCompletionListener() {
			            @Override
			            public void onCompletion(MediaPlayer mep) {
			            	mep.reset();
			                mep.release();
			                mp3 = null;
			                
			                play3.setImageResource(R.drawable.btn_play);
			                gif3.setPaused(!gif3.isPaused());
			            }
			        }); 
				}
				
				if(!mp3.isPlaying()){
					play3.setImageResource(R.drawable.btn_stop);
					mp3.start();
				}
				else{
					play3.setImageResource(R.drawable.btn_play);
					mp3.stop();
					mp3.reset();
					mp3.release();
	                mp3 = null;
				}
				
				if(play != null && mp != null){
					play.setImageResource(R.drawable.btn_play);
					gif.setPaused(!gif.isPaused());
					mp.stop();
					mp.reset();
					mp.release();
	                mp = null;
				}
				if(play2 != null && mp2 != null){
					play2.setImageResource(R.drawable.btn_play);
					gif2.setPaused(!gif2.isPaused());
					mp2.stop();
					mp2.reset();
					mp2.release();
	                mp2 = null;
				}
				
				gif3.setPaused(!gif3.isPaused());
			}
		}
	}

	public void onStop(){
		super.onStop();
		
		if(mp != null){
			mp.release();
			mp = null;
		}
		if(mp2 != null){
			mp2.release();
			mp2 = null;
		}
		if(mp3 != null){
			mp3.release();
			mp3 = null;
		}
	}
	
}
