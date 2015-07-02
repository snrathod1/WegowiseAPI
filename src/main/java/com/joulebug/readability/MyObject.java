package com.joulebug.readability;

/**
 * Created by shraddharathod on 6/29/15.
 */
public class MyObject {
    private String mykey;
    private ObjectTwo nestedkey;

    public String getMykey(){
        return mykey;
    }

    public void setMykey(String mykey) {
        this.mykey = mykey;

    }
    public ObjectTwo getNestedkey() {
        return nestedkey;
    }

    public void setNestedkey(ObjectTwo nestedkey) {
        this.nestedkey = nestedkey;
    }

}
