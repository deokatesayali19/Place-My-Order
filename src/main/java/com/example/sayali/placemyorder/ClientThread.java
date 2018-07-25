package com.example.sayali.placemyorder;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import dbClasses.Item;

public class ClientThread implements Runnable {
    Context con;
    int port=0;
    Thread t;
    String result;
    Vector<Item> item=new Vector<Item>();
    ContentResolver c;
    ArrayList<Item> order;
    public static Socket s;
    public ClientThread(Context c,String result){
        con=c;
        this.result=result;
        t=new Thread(this);
        t.start();

    }
    public void run(){
        try{
            c=con.getContentResolver();
            String sub=result.substring(result.length()-5);
            if(sub.charAt(0)==0){
                sub=sub.substring(sub.length()-4);
            }
            ObjectInputStream is=null;
            port=Integer.parseInt(sub);
            Log.d("Port:",Integer.toString(port));
            Log.d("Client","Building system");
            s=new Socket("192.168.43.1",port);
            Log.d("Client","connected");
            is=new ObjectInputStream(s.getInputStream());
            try {
                item = (Vector<Item>) is.readObject();
                Log.d("Client",item.get(0).getName());
            }catch (Exception e){
                Log.d("Error",e.getStackTrace().toString());
            }
            s.shutdownInput();
            Iterator i=item.iterator();
            while (i.hasNext()){
                Object r=i.next();
                Item x=(Item)r;
                MainActivity.database.itemDao().addItem(new Item(x.getName(),x.getDescription(),Integer.parseInt(x.getCost())));

            }


        }
        catch (IOException e) {
            Log.d("Error", e.getStackTrace().toString());
        }
    }
}
