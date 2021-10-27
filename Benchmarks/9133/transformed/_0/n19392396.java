class n19392396 {
	public void removeRecipe(Recipe gV2Eb6St) throws Exception {
		PreparedStatement F807zVnO = null;
		PreparedStatement w8Z7hVAW = null;
		PreparedStatement xYODVz1t = null;
		ResultSet APRDzYVI = null;
		try {
			int gM3ikgvS = -1;
			conn = getConnection();
			F807zVnO = conn.prepareStatement("SELECT recipe_id FROM recipes WHERE name = ? AND instructions = ? ");
			F807zVnO.setString(1, gV2Eb6St.getName());
			F807zVnO.setString(2, gV2Eb6St.getInstructions());
			APRDzYVI = F807zVnO.executeQuery();
			if (APRDzYVI.next()) {
				gM3ikgvS = APRDzYVI.getInt(1);
			}
			w8Z7hVAW = conn.prepareStatement("DELETE FROM ingredients WHERE recipe_id = ? ");
			xYODVz1t = conn.prepareStatement("DELETE FROM recipes WHERE recipe_id = ? ");
			w8Z7hVAW.setInt(1, gM3ikgvS);
			xYODVz1t.setInt(1, gM3ikgvS);
			w8Z7hVAW.executeUpdate();
			if (xYODVz1t.executeUpdate() > 0) {
				MainFrame.appendStatusText("Resepti poistettu kannasta");
			} else {
				MainFrame.appendStatusText("Resepti? poistettaessa tietokannasta tapahtui virhe");
			}
			conn.commit();
			MainFrame.recipePanel.update();
			MainFrame.recipePanel.update();
		} catch (Exception Sbn5T1po) {
			conn.rollback();
			MainFrame.appendStatusText("Can't remove recipe, the exception was " + Sbn5T1po.getMessage());
		} finally {
			try {
				if (APRDzYVI != null)
					APRDzYVI.close();
				APRDzYVI = null;
				if (F807zVnO != null)
					F807zVnO.close();
				F807zVnO = null;
				if (w8Z7hVAW != null)
					w8Z7hVAW.close();
				w8Z7hVAW = null;
				if (xYODVz1t != null)
					xYODVz1t.close();
				xYODVz1t = null;
			} catch (SQLException J5PtUxWR) {
				MainFrame.appendStatusText("Can't close database connection.");
			}
		}
	}

}