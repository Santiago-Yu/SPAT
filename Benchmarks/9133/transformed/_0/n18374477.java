class n18374477 {
	public void insertUser(final User GvnZA8Ko) throws IOException {
		try {
			Connection elALcRw6 = null;
			boolean UwoBvJ0r = false;
			try {
				elALcRw6 = pool.getConnection();
				UwoBvJ0r = elALcRw6.getAutoCommit();
				elALcRw6.setAutoCommit(false);
				final PreparedStatement ftCemR0B = elALcRw6
						.prepareStatement("insert into users (userId, mainRoleId) values (?,?)");
				log.finest("userId= " + GvnZA8Ko.getUserId());
				ftCemR0B.setString(1, GvnZA8Ko.getUserId());
				log.finest("mainRole= " + GvnZA8Ko.getMainRole().getId());
				ftCemR0B.setInt(2, GvnZA8Ko.getMainRole().getId());
				ftCemR0B.executeUpdate();
				final PreparedStatement SfN043Ez = elALcRw6
						.prepareStatement("insert into userRoles (userId, roleId) values (?,?)");
				for (final Role qwE2sXUF : GvnZA8Ko.getRoles()) {
					SfN043Ez.setString(1, GvnZA8Ko.getUserId());
					SfN043Ez.setInt(2, qwE2sXUF.getId());
					SfN043Ez.executeUpdate();
				}
				elALcRw6.commit();
			} catch (Throwable MVkh4w72) {
				if (elALcRw6 != null)
					elALcRw6.rollback();
				log.log(Level.SEVERE, MVkh4w72.toString(), MVkh4w72);
				throw new SQLException(MVkh4w72.toString());
			} finally {
				if (elALcRw6 != null) {
					elALcRw6.setAutoCommit(UwoBvJ0r);
					elALcRw6.close();
				}
			}
		} catch (final SQLException kPgUKNHt) {
			log.log(Level.SEVERE, kPgUKNHt.toString(), kPgUKNHt);
			throw new IOException(kPgUKNHt.toString());
		}
	}

}