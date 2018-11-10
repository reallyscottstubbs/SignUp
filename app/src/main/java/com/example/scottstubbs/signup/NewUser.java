package com.example.scottstubbs.signup;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.resources.MaterialResources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.parceler.Parcel;

public class NewUser extends AppCompatActivity {

    EditText edtName, edtPassword;
    Button button, button2;

   // private DatabaseReference databaseReference;
   // final FirebaseDatabase database = FirebaseDatabase.getInstance();
   // final DatabaseReference table_user = database.getReference("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

       // final FirebaseDatabase database = FirebaseDatabase.getInstance();
       // final DatabaseReference table_user = database.getReference("User");

        edtPassword = (MaterialEditText)findViewById(R.id.editText2);
        edtName = (MaterialEditText)findViewById(R.id.editText);

        Button add_user = findViewById(R.id.button3);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(NewUser.this);
                mDialog.setMessage("Please Wait");
                mDialog.show();


               table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        mDialog.dismiss();
                        users users = new users(edtName.getText().toString(),edtPassword.getText().toString());
                        table_user.child(edtName.getText().toString()).setValue(users);
                        Toast.makeText(NewUser.this,"Welcome New User", Toast.LENGTH_SHORT).show();
                        finish();

                        //users users = dataSnapshot.child(edtName.getText().toString()).getValue(users.class);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                /*databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.push().setValue(findViewById(R.id.editText));
                databaseReference.push().setValue(findViewById(R.id.editText2));



                Intent homeIntent = new Intent(NewUser.this, Login.class);
                startActivity(homeIntent);
                finish();
            */}
        });

    }
}
