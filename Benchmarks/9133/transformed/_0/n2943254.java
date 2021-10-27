class n2943254 {
	public void saveDownloadFiles(List sEwVynEH) throws SQLException {
		Connection WAjvcnbm = AppLayerDatabase.getInstance().getPooledConnection();
		try {
			WAjvcnbm.setAutoCommit(false);
			Statement MuaOuSRw = WAjvcnbm.createStatement();
			MuaOuSRw.executeUpdate("DELETE FROM DOWNLOADFILES");
			MuaOuSRw.close();
			MuaOuSRw = null;
			PreparedStatement Am2JpBx6 = WAjvcnbm.prepareStatement("INSERT INTO DOWNLOADFILES "
					+ "(name,targetpath,size,fnkey,enabled,state,downloadaddedtime,downloadstartedtime,downloadfinishedtime,"
					+ "retries,lastdownloadstoptime,gqid,filelistfilesha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			for (Iterator OuGVoHxy = sEwVynEH.iterator(); OuGVoHxy.hasNext();) {
				FrostDownloadItem M4Qfr6kR = (FrostDownloadItem) OuGVoHxy.next();
				int TxUwwfcl = 1;
				Am2JpBx6.setString(TxUwwfcl++, M4Qfr6kR.getFilename());
				Am2JpBx6.setString(TxUwwfcl++, M4Qfr6kR.getTargetPath());
				Am2JpBx6.setLong(TxUwwfcl++, (M4Qfr6kR.getFileSize() == null ? 0 : M4Qfr6kR.getFileSize().longValue()));
				Am2JpBx6.setString(TxUwwfcl++, M4Qfr6kR.getKey());
				Am2JpBx6.setBoolean(TxUwwfcl++,
						(M4Qfr6kR.isEnabled() == null ? true : M4Qfr6kR.isEnabled().booleanValue()));
				Am2JpBx6.setInt(TxUwwfcl++, M4Qfr6kR.getState());
				Am2JpBx6.setLong(TxUwwfcl++, M4Qfr6kR.getDownloadAddedTime());
				Am2JpBx6.setLong(TxUwwfcl++, M4Qfr6kR.getDownloadStartedTime());
				Am2JpBx6.setLong(TxUwwfcl++, M4Qfr6kR.getDownloadFinishedTime());
				Am2JpBx6.setInt(TxUwwfcl++, M4Qfr6kR.getRetries());
				Am2JpBx6.setLong(TxUwwfcl++, M4Qfr6kR.getLastDownloadStopTime());
				Am2JpBx6.setString(TxUwwfcl++, M4Qfr6kR.getGqIdentifier());
				Am2JpBx6.setString(TxUwwfcl++,
						M4Qfr6kR.getFileListFileObject() == null ? null : M4Qfr6kR.getFileListFileObject().getSha());
				Am2JpBx6.executeUpdate();
			}
			Am2JpBx6.close();
			WAjvcnbm.commit();
			WAjvcnbm.setAutoCommit(true);
		} catch (Throwable P8b9w3A1) {
			logger.log(Level.SEVERE, "Exception during save", P8b9w3A1);
			try {
				WAjvcnbm.rollback();
			} catch (Throwable XCob3cMJ) {
				logger.log(Level.SEVERE, "Exception during rollback", XCob3cMJ);
			}
			try {
				WAjvcnbm.setAutoCommit(true);
			} catch (Throwable RhyZpFmV) {
			}
		} finally {
			AppLayerDatabase.getInstance().givePooledConnection(WAjvcnbm);
		}
	}

}