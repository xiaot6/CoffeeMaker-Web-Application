package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.db.InventoryDB;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Sarah Heckman
 *
 * Inventory for the coffee maker
 */
public class Inventory {

    // private static int coffee;
    // private static int milk;
    // private static int sugar;
    // private static int chocolate;

    /**
     * Creates a coffee maker inventory object and
     * fills each item in the inventory with 15 units.
     */
    public Inventory() {
      InventoryDB.resetInventory();
    	setCoffee(15);
    	setMilk(15);
    	setSugar(15);
    	setChocolate(15);
    }

    /**
     * Returns the current number of chocolate units in
     * the inventory.
     * @return int
     */
    public int getChocolate() {
        // InventoryDB InventoryDB = new InventoryDB();
        return InventoryDB.checkInventory()[3];
        // return chocolate;
    }

    /**
     * Sets the number of chocolate units in the inventory
     * to the specified amount.
     * @param chocolate
     */
    public synchronized void setChocolate(int chocolate) {
    	if(chocolate >= 0) {
    		// InventoryDB InventoryDB = new InventoryDB();
        int cur_amount = getChocolate();
        InventoryDB.addInventory(0,0,0,-cur_amount);
        InventoryDB.addInventory(0,0,0,chocolate);
    	}

    }

    /**
     * Add the number of chocolate units in the inventory
     * to the current amount of chocolate units.
     * @param chocolate
     * @throws InventoryException
     */
    public synchronized void addChocolate(String chocolate) throws InventoryException {
    	int amtChocolate = 0;
    	try {
    		amtChocolate = Integer.parseInt(chocolate);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Units of chocolate must be a positive integer");
    	}
		if (amtChocolate >= 0) {
      // InventoryDB InventoryDB = new InventoryDB();
      InventoryDB.addInventory(0,0,0,amtChocolate);
		} else {
			throw new InventoryException("Units of chocolate must be a positive integer");
		}
    }

    /**
     * Returns the current number of coffee units in
     * the inventory.
     * @return int
     */
    public int getCoffee() {
      // InventoryDB InventoryDB = new InventoryDB();
      return InventoryDB.checkInventory()[0];
    }

    /**
     * Sets the number of coffee units in the inventory
     * to the specified amount.
     * @param coffee
     */
    public synchronized void setCoffee(int coffee) {
    	if(coffee >= 0) {
    		// Inventory.coffee = coffee;
        // InventoryDB InventoryDB = new InventoryDB();
        int cur_amount = getCoffee();
        InventoryDB.addInventory(-cur_amount, 0,0,0);
        InventoryDB.addInventory(coffee, 0,0,0);
    	}
    }

    /**
     * Add the number of coffee units in the inventory
     * to the current amount of coffee units.
     * @param coffee
     * @throws InventoryException
     */
    public synchronized void addCoffee(String coffee) throws InventoryException {
    	int amtCoffee = 0;
    	try {
    		amtCoffee = Integer.parseInt(coffee);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Units of coffee must be a positive integer");
    	}
		if (amtCoffee >= 0) {
			// Inventory.coffee += amtCoffee;
      // InventoryDB InventoryDB = new InventoryDB();
      InventoryDB.addInventory(amtCoffee,0,0,0);
		} else {
			throw new InventoryException("Units of coffee must be a positive integer");
		}
    }

    /**
     * Returns the current number of milk units in
     * the inventory.
     * @return int
     */
    public int getMilk() {
        // return milk;
        InventoryDB InventoryDB = new InventoryDB();
        return InventoryDB.checkInventory()[1];
    }

    /**
     * Sets the number of milk units in the inventory
     * to the specified amount.
     * @param milk
     */
    public synchronized void setMilk(int milk) {
    	if(milk >= 0) {
    		// Inventory.milk = milk;
        // InventoryDB InventoryDB = new InventoryDB();
        int cur_amount = getMilk();
        InventoryDB.addInventory(0,-cur_amount,0,0);
        InventoryDB.addInventory(0,milk, 0,0);
    	}
    }

    /**
     * Add the number of milk units in the inventory
     * to the current amount of milk units.
     * @param milk
     * @throws InventoryException
     */
    public synchronized void addMilk(String milk) throws InventoryException {
    	int amtMilk = 0;
    	try {
    		amtMilk = Integer.parseInt(milk);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Units of milk must be a positive integer");
    	}
		if (amtMilk >= 0) {
			// Inventory.milk += amtMilk;
      // InventoryDB InventoryDB = new InventoryDB();
      InventoryDB.addInventory(0,amtMilk,0,0);
		} else {
			throw new InventoryException("Units of milk must be a positive integer");
		}
    }

    /**
     * Returns the current number of sugar units in
     * the inventory.
     * @return int
     */
    public int getSugar() {
        // return sugar;
        // InventoryDB InventoryDB = new InventoryDB();
        return InventoryDB.checkInventory()[2];
    }

    /**
     * Sets the number of sugar units in the inventory
     * to the specified amount.
     * @param sugar
     */
    public synchronized void setSugar(int sugar) {
    	if(sugar >= 0) {
    		// Inventory.sugar = sugar;
        // InventoryDB InventoryDB = new InventoryDB();
        int cur_amount = getSugar();
        InventoryDB.addInventory(0,0,-cur_amount, 0);
        InventoryDB.addInventory(0,0,sugar,0);
    	}
    }

    /**
     * Add the number of sugar units in the inventory
     * to the current amount of sugar units.
     * @param sugar
     * @throws InventoryException
     */
    public synchronized void addSugar(String sugar) throws InventoryException {
    	int amtSugar = 0;
    	try {
    		amtSugar = Integer.parseInt(sugar);
    	} catch (NumberFormatException e) {
    		throw new InventoryException("Units of sugar must be a positive integer");
    	}
		if (amtSugar >= 0) {
			// Inventory.sugar += amtSugar;
      // InventoryDB InventoryDB = new InventoryDB();
      InventoryDB.addInventory(0,0,amtSugar,0);
		} else {
			throw new InventoryException("Units of sugar must be a positive integer");
		}
    }

    /**
     * Returns true if there are enough ingredients to make
     * the beverage.
     * @param r
     * @return boolean
     */
    protected synchronized boolean enoughIngredients(Recipe r) {
        // boolean isEnough = true;
        // InventoryDB InventoryDB = new InventoryDB();
        int[] cur_inven = InventoryDB.checkInventory();
        if(cur_inven[0] < r.getAmtCoffee()) {
          return false;
        }
        if(cur_inven[1] < r.getAmtMilk()) {
            return false;
        }
        if(cur_inven[2] < r.getAmtSugar()) {
            return false;
        }
        if(cur_inven[3] < r.getAmtChocolate()) {
            return false;
        }
        return true;
    }

    /**
     * Removes the ingredients used to make the specified
     * recipe.  Assumes that the user has checked that there
     * are enough ingredients to make
     * @param r
     */
    public synchronized boolean useIngredients(Recipe r) {
    	if (enoughIngredients(r)) {
        // InventoryDB InventoryDB = new InventoryDB();
        InventoryDB.useInventory(r.getAmtCoffee(),r.getAmtMilk(),r.getAmtSugar(),r.getAmtChocolate());
	    	// Inventory.coffee -= r.getAmtCoffee();
	    	// Inventory.milk -= r.getAmtMilk();
	    	// Inventory.sugar -= r.getAmtSugar();
	    	// Inventory.chocolate -= r.getAmtChocolate();
	    	return true;
    	} else {
    		return false;
    	}
    }

    /**
     * Returns a string describing the current contents
     * of the inventory.
     * @return String
     */
    public String toString() {
    	StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(getCoffee());
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(getMilk());
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(getSugar());
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(getChocolate());
    	buf.append("\n");
    	return buf.toString();
    }
}

