package dell.sampleapplication;

/**
 * Created by dell on 10-12-2017.
 */

public class DataModel {

    // Getter and Setter model for recycler view items
    private String title;
    private int image;

    public DataModel(String title,  int image) {

        this.title = title;

        this.image = image;
    }

    public String getTitle() {
        return title;
    }



    public int getImage() {
        return image;
    }
}
