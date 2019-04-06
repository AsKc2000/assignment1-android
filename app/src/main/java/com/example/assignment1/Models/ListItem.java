package com.example.assignment1.Models;

import com.example.assignment1.R;

public class ListItem {
    String name;
    String desc;
    int Image_res_id = R.drawable.facebook;

    public ListItem(String name, String desc) {
        this.name = name;
        this.desc = desc;
        //this.Image_res_id = R.drawable.facebook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage_res_id() {
        return this.Image_res_id;
    }

    public void setImage_res_id(int Image_res_id) {
        this.Image_res_id = Image_res_id;
    }


}




