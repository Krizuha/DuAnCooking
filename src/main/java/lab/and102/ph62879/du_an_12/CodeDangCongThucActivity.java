package lab.and102.ph62879.du_an_12;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class CodeDangCongThucActivity extends AppCompatActivity {

    ImageView imgMonAn;

    Button btnChonAnh, btnDangCongThuc;

    TextInputEditText inputTenMon, inputDanhMuc, inputNguyenLieu, inputCachLam;

    private static final int PICK_IMAGE = 200;
    private Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_code_dang_cong_thuc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        InitUI();
        btnChonAnh.setOnClickListener(v -> {
            Intent pick = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pick, PICK_IMAGE);
        });

        btnDangCongThuc.setOnClickListener(v -> uploadRecipe());
    }

    private void uploadRecipe() {
        String tenMon = inputTenMon.getText().toString().trim();
        String danhMuc = inputDanhMuc.getText().toString().trim();
        String nguyenLieu = inputNguyenLieu.getText().toString().trim();
        String cachLam = inputCachLam.getText().toString().trim();

        if (tenMon.isEmpty() || danhMuc.isEmpty() || nguyenLieu.isEmpty() || cachLam.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin! ", Toast.LENGTH_SHORT).show();
            return;
        }

        if (imageUri == null) {
            Toast.makeText(this, "Vui lòng chọn ảnh món ăn! ", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Đăng công thức thành công!", Toast.LENGTH_SHORT).show();
    }


    private void InitUI() {
        imgMonAn = findViewById(R.id.imgMonAn);
        btnChonAnh = findViewById(R.id.btnChonAnh);
        btnDangCongThuc = findViewById(R.id.btnDangCongThuc);
        inputTenMon = findViewById(R.id.inputTenMon);
        inputDanhMuc = findViewById(R.id.inputDanhMuc);
        inputNguyenLieu = findViewById(R.id.inputNguyenLieu);
        inputCachLam = findViewById(R.id.inputCachLam);
    }

}