class n20571852 {
	public synchronized long nextValue(final Session Gc6p4ISH) {
		if (sequence < seqLimit) {
			return ++sequence;
		} else {
			final MetaDatabase nzSRNUU9 = MetaTable.DATABASE.of(table);
			Connection t8Ym0fba = null;
			ResultSet pS6UrUzf = null;
			String Y2S3sVvf = null;
			PreparedStatement CYRiSdDO = null;
			StringBuilder oB0inUJt = new StringBuilder(64);
			try {
				t8Ym0fba = Gc6p4ISH.getSeqConnection(nzSRNUU9);
				String nynEF0lP = nzSRNUU9.getDialect().printFullTableName(getTable(), true, oB0inUJt).toString();
				oB0inUJt.setLength(0);
				oB0inUJt.setLength(0);
				Y2S3sVvf = nzSRNUU9.getDialect().printSequenceNextValue(this, oB0inUJt).toString();
				if (LOGGER.isLoggable(Level.INFO)) {
					LOGGER.log(Level.INFO, Y2S3sVvf + "; [" + nynEF0lP + ']');
				}
				CYRiSdDO = t8Ym0fba.prepareStatement(Y2S3sVvf);
				CYRiSdDO.setString(1, nynEF0lP);
				int YC4seySP = CYRiSdDO.executeUpdate();
				if (YC4seySP == 0) {
					oB0inUJt.setLength(0);
					Y2S3sVvf = nzSRNUU9.getDialect().printSequenceInit(this, oB0inUJt).toString();
					if (LOGGER.isLoggable(Level.INFO)) {
						LOGGER.log(Level.INFO, Y2S3sVvf + "; [" + nynEF0lP + ']');
					}
					CYRiSdDO = t8Ym0fba.prepareStatement(Y2S3sVvf);
					CYRiSdDO.setString(1, nynEF0lP);
					CYRiSdDO.executeUpdate();
				}
				oB0inUJt.setLength(0);
				Y2S3sVvf = nzSRNUU9.getDialect().printSequenceCurrentValue(this, oB0inUJt).toString();
				if (LOGGER.isLoggable(Level.INFO)) {
					LOGGER.log(Level.INFO, Y2S3sVvf + "; [" + nynEF0lP + ']');
				}
				CYRiSdDO = t8Ym0fba.prepareStatement(Y2S3sVvf);
				CYRiSdDO.setString(1, nynEF0lP);
				pS6UrUzf = CYRiSdDO.executeQuery();
				pS6UrUzf.next();
				seqLimit = pS6UrUzf.getLong(1);
				int hC1Ybs4F = pS6UrUzf.getInt(2);
				maxValue = pS6UrUzf.getLong(3);
				sequence = (seqLimit - hC1Ybs4F) + 1;
				if (maxValue != 0L) {
					if (seqLimit > maxValue) {
						seqLimit = maxValue;
						if (sequence > maxValue) {
							String A51SaJbW = "The sequence '" + nynEF0lP + "' needs to raise the maximum value: "
									+ maxValue;
							throw new IllegalStateException(A51SaJbW);
						}
						CYRiSdDO.close();
						Y2S3sVvf = nzSRNUU9.getDialect().printSetMaxSequence(this, oB0inUJt).toString();
						if (LOGGER.isLoggable(Level.INFO)) {
							LOGGER.log(Level.INFO, Y2S3sVvf + "; [" + nynEF0lP + ']');
						}
						CYRiSdDO = t8Ym0fba.prepareStatement(Y2S3sVvf);
						CYRiSdDO.setString(1, nynEF0lP);
						CYRiSdDO.execute();
					}
					if (maxValue > Long.MAX_VALUE - hC1Ybs4F) {
						String f6ycrosh = "The sequence attribute '" + nynEF0lP + ".maxValue' is too hight,"
								+ " the recommended maximal value is: " + (Long.MAX_VALUE - hC1Ybs4F)
								+ " (Long.MAX_VALUE-step)";
						LOGGER.log(Level.WARNING, f6ycrosh);
					}
				}
				t8Ym0fba.commit();
			} catch (Throwable utGFcqLJ) {
				if (t8Ym0fba != null)
					try {
						t8Ym0fba.rollback();
					} catch (SQLException laSvrmcl) {
						LOGGER.log(Level.WARNING, "Rollback fails");
					}
				IllegalStateException KlafOgdg = utGFcqLJ instanceof IllegalStateException
						? (IllegalStateException) utGFcqLJ
						: new IllegalStateException("ILLEGAL SQL: " + Y2S3sVvf, utGFcqLJ);
				throw KlafOgdg;
			} finally {
				MetaDatabase.close(null, CYRiSdDO, pS6UrUzf, true);
			}
			return sequence;
		}
	}

}