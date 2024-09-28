public class Landmark {
    public int imageResId;
    public String name;

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Landmark(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }
}
