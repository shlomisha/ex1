package tipcalculator.huji.ac.il.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends AppCompatActivity {

    private static final int DEFAULT_TIP_PERCENTAGE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        this.setButtons();
        this.setTipPercentage();
    }

    private void setTipPercentage() {
        final EditText field = (EditText) findViewById(R.id.edtTipPercentage);
        field.setText(Integer.toString(DEFAULT_TIP_PERCENTAGE));
    }

    private void setButtons() {
        final Button calculateButton = (Button) findViewById(R.id.btnCalculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {

                                                   EditText fieldBillAmount = (EditText) findViewById(R.id.edtBillAmount);
                                                   EditText fieldTipPercentage = (EditText) findViewById(R.id.edtTipPercentage);
                                                   TextView tipResult = (TextView) findViewById(R.id.txtTipResult);
                                                   CheckBox round = (CheckBox) findViewById(R.id.chkRound);

                                                   double percentage = Double.parseDouble(fieldTipPercentage.getText().toString());
                                                   double amount = Double.parseDouble(fieldBillAmount.getText().toString());

                                                   double tip = amount * percentage / 100;
                                                   String output = String.format("%1$,.2f", tip);

                                                   if (round.isChecked()) {
                                                       tip = Math.ceil(tip);
                                                       output = Integer.toString((int) tip);
                                                   }
                                                   tipResult.setText(output + "₪");
                                               }
                                           }
        );
    }
}
