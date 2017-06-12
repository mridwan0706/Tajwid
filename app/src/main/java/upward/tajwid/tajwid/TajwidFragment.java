package upward.tajwid.tajwid;

import upward.tajwid.main.R;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TajwidFragment extends Fragment implements OnItemClickListener{
	
	private ListView list;
	private String[] menus;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_tajwid, container, false);
		
		list = (ListView) rootView.findViewById(R.id.main_list);
		
		menus = TajwidMenuDataHolder.mainMenu;
		list.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.text, menus));
		list.setOnItemClickListener(this);
		
		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		String menu = menus[position]; 
		TajwidSubMenu[] subMenus = TajwidMenuDataHolder.getSubMenu(menu);
		
		if(subMenus.length > 1){
			DialogFragment fr = new TajwidSubMenuDialog();
			Bundle b = new Bundle();
			b.putString("title", menus[position]);
			b.putSerializable("submenu", subMenus);
			fr.setArguments(b);
			
			fr.show(getActivity().getSupportFragmentManager(), "submenu");
		}
		else{
			Fragment fr = new TajwidDetailFragment();
			Bundle b = new Bundle();
			b.putSerializable("data", subMenus[0]);
			fr.setArguments(b);
			
			FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
			fragmentManager
					.beginTransaction()
					.addToBackStack(null)
					.replace(R.id.container, fr, "detail").commit();
		}
	}

	public void onResume(){
		super.onResume();
		
		((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
	}
	
}