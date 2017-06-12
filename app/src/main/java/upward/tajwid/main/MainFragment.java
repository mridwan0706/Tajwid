package upward.tajwid.main;

import upward.tajwid.main.R;
import upward.tajwid.quiz.QuizFragment;
import upward.tajwid.tajwid.TajwidFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class MainFragment extends Fragment implements OnClickListener{

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		
		rootView.findViewById(R.id.tajwid).setOnClickListener(this);
		rootView.findViewById(R.id.quiz).setOnClickListener(this);
		rootView.findViewById(R.id.info).setOnClickListener(this);
		
		return rootView;
	}

	public void onActivityCreated(Bundle b){
		super.onActivityCreated(b);
		
	}
	
	@Override
	public void onClick(View v) {
		Fragment fr = null;
		switch (v.getId()) {
			case R.id.tajwid:
				fr = new TajwidFragment();
				break;
			case R.id.quiz:
				fr = new QuizFragment();
				break;
			case R.id.info:
				break;
		}
		
		getActivity().getSupportFragmentManager().beginTransaction()
						.replace(R.id.container, fr).addToBackStack(null).commit();
	}
	
	public void onResume(){
		super.onResume();
		
		((AppCompatActivity) getActivity()).getSupportActionBar().hide();
	}
	
	public void onStop(){
		super.onStop();
		
		((AppCompatActivity) getActivity()).getSupportActionBar().show();
	}
}
