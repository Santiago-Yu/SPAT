class n2210894 {
	protected int doExecuteInsert(PreparedStatement g72To0JG, Table pGl28t7f) throws SQLException {
		ResultSet XeYdckGL = null;
		int YwBNhe6s = -1;
		try {
			lastError = null;
			YwBNhe6s = g72To0JG.executeUpdate();
			if (!isAutoCommit())
				connection.commit();
			XeYdckGL = g72To0JG.getGeneratedKeys();
			while (XeYdckGL.next()) {
				FieldUtils.setValue(pGl28t7f, pGl28t7f.key, XeYdckGL.getObject(1));
			}
		} catch (SQLException bJRwuUJw) {
			if (!isAutoCommit()) {
				lastError = bJRwuUJw;
				connection.rollback();
				LogUtils.log(Level.SEVERE, "Transaction is being rollback. Error: " + bJRwuUJw.toString());
			} else {
				throw bJRwuUJw;
			}
		} finally {
			if (g72To0JG != null)
				g72To0JG.close();
			if (XeYdckGL != null)
				XeYdckGL.close();
		}
		return YwBNhe6s;
	}

}