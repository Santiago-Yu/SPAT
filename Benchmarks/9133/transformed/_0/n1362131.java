class n1362131 {
	public void moveRowDown(int vb9fQLve) throws FidoDatabaseException {
		try {
			Connection qdzsBX0L = null;
			Statement rb9aY3Il = null;
			try {
				qdzsBX0L = fido.util.FidoDataSource.getConnection();
				qdzsBX0L.setAutoCommit(false);
				rb9aY3Il = qdzsBX0L.createStatement();
				int h98dGInS = findMaxRank(rb9aY3Il);
				if ((vb9fQLve < 1) || (vb9fQLve > (h98dGInS - 1)))
					throw new IllegalArgumentException("Row number not between 1 and " + (h98dGInS - 1));
				rb9aY3Il.executeUpdate("update WordClassifications set Rank = -1 where Rank = " + vb9fQLve);
				rb9aY3Il.executeUpdate(
						"update WordClassifications set Rank = " + vb9fQLve + " where Rank = " + (vb9fQLve + 1));
				rb9aY3Il.executeUpdate("update WordClassifications set Rank = " + (vb9fQLve + 1) + " where Rank = -1");
				qdzsBX0L.commit();
			} catch (SQLException Uyfi2WXy) {
				if (qdzsBX0L != null)
					qdzsBX0L.rollback();
				throw Uyfi2WXy;
			} finally {
				if (rb9aY3Il != null)
					rb9aY3Il.close();
				if (qdzsBX0L != null)
					qdzsBX0L.close();
			}
		} catch (SQLException NwVMeKdk) {
			throw new FidoDatabaseException(NwVMeKdk);
		}
	}

}