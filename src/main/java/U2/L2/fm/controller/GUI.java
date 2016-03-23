package U2.L2.fm.controller;

import java.util.Set;

/**
 * Created by Ксения on 18.03.2016.
 */
public interface GUI {
    boolean authenticate(String username, String password);

    boolean register(String username, String password);
    Set<String> getNames();

    String getOwner();


}
