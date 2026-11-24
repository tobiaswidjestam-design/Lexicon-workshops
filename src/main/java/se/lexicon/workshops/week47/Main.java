package se.lexicon.workshops.week47;

import se.lexicon.workshops.week47.controller.ContactController;
import se.lexicon.workshops.week47.data.ContactDAO;
import se.lexicon.workshops.week47.data.FileContactDAOImpl;
import se.lexicon.workshops.week47.exception.ExceptionHandler;
import se.lexicon.workshops.week47.view.ContactView;
import se.lexicon.workshops.week47.data.JdbcContactDAOImpl;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args){
        ContactDAO contactDAO = new JdbcContactDAOImpl();
        ContactController controller = new ContactController(contactDAO, new ContactView(), new ExceptionHandler());

        controller.run();
    }
}
