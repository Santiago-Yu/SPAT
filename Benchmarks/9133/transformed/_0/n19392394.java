class n19392394 {
	public int editRecipe(int dkwvyq4u, Recipe PTudJN7p) throws Exception {
		PreparedStatement u5T7KwgH = null;
		PreparedStatement UNexgUFe = null;
		ResultSet AJJV7qPI = null;
		int WOvtdYeN = -1;
		try {
			conn = getConnection();
			u5T7KwgH = conn.prepareStatement(
					"UPDATE recipes SET name = ?, instructions = ?, category_id =? WHERE recipe_id = ?");
			u5T7KwgH.setString(1, PTudJN7p.getName());
			u5T7KwgH.setString(2, PTudJN7p.getInstructions());
			u5T7KwgH.setInt(3, PTudJN7p.getCategoryId());
			u5T7KwgH.setInt(4, dkwvyq4u);
			int dGSztprj = u5T7KwgH.executeUpdate();
			conn.commit();
			if (dGSztprj > 0) {
				updateIngredients(PTudJN7p, dkwvyq4u);
				MainFrame.recipePanel.update();
				WOvtdYeN = dkwvyq4u;
			} else {
				WOvtdYeN = -1;
			}
			conn.commit();
		} catch (Exception bLkpIvDm) {
			conn.rollback();
			throw new Exception("Can't edit recipe, the exception was " + bLkpIvDm.getMessage());
		} finally {
			try {
				if (AJJV7qPI != null)
					AJJV7qPI.close();
				AJJV7qPI = null;
				if (u5T7KwgH != null)
					u5T7KwgH.close();
				u5T7KwgH = null;
				if (UNexgUFe != null)
					UNexgUFe.close();
				UNexgUFe = null;
			} catch (SQLException FdXwE9FU) {
				MainFrame.appendStatusText("Can't close database connection.");
			}
		}
		return WOvtdYeN;
	}

}