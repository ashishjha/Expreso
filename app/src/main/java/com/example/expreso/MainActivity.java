package com.example.expreso;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = "Cost : ₹ " + (quantity * 5);
        displayMessage(priceMessage);
        displayThank();
        displayCups(quantity);
        displayCostPerCup();
        displayPrice(quantity);
        displayGST(quantity * 5);
        displayEnjoy();
        displayC1();

        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.layout1);
        linearLayout.setBackgroundResource(R.drawable.border);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity == 0) {
            quantity = quantity + 0;
            display(quantity);
        } else {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    private void displayThank() {
        TextView quantityTextView = (TextView) findViewById(R.id.thank);
        quantityTextView.setText("THANK YOU!");
    }

    private void displayCups(int cups) {
        TextView quantityTextView = (TextView) findViewById(R.id.cups);
        quantityTextView.setText("Number of cups of Coffee");
        TextView priceTextView = (TextView) findViewById(R.id.p1);
        priceTextView.setText("" + cups);
    }

    private void displayCostPerCup() {
        TextView quantityTextView = (TextView) findViewById(R.id.cost);
        quantityTextView.setText("Cost per cup of Coffee");
        TextView priceTextView = (TextView) findViewById(R.id.p2);
        priceTextView.setText("₹ 5");
    }

    private void displayPrice(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.price);
        quantityTextView.setText("Price");
        TextView priceTextView = (TextView) findViewById(R.id.p3);
        priceTextView.setText("₹ " + quantity * 5);
    }

    private void displayGST(int cost) {
        TextView quantityTextView = (TextView) findViewById(R.id.gst);
        quantityTextView.setText("GST(@ 18%)");
        double tax = (18.00 * cost) / 100;
        TextView priceTextView = (TextView) findViewById(R.id.p4);
        priceTextView.setText("₹ " + tax);
        displayTotalPrice(tax, cost);
    }

    private void displayTotalPrice(double tax, int cost) {
        TextView quantityTextView = (TextView) findViewById(R.id.total);
        quantityTextView.setText("Total Price");
        double totalPrice = cost + tax;
        TextView priceTextView = (TextView) findViewById(R.id.p5);
        priceTextView.setText("₹ " + totalPrice);
    }

    private void displayEnjoy() {
        TextView quantityTextView = (TextView) findViewById(R.id.enjoy);
        quantityTextView.setText("Enjoy Your Coffee!");
    }

    public void displayC1() {
        TextView c1TextView = (TextView) findViewById(R.id.c1);
        c1TextView.setText(":");

        TextView c2TextView = (TextView) findViewById(R.id.c2);
        c2TextView.setText(":");

        TextView c3TextView = (TextView) findViewById(R.id.c3);
        c3TextView.setText(":");

        TextView c4TextView = (TextView) findViewById(R.id.c4);
        c4TextView.setText(":");

        TextView c5TextView = (TextView) findViewById(R.id.c5);
        c5TextView.setText(":");
    }
    /**
     * This method displays the given price on the screen.

     private void displayPrice(int number) {
     TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
     priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
     }
     **/

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}