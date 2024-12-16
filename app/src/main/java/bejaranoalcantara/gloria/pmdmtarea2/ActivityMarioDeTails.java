package bejaranoalcantara.gloria.pmdmtarea2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityMarioDeTails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mario_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra esta actividad y regresa a la principal
            }
        });

        // Inicializar vistas
        TextView nameTextView = findViewById(R.id.textview_mario_name_details);
        ImageView characterImageView = findViewById(R.id.imageview_mario_details);
        TextView descriptionTextView = findViewById(R.id.textview_mario_description_details);
        TextView skillsTextView = findViewById(R.id.textview_mario_skills_details);

        // Obtener los datos pasados por el Intent
        String characterName = getIntent().getStringExtra("name");
        int characterImage = getIntent().getIntExtra("image", 0);
        String characterDescription = getIntent().getStringExtra("description");
        String characterSkills = getIntent().getStringExtra("skills");

        // Asignar los datos a las vistas
        nameTextView.setText(characterName);  // Nombre del personaje
        characterImageView.setImageResource(characterImage);  // Imagen del personaje
        descriptionTextView.setText(characterDescription);  // Descripción del personaje
        skillsTextView.setText(characterSkills);  // Habilidades del personaje

    }


}