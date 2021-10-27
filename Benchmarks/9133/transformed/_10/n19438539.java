class n19438539 {
	public void run() throws Exception {
		logger.debug("#run enter");
		logger.debug("#run orderId = " + orderId);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(SQL_SELECT_ORDER_LINE);
			ps.setInt(1, orderId);
			DeleteOrderLineAction action = new DeleteOrderLineAction();
			rs = ps.executeQuery();
			while (rs.next()) {
				Integer lineId = rs.getInt("ID");
				Integer itemId = rs.getInt("ITEM_ID");
				Integer quantity = rs.getInt("QUANTITY");
				action.execute(connection, lineId, itemId, quantity);
			}
			rs.close();
			ps.close();
			ps = connection.prepareStatement(SQL_DELETE_ORDER);
			ps.setInt(1, orderId);
			ps.executeUpdate();
			ps.close();
			logger.info("#run order delete OK");
			connection.commit();
		} catch (SQLException ex) {
			logger.error("SQLException", ex);
			connection.rollback();
			throw new Exception("§¯§Ö §å§Õ§Ñ§Ý§à§ã§î §å§Õ§Ñ§Ý§Ú§ä§î §Ù§Ñ§Ü§Ñ§Ù. §°§ê§Ú§Ò§Ü§Ñ : " + ex.getMessage());
		} finally {
			connection.setAutoCommit(true);
		}
		logger.debug("#run exit");
	}

}