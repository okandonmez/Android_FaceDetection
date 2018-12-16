package edmt.dev.androidfacedetection;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;

public class FaceDetection {


    public boolean detectFace(Context context, Bitmap myImage){
        com.google.android.gms.vision.face.FaceDetector faceDetector = new com.google.android.gms.vision.face.FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(com.google.android.gms.vision.face.FaceDetector.ALL_LANDMARKS)
                .setMode(com.google.android.gms.vision.face.FaceDetector.FAST_MODE)
                .build();

        if(!faceDetector.isOperational())
        {
            Toast.makeText(context, "Face Detector could not be set up on your device", Toast.LENGTH_SHORT).show();
        }

        int counter = 0;

        Frame frame = new Frame.Builder().setBitmap(myImage).build();
        SparseArray<Face> sparseArray = faceDetector.detect(frame);


        for(int i=0;i<sparseArray.size();i++)
        {
            Face face = sparseArray.valueAt(i);
           counter ++;

        }

        if (counter == 0)
            return false;
        else
            return true;

    }




}
