class n12021779 {
	private void insert() throws SQLException, NamingException {
		Logger L2ujtux2 = getLogger();
		if (L2ujtux2.isDebugEnabled()) {
			L2ujtux2.debug("enter - " + getClass().getName() + ".insert()");
		}
		try {
			if (L2ujtux2.isInfoEnabled()) {
				L2ujtux2.info("insert(): Create new sequencer record for " + getName());
			}
			Connection JfqLrpGz = null;
			PreparedStatement IKxHoY72 = null;
			ResultSet R4lnMPxI = null;
			try {
				InitialContext Sc2diSzs = new InitialContext();
				DataSource v4Shm5iz = (DataSource) Sc2diSzs.lookup(dataSourceName);
				JfqLrpGz = v4Shm5iz.getConnection();
				JfqLrpGz.setReadOnly(false);
				IKxHoY72 = JfqLrpGz.prepareStatement(INSERT_SEQ);
				IKxHoY72.setString(INS_NAME, getName());
				IKxHoY72.setLong(INS_NEXT_KEY, defaultInterval * 2);
				IKxHoY72.setLong(INS_INTERVAL, defaultInterval);
				IKxHoY72.setLong(INS_UPDATE, System.currentTimeMillis());
				try {
					if (IKxHoY72.executeUpdate() != 1) {
						nextId = -1L;
						L2ujtux2.warn(
								"insert(): Failed to create sequencer entry for " + getName() + " (no error message)");
					} else if (L2ujtux2.isInfoEnabled()) {
						nextId = defaultInterval;
						nextSeed = defaultInterval * 2;
						interval = defaultInterval;
						L2ujtux2.info("insert(): First ID will be " + nextId);
					}
				} catch (SQLException mof6VkAG) {
					L2ujtux2.warn("insert(): Error inserting row into database, possible concurrency issue: "
							+ mof6VkAG.getMessage());
					if (L2ujtux2.isDebugEnabled()) {
						mof6VkAG.printStackTrace();
					}
					nextId = -1L;
				}
				if (!JfqLrpGz.getAutoCommit()) {
					JfqLrpGz.commit();
				}
			} finally {
				if (R4lnMPxI != null) {
					try {
						R4lnMPxI.close();
					} catch (SQLException ejgw8wvv) {
					}
				}
				if (IKxHoY72 != null) {
					try {
						IKxHoY72.close();
					} catch (SQLException kEvQKhUI) {
					}
				}
				if (JfqLrpGz != null) {
					if (!JfqLrpGz.getAutoCommit()) {
						try {
							JfqLrpGz.rollback();
						} catch (SQLException gMPEzFZt) {
						}
					}
					try {
						JfqLrpGz.close();
					} catch (SQLException mHF1IiI5) {
					}
				}
			}
		} finally {
			if (L2ujtux2.isDebugEnabled()) {
				L2ujtux2.debug("exit - " + getClass().getName() + ".insert()");
			}
		}
	}

}