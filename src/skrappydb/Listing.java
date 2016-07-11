/*
 Listing class to hold seperate listings
 */
package skrappydb;

public class Listing {

    private String headline; 
    private String source; 
    private String date; 
    private String fullURL;
    
    public Listing(String headline,String source, String date)
    {
        this.headline = headline; 
        this.source = source; 
        this.date = date; 
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFullURL() {
        return fullURL;
    }

    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }
    
}
