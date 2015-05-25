
package TZTBackOffice;

/**
 *
 * @author Twan
 */
public interface Refreshable {
    
    //Zorgt ervoor dat de refreshable zich aanpast aan de nieuwe gegevens uit de database.
    public void refresh();
}
