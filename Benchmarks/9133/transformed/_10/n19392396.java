class n19392396 {
	public void removeRecipe(Recipe recipe) throws Exception {
		PreparedStatement pst2 = null;
		PreparedStatement pst1 = null;
		ResultSet rs = null;
		PreparedStatement pst3 = null;
		try {
			conn = getConnection();
			int id = -1;
			pst1 = conn.prepareStatement("SELECT recipe_id FROM recipes WHERE name = ? AND instructions = ? ");
			pst1.setString(1, recipe.getName());
			pst1.setString(2, recipe.getInstructions());
			rs = pst1.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			pst2 = conn.prepareStatement("DELETE FROM ingredients WHERE recipe_id = ? ");
			pst3 = conn.prepareStatement("DELETE FROM recipes WHERE recipe_id = ? ");
			pst2.setInt(1, id);
			pst3.setInt(1, id);
			pst2.executeUpdate();
			if (pst3.executeUpdate() > 0) {
				MainFrame.appendStatusText("Resepti poistettu kannasta");
			} else {
				MainFrame.appendStatusText("Resepti? poistettaessa tietokannasta tapahtui virhe");
			}
			conn.commit();
			MainFrame.recipePanel.update();
			MainFrame.recipePanel.update();
		} catch (Exception e) {
			conn.rollback();
			MainFrame.appendStatusText("Can't remove recipe, the exception was " + e.getMessage());
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
				if (pst3 != null)
					pst3.close();
				pst2 = null;
				pst3 = null;
			} catch (SQLException sqle) {
				MainFrame.appendStatusText("Can't close database connection.");
			}
		}
	}

}