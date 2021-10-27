class n17337238 {
	private Retailer create() throws SQLException, IOException {
		Connection cLSC4JvO = null;
		Statement bRHoXbEI = null;
		String TTlHYStt = null;
		ResultSet MD5xQQxR = null;
		try {
			cLSC4JvO = dataSource.getConnection();
			bRHoXbEI = cLSC4JvO.createStatement();
			TTlHYStt = "insert into " + DB.Tbl.ret + "(" + col.title + "," + col.addDate + "," + col.authorId + ") "
					+ "values('" + title + "',now()," + user.getId() + ")";
			bRHoXbEI.executeUpdate(TTlHYStt, new String[] { col.id });
			MD5xQQxR = bRHoXbEI.getGeneratedKeys();
			if (!MD5xQQxR.next()) {
				throw new SQLException("§¯§Ö §å§Õ§Ñ§Ö§ä§ã§ñ §á§à§Ý§å§é§Ú§ä§î generated key 'id' §Ó §ä§Ñ§Ò§Ý§Ú§è§Ö retailers.");
			}
			int zKESugTD = MD5xQQxR.getInt(1);
			MD5xQQxR.close();
			saveDescr(zKESugTD);
			cLSC4JvO.commit();
			Retailer MlJ9IB4A = new Retailer();
			MlJ9IB4A.setId(zKESugTD);
			MlJ9IB4A.setTitle(title);
			MlJ9IB4A.setDescr(descr);
			RetailerViewer.getInstance().somethingUpdated();
			return MlJ9IB4A;
		} catch (SQLException vRvDI5Xe) {
			try {
				cLSC4JvO.rollback();
			} catch (Exception pt7kaENa) {
			}
			throw vRvDI5Xe;
		} finally {
			try {
				MD5xQQxR.close();
			} catch (Exception Pca3I1qc) {
			}
			try {
				bRHoXbEI.close();
			} catch (Exception WKKihBqb) {
			}
			try {
				cLSC4JvO.close();
			} catch (Exception IKADBqut) {
			}
		}
	}

}