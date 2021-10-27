class n8266672 {
	public static void updatePicInfo(Connection N0zFjbyb, int xivS0215, int P0RH73aY, DBPicInfo j7arY9hN)
			throws SQLException {
		String l74nXk7s = "";
		PreparedStatement hnN3J8mZ = null;
		try {
			if (!j7arY9hN.getName().equals("")) {
				l74nXk7s = "update DBPic set name=? where bnr=?";
				hnN3J8mZ = N0zFjbyb.prepareStatement(l74nXk7s);
				hnN3J8mZ.setString(1, j7arY9hN.getName());
				hnN3J8mZ.setInt(2, xivS0215);
				hnN3J8mZ.executeUpdate();
			}
			if (j7arY9hN.getRate() != 0) {
				l74nXk7s = "update DBPic set rate=? where bnr=?";
				hnN3J8mZ = N0zFjbyb.prepareStatement(l74nXk7s);
				hnN3J8mZ.setInt(1, j7arY9hN.getRate());
				hnN3J8mZ.setInt(2, xivS0215);
				hnN3J8mZ.executeUpdate();
			}
			l74nXk7s = "update DBThumb set thumb_lock=? where bnr=?";
			hnN3J8mZ = N0zFjbyb.prepareStatement(l74nXk7s);
			hnN3J8mZ.setInt(1, P0RH73aY);
			hnN3J8mZ.setInt(2, xivS0215);
			hnN3J8mZ.executeUpdate();
			if (j7arY9hN.getCategories() != null) {
				l74nXk7s = "delete from Zuordnen where bnr=?";
				hnN3J8mZ = N0zFjbyb.prepareStatement(l74nXk7s);
				hnN3J8mZ.setInt(1, xivS0215);
				hnN3J8mZ.executeUpdate();
				DaoUpdate.insertPicInCategories(N0zFjbyb, xivS0215, j7arY9hN.getCategories());
			}
			if (j7arY9hN.getKeywords() != null) {
				l74nXk7s = "delete from Haben where bnr=?";
				hnN3J8mZ = N0zFjbyb.prepareStatement(l74nXk7s);
				hnN3J8mZ.setInt(1, xivS0215);
				hnN3J8mZ.executeUpdate();
				DaoUpdate.insertPicInKeywords(N0zFjbyb, xivS0215, j7arY9hN.getKeywords());
			}
			N0zFjbyb.commit();
		} catch (SQLException NNmsJpS6) {
			N0zFjbyb.rollback();
			throw NNmsJpS6;
		} finally {
			hnN3J8mZ.close();
		}
	}

}