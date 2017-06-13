package com.example.norman.android_project;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2017/6/10.
 */

public class FirebaseThread extends Thread {
    private DataSnapshot dataSnapshot;
    private Handler handler = null;
    private  int  LIST_DATAS;

    public FirebaseThread(DataSnapshot dataSnapshot) {
        this.dataSnapshot = dataSnapshot;
    }

    public FirebaseThread(DataSnapshot dataSnapshot,Handler handler, int  LIST_DATAS) {
        this.dataSnapshot = dataSnapshot;
        this.handler = handler;
        this.LIST_DATAS = LIST_DATAS ;
    }

    @Override
    public void run() {
        List<Data> lsdatas = new ArrayList<>();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {

            String classification ="";
            String title  ="";
            String content ="";
            String link ="";
            String date ="";


            for(DataSnapshot cc: ds.getChildren()) {

                DataSnapshot dsclassification = cc.child("分類");
                String a = (String)dsclassification.getValue();
                if(a != null) {
                    classification = a;
                }

                DataSnapshot dstitle = cc.child("標題");
                String t = (String)dstitle.getValue();
                if(t != null) {
                    title = t;
                }

                DataSnapshot dscontent = cc.child("內容");
                String c = (String)dscontent.getValue();
                if(c != null) {
                    content = c;
                }


                DataSnapshot dslink = cc.child("附檔連結");
                String l = (String)dslink.getValue();
                if(l != null) {
                    link = l;
                }

                DataSnapshot dsdate = cc.child("發布日期");
                String d = (String)dsdate.getValue();
                if(d != null) {
                    date = d;
                }

            }

           /* DataSnapshot dsSName = ds.child("shelter_name");
            DataSnapshot dsAKind = ds.child("animal_kind");
            String shelterName = (String)dsSName.getValue();
            String kind = (String)dsAKind.getValue();
            DataSnapshot dsImg = ds.child("album_file");*/
            // String imgUrl = (String) dsImg.getValue();

            //Bitmap petImg = getImgBitmap(imgUrl);
            Data aData = new Data();
            aData.setClassification(classification);
            aData.setTitle(title);
            aData.setContent(content);
            aData.setLink(link);
            aData.setDate(date);

            lsdatas.add(aData);
            Log.v("Adata", classification + ";" + title + ";" + content);


            Message msg = new Message();
            msg.what = LIST_DATAS;
            msg.obj = lsdatas;
            handler.sendMessage(msg);

        }
    }
}