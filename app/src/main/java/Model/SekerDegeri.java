package Model;

/**
 * Created by Elif AKDAĞ on 31.05.2017.
 */


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SekerDegeri {



    //To read or write data from the database, you need an instance of DatabaseReference:
    public String userId="";
    public int sekerDegeri;
    public int minute;
    public int hour;
    public int day;
    String path = null;
    private DatabaseReference mDatabase;
    public SekerDegeri(String userId, int sekerDegeri, int m, int h, int d){
        path = FirebaseDatabase.getInstance().getReference("hasta/"+userId+"/sekerDegeri/").push().getKey();
        mDatabase = FirebaseDatabase.getInstance().getReference("hasta/"+userId+"/sekerDegeri/"+path);

        this.sekerDegeri = sekerDegeri;
        this.userId = userId;
        this.minute = m;
        this.hour = h;
        this.day = d;
        writeNewSekerDegeri();
    }

    private void writeNewSekerDegeri(){
        mDatabase.child("SekerDegeri").setValue(sekerDegeri);
        mDatabase.child("minute").setValue(minute);
        mDatabase.child("hour").setValue(hour);
        mDatabase.child("day").setValue(day);
    }

}
