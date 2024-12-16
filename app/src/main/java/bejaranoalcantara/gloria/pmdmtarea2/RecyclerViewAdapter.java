package bejaranoalcantara.gloria.pmdmtarea2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Adaptador personalizado RecyclerView que muestra una lista de personajes.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    /** Contexto de la actividad o fragmnto donde se utiliza el RecyclerView. */
   Context context;
    /** Lista de modelos de datos de representacion de personajes
     * que se mostrarán en el RecyclerView. */
   ArrayList<CharacterModel> characterModels;

    /**
     * Constructor para inicializar el adaptador con un contexto y una lista de personajes.
     *
     * @param context el contexto donde se usará el RecyclerView.
     * @param characterModels la lista de modelos de personajes.
     */
   public RecyclerViewAdapter (Context context, ArrayList<CharacterModel> characterModels,
                               RecyclerViewInterface recyclerViewInterface){
       this.context=context;
       this.characterModels=characterModels;
       this.recyclerViewInterface = recyclerViewInterface;
   }

    /**
     * Infla el diseño de cada elemento del RecyclerView.
     * Inflar significa convertir un archivo XML de diseño en una jerarquía de vistas (un objeto View)
     * que se puede manipular y mostrar en la pantalla mediante código.
     *
     * @param parent el ViewGroup padre al que se añadirá la vista inflada.
     * @param viewType el tipo de vista (en este caso no se usa porque todas las vistas son iguales).
     * @return un nuevo ViewHolder que contiene la vista inflada o View del xml convertido.
     */
    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_mainactivity_row_model, parent, false);
        return new RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    /**
     * Asigna datos a los elementos visuales en una posición específica del RecyclerView.
     * se llama cada vez que el RecyclerView necesita mostrar datos en una vista existente
     * que ya ha sido creada (por onCreateViewHolder) o reciclada
     *
     * @param holder el ViewHolder que contiene las vistas para un elemento.
     * @param position la posición del elemento en la lista characterModels
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
    holder.name.setText(characterModels.get(position).getCharacterName());
    holder.imageView.setImageResource(characterModels.get(position).getImage());

    }

    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return el tamaño de la lista de modelos de personajes.
     */
    @Override
    public int getItemCount() {
        // The recycler view just wants to know the number of items you want displayed
        return characterModels.size();
    }

    /**
     * Clase interna que representa el ViewHolder para un elemento del RecyclerView.
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        /** Imagen del personaje. */
        ImageView imageView;
        /** Nombre del personaje. */
        TextView name;

        /**
         * Constructor del ViewHolder que enlaza las vistas del diseño.
         *
         * @param itemView la vista inflada para un elemento del RecyclerView.
         */
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
        // Asocia las vistas del diseño con los atributos del ViewHolder
        imageView = itemView.findViewById(R.id.imageview_mario);
        name = itemView.findViewById(R.id.textView_mario_name);

        // Attached our listener to or RecyclerView
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // verificar que la instancia de recyclerViewInterface no es nula
                if (recyclerViewInterface != null) {
                    //obtener posicion del elemento clickado
                    int position = getAdapterPosition();
                    //llamada al metodo onItemClick() si la posicion es valida
                    if (position != RecyclerView.NO_POSITION){
                       recyclerViewInterface.onItemClick(position);
                    }
                }
            }
        });
        }
    }
}