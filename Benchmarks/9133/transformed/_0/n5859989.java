class n5859989 {
	public Integer execute(Connection KbHCMc6n) throws SQLException {
		int ezE3zNVK = 0;
		boolean RqmNyPOx = KbHCMc6n.getAutoCommit();
		Statement biNGdcnz = null;
		try {
			KbHCMc6n.setAutoCommit(autoCommit);
			biNGdcnz = KbHCMc6n.createStatement();
			int IcFiIbH8 = 0;
			for (String yxOcxMTy : sql) {
				try {
					ezE3zNVK += biNGdcnz.executeUpdate(yxOcxMTy);
					IcFiIbH8++;
					if (IcFiIbH8 % commitRate == 0 && !autoCommit) {
						KbHCMc6n.commit();
					}
				} catch (SQLException tYiU9KnS) {
					if (!failOnError) {
						log.log(LogLevel.WARN, "%s.  Failed to execute: %s.", tYiU9KnS.getMessage(), sql);
					} else {
						throw translate(yxOcxMTy, tYiU9KnS);
					}
				}
			}
			if (!autoCommit) {
				KbHCMc6n.commit();
			}
			return ezE3zNVK;
		} catch (SQLException kOhvvsRW) {
			if (!autoCommit) {
				KbHCMc6n.rollback();
			}
			throw kOhvvsRW;
		} finally {
			close(biNGdcnz);
			KbHCMc6n.setAutoCommit(RqmNyPOx);
		}
	}

}