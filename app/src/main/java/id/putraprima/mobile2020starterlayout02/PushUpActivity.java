package id.putraprima.mobile2020starterlayout02;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import id.putraprima.mobile2020starterlayout02.databinding.ActivityPushUpBinding;

//import android.hardware.Sensor

public class PushUpActivity extends AppCompatActivity {

    private int counter = 0;
    private ActivityPushUpBinding binding;
    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private SensorEventListener proximitySensorListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //counter ++;

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_push_up);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_push_up);
        binding.textPushupCount.setText("0");
        //binding.containerPushupCounter.setOnClickListener(counter +);
        binding.containerPushupCounter.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                counter++;
                binding.textPushupCount.setText("" + counter);
            }
        });

//        TextCount = findViewById(R.id.text_pushup_count);
//        TextCount.setText("0");
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (proximitySensor == null) {
            Toast.makeText(this, "Proximity sensor tidak tersedia" , Toast.LENGTH_LONG).show();
            finish();
        }

        proximitySensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                    if (event.values[0] == 0) {
                        counter++;
                        binding.textPushupCount.setText("" + counter);
                    } else {
                        binding.textPushupCount.getText();
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        sensorManager.registerListener(proximitySensorListener, proximitySensor, 2 * 1000 * 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(proximitySensorListener);
    }
}