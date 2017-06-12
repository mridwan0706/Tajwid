package upward.tajwid.constant;

import java.util.ArrayList;

import upward.tajwid.database.QueryOperation;
import android.content.Context;

public class Constant {

	public static int DATABASE_VERSION = 3;
	
	public final static String KEY_PREF_DB_VERSION = "keyPrefDbVersion";
	
	private static QueryOperation op;
	
	public static QueryOperation getDBInstance(Context ctx){
		if(op == null) op = new QueryOperation(ctx);
		
		return op;
	}
	
	public static ArrayList<Integer> getRandomNumbers(int size, int range){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while(result.size() < size){
			int rand = (int) (Math.random() * (range + 1));
			if(rand > 0 && rand <= range && !result.contains(rand))
				result.add(rand);
		}
		
		return result;
	}
}
