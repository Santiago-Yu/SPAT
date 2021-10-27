class n19392393 {
	private void addIngredients(Recipe q57YOJp4, int dNr17pmy) throws Exception {
		PreparedStatement qjj9573a = null;
		try {
			conn = getConnection();
			qjj9573a = conn.prepareStatement(
					"INSERT INTO ingredients (recipe_id, name, amount, measure_id, shop_flag) VALUES (?,?,?,?,?)");
			IngredientContainer lnieXPEi = q57YOJp4.getIngredients();
			Ingredient Rq4tNNIh = null;
			Iterator cOY9Hyvx;
			for (cOY9Hyvx = lnieXPEi.getIngredients().iterator(); cOY9Hyvx.hasNext();) {
				Rq4tNNIh = (Ingredient) cOY9Hyvx.next();
				qjj9573a.setInt(1, dNr17pmy);
				qjj9573a.setString(2, Rq4tNNIh.getName());
				qjj9573a.setDouble(3, Rq4tNNIh.getAmount());
				qjj9573a.setInt(4, Rq4tNNIh.getType());
				qjj9573a.setInt(5, Rq4tNNIh.getShopFlag());
				qjj9573a.executeUpdate();
			}
			conn.commit();
		} catch (Exception o7jFjeli) {
			conn.rollback();
			MainFrame.appendStatusText("Can't add ingredient, the exception was " + o7jFjeli.getMessage());
		} finally {
			try {
				if (qjj9573a != null)
					qjj9573a.close();
				qjj9573a = null;
			} catch (Exception nYXGQl3g) {
				MainFrame.appendStatusText("Can't close database connection.");
			}
		}
	}

}