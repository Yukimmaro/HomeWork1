package com.example.MyPhone;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.MyPhone.Contacts.ContactsContent;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactDetails extends Fragment {

    public ContactDetails() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_details, container, false);
    }

    // added

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        Intent intent = getActivity().getIntent();
        if(intent != null){
            ContactsContent.Contact receivedContact = intent.getParcelableExtra(MainActivity.contactDetailActivity);
            if(receivedContact != null){
                displayContact(receivedContact);
            }
        }
    }

    public void displayContact(ContactsContent.Contact contact)
    {
        FragmentActivity activity = getActivity();

        TextView contactName = activity.findViewById(R.id.nameView);
        TextView contactSurname = activity.findViewById(R.id.surnameView);
        TextView contactBirthday = activity.findViewById(R.id.birthdayView);
        TextView contactNumber = activity.findViewById(R.id.numberView);
        ImageView contactImage = activity.findViewById(R.id.taskInfoImage);

        contactName.setText(contact.name);
        contactSurname.setText(contact.surname);
        contactBirthday.setText(contact.birthDate);
        contactNumber.setText(contact.phoneNumber);
        if(contact.photoPath != null && !contact.photoPath.isEmpty())
        {
            Drawable contactDrawable;
            if (contact.photoPath.equals("1")) contactDrawable = activity.getResources().getDrawable(R.drawable.av1);
            else if(contact.photoPath.equals("2")) contactDrawable = activity.getResources().getDrawable(R.drawable.av2);
            else if(contact.photoPath.equals("3")) contactDrawable = activity.getResources().getDrawable(R.drawable.av3);
            else if(contact.photoPath.equals("4")) contactDrawable = activity.getResources().getDrawable(R.drawable.av4);
            else if(contact.photoPath.equals("5")) contactDrawable = activity.getResources().getDrawable(R.drawable.av5);
            else if(contact.photoPath.equals("6")) contactDrawable = activity.getResources().getDrawable(R.drawable.av6);
            else contactDrawable = activity.getResources().getDrawable(R.drawable.av1);

            contactImage.setImageDrawable(contactDrawable);
        }
        else {
            contactImage.setImageDrawable(activity.getResources().getDrawable(R.drawable.av1));
        }
    }
}
