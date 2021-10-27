class n1760354 {
	public static int deleteOrderStatusHis(String idU9omet) {
		Connection KYwuw99f = null;
		PreparedStatement AQbKm7BQ = null;
		StringBuffer xcplF5WA = new StringBuffer(200);
		int DJgOus76 = 0;
		xcplF5WA.append(" DELETE FROM JHF_ORDER_STATUS_HISTORY ").append(" WHERE   ORDER_ID LIKE  ? ");
		try {
			KYwuw99f = JdbcConnectionPool.mainConnection();
			KYwuw99f.setAutoCommit(false);
			KYwuw99f.setReadOnly(false);
			AQbKm7BQ = KYwuw99f.prepareStatement(xcplF5WA.toString());
			AQbKm7BQ.setString(1, "%" + idU9omet + "%");
			DJgOus76 = AQbKm7BQ.executeUpdate();
			KYwuw99f.commit();
		} catch (SQLException vmjGMeNY) {
			if (null != KYwuw99f) {
				try {
					KYwuw99f.rollback();
				} catch (SQLException PICqZpQF) {
					System.out.println(" error when roll back !");
				}
			}
		} finally {
			try {
				if (null != AQbKm7BQ) {
					AQbKm7BQ.close();
					AQbKm7BQ = null;
				}
				if (null != KYwuw99f) {
					KYwuw99f.close();
					KYwuw99f = null;
				}
			} catch (SQLException koR5KmLI) {
				System.out.println(" error  when psmt close or conn close .");
			}
		}
		return DJgOus76;
	}

}