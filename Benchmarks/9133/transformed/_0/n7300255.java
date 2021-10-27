class n7300255 {
	public boolean renameTo(Folder eDFtCLuL) throws MessagingException, StoreClosedException, NullPointerException {
		String[] Gfeeqx2F = new String[] { "en", "es", "fr", "de", "it", "pt", "ca", "ja", "cn", "tw", "fi", "ru", "pl",
				"nl", "xx" };
		PreparedStatement vBZQgGzx = null;
		if (!((DBStore) getStore()).isConnected())
			throw new StoreClosedException(getStore(), "Store is not connected");
		if (oCatg.isNull(DB.gu_category))
			throw new NullPointerException("Folder is closed");
		try {
			vBZQgGzx = getConnection()
					.prepareStatement("DELETE FROM " + DB.k_cat_labels + " WHERE " + DB.gu_category + "=?");
			vBZQgGzx.setString(1, oCatg.getString(DB.gu_category));
			vBZQgGzx.executeUpdate();
			vBZQgGzx.close();
			vBZQgGzx.getConnection().prepareStatement("INSERT INTO " + DB.k_cat_labels + " (" + DB.gu_category + ","
					+ DB.id_language + "," + DB.tr_category + "," + DB.url_category + ") VALUES (?,?,?,NULL)");
			vBZQgGzx.setString(1, oCatg.getString(DB.gu_category));
			for (int CTZxznQk = 0; CTZxznQk < Gfeeqx2F.length; CTZxznQk++) {
				vBZQgGzx.setString(2, Gfeeqx2F[CTZxznQk]);
				vBZQgGzx.setString(3, eDFtCLuL.getName().substring(0, 1).toUpperCase()
						+ eDFtCLuL.getName().substring(1).toLowerCase());
				vBZQgGzx.executeUpdate();
			}
			vBZQgGzx.close();
			vBZQgGzx = null;
			getConnection().commit();
		} catch (SQLException lHPyhVM0) {
			try {
				if (null != vBZQgGzx)
					vBZQgGzx.close();
			} catch (SQLException oCnWiBWd) {
			}
			try {
				getConnection().rollback();
			} catch (SQLException mM1WDjGP) {
			}
			throw new MessagingException(lHPyhVM0.getMessage(), lHPyhVM0);
		}
		return true;
	}

}