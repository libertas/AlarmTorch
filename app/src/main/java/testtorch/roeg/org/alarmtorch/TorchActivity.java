package testtorch.roeg.org.alarmtorch;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TorchActivity extends AppCompatActivity {
    private Camera.Parameters parameter = null;
    private Camera camera = null;

    protected void camOn() {
        camera = Camera.open();
        camera.startPreview();
        parameter = camera.getParameters();
        parameter.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameter);
    }

    protected void camOff() {
        parameter = camera.getParameters();
        parameter.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameter);

        camera.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.torch);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        camOff();

        android.os.Debug.stopMethodTracing();
    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

        camOn();
    }
}
