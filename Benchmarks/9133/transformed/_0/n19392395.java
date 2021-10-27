class n19392395 {
	private void updateIngredients(Recipe BeWTkiTU, int yMLa4W8y) throws Exception {
		PreparedStatement cMkpwwkA = null;
		PreparedStatement XYw4ArvR = null;
		try {
			conn = getConnection();
			cMkpwwkA = conn.prepareStatement("DELETE FROM ingredients WHERE recipe_id = ?");
			cMkpwwkA.setInt(1, yMLa4W8y);
			if (cMkpwwkA.executeUpdate() >= 0) {
				XYw4ArvR = conn.prepareStatement(
						"INSERT INTO ingredients (recipe_id, name, amount, measure_id, shop_flag) VALUES (?,?,?,?,?)");
				IngredientContainer k940drSW = BeWTkiTU.getIngredients();
				Ingredient WmlsT5cz = null;
				Iterator q3nr4GHf;
				for (q3nr4GHf = k940drSW.getIngredients().iterator(); q3nr4GHf.hasNext();) {
					WmlsT5cz = (Ingredient) q3nr4GHf.next();
					XYw4ArvR.setInt(1, yMLa4W8y);
					XYw4ArvR.setString(2, WmlsT5cz.getName());
					XYw4ArvR.setDouble(3, WmlsT5cz.getAmount());
					XYw4ArvR.setInt(4, WmlsT5cz.getType());
					XYw4ArvR.setInt(5, WmlsT5cz.getShopFlag());
					XYw4ArvR.executeUpdate();
				}
			}
			conn.commit();
		} catch (Exception j8uW89Wv) {
			conn.rollback();
			MainFrame.appendStatusText("Can't add ingredient, the exception was " + j8uW89Wv.getMessage());
		} finally {
			try {
				if (cMkpwwkA != null)
					cMkpwwkA.close();
				cMkpwwkA = null;
				if (XYw4ArvR != null)
					XYw4ArvR.close();
				XYw4ArvR = null;
			} catch (Exception unQ120HS) {
				MainFrame.appendStatusText("Can't close database connection.");
			}
		}
	}

}