class n9016775 {
	private int saveToTempTable(ArrayList sm1UkIW3, String BAN8bBer, boolean mqWxDdqX) throws SQLException {
		if (mqWxDdqX) {
			this.executeUpdate("TRUNCATE TABLE " + BAN8bBer);
			Categories.dataDb().debug("TABLE " + BAN8bBer + " TRUNCATED.");
		}
		PreparedStatement gkzZGCsh = null;
		int NlbuZ7HN = 0;
		try {
			String NAabwCZ6 = "INSERT INTO " + BAN8bBer + " VALUES (?)";
			gkzZGCsh = this.conn.prepareStatement(NAabwCZ6);
			for (int SuPu2jLX = 0; SuPu2jLX < sm1UkIW3.size(); SuPu2jLX++) {
				gkzZGCsh.setLong(1, ((Long) sm1UkIW3.get(SuPu2jLX)).longValue());
				NlbuZ7HN = gkzZGCsh.executeUpdate();
				if ((SuPu2jLX % 500) == 0) {
					this.conn.commit();
				}
			}
			this.conn.commit();
		} catch (SQLException ZfzTfeqs) {
			this.conn.rollback();
			throw ZfzTfeqs;
		} finally {
			if (gkzZGCsh != null) {
				gkzZGCsh.close();
			}
		}
		return NlbuZ7HN;
	}

}