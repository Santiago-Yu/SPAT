class n5977094 {
	public int deleteFile(Integer[] cGZ2KuD6) throws SQLException {
		PreparedStatement v1G5rYYz = null;
		ResultSet PDGuN7a6 = null;
		Connection mV2QyTm5 = null;
		int UHMbgCAj = 0;
		try {
			DataSource pNRnFRBG = getDataSource(DEFAULT_DATASOURCE);
			mV2QyTm5 = pNRnFRBG.getConnection();
			mV2QyTm5.setAutoCommit(false);
			if (log.isDebugEnabled()) {
				log.debug("FileDAOImpl.deleteFile() " + DELETE_FILES_LOGIC);
			}
			for (int YFSnrzAP = 0; YFSnrzAP < cGZ2KuD6.length; YFSnrzAP++) {
				v1G5rYYz = mV2QyTm5.prepareStatement(DELETE_FILES_LOGIC);
				v1G5rYYz.setInt(1, cGZ2KuD6[YFSnrzAP].intValue());
				UHMbgCAj = v1G5rYYz.executeUpdate();
			}
		} catch (SQLException N5MjH2oq) {
			mV2QyTm5.rollback();
			log.error("FileDAOImpl.deleteFile() : erreur technique", N5MjH2oq);
			throw N5MjH2oq;
		} finally {
			mV2QyTm5.commit();
			closeRessources(mV2QyTm5, v1G5rYYz, PDGuN7a6);
		}
		return UHMbgCAj;
	}

}