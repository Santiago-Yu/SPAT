class n10315160 {
	public void saveSharedFiles(List<FrostSharedFileItem> sfFiles) throws SQLException {
		Connection conn = AppLayerDatabase.getInstance().getPooledConnection();
		try {
			conn.setAutoCommit(false);
			Statement s = conn.createStatement();
			s.executeUpdate("DELETE FROM SHAREDFILES");
			s.close();
			s = null;
			PreparedStatement ps = conn.prepareStatement("INSERT INTO SHAREDFILES ("
					+ "path,size,fnkey,sha,owner,comment,rating,keywords,"
					+ "lastuploaded,uploadcount,reflastsent,requestlastreceived,requestsreceivedcount,lastmodified) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			for (Iterator<FrostSharedFileItem> i = sfFiles.iterator(); i.hasNext();) {
				FrostSharedFileItem sfItem = i.next();
				int ix = 1;
				ps.setString(ix, sfItem.getFile().getPath());
				ix++;
				ps.setLong(ix, sfItem.getFileSize());
				ix++;
				ps.setString(ix, sfItem.getChkKey());
				ix++;
				ps.setString(ix, sfItem.getSha());
				ix++;
				ps.setString(ix, sfItem.getOwner());
				ix++;
				ps.setString(ix, sfItem.getComment());
				ix++;
				ps.setInt(ix, sfItem.getRating());
				ix++;
				ps.setString(ix, sfItem.getKeywords());
				ix++;
				ps.setLong(ix, sfItem.getLastUploaded());
				ix++;
				ps.setInt(ix, sfItem.getUploadCount());
				ix++;
				ps.setLong(ix, sfItem.getRefLastSent());
				ix++;
				ps.setLong(ix, sfItem.getRequestLastReceived());
				ix++;
				ps.setInt(ix, sfItem.getRequestsReceived());
				ix++;
				ps.setLong(ix, sfItem.getLastModified());
				ix++;
				ps.executeUpdate();
			}
			ps.close();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Throwable t) {
			logger.log(Level.SEVERE, "Exception during save", t);
			try {
				conn.rollback();
			} catch (Throwable t1) {
				logger.log(Level.SEVERE, "Exception during rollback", t1);
			}
			try {
				conn.setAutoCommit(true);
			} catch (Throwable t1) {
			}
		} finally {
			AppLayerDatabase.getInstance().givePooledConnection(conn);
		}
	}

}