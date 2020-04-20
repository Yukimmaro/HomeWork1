package com.example.MyPhone;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.MyPhone.ContactsFragment.OnListFragmentInteractionListener;
import com.example.MyPhone.Contacts.ContactsContent.Contact;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Contact} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyContactsRecyclerViewAdapter extends RecyclerView.Adapter<MyContactsRecyclerViewAdapter.ViewHolder> {

    private final List<Contact> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyContactsRecyclerViewAdapter(List<Contact> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_contacts, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Contact contact = mValues.get(position);
        String photoPath = contact.photoPath;
        Context context = holder.mView.getContext();

        holder.mItem = contact;
        holder.nameView.setText(contact.name);

        if(photoPath !=null && !photoPath.isEmpty())
        {
            Drawable conDrawable;
            switch (photoPath){
                case "1":
                    conDrawable = context.getResources().getDrawable(R.drawable.av1);
                    break;
                case "2":
                    conDrawable = context.getResources().getDrawable(R.drawable.av2);
                    break;
                case "3":
                    conDrawable = context.getResources().getDrawable(R.drawable.av3);
                    break;
                case "4":
                    conDrawable = context.getResources().getDrawable(R.drawable.av4);
                    break;
                case "5":
                    conDrawable = context.getResources().getDrawable(R.drawable.av5);
                    break;
                case "6":
                    conDrawable = context.getResources().getDrawable(R.drawable.av6);
                    break;
                default:
                    conDrawable = context.getResources().getDrawable(R.drawable.av1);
            }
            holder.photoView.setImageDrawable(conDrawable);

        }else
        {
            holder.photoView.setImageDrawable(context.getResources().getDrawable(R.drawable.av1));
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onListFragmentInteraction(holder.mItem, position);
                }
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListener.onListFragmentLongClickInteraction(position);
                return false;
            }
        });

        holder.binView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onListDeleteContact(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nameView;
        public final ImageView photoView;
        public final ImageButton binView;
        public Contact mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nameView = (TextView) view.findViewById(R.id.content);
            photoView = (ImageView) view.findViewById(R.id.item_image);
            binView = (ImageButton) view.findViewById(R.id.imageButton);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nameView.getText() + "'";
        }
    }
}
