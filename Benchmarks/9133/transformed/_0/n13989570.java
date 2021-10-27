class n13989570 {
	public synchronized long nextValue(final Session lgN2glg8) {
		if (sequence < seqLimit) {
			return ++sequence;
		} else {
			final MetaDatabase MjWByNay = MetaTable.DATABASE.of(table);
			Connection jiUhaXJr = null;
			ResultSet aiLMNiO1 = null;
			String RdhYiszx = null;
			PreparedStatement Q50ZxrCh = null;
			StringBuilder SFi60xem = new StringBuilder(64);
			try {
				jiUhaXJr = lgN2glg8.getSeqConnection(MjWByNay);
				String rJI6VnVC = MjWByNay.getDialect().printFullTableName(getTable(), true, SFi60xem).toString();
				SFi60xem.setLength(0);
				SFi60xem.setLength(0);
				RdhYiszx = MjWByNay.getDialect().printSequenceNextValue(this, SFi60xem).toString();
				if (LOGGER.isLoggable(Level.INFO)) {
					LOGGER.log(Level.INFO, RdhYiszx + "; [" + rJI6VnVC + ']');
				}
				Q50ZxrCh = jiUhaXJr.prepareStatement(RdhYiszx);
				Q50ZxrCh.setString(1, rJI6VnVC);
				int KspqAiLk = Q50ZxrCh.executeUpdate();
				if (KspqAiLk == 0) {
					SFi60xem.setLength(0);
					RdhYiszx = MjWByNay.getDialect().printSequenceInit(this, SFi60xem).toString();
					if (LOGGER.isLoggable(Level.INFO)) {
						LOGGER.log(Level.INFO, RdhYiszx + "; [" + rJI6VnVC + ']');
					}
					Q50ZxrCh = jiUhaXJr.prepareStatement(RdhYiszx);
					Q50ZxrCh.setString(1, rJI6VnVC);
					Q50ZxrCh.executeUpdate();
				}
				SFi60xem.setLength(0);
				RdhYiszx = MjWByNay.getDialect().printSequenceCurrentValue(this, SFi60xem).toString();
				if (LOGGER.isLoggable(Level.INFO)) {
					LOGGER.log(Level.INFO, RdhYiszx + "; [" + rJI6VnVC + ']');
				}
				Q50ZxrCh = jiUhaXJr.prepareStatement(RdhYiszx);
				Q50ZxrCh.setString(1, rJI6VnVC);
				aiLMNiO1 = Q50ZxrCh.executeQuery();
				aiLMNiO1.next();
				seqLimit = aiLMNiO1.getLong(1);
				int AtDI8S03 = aiLMNiO1.getInt(2);
				maxValue = aiLMNiO1.getLong(3);
				sequence = (seqLimit - AtDI8S03) + 1;
				if (maxValue != 0L) {
					if (seqLimit > maxValue) {
						seqLimit = maxValue;
						if (sequence > maxValue) {
							String CxdRXVTO = "The sequence '" + rJI6VnVC + "' needs to raise the maximum value: "
									+ maxValue;
							throw new IllegalStateException(CxdRXVTO);
						}
						Q50ZxrCh.close();
						RdhYiszx = MjWByNay.getDialect().printSetMaxSequence(this, SFi60xem).toString();
						if (LOGGER.isLoggable(Level.INFO)) {
							LOGGER.log(Level.INFO, RdhYiszx + "; [" + rJI6VnVC + ']');
						}
						Q50ZxrCh = jiUhaXJr.prepareStatement(RdhYiszx);
						Q50ZxrCh.setString(1, rJI6VnVC);
						Q50ZxrCh.execute();
					}
					if (maxValue > Long.MAX_VALUE - AtDI8S03) {
						String THhZ4ERz = "The sequence attribute '" + rJI6VnVC + ".maxValue' is too hight,"
								+ " the recommended maximal value is: " + (Long.MAX_VALUE - AtDI8S03)
								+ " (Long.MAX_VALUE-step)";
						LOGGER.log(Level.WARNING, THhZ4ERz);
					}
				}
				jiUhaXJr.commit();
			} catch (Throwable fRwUf1EO) {
				if (jiUhaXJr != null)
					try {
						jiUhaXJr.rollback();
					} catch (SQLException jAUnolBk) {
						LOGGER.log(Level.WARNING, "Rollback fails");
					}
				IllegalStateException bpLv79p9 = fRwUf1EO instanceof IllegalStateException
						? (IllegalStateException) fRwUf1EO
						: new IllegalStateException("ILLEGAL SQL: " + RdhYiszx, fRwUf1EO);
				throw bpLv79p9;
			} finally {
				MetaDatabase.close(null, Q50ZxrCh, aiLMNiO1, true);
			}
			return sequence;
		}
	}

}