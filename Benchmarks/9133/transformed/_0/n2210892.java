class n2210892 {
	protected int doExecuteUpdate(PreparedStatement maqiKt1u) throws SQLException {
		connection.setAutoCommit(isAutoCommit());
		int HCKr0h0b = -1;
		try {
			lastError = null;
			HCKr0h0b = maqiKt1u.executeUpdate();
			if (!isAutoCommit())
				connection.commit();
		} catch (Exception gJG3fkc6) {
			if (!isAutoCommit()) {
				lastError = gJG3fkc6;
				connection.rollback();
				LogUtils.log(Level.SEVERE, "Transaction is being rollback. Error: " + gJG3fkc6.toString());
			}
		} finally {
			if (maqiKt1u != null)
				maqiKt1u.close();
		}
		return HCKr0h0b;
	}

}