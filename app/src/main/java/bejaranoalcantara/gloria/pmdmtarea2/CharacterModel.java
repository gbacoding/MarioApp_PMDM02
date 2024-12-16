package bejaranoalcantara.gloria.pmdmtarea2;

/**
 * Modelo de datos que representa un personaje con un nombre y una imagen.
 */
public class CharacterModel {

    /** Nombre del personaje. */
    private String characterName;

    /** ID del recurso drawable asociado a la imagen del personaje. */
    private int image;

    private String characterDescription;
    private String characterSkills;

    /**
     * Constructor para crear una instancia de CharacterModel.
     *
     * @param characterName el nombre del personaje.
     * @param image el ID del recurso drawable de la imagen del personaje.
     * @param description descripcion del personaje
     * @param skills skills del personaje
     *
     */
    public CharacterModel(String characterName, int image, String description, String skills) {
        this.characterName = characterName;
        this.image = image;
        this.characterDescription = description;
        this.characterSkills = skills;
    }

    /**
     * Devuelve el nombre del personaje.
     *
     * @return el nombre del personaje.
     */
    public String getCharacterName() {
        return characterName;
    }

    /**
     * Devuelve el ID del recurso drawable de la imagen del personaje.
     *
     * @return el ID del recurso drawable de la imagen.
     */
    public int getImage() {
        return image;
    }

    public String getDescription() {
        return characterDescription;
    }

    public String getSkills() {
        return characterSkills;
    }
}
