package com.example.huynb.androidcaculator;

import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.Voice;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView tvResult;
    private String listCal = "";
    private ArrayList<String> arrayStringCal = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvResult = (TextView) findViewById(R.id.txtResult);

        Button btnOne = (Button) findViewById(R.id.btOne);
        btnOne.setOnClickListener(this);

        Button btnTwo = (Button) findViewById(R.id.btTwo);
        btnTwo.setOnClickListener(this);

        Button btnThree = (Button) findViewById(R.id.btThree);
        btnThree.setOnClickListener(this);

        Button btnFour = (Button) findViewById(R.id.btFour);
        btnFour.setOnClickListener(this);

        Button btnFive = (Button) findViewById(R.id.btFive);
        btnFive.setOnClickListener(this);

        Button btnSix = (Button) findViewById(R.id.btSix);
        btnSix.setOnClickListener(this);

        Button btnSeven = (Button) findViewById(R.id.btSeven);
        btnSeven.setOnClickListener(this);

        Button btnEight = (Button) findViewById(R.id.btEight);
        btnEight.setOnClickListener(this);

        Button btnNinth = (Button) findViewById(R.id.btninth);
        btnNinth.setOnClickListener(this);

        Button btnEsc = (Button) findViewById(R.id.btESC);
        btnEsc.setOnClickListener(this);

        Button btnAdd = (Button) findViewById(R.id.btAdd);
        btnAdd.setOnClickListener(this);

        Button btnSub = (Button) findViewById(R.id.btSub);
        btnSub.setOnClickListener(this);

        Button btnMul = (Button) findViewById(R.id.btMul);
        btnMul.setOnClickListener(this);

        Button btnDiv = (Button) findViewById(R.id.btDiv);
        btnDiv.setOnClickListener(this);

        Button btnResult = (Button) findViewById(R.id.btResult);
        btnResult.setOnClickListener(this);

        Button btnZero = (Button) findViewById(R.id.btZero);
        btnZero.setOnClickListener(this);

        Button btnDellChar = (Button) findViewById(R.id.btDelChar);
        btnDellChar.setOnClickListener(this);

//        AsyncTask


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void doSomething(View view) {
        //
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btESC:
                tvResult.setText("");tvResult.setText("");
                listCal = "";
                arrayStringCal.clear();
                break;
            case R.id.btDelChar:
                String result = (String)tvResult.getText();
                tvResult.setText(result.substring(0,result.length()-1));
                break;
            case R.id.btZero:
                tvResult.setText(tvResult.getText() + "0");
                break;
            case R.id.btOne:
                tvResult.setText(tvResult.getText() + "1");
                break;
            case R.id.btTwo:
                tvResult.setText(tvResult.getText() + "2");
                break;
            case R.id.btThree:
                tvResult.setText(tvResult.getText() + "3");
                break;
            case R.id.btFour:
                tvResult.setText(tvResult.getText() + "4");
                break;
            case R.id.btFive:
                tvResult.setText(tvResult.getText() + "5");
                break;
            case R.id.btSix:
                tvResult.setText(tvResult.getText() + "6");
                break;
            case R.id.btSeven:
                tvResult.setText(tvResult.getText() + "7");
                break;
            case R.id.btEight:
                tvResult.setText(tvResult.getText() + "8");
                break;
            case R.id.btninth:
                tvResult.setText(tvResult.getText() + "9");
                break;
            case R.id.btAdd:
                if (tvResult.getText().equals("")){
                    tvResult.setText("");
                }else {
                    tvResult.setText(tvResult.getText() + "+");
                }
                break;
            case R.id.btSub:
                if (tvResult.getText().equals("")){
                    tvResult.setText("");
                }else {
                    tvResult.setText(tvResult.getText() + "-");
                }
                break;
            case R.id.btDiv:
                if (tvResult.getText().equals("")){
                    tvResult.setText("");
                }else {
                    tvResult.setText(tvResult.getText() + "/");
                }
                break;
            case R.id.btMul:
                if (tvResult.getText().equals("")){
                    tvResult.setText("");
                }else {
                    tvResult.setText(tvResult.getText() + "*");
                }
                break;
            case R.id.btResult:

                listCal = "" + tvResult.getText();
                if(listCal.trim().length() >= 1){
                    CheckCharEnd();
                    // put operator into array element
                    ArrayList<String> arrayElement = new ArrayList<String>();
                    arrayElement = ConvertArrayElement(listCal);
                    //execute mul and div first
                    arrayElement = ExecuteMulDiv(arrayElement);
                    //execute mul and div first
                    String listCalcu = ExecuteAddDiv(arrayElement);
                    tvResult.setText(listCalcu);
                    listCal = "";
                    arrayStringCal.clear();
                }
                break;
        }

    }

    //function execute mul and div operator
    private ArrayList<String> ExecuteMulDiv(ArrayList<String> arrayElement){
        int index = 0;
        long xxx = 0;
        while (index < arrayElement.size()){
            if(arrayElement.get(index).equals("*")){
                xxx = Long.parseLong(arrayElement.get(index - 1)) * Long.parseLong(arrayElement.get(index + 1));
                arrayElement.set(index - 1, String.valueOf(xxx));
                arrayElement.remove(index);
                arrayElement.remove(index);
            }else if(arrayElement.get(index).equals("/")){
                xxx = Long.parseLong(arrayElement.get(index - 1)) / Long.parseLong(arrayElement.get(index + 1));
                arrayElement.set(index - 1, String.valueOf(xxx));
                arrayElement.remove(index);
                arrayElement.remove(index);
            }else{
                index++;
            }
        }
        for(int i = 0;i < arrayElement.size();i++){
            System.out.println("pha tu xxx:  "+arrayElement.get(i));
        }
        return arrayElement;
    }
    //function execute Add and sub operator
    private String ExecuteAddDiv(ArrayList<String> arrayElement){
        String listOther = "";
        int index = 0;
        long xxx = 0;
        while (index < arrayElement.size()){
            if(arrayElement.get(index).equals("+")){
                xxx = Long.parseLong(arrayElement.get(index - 1)) + Long.parseLong(arrayElement.get(index + 1));
                arrayElement.set(index - 1, String.valueOf(xxx));
                arrayElement.remove(index);
                arrayElement.remove(index);
            }else if(arrayElement.get(index).equals("-")){
                xxx = Long.parseLong(arrayElement.get(index - 1)) - Long.parseLong(arrayElement.get(index + 1));
                arrayElement.set(index - 1, String.valueOf(xxx));
                arrayElement.remove(index);
                arrayElement.remove(index);
            }else{
                index++;
            }
        }
        for(int i = 0;i < arrayElement.size();i++){
            listOther = listOther + arrayElement.get(i);
        }
        return listOther;
    }
    //Function convert an element into array String
    private ArrayList<String> ConvertArrayElement(String listCalcu){
        ArrayList<String> arrayElement = new ArrayList<String>();
        char[] arrayChar = listCalcu.toCharArray();
        String oneElement = "";
        int index = 0;
        int indexFix = 0;
        for (index = 0;index < arrayChar.length; index ++){
            if(arrayChar[index] == '+' || arrayChar[index] == '-' || arrayChar[index] == '*'
                    || arrayChar[index] == '/'){
                if((indexFix != 0) && (index - indexFix == 1)){
                    indexFix = index;
                }else{
                    arrayElement.add(oneElement);
                    arrayElement.add(String.valueOf(arrayChar[index]));
                    oneElement = "";
                    indexFix = index;
                }
            }else{
                oneElement = oneElement + String.valueOf(arrayChar[index]);
            }
            if(index == (arrayChar.length - 1)){
                arrayElement.add(oneElement);
            }
        }
        return arrayElement;
    }

    private void CheckCharEnd(){
        String endChar = "";
        endChar = listCal.substring(listCal.length() - 1);
        boolean checkEnd = true;
        while(checkEnd) {
            if (endChar.equals("+") || endChar.equals("-") || endChar.equals("*") || endChar.equals("/")) {
                listCal = "" + listCal.substring(0, listCal.length() - 1);
            }
            endChar = listCal.substring(listCal.length() - 1);
            if (!(endChar.equals("+") || endChar.equals("-") || endChar.equals("*") || endChar.equals("/"))) {
                checkEnd = false;
            }
        }
    }
    /*private class AAA extends AsyncTask<Void, Integer, Integer> {


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Void... params) {
            // EX: Call API
            publishProgress(12);

            return null;
        }


        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }
    }*/
}
