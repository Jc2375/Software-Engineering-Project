package com.example.vam1994.whyw8;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * The type Menu adapter.
 */
public class MenuAdapter extends ArrayAdapter<OrderedItem>{

    /**
     * Instantiates a new Menu adapter.
     *
     * @param context  the context
     * @param resource the resource
     */
    static String ordername;
    static Context mcontext;
    static ViewGroup mparent;
    static TextView ordertotal;

    static int pos;

    public MenuAdapter(Context context, ArrayList<OrderedItem> resource){
        super(context, R.layout.menuadapterrows, resource);
        mcontext= context;
    }

    public View getView(final int position, View convertView, ViewGroup parent){

        LayoutInflater LI = LayoutInflater.from(getContext());
        View customView = LI.inflate(R.layout.menuadapterrows, parent, false);
        customView.setBackgroundColor(Color.WHITE);
        mparent= parent;
        String time = getItem(position).food;
        String foodprice= "$" + getItem(position).price;
        pos= position;
        RatingBar rb = (RatingBar)customView.findViewById(R.id.setRating);
        TextView tv = (TextView)customView.findViewById(R.id.menuItem);
        TextView price= (TextView) customView.findViewById(R.id.price);

        tv.setText(time);
        tv.setTextColor(Color.BLACK);
        price.setText(foodprice);
        price.setTextColor(Color.BLACK);
        //ordername= tv.getText().toString();
        //NumberPicker np = (NumberPicker)customView.findViewById(R.id.numberPicker);
        Button add= (Button) customView.findViewById(R.id.plus);
        Button minus= (Button) customView.findViewById(R.id.sub);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ordername= Menu.menuItems[position];
                OrderedItem sel= Menu.menu.get(position);
                boolean found= false;
                for(int i=0; i<Menu.ordered.size();i++) {
                    if (Menu.ordered.get(i).food.equals(sel.food)) {
                        found= true;
                        Menu.ordered.get(i).quantity++;
                        break;
                    }
                }
                if(!found){
                    OrderedItem order= new OrderedItem(sel.food,sel.price,1);
                    Menu.ordered.add(order);
                }
                double total=0;
                for(int i=0;i<Menu.ordered.size();i++){
                    total+= Menu.ordered.get(i).quantity*Menu.ordered.get(i).price;
                }
                String settotal= "$" + total;
                TextView ordert= (TextView) view.getRootView().findViewById(R.id.ordertotal);
                ordert.setText(settotal);
                ArrayAdapter<OrderedItem> adapter = new ArrayAdapter<OrderedItem>(Menu.mcontext, android.R.layout.simple_list_item_1, Menu.ordered);

                Menu.orderedtotal.setAdapter(adapter);

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordername= Menu.menuItems[pos];
                for(int i=0; i<Menu.ordered.size();i++){
                    if(Menu.ordered.get(i).food.equals(ordername)){
                        if(Menu.ordered.get(i).quantity<=1){
                            Menu.ordered.remove(i);
                        }
                        else{
                            Menu.ordered.get(i).quantity--;
                        }
                    }
                }
                ArrayAdapter<OrderedItem> adapter = new ArrayAdapter<OrderedItem>(Menu.mcontext, android.R.layout.simple_list_item_1, Menu.ordered);
                Menu.orderedtotal.setAdapter(adapter);

            }
        });
        //np.setMinValue(0);
        //np.setMaxValue(6);
        //np.setWrapSelectorWheel(true);

        rb.setNumStars(5);



        return customView;

    }
}
