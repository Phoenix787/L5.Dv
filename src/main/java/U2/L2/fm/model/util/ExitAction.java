package U2.L2.fm.model.util;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Сергеева on 25.03.2016.
 */
public class ExitAction extends AbstractAction {

    public ExitAction() {
        putValue(NAME, "Выход");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
