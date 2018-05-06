package com.okunan.tunahan.mycriminalintent;

import android.content.Context;
import android.os.Environment;

import com.activeandroid.query.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by TUNAHAN on 17.12.2017.
 */

public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;
    private static Context mContext;

    public static CrimeLab get(Context context){
        if (sCrimeLab==null){
            sCrimeLab=new CrimeLab();
        }
        mContext=context;
        return sCrimeLab;

    }
    private CrimeLab(){
        mCrimes=new ArrayList<>();
     /*   for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // Every other one
            mCrimes.add(crime);
        }
        */
    }

   /* public List<Crime> getCrimes() {
        return mCrimes;
    }
   */

    public void setCrimes(List<Crime> crimes) {
        mCrimes = crimes;
    }

  /*  public Crime getCrime(UUID id){
         for (Crime crime:mCrimes){
             if (crime.getID().equals(id)){
                 return crime;
             }
         }
         return null;
    }
    */
    public Crime getCrime(UUID id) {

        Crime a = new Select().from(Crime.class)
                .where("mID = ?", id)
                .executeSingle();

        return a;

    }

    public void addCrime(Crime crime) {
        crime.save();
    }

    public void updateCrime(Crime crime) {
        crime.save();
    }
   /* public void addCrime(Crime c) {
        mCrimes.add(c);
    }
    */
    public List<Crime> getCrimes() {
        return new Select()
                .from(Crime.class)
                .execute();
    }

    public File getPhotoFile(Crime crime){
        File externalFilesDir=mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            return null;
        }
        return new File(externalFilesDir,crime.getPhotoFileName());
    }
}
