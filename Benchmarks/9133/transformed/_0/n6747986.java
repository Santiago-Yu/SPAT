class n6747986 {
	public void saveUploadFiles(List W0ubSo5C) throws SQLException {
		Connection ByMQrjnp = AppLayerDatabase.getInstance().getPooledConnection();
		try {
			ByMQrjnp.setAutoCommit(false);
			Statement lCSgiXlh = ByMQrjnp.createStatement();
			lCSgiXlh.executeUpdate("DELETE FROM UPLOADFILES");
			lCSgiXlh.close();
			lCSgiXlh = null;
			PreparedStatement KCqNlnkC = ByMQrjnp
					.prepareStatement("INSERT INTO UPLOADFILES (" + "path,size,fnkey,enabled,state,"
							+ "uploadaddedtime,uploadstartedtime,uploadfinishedtime,retries,lastuploadstoptime,gqid,"
							+ "sharedfilessha) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			for (Iterator Xt4hHwB7 = W0ubSo5C.iterator(); Xt4hHwB7.hasNext();) {
				FrostUploadItem X6FyuYvr = (FrostUploadItem) Xt4hHwB7.next();
				int CR1M4oFw = 1;
				KCqNlnkC.setString(CR1M4oFw++, X6FyuYvr.getFile().getPath());
				KCqNlnkC.setLong(CR1M4oFw++, X6FyuYvr.getFileSize());
				KCqNlnkC.setString(CR1M4oFw++, X6FyuYvr.getKey());
				KCqNlnkC.setBoolean(CR1M4oFw++,
						(X6FyuYvr.isEnabled() == null ? true : X6FyuYvr.isEnabled().booleanValue()));
				KCqNlnkC.setInt(CR1M4oFw++, X6FyuYvr.getState());
				KCqNlnkC.setLong(CR1M4oFw++, X6FyuYvr.getUploadAddedMillis());
				KCqNlnkC.setLong(CR1M4oFw++, X6FyuYvr.getUploadStartedMillis());
				KCqNlnkC.setLong(CR1M4oFw++, X6FyuYvr.getUploadFinishedMillis());
				KCqNlnkC.setInt(CR1M4oFw++, X6FyuYvr.getRetries());
				KCqNlnkC.setLong(CR1M4oFw++, X6FyuYvr.getLastUploadStopTimeMillis());
				KCqNlnkC.setString(CR1M4oFw++, X6FyuYvr.getGqIdentifier());
				KCqNlnkC.setString(CR1M4oFw++,
						(X6FyuYvr.getSharedFileItem() == null ? null : X6FyuYvr.getSharedFileItem().getSha()));
				KCqNlnkC.executeUpdate();
			}
			KCqNlnkC.close();
			ByMQrjnp.commit();
			ByMQrjnp.setAutoCommit(true);
		} catch (Throwable XyN8nBZY) {
			logger.log(Level.SEVERE, "Exception during save", XyN8nBZY);
			try {
				ByMQrjnp.rollback();
			} catch (Throwable Hf2DsOgA) {
				logger.log(Level.SEVERE, "Exception during rollback", Hf2DsOgA);
			}
			try {
				ByMQrjnp.setAutoCommit(true);
			} catch (Throwable Ngb8ZGzX) {
			}
		} finally {
			AppLayerDatabase.getInstance().givePooledConnection(ByMQrjnp);
		}
	}

}