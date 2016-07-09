/*
 *  Class will hold a Map list of returned listings for mutibility
 */
package skrappydb;

import javafx.scene.control.TableView;


public class ListingBook {

    private Listing lists;
    private TableView<Listing> listingBook;
    
    public ListingBook()
    {
        listingBook = new TableView<>(); 
    }
    
    public void addListing(Listing list)
    {
        listingBook.getItems().add(list);
    }
    
    
    
}
