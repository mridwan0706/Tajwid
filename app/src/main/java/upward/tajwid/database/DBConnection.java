package upward.tajwid.database;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import upward.tajwid.constant.Constant;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBConnection extends SQLiteOpenHelper{

	protected static String DB_PATH;

	protected static final String DATABASE_NAME = "tajwid.db";
	protected static final int DATABASE_VERSION = Constant.DATABASE_VERSION;

	protected Context context;

	public DBConnection(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
		if(android.os.Build.VERSION.SDK_INT >= 17)
		       DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
	    else DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
		
		this.context = context;
	}
	
	public void deleteDB(){
		context.deleteDatabase(DB_PATH + DATABASE_NAME);
	}
	
	public void createDB() throws IOException{
		this.getReadableDatabase();
    	try {
    		close();
    		copyDataBase(); 
    		SQLiteDatabase db = getWritableDatabase();
			db.execSQL("create table if not exists android_metadata (locale TEXT)");
			db.close();
		} catch (IOException e) {
			Toast.makeText(context, "Creating Database Error", Toast.LENGTH_LONG).show();
    	}
    }
	
	public boolean isDBExist(){
		SQLiteDatabase checkDB = null;
    	try{
    		String myPath = DB_PATH + DATABASE_NAME;
    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    	}catch(SQLiteException e){}
    	if(checkDB != null){
    		checkDB.close();
    		return true;
    	}
    	else return false;
    }
	
	private void copyDataBase() throws IOException{
		 
    	//Open your local db as the input stream
    	InputStream myInput = context.getAssets().open(DATABASE_NAME);
 
    	// Path to the just created empty db
    	String outFileName = DB_PATH + DATABASE_NAME;
 
    	//Open the empty db as the output stream
    	OutputStream myOutput = new FileOutputStream(outFileName);
 
    	//transfer bytes from the inputfile to the outputfile
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
     	//Close the streams
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
    }
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
}

