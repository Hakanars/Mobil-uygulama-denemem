package com.example.deneme3;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class LoginTabFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login_tab,container,false);
        Button loginbtn=view.findViewById(R.id.login_button);
        EditText mail=view.findViewById(R.id.login_email);
        EditText sifre=view.findViewById(R.id.login_password);
        Button button=view.findViewById(R.id.button);
        Button nbutton=view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Bağlanılamadı!" , Toast.LENGTH_SHORT).show();} });
        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Bağlanılamadı!" , Toast.LENGTH_SHORT).show(); }});
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String email=mail.getText().toString();
String Sifre=sifre.getText().toString();
if (userData.users.containsKey(email) &&
                        userData.users.get(email).equals(Sifre)){
                    Toast.makeText(getContext(), "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), ArayuzActivity.class);
                    startActivity(intent);
                 }else {
    Toast.makeText(getContext(), "Hatali Giris", Toast.LENGTH_SHORT).show();
}}});
 return view;
    }
}