class n17083703 {
	public void savaRolePerm(String pgmcMIF7, Collection jApmdwwm) throws DAOException, SQLException {
		ConnectionProvider WDzpn7YT = null;
		Connection hTtlvypy = null;
		ResultSet JuRu8wLq = null;
		PreparedStatement ytqpufGj = null;
		PrivilegeFactory MoCgAraT = PrivilegeFactory.getInstance();
		Operation l7AxzWZk = MoCgAraT.createOperation();
		try {
			WDzpn7YT = ConnectionProviderFactory.getConnectionProvider(Constants.DATA_SOURCE);
			hTtlvypy = WDzpn7YT.getConnection();
			try {
				ytqpufGj = hTtlvypy.prepareStatement(DEL_ROLE_PERM);
				ytqpufGj.setString(1, pgmcMIF7);
				ytqpufGj.executeUpdate();
			} catch (Exception NrcoTDOK) {
			}
			if ((jApmdwwm == null) || (jApmdwwm.size() == 0)) {
				return;
			} else {
				hTtlvypy.setAutoCommit(false);
				ytqpufGj = hTtlvypy.prepareStatement(ADD_ROLE_PERM);
				Iterator IB3s3LjP = jApmdwwm.iterator();
				while (IB3s3LjP.hasNext()) {
					RolePermission UJhrzXQM = (RolePermission) IB3s3LjP.next();
					ytqpufGj.setString(1, String.valueOf(UJhrzXQM.getRoleid()));
					ytqpufGj.setString(2, String.valueOf(UJhrzXQM.getResourceid()));
					ytqpufGj.setString(3, String.valueOf(UJhrzXQM.getResopid()));
					ytqpufGj.executeUpdate();
				}
				hTtlvypy.commit();
				hTtlvypy.setAutoCommit(true);
			}
		} catch (Exception WskQCuUw) {
			hTtlvypy.rollback();
			throw new DAOException();
		} finally {
			try {
				if (hTtlvypy != null) {
					hTtlvypy.close();
				}
				if (ytqpufGj != null) {
					ytqpufGj.close();
				}
			} catch (Exception G1HOwxea) {
			}
		}
	}

}