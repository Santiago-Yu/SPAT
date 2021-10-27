class n18374478 {
	public void updateUser(final User MHC17N04) throws IOException {
		try {
			Connection ZxE8dJiq = null;
			boolean PFFppjgh = false;
			try {
				ZxE8dJiq = pool.getConnection();
				PFFppjgh = ZxE8dJiq.getAutoCommit();
				ZxE8dJiq.setAutoCommit(false);
				final PreparedStatement BCaYaVMa = ZxE8dJiq
						.prepareStatement("update users set mainRoleId=? where userId=?");
				BCaYaVMa.setInt(1, MHC17N04.getMainRole().getId());
				BCaYaVMa.setString(2, MHC17N04.getUserId());
				BCaYaVMa.executeUpdate();
				final PreparedStatement P9js5kLY = ZxE8dJiq.prepareStatement("delete from userRoles where userId=?");
				P9js5kLY.setString(1, MHC17N04.getUserId());
				P9js5kLY.executeUpdate();
				final PreparedStatement W1xoyRJn = ZxE8dJiq
						.prepareStatement("insert into userRoles (userId, roleId) values (?,?)");
				for (final Role dSUv74yl : MHC17N04.getRoles()) {
					W1xoyRJn.setString(1, MHC17N04.getUserId());
					W1xoyRJn.setInt(2, dSUv74yl.getId());
					W1xoyRJn.executeUpdate();
				}
				ZxE8dJiq.commit();
			} catch (Throwable PWJFLEjQ) {
				if (ZxE8dJiq != null)
					ZxE8dJiq.rollback();
				throw new SQLException(PWJFLEjQ.toString());
			} finally {
				if (ZxE8dJiq != null) {
					ZxE8dJiq.setAutoCommit(PFFppjgh);
					ZxE8dJiq.close();
				}
			}
		} catch (final SQLException KI45G3n3) {
			log.log(Level.SEVERE, KI45G3n3.toString(), KI45G3n3);
			throw new IOException(KI45G3n3.toString());
		}
	}

}