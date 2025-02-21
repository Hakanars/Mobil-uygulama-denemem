package com.example.deneme3;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class OyunActivity extends AppCompatActivity {
    private String currentPlayer = "X"; // X başlar
    private String[][] board = new String[3][3]; // Oyun tahtası
    private boolean isGameActive = true;
        Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_oyun);
        Button oyunbtn=(Button) findViewById(R.id.button7);
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        TextView statusText = findViewById(R.id.statusText);
        resetBoard();
oyunbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(OyunActivity.this,OyunActivity.class);
        startActivity(intent);}});
for (int i = 0; i < gridLayout.getChildCount(); i++) {     final int index = i;
            Button button = (Button) gridLayout.getChildAt(i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isGameActive && button.getText().toString().isEmpty()) {
                        int row = index / 3;
                        int col = index % 3;
                        board[row][col] = currentPlayer;
                        button.setText(currentPlayer);
                        if (checkWinner()) {
                            statusText.setText(currentPlayer + " kazandı!");
                            isGameActive = false;
                        } else if (isBoardFull()) {
                            statusText.setText("Beraberlik!");
                            isGameActive = false;
                        } else {
                            // Sırayı değiştir
                            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                            statusText.setText(currentPlayer + "'in sırası");}}}});}}
    private boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(currentPlayer) &&
                    board[i][1].equals(currentPlayer) &&
                    board[i][2].equals(currentPlayer)) {
                return true;}
            if (board[0][i].equals(currentPlayer) &&
                    board[1][i].equals(currentPlayer) &&
                    board[2][i].equals(currentPlayer)) {
                return true;}}
        if (board[0][0].equals(currentPlayer) &&
                board[1][1].equals(currentPlayer) &&
                board[2][2].equals(currentPlayer)) {
            return true;}
        if (board[0][2].equals(currentPlayer) &&
                board[1][1].equals(currentPlayer) &&
                board[2][0].equals(currentPlayer)) {
            return true;}
        return false;}
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].isEmpty()) {
                    return false;}}}return true;}
    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";}}}}