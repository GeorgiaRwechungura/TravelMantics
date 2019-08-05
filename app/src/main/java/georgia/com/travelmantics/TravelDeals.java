package georgia.com.travelmantics;

import java.io.Serializable;

public class TravelDeals implements Serializable {
    private String id;
    private  String tille;
    private  String description;
    private  String price;
    private String ImageUrl;

    public TravelDeals(){}

    public TravelDeals( String tille, String description, String price,String imageUrl) {
        this.setId(id);
        this.setTille(tille);
        this.setDescription(description);
        this.setPrice(price);
        setImageUrl(imageUrl);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTille() {
        return tille;
    }

    public void setTille(String tille) {
        this.tille = tille;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
