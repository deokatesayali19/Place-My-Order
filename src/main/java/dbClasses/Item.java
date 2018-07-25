package dbClasses;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.Image;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.net.Uri;
import android.util.Log;
import android.view.Display;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

@Entity
public class Item implements Serializable{
    @PrimaryKey
    public String name;
    public int cost;
    public  String description;


    public Item(String name, String description, int cost){

        this.name=name;
        this.description=description;
        this.cost=cost;
    }
    public String getCost() {
        return Integer.toString(cost);
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
}