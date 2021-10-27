class n1760352 {
	public static int deleteContract(String FSHOwKwW) {
		Connection tuGlgjWE = null;
		PreparedStatement xACprgiA = null;
		StringBuffer nxN7iuza = new StringBuffer(200);
		int sIJropom = 0;
		nxN7iuza.append(" DELETE FROM JHF_ALIVE_CONTRACT ").append(" WHERE   ORDER_ID LIKE  ? ");
		try {
			tuGlgjWE = JdbcConnectionPool.mainConnection();
			tuGlgjWE.setAutoCommit(false);
			tuGlgjWE.setReadOnly(false);
			xACprgiA = tuGlgjWE.prepareStatement(nxN7iuza.toString());
			xACprgiA.setString(1, "%" + FSHOwKwW + "%");
			sIJropom = xACprgiA.executeUpdate();
			tuGlgjWE.commit();
		} catch (SQLException XVGZw4Ei) {
			if (null != tuGlgjWE) {
				try {
					tuGlgjWE.rollback();
				} catch (SQLException Lh9jPZFE) {
					System.out.println(" error when roll back !");
				}
			}
		} finally {
			try {
				if (null != xACprgiA) {
					xACprgiA.close();
					xACprgiA = null;
				}
				if (null != tuGlgjWE) {
					tuGlgjWE.close();
					tuGlgjWE = null;
				}
			} catch (SQLException wqd8exs1) {
				System.out.println(" error  when psmt close or conn close .");
			}
		}
		return sIJropom;
	}

}