package lab.and102.ph62879.du_an_12;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class EditProfileActivity extends AppCompatActivity {


    ImageView imgAvatar;
    Button btnChangeAvatar, btnSave, btnCancel;
    TextInputEditText inputName, inputEmail, inputAddress, inputPhone;
    RadioGroup groupGender;
    RadioButton rbMale, rbFemale;

    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        InitUI();


        btnChangeAvatar.setOnClickListener(v -> {
            Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickImage, PICK_IMAGE);
        });

        btnSave.setOnClickListener( v -> saveProfile());
        btnCancel.setOnClickListener(v -> finish());
    }


    protected void onActivityResuit(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            imageUri = data.getData();
            imgAvatar.setImageURI(imageUri);
        }

    }

    private void saveProfile() {
        String name = inputName.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String address = inputAddress.getText().toString().trim();
        String phone = inputPhone.getText().toString().trim();

        String gender = rbMale.isChecked() ? "Nam" : rbFemale.isChecked() ? "Nữ" : "";

        Toast.makeText(this, "Save completed!", Toast.LENGTH_SHORT);


    }



    private void InitUI() {
        imgAvatar = findViewById(R.id.imgAvatar);
        btnChangeAvatar = findViewById(R.id.btnChangeAvatar);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        inputAddress = findViewById(R.id.inputAddress);
        inputPhone = findViewById(R.id.inputPhone);

        groupGender = findViewById(R.id.groupGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
    }
}