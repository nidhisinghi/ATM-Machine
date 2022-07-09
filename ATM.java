package ATM_project;
import java.io.IOException;

import ATM_project.optionMenu.*;

public class ATM{
    public static void main(String[] args) throws IOException {
        optionMenu optionMenu = new optionMenu();

        optionMenu.getLogin();
    }    
}
