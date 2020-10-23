package com.example.dz_xogame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer>  player1 = new ArrayList<>();
    ArrayList<Integer>  player2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void processGame(View view) {
        Button choosesBtn = (Button) view;
        choosesBtn.setText("X");
        choosesBtn.setEnabled(false);

        int cellNo = 0;
        if(choosesBtn.getId() == R.id.btn1){
            cellNo = 1;
        }
        if(choosesBtn.getId() == R.id.btn2){
            cellNo = 2;
        }
        if(choosesBtn.getId() == R.id.btn3){
            cellNo = 3;
        }
        if(choosesBtn.getId() == R.id.btn4){
            cellNo = 4;
        }
        if(choosesBtn.getId() == R.id.btn5){
            cellNo = 5;
        }
        if(choosesBtn.getId() == R.id.btn6){
            cellNo = 6;
        }
        if(choosesBtn.getId() == R.id.btn7){
            cellNo = 7;
        }
        if(choosesBtn.getId() == R.id.btn8){
            cellNo = 8;
        }
        if(choosesBtn.getId() == R.id.btn9){
            cellNo = 9;
        }

        player1.add(cellNo);

        if(isGameOver(player1)){
            displayWinner("User");
        }
        else mobilechooses();


    }
    public boolean isGameOver(ArrayList<Integer> player){
        ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(4,5,6));
        ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(7,8,9));

        ArrayList<Integer> row4 = new ArrayList<>(Arrays.asList(1,4,7));
        ArrayList<Integer> row5 = new ArrayList<>(Arrays.asList(2,5,8));
        ArrayList<Integer> row6 = new ArrayList<>(Arrays.asList(3,6,9));

        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,5,9));
        ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(3,5,7));

        if(player.containsAll(row1) || player.containsAll(row2) || player.containsAll(row3) || player.containsAll(row4) || player.containsAll(row5) || player.containsAll(row6) || player.containsAll(a1) || player.containsAll(a2)){
            return true;
        }
        else return false;
    }

    public void mobilechooses(){
        Random rnd = new Random();
        int cellNum2 = rnd.nextInt(8)+1;
        if()//צריך לעשות פעולת while שתעבוד עד מתי שאני מוצא מספר שלא תפוס
        if(isGameOver(player2)){
            displayWinner("Mobile");
        }
        else processGame();
    }

    private void displayWinner(String winner){
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setIcon(R.drawable.winner);
        adb.setTitle("The Winner is: ");
        adb.setMessage(Winner);
        adb.setPositiveButton("Ok",null);
        adb.create().show();
    }
}