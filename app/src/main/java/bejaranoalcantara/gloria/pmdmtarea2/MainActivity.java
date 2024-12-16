package bejaranoalcantara.gloria.pmdmtarea2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/**
 * La actividad principal de la aplicación que gestiona la visualización de una lista
 * de personajes en un RecyclerView. Esta actividad configura el adaptador y el diseño
 * para mostrar los personajes con sus imágenes y nombres.
 */

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    // Lista que contendrá los modelos de personajes
    ArrayList<CharacterModel> characterModels = new ArrayList<>();
    // Array de imágenes de los personaje
    int[] characterImages = {
            R.drawable.mario_face,
            R.drawable.luigi,
            R.drawable.princess_peach,
            R.drawable.toad
    };

    /**
     * Este método es llamado cuando la actividad es creada. Se encarga de establecer
     * el contenido de la actividad, aplicar configuraciones de diseño sin bordes
     * y configurar el RecyclerView con su adaptador.
     *
     * @param savedInstanceState El estado guardado de la actividad, si existe.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Habilita el diseño sin bordes para que la actividad ocupe toda la pantalla
        EdgeToEdge.enable(this);
        // Establece el diseño de la actividad desde el archivo XML
        setContentView(R.layout.activity_main);
        // Aplica un padding para las barras del sistema (barra de estado y de navegación)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Obtiene los márgenes de las barras del sistema
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar la Toolbar como ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // RecyclerView
            // Obtiene el RecyclerView desde el XML
            RecyclerView recyclerViewList = findViewById(R.id.recyclerview_charactersList);
            // Inicializa la lista de modelos de personajes
            setUpCharacterModels();

            // Crea el adaptador y asigna la lista de personajes
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,characterModels, this);
            // Asigna el adaptador al RecyclerView
            recyclerViewList.setAdapter(adapter);

            // Establece un LayoutManager para que los elementos se muestren en una lista vertical
            recyclerViewList.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Inicializa la lista de modelos de personajes con los nombres de personajes y
     * las imágenes correspondientes.
     */
    private void setUpCharacterModels(){
        // Obtiene los nombres de los personajes desde los recursos (strings.xml)
        String[] characterNames = getResources().getStringArray(R.array.array_characters);
        String[] characterDescriptions = getResources().getStringArray(R.array.array_character_descriptions);  // Nuevo arreglo para descripciones
        String[] characterSkills = getResources().getStringArray(R.array.array_character_skills);  // Nuevo arreglo para habilidades


        // Agrega cada personaje con su nombre y su imagen correspondiente
        for (int i=0;i<characterNames.length;i++){
            // Crea un nuevo modelo de personaje y lo agrega a la lista
            characterModels.add(new CharacterModel(
                    characterNames[i],
                    characterImages[i],
                    characterDescriptions[i],
                    characterSkills[i]
            ));
        }
    }

    @Override
    public void onItemClick(int position) {
        // Obtener el personaje clickeado
        CharacterModel clickedCharacter = characterModels.get(position);

        // Crear un Intent para abrir la actividad de detalles
        Intent intent = new Intent(MainActivity.this, ActivityMarioDeTails.class);

        // Pasar los datos del personaje al Intent
        intent.putExtra("name", clickedCharacter.getCharacterName());
        intent.putExtra("image", clickedCharacter.getImage());
        intent.putExtra("description", clickedCharacter.getDescription());
        intent.putExtra("skills", clickedCharacter.getSkills());  // También pasar habilidades

        // Iniciar la actividad de detalles
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menú en la Toolbar
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    /**
     * Funcionalidad menu contextual
     * @param item
     * @return
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            new AlertDialog.Builder(this)
                    .setTitle("Acerca de...")
                    .setMessage("Aplicación desarrollada por Gloria Bejarano Alcantara. Versión 1.0.")
                    .setIcon(R.mipmap.mariowebp)
                    .setPositiveButton("Aceptar", null)
                    .show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}