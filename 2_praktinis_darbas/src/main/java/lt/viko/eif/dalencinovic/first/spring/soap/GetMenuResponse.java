package lt.viko.eif.dalencinovic.first.spring.soap;

import jakarta.xml.bind.annotation.XmlRootElement;
import lt.viko.eif.dalencinovic.first.spring.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * SOAP response object containing menu items
 * of a selected restaurant.
 */
@XmlRootElement
public class GetMenuResponse {

    /**
     * List of menu items returned by the SOAP service.
     */
    private List<MenuItem> menu = new ArrayList<>();

    /**
     * Returns restaurant menu items.
     *
     * @return list of menu items
     */
    public List<MenuItem> getMenu() {
        return menu;
    }

    /**
     * Sets restaurant menu items.
     *
     * @param menu list of menu items
     */
    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }
}