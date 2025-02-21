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
public class SignupFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_signup,container,false);
        Button signbutton=view.findViewById(R.id.signup_button);
        EditText editText=view.findViewById(R.id.signup_email);
        EditText editText1=view.findViewById(R.id.signup_password);
        Button button=view.findViewById(R.id.button);
        Button nbutton=view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Toast.makeText(getContext(),"Bağlanılamadı!" , Toast.LENGTH_SHORT).show();
            }});
        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Bağlanılamadı!" , Toast.LENGTH_SHORT).show();
            }
        });
        signbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUsername = editText.getText().toString();
                String newPassword = editText1.getText().toString();

                if (newUsername.isEmpty() || newPassword.isEmpty()) {
                    Toast.makeText(getContext(),"Tüm alanları doldurun!" , Toast.LENGTH_SHORT).show();
                } else if (userData.users.containsKey(newUsername)) {
                    Toast.makeText(getContext(),"Bu kullanıcı adı zaten mevcut!" , Toast.LENGTH_SHORT).show();

                } else {
                    userData.users.put(newUsername, newPassword);
                    Toast.makeText(getContext(),"Kullanıcı başarıyla oluşturuldu!" , Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(getActivity(),LoginTabFragment.class);
//                    startActivity(intent);
}}});return view; }}