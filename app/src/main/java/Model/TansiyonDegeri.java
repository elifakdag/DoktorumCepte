package Model;

/**
 * Created by Elif AKDAĞ on 31.05.2017.
 */


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TansiyonDegeri {



    //To read or write data from the database, you need an instance of DatabaseReference:
    public String userId="";
    public int stansiyon;
    public int btansiyon;
    public int minute;
    public int hour;
    public int day;
    String path = null;
    private DatabaseReference mDatabase;
    public TansiyonDegeri(String userId, int stansiyon,int btansiyon, int m, int h, int d){
        path = FirebaseDatabase.getInstance().getReference("hasta/"+userId+"/TansiyonDegeri/").push().getKey();
        mDatabase = FirebaseDatabase.getInstance().getReference("hasta/"+userId+"/TansiyonDegeri/"+path);

        this.stansiyon = stansiyon;
        this.btansiyon = btansiyon;
        this.userId = userId;
        this.minute = m;
        this.hour = h;
        this.day = d;
        writeNewTansiyonDegeri();
    }

    private void writeNewTansiyonDegeri(){
        mDatabase.child("Kucuk Tansiyon").setValue(stansiyon);
        mDatabase.child("Buyuk Tansiyon").setValue(btansiyon);
        mDatabase.child("minute").setValue(minute);
        mDatabase.child("hour").setValue(hour);
        mDatabase.child("day").setValue(day);
    }

}
