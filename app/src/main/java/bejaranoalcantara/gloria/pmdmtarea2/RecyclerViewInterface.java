package bejaranoalcantara.gloria.pmdmtarea2;

/**
 * Interfaz para manejar lo clics en los elementos del Recyclerview
 */

public interface RecyclerViewInterface {

    /**
     * Se ejecuta cuando se hace click en un elemento del RecyclerView
     * @param position devuelve la posicion de elemento en el que se hizo click
     */
    void onItemClick(int position);

}
