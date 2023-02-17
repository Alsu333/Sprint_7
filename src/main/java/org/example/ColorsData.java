package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ColorsData {
    public OrdersData ordersData;
    //    List<String> colors = List.of("GRAY","BLACK");
    String[] color = new String[]{"GRAY","BLACK"};
    int randomColor = new Random().nextInt(color.length);

    public OrdersData getDefaultColors() {
     return new OrdersData("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", List.of(color[randomColor]));
    }
    public void randomOrder(){

    }
}
