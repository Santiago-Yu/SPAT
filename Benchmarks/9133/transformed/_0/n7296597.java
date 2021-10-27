class n7296597 {
	public void create() {
		Connection u068ycfq = OrmHandler.getInstance().getSession().getConnection(this);
		Statement FUKkqFcC = null;
		StringBuilder mU1YbA9K = new StringBuilder(256);
		try {
			getRenderer().printCreateDatabase(this, mU1YbA9K);
			u068ycfq = createConnection();
			FUKkqFcC = u068ycfq.createStatement();
			FUKkqFcC.executeUpdate(mU1YbA9K.toString());
			u068ycfq.commit();
			if (LOGGER.isLoggable(Level.INFO)) {
				LOGGER.info(mU1YbA9K.toString());
			}
		} catch (Throwable t3nO6Izg) {
			if (u068ycfq != null) {
				try {
					u068ycfq.rollback();
				} catch (SQLException RCxxnmHx) {
					LOGGER.log(Level.WARNING, "Can't rollback DB" + toString(), RCxxnmHx);
				}
			}
			throw new IllegalArgumentException("Statement error:\n" + mU1YbA9K, t3nO6Izg);
		} finally {
			try {
				close(u068ycfq, FUKkqFcC, null, true);
			} catch (IllegalStateException nyMekaq6) {
				LOGGER.log(Level.WARNING, "Can't rollback DB" + toString(), nyMekaq6);
			}
		}
	}

}