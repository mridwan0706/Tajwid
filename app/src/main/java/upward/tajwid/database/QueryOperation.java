package upward.tajwid.database;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class QueryOperation extends DBConnection{
	
	private SQLiteDatabase db;
	
	public QueryOperation(Context context) {
		super(context);
		db = getReadableDatabase();
	}

	public int getTotalQuiz(){
		if(!db.isOpen()) db = getReadableDatabase();
		
		String query = "SELECT COUNT(id) FROM kuis";
		
		Cursor crs = db.rawQuery(query, null);
		
		if(crs.getCount() > 0){
			crs.moveToFirst();
		}
		
		return crs.getInt(0);
	}
	
	public Cursor getQuiz(ArrayList<Integer> quizId){
		if(!db.isOpen()) db = getReadableDatabase();
		
		String ids = "";
		for(int i = 0; i < quizId.size(); i++){
			if(i == quizId.size() - 1)
				ids += quizId.get(i);
			else ids += quizId.get(i) + ", ";
		}
		Log.d("cek", ids);
		String query = "SELECT pertanyaan, A, B, C, D, jawaban " +
						"FROM kuis " +
						"WHERE id IN (" + ids + ")";
		
		return db.rawQuery(query, null);
	}
}
