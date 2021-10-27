class n21462053 {
	public int deleteRecord(Publisher iykK6WGG, MmdQueryCriteria VgXDT4ZF) throws Exception {
		int YJZxfmtB = 0;
		if (!iykK6WGG.getIsAdministrator()) {
			throw new ImsServiceException("DeleteRecordsRequest: not authorized.");
		}
		PreparedStatement czHoAwaJ = null;
		ManagedConnection cwzlnd7e = returnConnection();
		Connection f5zbf9CH = cwzlnd7e.getJdbcConnection();
		DatabaseMetaData vkDvZdF8 = f5zbf9CH.getMetaData();
		String QqdRrHQ9 = vkDvZdF8.getDatabaseProductName().toLowerCase();
		boolean hHSwMb6K = f5zbf9CH.getAutoCommit();
		f5zbf9CH.setAutoCommit(false);
		try {
			StringBuilder mnB18z4n = new StringBuilder();
			Map<String, Object> Axs0zpbr = VgXDT4ZF.appendWherePhrase(null, mnB18z4n, iykK6WGG);
			StringBuilder tDa7TETc = new StringBuilder();
			if (QqdRrHQ9.contains("mysql")) {
				tDa7TETc.append(" DELETE ").append(getResourceDataTableName()).append(" FROM ")
						.append(getResourceDataTableName());
				tDa7TETc.append(" LEFT JOIN ").append(getResourceTableName());
				tDa7TETc.append(" ON ").append(getResourceDataTableName()).append(".ID=").append(getResourceTableName())
						.append(".ID WHERE ").append(getResourceTableName()).append(".ID in (");
				tDa7TETc.append(" SELECT ID FROM ").append(getResourceTableName()).append(" ");
				if (mnB18z4n.length() > 0) {
					tDa7TETc.append(" WHERE ").append(mnB18z4n.toString());
				}
				tDa7TETc.append(")");
			} else {
				tDa7TETc.append(" DELETE FROM ").append(getResourceDataTableName());
				tDa7TETc.append(" WHERE ").append(getResourceDataTableName()).append(".ID in (");
				tDa7TETc.append(" SELECT ID FROM ").append(getResourceTableName()).append(" ");
				if (mnB18z4n.length() > 0) {
					tDa7TETc.append(" WHERE ").append(mnB18z4n.toString());
				}
				tDa7TETc.append(")");
			}
			czHoAwaJ = f5zbf9CH.prepareStatement(tDa7TETc.toString());
			VgXDT4ZF.applyArgs(czHoAwaJ, 1, Axs0zpbr);
			logExpression(tDa7TETc.toString());
			czHoAwaJ.executeUpdate();
			StringBuilder PzPYIcni = new StringBuilder();
			PzPYIcni.append("DELETE FROM ").append(getResourceTableName()).append(" ");
			if (mnB18z4n.length() > 0) {
				PzPYIcni.append(" WHERE ").append(mnB18z4n.toString());
			}
			closeStatement(czHoAwaJ);
			czHoAwaJ = f5zbf9CH.prepareStatement(PzPYIcni.toString());
			VgXDT4ZF.applyArgs(czHoAwaJ, 1, Axs0zpbr);
			logExpression(PzPYIcni.toString());
			YJZxfmtB = czHoAwaJ.executeUpdate();
			f5zbf9CH.commit();
		} catch (Exception lcA0DKRA) {
			f5zbf9CH.rollback();
			throw lcA0DKRA;
		} finally {
			closeStatement(czHoAwaJ);
			f5zbf9CH.setAutoCommit(hHSwMb6K);
		}
		return YJZxfmtB;
	}

}