class n19392394 {
	public int editRecipe(int oldRecipeId, Recipe newRecipe) throws Exception {
		PreparedStatement pst2 = null;
		PreparedStatement pst1 = null;
		int retVal = -1;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pst1 = conn.prepareStatement(
					"UPDATE recipes SET name = ?, instructions = ?, category_id =? WHERE recipe_id = ?");
			pst1.setString(1, newRecipe.getName());
			pst1.setString(2, newRecipe.getInstructions());
			pst1.setInt(3, newRecipe.getCategoryId());
			pst1.setInt(4, oldRecipeId);
			int rsVal = pst1.executeUpdate();
			conn.commit();
			if (rsVal > 0) {
				updateIngredients(newRecipe, oldRecipeId);
				MainFrame.recipePanel.update();
				retVal = oldRecipeId;
			} else {
				retVal = -1;
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw new Exception("Can't edit recipe, the exception was " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst1 != null)
					pst1.close();
				rs = null;
				if (pst2 != null)
					pst2.close();
				pst1 = null;
				pst2 = null;
			} catch (SQLException sqle) {
				MainFrame.appendStatusText("Can't close database connection.");
			}
		}
		return retVal;
	}

}