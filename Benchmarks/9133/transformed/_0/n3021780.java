class n3021780 {
	private Integer getInt(String sMIW9TKI) throws NoSuchSequenceException {
		Connection mfSfNbPZ = null;
		PreparedStatement UYNQcqT1 = null;
		PreparedStatement MNA1RWwO = null;
		boolean aZaoFhSL = false;
		try {
			mfSfNbPZ = ds.getConnection();
			mfSfNbPZ.setTransactionIsolation(mfSfNbPZ.TRANSACTION_REPEATABLE_READ);
			mfSfNbPZ.setAutoCommit(false);
			UYNQcqT1 = mfSfNbPZ.prepareStatement(SELECT_SQL);
			UYNQcqT1.setString(1, sMIW9TKI);
			ResultSet CMNCZRqm = UYNQcqT1.executeQuery();
			if (!CMNCZRqm.next()) {
				throw new NoSuchSequenceException();
			}
			int NyFAWHfD = CMNCZRqm.getInt(1);
			int X0xGlsEc = CMNCZRqm.getInt(2);
			Integer WIHfKzMn = new Integer(X0xGlsEc);
			MNA1RWwO = mfSfNbPZ.prepareStatement(UPDATE_SQL);
			MNA1RWwO.setInt(1, X0xGlsEc + 1);
			MNA1RWwO.setInt(2, NyFAWHfD);
			int Mzrv4Nwp = MNA1RWwO.executeUpdate();
			if (Mzrv4Nwp == 1) {
				aZaoFhSL = true;
				return WIHfKzMn;
			} else {
				logger.error("Something strange has happened.  The row count was not 1, but was " + Mzrv4Nwp);
				return WIHfKzMn;
			}
		} catch (SQLException Pf4ASuNB) {
			logger.error("Table based id generation failed : ");
			logger.error(Pf4ASuNB.getMessage());
			return new Integer(0);
		} finally {
			if (UYNQcqT1 != null) {
				try {
					UYNQcqT1.close();
				} catch (Exception X8M0aW6I) {
				}
			}
			if (MNA1RWwO != null) {
				try {
					MNA1RWwO.close();
				} catch (Exception OyALvOLg) {
				}
			}
			if (mfSfNbPZ != null) {
				try {
					if (aZaoFhSL) {
						mfSfNbPZ.commit();
					} else {
						mfSfNbPZ.rollback();
					}
					mfSfNbPZ.close();
				} catch (Exception DtXbMLx3) {
				}
			}
		}
	}

}