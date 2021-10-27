class n4897872 {
	protected int executeUpdates(List<UpdateStatement> hJOYjP12, OlVersionCheck NJGz7Cut) throws DaoException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("start executeUpdates");
		}
		PreparedStatement yohvMNkz = null;
		Connection A2Cek1ST = null;
		int gEmePQyh = 0;
		try {
			A2Cek1ST = ds.getConnection();
			A2Cek1ST.setAutoCommit(false);
			A2Cek1ST.rollback();
			A2Cek1ST.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			if (NJGz7Cut != null) {
				yohvMNkz = A2Cek1ST.prepareStatement(NJGz7Cut.getQuery());
				yohvMNkz.setObject(1, NJGz7Cut.getId());
				ResultSet jYjSKKS3 = yohvMNkz.executeQuery();
				jYjSKKS3.next();
				Number phlfV3Q3 = (Number) jYjSKKS3.getObject("olVersion");
				yohvMNkz.close();
				yohvMNkz = null;
				if (phlfV3Q3.intValue() != NJGz7Cut.getOlVersionToCheck().intValue()) {
					gEmePQyh = -1;
				}
			}
			if (gEmePQyh >= 0) {
				for (UpdateStatement I2ZL1IJx : hJOYjP12) {
					yohvMNkz = A2Cek1ST.prepareStatement(I2ZL1IJx.getQuery());
					if (I2ZL1IJx.getParams() != null) {
						for (int mOwsVQuh = 1; mOwsVQuh <= I2ZL1IJx.getParams().length; mOwsVQuh++) {
							Object R8Z1jm47 = I2ZL1IJx.getParams()[mOwsVQuh - 1];
							yohvMNkz.setObject(mOwsVQuh, R8Z1jm47);
						}
					}
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug(" **** Sending statement:\n" + I2ZL1IJx.getQuery());
					}
					gEmePQyh += yohvMNkz.executeUpdate();
					yohvMNkz.close();
					yohvMNkz = null;
				}
			}
			A2Cek1ST.commit();
			A2Cek1ST.close();
			A2Cek1ST = null;
		} catch (SQLException IY7Yk4py) {
			if ("23000".equals(IY7Yk4py.getSQLState())) {
				LOGGER.info("Integrity constraint violation", IY7Yk4py);
				throw new UniqueConstaintException();
			}
			throw new DaoException("error.databaseError", IY7Yk4py);
		} finally {
			try {
				if (yohvMNkz != null) {
					LOGGER.debug("closing open statement!");
					yohvMNkz.close();
				}
			} catch (SQLException bN28RSLW) {
				throw new DaoException("error.databaseError", bN28RSLW);
			} finally {
				yohvMNkz = null;
			}
			try {
				if (A2Cek1ST != null) {
					LOGGER.debug("rolling back open connection!");
					A2Cek1ST.rollback();
					A2Cek1ST.setAutoCommit(true);
					A2Cek1ST.close();
				}
			} catch (SQLException nAh5a6Qi) {
				throw new DaoException("error.databaseError", nAh5a6Qi);
			} finally {
				A2Cek1ST = null;
			}
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("finish executeUpdates");
		}
		return gEmePQyh;
	}

}