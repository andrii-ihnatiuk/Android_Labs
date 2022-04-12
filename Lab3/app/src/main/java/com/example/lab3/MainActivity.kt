package com.example.lab3
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.lab3.databinding.ActivityMainBinding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var photoURI: Uri
    private lateinit var cameraLauncher: ActivityResultLauncher<Uri>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val photoBox = binding.photo

        // Using Activity Result API to start camera activity and handle result
        cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()) {
            when (it) {
                true -> photoBox.setImageURI(photoURI)
                false -> Toast.makeText(this, "Operation was canceled!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnPhoto.setOnClickListener {
            captureImage()
        }

        binding.btnSend.setOnClickListener {
            if (photoBox.drawable == null) {
                Toast.makeText(this, "Take a photo first!", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(Intent.ACTION_SEND)

                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hodovychenko.labs@gmail.com"))
                intent.putExtra(Intent.EXTRA_SUBJECT, "КПП УІ-191 Ігнатюк")
                intent.putExtra(Intent.EXTRA_TEXT, "Sending nudes")
                intent.putExtra(Intent.EXTRA_STREAM, photoURI)
                intent.type = "message/rfc822"

                try {
                    startActivity(Intent.createChooser(intent, "Select an application"))
                }
                catch (ex: ActivityNotFoundException) {
                    Toast.makeText(this, "No supported application", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @Throws(IOException::class)
    private fun getImageFile(): File {
        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageName = "jpg_$timestamp"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        return File.createTempFile(imageName, ".jpg", storageDir)
    }

    private fun captureImage() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (intent.resolveActivity(packageManager) != null) {
            val imageFile: File? = try {
                getImageFile()
            } catch (ex: IOException) {
                Toast.makeText(this, "Error occurred while creating file!", Toast.LENGTH_SHORT).show()
                null
            }

            if (imageFile != null) {
                val imageURI = FileProvider.getUriForFile(
                    this,
                    "com.example.android.fileprovider",
                    imageFile)
                photoURI = imageURI

                cameraLauncher.launch(imageURI)
            }
        }
        else Toast.makeText(this, "No supported application", Toast.LENGTH_SHORT).show()

    }
}