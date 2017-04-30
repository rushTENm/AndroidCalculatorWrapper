package com.example.rusht.androidcalculatorwrapper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void num7(View view) {
        TextView textView = (TextView) findViewById(R.id.calText);
        CharSequence charSequence = textView.getText();
        charSequence = charSequence + "7";
        textView.setText(charSequence);
    }

    public void opDel(View view) {
        TextView textView = (TextView) findViewById(R.id.calText);
        CharSequence charSequence = textView.getText();
        String deleted = "";
        for (int i = 0; i < charSequence.length() - 1; i++) {
            deleted += charSequence.charAt(i);
        }
        textView.setText(deleted);
    }

    public void opDiv(View view) {
        TextView textView = (TextView) findViewById(R.id.calText);
        CharSequence charSequence = textView.getText();
        charSequence = charSequence + "/";
        textView.setText(charSequence);
    }

    public void opEqu(View view) {
        TextView textView = (TextView) findViewById(R.id.calText);
        CharSequence charSequence = textView.getText();

        Infix obj = new Infix(charSequence.toString());
        String postfix = obj.getResult();
        Postfix obj2 = new Postfix(postfix);

        textView.setText(String.valueOf(obj2.getValue()));
    }
}
