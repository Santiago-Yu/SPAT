class n19392392 {
	public int addRecipe(Recipe EvwHLUo3) throws Exception {
		PreparedStatement YbmT75gJ = null;
		PreparedStatement YV3kOvIT = null;
		ResultSet uQO5WGUA = null;
		int vsI1SYey = -1;
		try {
			conn = getConnection();
			YbmT75gJ = conn.prepareStatement("INSERT INTO recipes (name, instructions, category_id) VALUES (?, ?, ?)");
			YbmT75gJ.setString(1, EvwHLUo3.getName());
			YbmT75gJ.setString(2, EvwHLUo3.getInstructions());
			YbmT75gJ.setInt(3, EvwHLUo3.getCategoryId());
			if (YbmT75gJ.executeUpdate() > 0) {
				YV3kOvIT = conn.prepareStatement(
						"SELECT recipe_id FROM recipes WHERE name = ? AND instructions = ? AND category_id = ?");
				YV3kOvIT.setString(1, EvwHLUo3.getName());
				YV3kOvIT.setString(2, EvwHLUo3.getInstructions());
				YV3kOvIT.setInt(3, EvwHLUo3.getCategoryId());
				uQO5WGUA = YV3kOvIT.executeQuery();
				conn.commit();
				if (uQO5WGUA.next()) {
					int SuGXNMr4 = uQO5WGUA.getInt(1);
					addIngredients(EvwHLUo3, SuGXNMr4);
					MainFrame.recipePanel.update();
					vsI1SYey = SuGXNMr4;
				} else {
					vsI1SYey = -1;
				}
			} else {
				vsI1SYey = -1;
			}
			conn.commit();
		} catch (Exception jyUNjT4K) {
			conn.rollback();
			MainFrame.appendStatusText("Can't add recipe, the exception was " + jyUNjT4K.getMessage());
		} finally {
			try {
				if (uQO5WGUA != null)
					uQO5WGUA.close();
				uQO5WGUA = null;
				if (YbmT75gJ != null)
					YbmT75gJ.close();
				YbmT75gJ = null;
				if (YV3kOvIT != null)
					YV3kOvIT.close();
				YV3kOvIT = null;
			} catch (SQLException d8WcL6Gb) {
				MainFrame.appendStatusText("Can't close database connection.");
			}
		}
		return vsI1SYey;
	}

}