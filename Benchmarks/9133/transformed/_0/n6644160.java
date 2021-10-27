class n6644160 {
	public void saveHiddenNames(HashSet qk7xVk48) throws SQLException {
		Connection OB6OVsQa = AppLayerDatabase.getInstance().getPooledConnection();
		PreparedStatement uQkL1cvd = null;
		try {
			OB6OVsQa.setAutoCommit(false);
			Statement yK6wzcmR = OB6OVsQa.createStatement();
			yK6wzcmR.executeUpdate("DELETE FROM HIDDENBOARDNAMES");
			yK6wzcmR.close();
			yK6wzcmR = null;
			uQkL1cvd = OB6OVsQa.prepareStatement("INSERT INTO HIDDENBOARDNAMES (boardname) VALUES (?)");
			for (Iterator QGid2aYK = qk7xVk48.iterator(); QGid2aYK.hasNext();) {
				String H9HiTFbK = (String) QGid2aYK.next();
				uQkL1cvd.setString(1, H9HiTFbK);
				uQkL1cvd.executeUpdate();
			}
			uQkL1cvd.close();
			OB6OVsQa.commit();
			OB6OVsQa.setAutoCommit(true);
		} catch (Throwable DTgkzjym) {
			logger.log(Level.SEVERE, "Exception during save", DTgkzjym);
			try {
				OB6OVsQa.rollback();
			} catch (Throwable kRmwbJnx) {
				logger.log(Level.SEVERE, "Exception during rollback", kRmwbJnx);
			}
			try {
				OB6OVsQa.setAutoCommit(true);
			} catch (Throwable ntncmuQr) {
			}
		} finally {
			AppLayerDatabase.getInstance().givePooledConnection(OB6OVsQa);
			try {
				if (uQkL1cvd != null)
					uQkL1cvd.close();
			} catch (Throwable zqZlrXaj) {
			}
			;
		}
	}

}