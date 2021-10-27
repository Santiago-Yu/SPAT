class n1638505 {
	private Vendor createVendor() throws SQLException, IOException {
		Connection KR7vqvx8 = null;
		Statement xoEgXcr9 = null;
		String B73NCBtw = null;
		ResultSet sVBl8gUX = null;
		try {
			KR7vqvx8 = dataSource.getConnection();
			xoEgXcr9 = KR7vqvx8.createStatement();
			B73NCBtw = "insert into " + DB.Tbl.vend + "(" + col.title + "," + col.addDate + "," + col.authorId
					+ ") values('" + title + "',now()," + user.getId() + ")";
			xoEgXcr9.executeUpdate(B73NCBtw, new String[] { col.id });
			sVBl8gUX = xoEgXcr9.getGeneratedKeys();
			if (!sVBl8gUX.next()) {
				throw new SQLException("§¯§Ö §å§Õ§Ñ§Ö§ä§ã§ñ §á§à§Ý§å§é§Ú§ä§î generated key 'id' §Ó §ä§Ñ§Ò§Ý§Ú§è§Ö vendors.");
			}
			int pLHTyd30 = sVBl8gUX.getInt(1);
			sVBl8gUX.close();
			saveDescr(pLHTyd30);
			KR7vqvx8.commit();
			Vendor lEWJLBZJ = new Vendor();
			lEWJLBZJ.setId(pLHTyd30);
			lEWJLBZJ.setTitle(title);
			lEWJLBZJ.setDescr(descr);
			VendorViewer.getInstance().vendorListChanged();
			return lEWJLBZJ;
		} catch (SQLException rOUggUp8) {
			try {
				KR7vqvx8.rollback();
			} catch (Exception siHuikXv) {
			}
			throw rOUggUp8;
		} finally {
			try {
				sVBl8gUX.close();
			} catch (Exception uu1FLpYu) {
			}
			try {
				xoEgXcr9.close();
			} catch (Exception AKA8D5oi) {
			}
			try {
				KR7vqvx8.close();
			} catch (Exception KV3zfy86) {
			}
		}
	}

}