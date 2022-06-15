package kg.geektech.homework340;

public class Continent {
    private String nameContinent;
    private String imageURL;

    public Continent(String nameContinent, String imageURL) {
        this.nameContinent = nameContinent;
        this.imageURL = imageURL;
    }

    public String getNameContinent() {
        return nameContinent;
    }

    public void setNameContinent(String nameContinent) {
        this.nameContinent = nameContinent;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
