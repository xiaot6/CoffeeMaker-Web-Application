package edu.ncsu.csc326.coffeemaker.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class InventoryDB{

  public static boolean addInventory(int coffee, int milk, int sugar, int chocolate){
    DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
    boolean inventoryAdded = false;
    try{
      conn = db.getConnection();
      stmt = conn.prepareStatement("INSERT INTO inventory VALUES(?,?,?,?)");
      stmt.setInt(1, coffee);
      stmt.setInt(2, milk);
      stmt.setInt(3, sugar);
      stmt.setInt(4, chocolate);
      int updated = stmt.executeUpdate();
      if(updated == 1){
        inventoryAdded = true;
      }
    } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
		return inventoryAdded;
	}


  public static boolean useInventory(int coffee, int milk, int sugar, int chocolate){
    DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
    boolean inventoryUsed = false;
    try{
      conn = db.getConnection();
      stmt = conn.prepareStatement("INSERT INTO inventory VALUES(?,?,?,?)");
      stmt.setInt(1, -coffee);
      stmt.setInt(2, -milk);
      stmt.setInt(3, -sugar);
      stmt.setInt(4, -chocolate);
      int updated = stmt.executeUpdate();
      if(updated == 1){
        inventoryUsed = true;
      }
    } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
		return inventoryUsed;
  }



	public static int[] checkInventory() {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		int ans[] = new int[4];
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("SELECT sum(coffee) AS sum_coffee, sum(milk) AS sum_milk, sum(sugar) AS sum_sugar,sum(chocolate) AS sum_chocolate FROM inventory");
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				ans[0] = rs.getInt("sum_coffee");
				ans[1] = rs.getInt("sum_milk");
				ans[2] = rs.getInt("sum_sugar");
				ans[3] = rs.getInt("sum_chocolate");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}

		return ans;
	}
  public static void resetInventory(){
    DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
    int[] ans = new int[4];
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("DELETE FROM inventory WHERE name ='coffee' OR name = 'milk' OR name = 'sugar' OR name = 'chocolate'");
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
  }
}

