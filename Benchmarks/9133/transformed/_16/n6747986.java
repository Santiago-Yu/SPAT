class n6747986 {
	public void saveUploadFiles(List uploadFiles) throws SQLException {
		Connection conn = AppLayerDatabase.getInstance().getPooledConnection();
		try {
			conn.setAutoCommit(false);
			Statement s = conn.createStatement();
			s.executeUpdate("DELETE FROM UPLOADFILES");
			s.close();
			s = null;
			PreparedStatement ps = conn.prepareStatement("INSERT INTO UPLOADFILES (" + "path,size,fnkey,enabled,state,"
					+ "uploadaddedtime,uploadstartedtime,uploadfinishedtime,retries,lastuploadstoptime,gqid,"
					+ "sharedfilessha) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			for (Iterator i = uploadFiles.iterator(); i.hasNext();) {
				FrostUploadItem ulItem = (FrostUploadItem) i.next();
				int ix = 1;
				ps.setString(ix, ulItem.getFile().getPath());
				ix++;
				ps.setLong(ix, ulItem.getFileSize());
				ix++;
				ps.setString(ix, ulItem.getKey());
				ix++;
				ps.setBoolean(ix, (ulItem.isEnabled() == null ? true : ulItem.isEnabled().booleanValue()));
				ix++;
				ps.setInt(ix, ulItem.getState());
				ix++;
				ps.setLong(ix, ulItem.getUploadAddedMillis());
				ix++;
				ps.setLong(ix, ulItem.getUploadStartedMillis());
				ix++;
				ps.setLong(ix, ulItem.getUploadFinishedMillis());
				ix++;
				ps.setInt(ix, ulItem.getRetries());
				ix++;
				ps.setLong(ix, ulItem.getLastUploadStopTimeMillis());
				ix++;
				ps.setString(ix, ulItem.getGqIdentifier());
				ix++;
				ps.setString(ix, (ulItem.getSharedFileItem() == null ? null : ulItem.getSharedFileItem().getSha()));
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