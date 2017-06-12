package upward.tajwid.quiz;

import java.util.ArrayList;

import upward.tajwid.constant.Constant;
import upward.tajwid.main.MainFragment;
import upward.tajwid.main.R;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizFragment extends Fragment implements OnClickListener{

	private TextView question;
	private RadioButton a, b, c, d;
	private ImageView next, prev;
	
	private int currentQuestionIndex;
	private String currentAnswer;
	private ArrayList<Quiz> questions;
	private boolean[] answers;
	
	private final int TOTAL_QUIZ = 10;
	
	private TextView scoreTxt, rightAnswerTxt;
	private Button repeat, mainMenu;
	private View scoreLayout;
	
	private int score, rightAnswer;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_quiz, container, false);
		
		question = (TextView) rootView.findViewById(R.id.question);
		a = (RadioButton) rootView.findViewById(R.id.a);
		b = (RadioButton) rootView.findViewById(R.id.b);
		c = (RadioButton) rootView.findViewById(R.id.c);
		d = (RadioButton) rootView.findViewById(R.id.d);
		next = (ImageView) rootView.findViewById(R.id.next);
		prev = (ImageView) rootView.findViewById(R.id.prev);
		
		a.setOnClickListener(this);
		b.setOnClickListener(this);
		c.setOnClickListener(this);
		d.setOnClickListener(this);
		next.setOnClickListener(this);
		prev.setOnClickListener(this);
		
		scoreTxt = (TextView) rootView.findViewById(R.id.score);
		rightAnswerTxt = (TextView) rootView.findViewById(R.id.right_answer);
		repeat = (Button) rootView.findViewById(R.id.repeat);
		mainMenu = (Button) rootView.findViewById(R.id.main_menu);
		scoreLayout = rootView.findViewById(R.id.score_layout);
		
		repeat.setOnClickListener(this);
		mainMenu.setOnClickListener(this);
		
		return rootView;
	}

	public void onActivityCreated(Bundle b){
		super.onActivityCreated(b);
		
		initAll();
	}
	
	private void initAll(){
		scoreLayout.setVisibility(View.GONE);
		
		getQuizes();
		
		answers = new boolean[questions.size()];
		currentAnswer = "-";
		currentQuestionIndex = 0;
		setQuestion(0);
	}
	
	private void getQuizes(){
		// Get random questions
		ArrayList<Integer> randomNumbers = Constant.getRandomNumbers(TOTAL_QUIZ, Constant.getDBInstance(getActivity()).getTotalQuiz());
		Cursor crs = Constant.getDBInstance(getActivity()).getQuiz(randomNumbers);
		
		questions = new ArrayList<Quiz>();
		while(crs.moveToNext()){
			Quiz quiz = new Quiz(crs.getString(0), crs.getString(5));
			quiz.setAnswers(crs.getString(1), crs.getString(2), crs.getString(3), crs.getString(4));
			
			questions.add(quiz);
		}
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.a:
				currentAnswer = "a";
				break;
			case R.id.b:
				currentAnswer = "b";	
				break;
			case R.id.c:
				currentAnswer = "c";
				break;
			case R.id.d:
				currentAnswer = "d";
				break;
			case R.id.next:
				if(!currentAnswer.equals("-")){
					getAnswer(currentQuestionIndex);
					
					if(currentQuestionIndex < questions.size() - 1){
						currentQuestionIndex++;
						setQuestion(currentQuestionIndex);
					}
					else{
						// Last question, display the result
						displayResult();
					}
				}
				else Toast.makeText(getActivity(), "Anda harus menjawab terlebih dahulu sebelum melanjutkan pertanyaan", Toast.LENGTH_SHORT).show();
				break;
			case R.id.prev:
				currentQuestionIndex--;
				setQuestion(currentQuestionIndex);
				break;
			case R.id.repeat:
				initAll();
				break;
			case R.id.main_menu:
				Fragment fr = new MainFragment();
				getActivity().getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, fr).commit();
				break;
			default:
				break;
		}
	}
	
	private void setQuestion(int index){
		Quiz quiz = questions.get(index);
		
		question.setText(quiz.getQuestion());
		a.setText(quiz.getA());
		b.setText(quiz.getB());
		c.setText(quiz.getC());
		d.setText(quiz.getD());

		a.setChecked(false);
		b.setChecked(false);
		c.setChecked(false);
		d.setChecked(false);
		
		currentAnswer = "-";
		
		((AppCompatActivity) getActivity()).getSupportActionBar().setTitle((index + 1) + " dari " + questions.size());
		
		if(index == 0)
			prev.setVisibility(View.GONE);
		else prev.setVisibility(View.VISIBLE);
		
		if(index == TOTAL_QUIZ - 1)
			next.setImageResource(R.drawable.btn_submit);
		else next.setImageResource(R.drawable.btn_arrow_next);
	}
	
	private void getAnswer(int index){
		Quiz quiz = questions.get(index);
		String answer = quiz.getAnswer();
		
		answers[index] = (answer.toLowerCase().equals(currentAnswer)) ? true : false;
	}
	
	private void displayResult(){
		scoreLayout.setVisibility(View.VISIBLE);
		
		getScore(answers);
		
		scoreTxt.setText(String.valueOf(score));
		rightAnswerTxt.setText(rightAnswer + " dari " + answers.length);
		
		int colorId = getResources().getColor(R.color.light_green);
		if(score < 60) colorId = getResources().getColor(R.color.bittersweet);
		else if(score < 80) colorId = getResources().getColor(R.color.sunflower);
		
		scoreTxt.setTextColor(colorId);
	}
	
	private void getScore(boolean[] answers){
		for (boolean isTrue : answers) {
			if(isTrue) rightAnswer++;
		}
		
		score = (int) ((double) rightAnswer/answers.length * 100);
	}
}
