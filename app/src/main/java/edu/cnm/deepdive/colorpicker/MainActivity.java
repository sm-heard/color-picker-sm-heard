package edu.cnm.deepdive.colorpicker;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  private SeekBar redSeekbar;
  private SeekBar greenSeekbar;
  private SeekBar blueSeekbar;
  private SeekBar alphaSeekbar;
  private ImageView imageView;
  private int red;
  private int green;
  private int blue;
  private int alpha;
  private EditText redEditText;
  private EditText greenEditText;
  private EditText blueEditText;
  private EditText alphaEditText;
  private EditText hexText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    redSeekbar = findViewById(R.id.red_seekbar);
    redSeekbar.setMax(255);
    redEditText = findViewById(R.id.red_edit_text);

    greenSeekbar = findViewById(R.id.green_seekbar);
    greenSeekbar.setMax(255);
    greenEditText = findViewById(R.id.green_edit_text);

    blueSeekbar = findViewById(R.id.blue_seekbar);
    blueSeekbar.setMax(255);
    blueEditText = findViewById(R.id.blue_edit_text);

    alphaSeekbar = findViewById(R.id.alpha_seekbar);
    alphaSeekbar.setMax(255);
    alphaEditText = findViewById(R.id.alpha_edit_text);

    imageView = findViewById(R.id.image_view);

    hexText = findViewById(R.id.hex_text);



    alphaSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        alpha = alphaSeekbar.getProgress();
        imageView.setBackgroundColor(Color.argb(alpha,red,green,blue));
        alphaEditText.setText(String.valueOf(alpha));
        hexText.setText(String.format("%02x%02x%02x%02x",alpha,red,green,blue));

      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });




    redSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        red = redSeekbar.getProgress();
        imageView.setBackgroundColor(Color.argb(alpha,red,green,blue));
        redEditText.setText(String.valueOf(red));
        hexText.setText(String.format("%02x%02x%02x%02x",alpha,red,green,blue));



      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });


    greenSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        green = greenSeekbar.getProgress();
        imageView.setBackgroundColor(Color.argb(alpha,red,green,blue));
        greenEditText.setText(String.valueOf(green));
        hexText.setText(String.format("%02x%02x%02x%02x",alpha,red,green,blue));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });


    blueSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        blue = blueSeekbar.getProgress();
        imageView.setBackgroundColor(Color.argb(alpha,red,green,blue));
        blueEditText.setText(String.valueOf(blue));
        hexText.setText(String.format("%02x%02x%02x%02x",alpha,red,green,blue));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });

    redEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
      @Override
      public void onFocusChange(View view, boolean b) {
        red = Integer.parseInt(redEditText.getText().toString());
        redSeekbar.setProgress(red);
        imageView.setBackgroundColor(Color.argb(alpha,red,green,blue));
      }
    });

    greenEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
      @Override
      public void onFocusChange(View view, boolean b) {
        green = Integer.parseInt(greenEditText.getText().toString());
        greenSeekbar.setProgress(green);
        imageView.setBackgroundColor(Color.argb(alpha,red,green,blue));
      }
    });

     blueEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
       @Override
       public void onFocusChange(View view, boolean b) {
         blue = Integer.parseInt(blueEditText.getText().toString());
         blueSeekbar.setProgress(blue);
         imageView.setBackgroundColor(Color.argb(alpha,red,green,blue));
       }
     });

     alphaEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
       @Override
       public void onFocusChange(View view, boolean b) {
         alpha = Integer.parseInt(alphaEditText.getText().toString());
         alphaSeekbar.setProgress(alpha);
         imageView.setBackgroundColor(Color.argb(alpha,red,green,blue));
       }
     });

     hexText.setOnFocusChangeListener(new OnFocusChangeListener() {
       @Override
       public void onFocusChange(View view, boolean b) {

         String hexString = hexText.getText().toString();

         if (!(hexString.matches("^[0-9a-fA-F]+$"))){
           hexString="00000000";
         }

         alpha = Integer.valueOf(hexString.substring(0,2),16);
         red = Integer.valueOf(hexString.substring(2,4),16);
         green = Integer.valueOf(hexString.substring(4,6),16);
         blue = Integer.valueOf(hexString.substring(6,8),16);

         alphaSeekbar.setProgress(alpha);
         redSeekbar.setProgress(red);
         greenSeekbar.setProgress(green);
         blueSeekbar.setProgress(blue);

         imageView.setBackgroundColor(Color.argb(alpha,red,green,blue));
       }
     });






  }
}
