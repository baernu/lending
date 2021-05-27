package admin;

import java.util.logging.Logger;

import persistence.DAOFactory;
import persistence.DataManager;



public class Administration {
private static final Logger LOGGER = Logger.getLogger(Administration.class.getName());
private DataManager dataManager;
private DAOFactory daoFactory;
private LendingManager lendingManager;
}
