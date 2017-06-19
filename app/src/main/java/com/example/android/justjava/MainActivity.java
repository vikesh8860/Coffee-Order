    package com.example.android.justjava;

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.CheckBox;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;

    /**
     * This app displays an order form to order coffee.
     */
    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
        /**
         * This method is called when the order button is clicked.
         */
        int quantity=1;
        public void increment(View view)
        {  if(quantity<150) {
            quantity++;
            display(quantity);
        }
            else {
            Toast toast= Toast.makeText(this,"Please order below 150 quantities",Toast.LENGTH_SHORT);
            toast.show();
        }

        }
        public void decrement(View view)
        {
            if(quantity!=0)
            {
                quantity--;
                display(quantity);
            }
            else {
                       Toast.makeText(this,"Order Possitive Quantities",Toast.LENGTH_SHORT).show();
            }
        }
        boolean hasChocolate,hasWhippedCream;
        public void submitOrder(View view) {

            CheckBox checkBoxCream = (CheckBox) findViewById(R.id.checkboxCream);
            hasWhippedCream=checkBoxCream.isChecked();
            CheckBox checkBoxChocolate = (CheckBox) findViewById(R.id.checkboxChocolate);
            hasChocolate=checkBoxChocolate.isChecked();

            EditText editText =(EditText)findViewById(R.id.editText);
            String getText=editText.getText().toString();

            int price= calculatePrice();
            String message=createOrderSummary(price,hasWhippedCream,hasChocolate,getText);
            displayMessage(message);
        }

         private String createOrderSummary(int price,boolean whipped,boolean chocolate,String getText)
         {
             return ""+getString(R.string.name)+" = "+getText+"\nAdd Whipped Cream -> : "+whipped+"\nAdd Chocolate -> : "+chocolate+"\nQuantity = "+price/12+"\nTotal = Rs. "+price+"\nThank You!";
         }
        /**
         *  Calculate the price of quantity
         */
        private int calculatePrice()
        {  if(hasWhippedCream==true&&hasChocolate==true)
            return quantity*(12+5+6);
            else if(hasWhippedCream==true&&hasChocolate==false)
            return quantity*(12+5);
            else if(hasWhippedCream==false&&hasChocolate==false)
            return quantity*(12);
           else
            return quantity*(12+6);
        }

        private void displayMessage(String message) {
            TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
            orderSummaryTextView.setText(message);
        }
        /**
         * This method displays the given quantity value on the screen.
         */
        private void display(int number) {
            TextView quantityTextView = (TextView) findViewById(
                    R.id.quantity_text_view);
            quantityTextView.setText("" + number);
        }
    }