package upward.tajwid.tajwid;

import java.util.ArrayList;

import upward.tajwid.main.R;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TajwidSubMenuDialog extends DialogFragment implements OnItemClickListener{

	private ListView list;
	private TajwidSubMenu[] submenus;
	
	public Dialog onCreateDialog(Bundle b){
		super.onCreateDialog(b);
		
		String title = getArguments().getString("title");
		submenus = (TajwidSubMenu[]) getArguments().getSerializable("submenu");
		ArrayList<String> itemList = getList(submenus);
		
		Dialog dg = new Dialog(getActivity());
		
		dg.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dg.setContentView(R.layout.dialog_list);
		//dg.getWindow().setBackgroundDrawableResource(R.drawable.white_rounded_panel);
		
		((TextView) dg.findViewById(R.id.list_dialog_title)).setText(title);
		
		list = (ListView) dg.findViewById(R.id.list_dialog_listview);
		list.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.text, itemList));
		list.setOnItemClickListener(this);
		
		return dg;
	}

	private ArrayList<String> getList(TajwidSubMenu[] submenus){
		ArrayList<String> result = new ArrayList<String>();
		
		for (TajwidSubMenu subMenu : submenus) {
			result.add(subMenu.getTitle());
		}
		
		return result;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		TajwidSubMenu submenu = submenus[position];
		
		Fragment fr = new TajwidDetailFragment();
		Bundle b = new Bundle();
		b.putSerializable("data", submenu);
		fr.setArguments(b);
		
		FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
		fragmentManager
				.beginTransaction()
				.addToBackStack(null)
				.replace(R.id.container, fr, "detail").commit();
		
		dismiss();
	}
	
}
