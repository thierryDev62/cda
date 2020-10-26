package Controller;

import java.util.ArrayList;

public class Datas {

    private static ArrayList<String> datas = new ArrayList<>();

    public Datas() {
        datas.add("Chien");
        datas.add("Chat");
    }

    public static ArrayList<String> getDatas() {
        return datas;
    }
}
