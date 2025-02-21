package com.example.deneme3;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.button.MaterialButton;
public class HesapActivity extends AppCompatActivity implements View.OnClickListener {
    TextView resultTv, solutionTv;
    MaterialButton buttonSin, buttonCos, buttonTan, buttonUst, buttonLog, buttonLn;
    MaterialButton buttonParantezac, buttonParantezkapa, buttonKarekok, buttonC, buttonSil;
    MaterialButton buttonYuzde, buttonBol, buttonFactorial, button7, button8, button9, buttonCarpma;
    MaterialButton button1bolux, button4, button5, button6, buttonCikart, buttonPi, button1;
    MaterialButton button2, button3, buttonTopla, buttonGenislet, buttonE, button0, buttonNokta;
    MaterialButton buttonEsittir;
    String currentInput = "";
    String previousInput = "";
    String operator = "";
    boolean isParenthesisOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hesap);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;});
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);
        buttonSin = findViewById(R.id.button_sinus);
        buttonCos = findViewById(R.id.button_cosinus);
        buttonTan = findViewById(R.id.button_tanjant);
        buttonUst = findViewById(R.id.button_ust);
        buttonLog = findViewById(R.id.button_logaritma);
        buttonLn = findViewById(R.id.button_ln);
        buttonParantezac = findViewById(R.id.button_parantez_ac);
        buttonParantezkapa = findViewById(R.id.button_parantez_kapat);
        buttonKarekok = findViewById(R.id.button_karekok);
        buttonC = findViewById(R.id.button_C);
        buttonSil = findViewById(R.id.button_sil);
        buttonYuzde = findViewById(R.id.button_yuzde);
        buttonBol = findViewById(R.id.button_bol);
        buttonFactorial = findViewById(R.id.button_faktoriel);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonCarpma = findViewById(R.id.button_carp);
        button1bolux = findViewById(R.id.button_1bolux);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        buttonCikart = findViewById(R.id.button_cıkartma);
        buttonPi = findViewById(R.id.button_pi);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        buttonTopla = findViewById(R.id.button_toplama);
        buttonGenislet = findViewById(R.id.button_genislet);
        buttonE = findViewById(R.id.button_e);
        button0 = findViewById(R.id.button_0);
        buttonNokta = findViewById(R.id.button_nokta);
        buttonEsittir = findViewById(R.id.button_esittir);
        buttonSin.setOnClickListener(this);
        buttonCos.setOnClickListener(this);
        buttonTan.setOnClickListener(this);
        buttonUst.setOnClickListener(this);
        buttonLog.setOnClickListener(this);
        buttonLn.setOnClickListener(this);
        buttonParantezac.setOnClickListener(this);
        buttonParantezkapa.setOnClickListener(this);
        buttonKarekok.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonSil.setOnClickListener(this);
        buttonYuzde.setOnClickListener(this);
        buttonBol.setOnClickListener(this);
        buttonFactorial.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonCarpma.setOnClickListener(this);
        button1bolux.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        buttonCikart.setOnClickListener(this);
        buttonPi.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        buttonTopla.setOnClickListener(this);
        buttonGenislet.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonNokta.setOnClickListener(this);
        buttonEsittir.setOnClickListener(this);}
    private boolean isNumber(String text) {
        return text.matches("[0-9]") || text.equals(".");
    }
    private boolean isOperator(String text) {
        return text.matches("[+\\-*/^]");
    }
    private double performCalculation(String num1, String num2, String operator) {
        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        double result = 0;
        switch (operator) {
            case "+": result = n1 + n2;break;
            case "-": result = n1 - n2;break;
            case "*": result = n1 * n2;break;
            case "/": if (n2 != 0) {result = n1 / n2;
                } else {result = Double.NaN;}
                break;
            case "^": result = Math.pow(n1, n2);break;}
        return result;}
    private int factorial(int num) {
        if (num < 0) {return -1;}
        int result = 1;
        for (int i = 1; i <= num; i++) {result *= i;}
        return result;}
    @Override
    public void onClick(View view) {
        MaterialButton clickedButton = (MaterialButton) view;
        String buttonText = clickedButton.getText().toString();
        if (isNumber(buttonText)) {
            currentInput += buttonText;
            resultTv.setText(currentInput);
        }
        else if (isOperator(buttonText)) {
            if (!currentInput.isEmpty()) {
                previousInput = currentInput;
                currentInput = "";
                operator = buttonText;
                solutionTv.setText(previousInput + " " + operator);}}
        else if (buttonText.equals("=")) {
            if (!currentInput.isEmpty() && !previousInput.isEmpty()) {
                double result = performCalculation(previousInput, currentInput, operator);
                resultTv.setText(String.valueOf(result));
                solutionTv.setText(previousInput + " " + operator + " " + currentInput);
                currentInput = String.valueOf(result);
                previousInput = "";}}
        else if (buttonText.equals("C")) {
            currentInput = "";
            previousInput = "";
            operator = "";
            resultTv.setText("");
            solutionTv.setText("");}
        else if (buttonText.equals("sin")) {
            if (!currentInput.isEmpty()) {
                double value = Math.toRadians(Double.parseDouble(currentInput));
                currentInput = String.valueOf(Math.sin(value));
                resultTv.setText(currentInput);}}
        else if (buttonText.equals("cos")) {
            if (!currentInput.isEmpty()) {
                double value = Math.toRadians(Double.parseDouble(currentInput));
                currentInput = String.valueOf(Math.cos(value));
                resultTv.setText(currentInput);}}
        else if (buttonText.equals("tan")) {
            if (!currentInput.isEmpty()) {
                double value = Math.toRadians(Double.parseDouble(currentInput));
                currentInput = String.valueOf(Math.tan(value));
                resultTv.setText(currentInput);}}
        else if (buttonText.equals("1/x")) {
            if (!currentInput.isEmpty()) {
                double value = Double.parseDouble(currentInput);
                if (value != 0) {
                    currentInput = String.valueOf(1 / value);
                    resultTv.setText(currentInput);
                } else {
                    resultTv.setText("Error");}}}
        else if (buttonText.equals("√")) {
            if (!currentInput.isEmpty()) {
                double value = Double.parseDouble(currentInput);
                if (value >= 0) {
                    currentInput = String.valueOf(Math.sqrt(value));
                    resultTv.setText(currentInput);
                } else {
                    resultTv.setText("Error");}}}
        else if (buttonText.equals("log")) {
            if (!currentInput.isEmpty()) {
                double value = Double.parseDouble(currentInput);
                if (value > 0) {
                    currentInput = String.valueOf(Math.log10(value));
                    resultTv.setText(currentInput);
                } else {
                    resultTv.setText("Error");}}}
        else if (buttonText.equals("ln")) {
            if (!currentInput.isEmpty()) {
                double value = Double.parseDouble(currentInput);
                if (value > 0) {
                    currentInput = String.valueOf(Math.log(value));
                    resultTv.setText(currentInput);
                } else {
                    resultTv.setText("Error");}}}
        else if (buttonText.equals("(")) {
            currentInput += "(";
            resultTv.setText(currentInput);
            isParenthesisOpen = true;}
        else if (buttonText.equals(")")) {
            if (isParenthesisOpen) {
                currentInput += ")";
                resultTv.setText(currentInput);
                isParenthesisOpen = false;}}
        else if (buttonText.equals("x!")) {
            if (!currentInput.isEmpty()) {
                currentInput = String.valueOf(factorial(Integer.parseInt(currentInput)));
                resultTv.setText(currentInput);}}}}