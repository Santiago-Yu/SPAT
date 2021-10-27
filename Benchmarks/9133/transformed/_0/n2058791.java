class n2058791 {
	public void doPreparedStatementQueryAndUpdate(Connection nYUD5PhV, String oEEGIHbe) throws SQLException {
		try {
			int ooCQBtb6 = getNextKey();
			String UNFoD8RR = "doPreparedStatementQueryAndUpdate:" + oEEGIHbe + ":" + testId;
			PreparedStatement ePHqfE47;
			if (ooCQBtb6 >= MAX_KEY_VALUE) {
				ooCQBtb6 = ooCQBtb6 % MAX_KEY_VALUE;
				ePHqfE47 = nYUD5PhV.prepareStatement("delete from many_threads where a = ?");
				ePHqfE47.setInt(1, ooCQBtb6);
				ePHqfE47.executeUpdate();
				ePHqfE47.close();
			}
			ePHqfE47 = nYUD5PhV.prepareStatement("insert into many_threads values (?, ?, 0)");
			ePHqfE47.setInt(1, ooCQBtb6);
			ePHqfE47.setString(2, UNFoD8RR);
			assertEquals(1, ePHqfE47.executeUpdate());
			ePHqfE47.close();
			ePHqfE47 = nYUD5PhV.prepareStatement("select a from many_threads where a = ?");
			ePHqfE47.setInt(1, ooCQBtb6);
			assertEquals(ooCQBtb6, executeQuery(ePHqfE47));
			ePHqfE47.close();
			ePHqfE47 = nYUD5PhV.prepareStatement("update many_threads set value = a * a, b = b || ? where a = ?");
			ePHqfE47.setString(1, "&" + UNFoD8RR);
			ePHqfE47.setInt(2, ooCQBtb6 + 1);
			ePHqfE47.executeUpdate();
			ePHqfE47.close();
			if (!nYUD5PhV.getAutoCommit()) {
				nYUD5PhV.commit();
			}
		} catch (SQLException w3nDcmEM) {
			if (!nYUD5PhV.getAutoCommit()) {
				try {
					nYUD5PhV.rollback();
				} catch (SQLException rjFHUoy7) {
				}
			}
		}
	}

}