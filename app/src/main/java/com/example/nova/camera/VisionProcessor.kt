package com.example.nova.camera

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.tasks.await

class VisionProcessor(private val context: Context) {
    
    private val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    suspend fun processImage(imageProxy: ImageProxy): String {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            return try {
                val result = recognizer.process(image).await()
                Log.d("VisionProcessor", "OCR Result: ${result.text}")
                result.text
            } catch (e: Exception) {
                Log.e("VisionProcessor", "OCR failed", e)
                ""
            } finally {
                imageProxy.close()
            }
        } else {
             imageProxy.close()
        }
        return ""
    }
}
