class n1616055 {
	public void run() throws Exception {
		logger.debug("#run enter");
		PreparedStatement MIHawOfo = null;
		ResultSet gVZWcjl9 = null;
		PreparedStatement ff8z30uP = null;
		try {
			PreparedStatement eeCbGjWi = connection.prepareStatement(COUNT_ACTIVE_ORDERS);
			eeCbGjWi.setString(1, login);
			ResultSet Ftxic9mm = eeCbGjWi.executeQuery();
			if (Ftxic9mm.next()) {
				Integer KMXUP071 = Ftxic9mm.getInt(1);
				if (KMXUP071 > 0) {
					DBHelper.closeAll(null, Ftxic9mm, eeCbGjWi);
					throw new RuntimeException("§µ §Ó§Ñ§ã §å§Ø§Ö §Ö§ã§ä§î §à§Õ§Ú§ß §Ñ§Ü§ä§Ú§Ó§ß§í§Û §Ù§Ñ§Ü§Ñ§Ù. §£§í §ß§Ö §Þ§à§Ø§Ö§ä§Ö §ã§à§Ù§Õ§Ñ§ä§î §Ó§ä§à§â§à§Û.");
				}
			}
			connection.setAutoCommit(false);
			MIHawOfo = connection.prepareStatement(NEXT_ORDER);
			gVZWcjl9 = MIHawOfo.executeQuery();
			if (gVZWcjl9.next()) {
				orderId = gVZWcjl9.getInt(1);
			}
			gVZWcjl9.close();
			MIHawOfo.close();
			logger.info("#run orderId  = " + orderId);
			ff8z30uP = connection.prepareStatement(INSERT_ORDER);
			ff8z30uP.setInt(1, orderId);
			if (order.getCustomerId() != null) {
				ff8z30uP.setInt(2, order.getCustomerId());
			} else {
				ff8z30uP.setNull(2, Types.INTEGER);
			}
			ff8z30uP.setString(3, order.getSellerLogin());
			ff8z30uP.executeUpdate();
			ff8z30uP.close();
			logger.info("#run order insert OK");
			Iterator<OrderLine> CGuQVms6 = order.getLines().iterator();
			while (CGuQVms6.hasNext()) {
				OrderLine IllOru1v = CGuQVms6.next();
				CreateOrderLineAction fpDSBR9P = new CreateOrderLineAction();
				fpDSBR9P.execute(connection, orderId, IllOru1v);
			}
			connection.commit();
		} catch (SQLException LkdjgZK3) {
			logger.error("SQLException", LkdjgZK3);
			connection.rollback();
			throw new Exception("§¯§Ö §å§Õ§Ñ§Ý§à§ã§î §ã§à§Ù§Õ§Ñ§ä§î §Ù§Ñ§Ü§Ñ§Ù. §°§ê§Ú§Ò§Ü§Ñ : " + LkdjgZK3.getMessage());
		} finally {
			connection.setAutoCommit(true);
		}
		logger.debug("#run exit");
	}

}