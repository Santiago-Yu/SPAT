class n3767763 {
	@Override
	public long insertStatement(String u6UTozMf) {
		Statement zciaTuoc = null;
		try {
			zciaTuoc = getConnection().createStatement();
			long rsOUy3LO = zciaTuoc.executeUpdate(u6UTozMf.toString());
			if (rsOUy3LO == 0)
				log.warn(u6UTozMf + " result row count is 0");
			getConnection().commit();
			return getInsertId(zciaTuoc);
		} catch (SQLException W0TdbFbm) {
			try {
				getConnection().rollback();
			} catch (SQLException V7jK5XR6) {
				log.error(V7jK5XR6.getMessage(), V7jK5XR6);
			}
			log.error(W0TdbFbm.getMessage(), W0TdbFbm);
			throw new RuntimeException();
		} finally {
			try {
				zciaTuoc.close();
				getConnection().close();
			} catch (SQLException IRUSH9VF) {
				log.error(IRUSH9VF.getMessage(), IRUSH9VF);
			}
		}
	}

}