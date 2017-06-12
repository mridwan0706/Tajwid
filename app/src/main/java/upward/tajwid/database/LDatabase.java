package upward.tajwid.database;

import java.io.IOException;

import upward.tajwid.constant.Constant;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.preference.PreferenceManager;

public class LDatabase {

	private static SharedPreferences settings;
	
	public static void databaseCheck(Context ctx){
		settings = PreferenceManager.getDefaultSharedPreferences(ctx);
		
		int newDBVersion = Constant.DATABASE_VERSION;
		QueryOperation op = Constant.getDBInstance(ctx);
		
        try {
        	if(op.isDBExist()){
        		try{
	        		int oldDBVersion = settings.getInt(Constant.KEY_PREF_DB_VERSION, 0);
	        		
	        		//update database
	        		if(oldDBVersion < newDBVersion){
	        			op.deleteDB();
	        			op.createDB();
	        			updateDBVersion(newDBVersion);
	        		}
        		}
        		catch(SQLiteException s){
        			op.deleteDB();
        			op.createDB();
        			updateDBVersion(newDBVersion);
        		}
        	}
        	else { //create database
        		op.createDB();
        		updateDBVersion(newDBVersion);
        	}
        	
        	op.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateDBVersion(int version){
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt(Constant.KEY_PREF_DB_VERSION, version);
		editor.commit();
	}

}
