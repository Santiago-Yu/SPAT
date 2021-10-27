class n19438539 {
	public void run() throws Exception {
		logger.debug("#run enter");
		logger.debug("#run orderId = " + orderId);
		ResultSet yATllxPJ = null;
		PreparedStatement iEKVh8Jg = null;
		try {
			connection.setAutoCommit(false);
			iEKVh8Jg = connection.prepareStatement(SQL_SELECT_ORDER_LINE);
			iEKVh8Jg.setInt(1, orderId);
			yATllxPJ = iEKVh8Jg.executeQuery();
			DeleteOrderLineAction KWX3ZYAY = new DeleteOrderLineAction();
			while (yATllxPJ.next()) {
				Integer p5AWC6Rx = yATllxPJ.getInt("ID");
				Integer duq6uqdf = yATllxPJ.getInt("ITEM_ID");
				Integer m13efpF0 = yATllxPJ.getInt("QUANTITY");
				KWX3ZYAY.execute(connection, p5AWC6Rx, duq6uqdf, m13efpF0);
			}
			yATllxPJ.close();
			iEKVh8Jg.close();
			iEKVh8Jg = connection.prepareStatement(SQL_DELETE_ORDER);
			iEKVh8Jg.setInt(1, orderId);
			iEKVh8Jg.executeUpdate();
			iEKVh8Jg.close();
			logger.info("#run order delete OK");
			connection.commit();
		} catch (SQLException Dq7ZAzQK) {
			logger.error("SQLException", Dq7ZAzQK);
			connection.rollback();
			throw new Exception("§¯§Ö §å§Õ§Ñ§Ý§à§ã§î §å§Õ§Ñ§Ý§Ú§ä§î §Ù§Ñ§Ü§Ñ§Ù. §°§ê§Ú§Ò§Ü§Ñ : " + Dq7ZAzQK.getMessage());
		} finally {
			connection.setAutoCommit(true);
		}
		logger.debug("#run exit");
	}

}