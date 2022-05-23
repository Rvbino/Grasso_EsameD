package org.example;

import java.util.ArrayList;

public class ElabArray {
    ArrayList<Wines> arr;
    ElabArray(){
        arr=new ArrayList<Wines>();
    }

    void add_Vini(int id, String name, String type, double price){
        Wines a= new Wines(id,name,type,price);
        arr.add(a);
    }

    void crea_lista(){
        add_Vini(13,"Dom perignon Vintage Moet & chandon 2008","white", 225.94);
        add_Vini(13,"Pignoli Radikon Radikon","red", 133.0);
        add_Vini(13,"Pinot Nero Elena Walch Elena Walch","red", 43.0);
    }

    String all(){
        String msg="";
        for(int i=0;i<arr.size();i++){
            msg=msg+arr.get(i).toString();
        }
        return msg;
    }

    String red(){
        String msg="";
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getType().equals("red")){
                msg += arr.get(i);
            }
        }
        return msg;
    }

    String white(){
        String msg="";
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getType().equals("white")){
                msg += arr.get(i);
            }
        }
        return msg;
    }
}
