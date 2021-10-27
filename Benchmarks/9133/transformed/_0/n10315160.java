class n10315160 {
	public void saveSharedFiles(List<FrostSharedFileItem> MYf8hHN6) throws SQLException {
		Connection c4kepbOW = AppLayerDatabase.getInstance().getPooledConnection();
		try {
			c4kepbOW.setAutoCommit(false);
			Statement Ev76hKIn = c4kepbOW.createStatement();
			Ev76hKIn.executeUpdate("DELETE FROM SHAREDFILES");
			Ev76hKIn.close();
			Ev76hKIn = null;
			PreparedStatement QGL608zY = c4kepbOW.prepareStatement("INSERT INTO SHAREDFILES ("
					+ "path,size,fnkey,sha,owner,comment,rating,keywords,"
					+ "lastuploaded,uploadcount,reflastsent,requestlastreceived,requestsreceivedcount,lastmodified) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			for (Iterator<FrostSharedFileItem> AGYZhGQv = MYf8hHN6.iterator(); AGYZhGQv.hasNext();) {
				FrostSharedFileItem crSZxAdh = AGYZhGQv.next();
				int W3smigrl = 1;
				QGL608zY.setString(W3smigrl++, crSZxAdh.getFile().getPath());
				QGL608zY.setLong(W3smigrl++, crSZxAdh.getFileSize());
				QGL608zY.setString(W3smigrl++, crSZxAdh.getChkKey());
				QGL608zY.setString(W3smigrl++, crSZxAdh.getSha());
				QGL608zY.setString(W3smigrl++, crSZxAdh.getOwner());
				QGL608zY.setString(W3smigrl++, crSZxAdh.getComment());
				QGL608zY.setInt(W3smigrl++, crSZxAdh.getRating());
				QGL608zY.setString(W3smigrl++, crSZxAdh.getKeywords());
				QGL608zY.setLong(W3smigrl++, crSZxAdh.getLastUploaded());
				QGL608zY.setInt(W3smigrl++, crSZxAdh.getUploadCount());
				QGL608zY.setLong(W3smigrl++, crSZxAdh.getRefLastSent());
				QGL608zY.setLong(W3smigrl++, crSZxAdh.getRequestLastReceived());
				QGL608zY.setInt(W3smigrl++, crSZxAdh.getRequestsReceived());
				QGL608zY.setLong(W3smigrl++, crSZxAdh.getLastModified());
				QGL608zY.executeUpdate();
			}
			QGL608zY.close();
			c4kepbOW.commit();
			c4kepbOW.setAutoCommit(true);
		} catch (Throwable PUevnu5o) {
			logger.log(Level.SEVERE, "Exception during save", PUevnu5o);
			try {
				c4kepbOW.rollback();
			} catch (Throwable bNzAFXKi) {
				logger.log(Level.SEVERE, "Exception during rollback", bNzAFXKi);
			}
			try {
				c4kepbOW.setAutoCommit(true);
			} catch (Throwable fSttFmrd) {
			}
		} finally {
			AppLayerDatabase.getInstance().givePooledConnection(c4kepbOW);
		}
	}

}