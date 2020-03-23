package com.bb.contentproviderclerk.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.bb.contentproviderclerk.R;
import com.bb.contentproviderclerk.adapter.GuestAdapter;
import com.bb.contentproviderclerk.model.Guest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    private List<Guest> guestList = new ArrayList<Guest>();

    RecyclerView guestRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guestRecyclerView = findViewById(R.id.guest_list_recyclerView);

        setUpAdapter();
        readFromContentProvider();
    }

    private void readFromContentProvider(){
        String uri = "content://com.bb.contentproviderlogin.provider.GuestProvider/guests";

        ContentResolver contentResolver = getContentResolver();

        Cursor guestCursor= contentResolver.query(Uri.parse(uri), null, null, null,null);

        guestCursor.moveToPosition(-1);
        guestList.clear();
        Log.d("TAG_H", "Checking: " + guestList );

        while(guestCursor.moveToNext()){

            String guestName = guestCursor.getString(guestCursor.getColumnIndex("guest_name"));
            String guestRoomNum = guestCursor.getString(guestCursor.getColumnIndex("guest_room_number"));

            guestList.add(new Guest(guestName, guestRoomNum));
            Log.d("TAG_X", "From Provider: " + guestName);
        }

        guestCursor.close();
    }

    private void setUpAdapter(){
        GuestAdapter guestAdapter = new GuestAdapter(guestList);
        guestRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        guestRecyclerView.setAdapter(guestAdapter);
    }

}
