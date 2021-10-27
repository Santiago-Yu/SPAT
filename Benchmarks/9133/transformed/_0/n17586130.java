class n17586130 {
	protected N save(String YMjyE9Na, Object[] SAcQC8Jc) {
		Connection dbi9oW86 = null;
		PreparedStatement OrQ7ktIt = null;
		ResultSet iOebsJsJ = null;
		try {
			dbi9oW86 = JdbcUtils.getConnection();
			dbi9oW86.setAutoCommit(false);
			OrQ7ktIt = dbi9oW86.prepareStatement(YMjyE9Na, Statement.RETURN_GENERATED_KEYS);
			this.setParameters(OrQ7ktIt, SAcQC8Jc);
			OrQ7ktIt.executeUpdate();
			dbi9oW86.commit();
			dbi9oW86.setAutoCommit(true);
			iOebsJsJ = OrQ7ktIt.getGeneratedKeys();
			return (N) iOebsJsJ.getObject(1);
		} catch (SQLException IIRSwpdR) {
			try {
				if (dbi9oW86 != null) {
					dbi9oW86.rollback();
					dbi9oW86.setAutoCommit(true);
				}
			} catch (SQLException htFMvRFl) {
				htFMvRFl.printStackTrace();
			}
			throw new JdbcDaoException(IIRSwpdR.getMessage(), IIRSwpdR);
		} finally {
			JdbcUtils.free(iOebsJsJ, OrQ7ktIt, dbi9oW86);
		}
	}

}