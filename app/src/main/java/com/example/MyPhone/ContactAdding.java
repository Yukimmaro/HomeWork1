package com.example.MyPhone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.MyPhone.Contacts.ContactsContent;

import java.util.Calendar;
import java.util.Random;

public class ContactAdding extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

    }

    public void addContact(View view) {
        EditText name = findViewById(R.id.nameAdd);
        EditText surname = findViewById(R.id.surnameAdd);
        EditText birthday = findViewById(R.id.birthdayAdd);
        EditText phoneNumber = findViewById(R.id.phonebumberAdd);

        String sName = name.getText().toString();
        String sSurname = surname.getText().toString();
        String sBirthday = birthday.getText().toString();
        String sPhoneNumber = phoneNumber.getText().toString();

        int check_numbers = 0;
        int lenght = sPhoneNumber.length();
        if(lenght ==9) {
            for(int i = 0; i <lenght ; ++i) {
                if(sPhoneNumber.charAt(i) >= 48 && sPhoneNumber.charAt(i) <=57) {
                    check_numbers++;
                }
            }
        }

        Random rand = new Random();
        int random_number = rand.nextInt(6);


        Intent dataToInput = new Intent();
        if(sName.isEmpty() || sPhoneNumber.isEmpty() || check_numbers != 9){
            setResult(RESULT_CANCELED, dataToInput);
        } else {
            if(random_number == 1)
            {
                String random_pic = Integer.toString(random_number);
                ContactsContent.Contact contact = new ContactsContent.Contact(ContactsContent.ITEMS.size()+101, sName, sSurname,
                        sBirthday,random_pic, sPhoneNumber);
                dataToInput.putExtra("output_ack", contact);
                setResult(RESULT_OK, dataToInput);
            }
            else if(random_number ==2)
            {
                String random_pic = Integer.toString(random_number);
                ContactsContent.Contact contact = new ContactsContent.Contact(ContactsContent.ITEMS.size()+101, sName, sSurname,
                        sBirthday,random_pic, sPhoneNumber);
                dataToInput.putExtra("output_ack", contact);
                setResult(RESULT_OK, dataToInput);
            }
            else if(random_number ==3)
            {
                String random_pic = Integer.toString(random_number);
                ContactsContent.Contact contact = new ContactsContent.Contact(ContactsContent.ITEMS.size()+101, sName, sSurname,
                        sBirthday,random_pic, sPhoneNumber);
                dataToInput.putExtra("output_ack", contact);
                setResult(RESULT_OK, dataToInput);
            }
            else if(random_number ==4)
            {
                String random_pic = Integer.toString(random_number);
                ContactsContent.Contact contact = new ContactsContent.Contact(ContactsContent.ITEMS.size()+101, sName, sSurname,
                        sBirthday,random_pic, sPhoneNumber);
                dataToInput.putExtra("output_ack", contact);
                setResult(RESULT_OK, dataToInput);
            }
            else if(random_number ==5)
            {
                String random_pic = Integer.toString(random_number);
                ContactsContent.Contact contact = new ContactsContent.Contact(ContactsContent.ITEMS.size()+101, sName, sSurname,
                        sBirthday,random_pic, sPhoneNumber);
                dataToInput.putExtra("output_ack", contact);
                setResult(RESULT_OK, dataToInput);
            }
            else if(random_number ==6)
            {
                String random_pic = Integer.toString(random_number);
                ContactsContent.Contact contact = new ContactsContent.Contact(ContactsContent.ITEMS.size()+101, sName, sSurname,
                        sBirthday,random_pic, sPhoneNumber);
                dataToInput.putExtra("output_ack", contact);
                setResult(RESULT_OK, dataToInput);
            }

        }
        finish();
    }
}



