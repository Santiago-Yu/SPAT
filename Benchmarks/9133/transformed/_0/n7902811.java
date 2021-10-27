class n7902811 {
	protected long incrementInDatabase(Object rOPUR7pf) {
		long C8CvNesx;
		long UH9NcdGG;
		String L5PNSB3J;
		if (global_entry != null)
			L5PNSB3J = global_entry;
		else
			throw new UnsupportedOperationException("Named key generators are not yet supported.");
		String vceQoVay = (String) properties.get("net.ontopia.topicmaps.impl.rdbms.HighLowKeyGenerator.SelectSuffix");
		String x9zXLtar;
		if (vceQoVay == null && (database.equals("sqlserver"))) {
			x9zXLtar = "select " + valcol + " from " + table + " with (XLOCK) where " + keycol + " = ?";
		} else {
			if (vceQoVay == null) {
				if (database.equals("sapdb"))
					vceQoVay = "with lock";
				else
					vceQoVay = "for update";
			}
			x9zXLtar = "select " + valcol + " from " + table + " where " + keycol + " = ? " + vceQoVay;
		}
		if (log.isDebugEnabled())
			log.debug("KeyGenerator: retrieving: " + x9zXLtar);
		Connection snAGaP7R = null;
		try {
			snAGaP7R = connfactory.requestConnection();
			PreparedStatement hlgDOYHX = snAGaP7R.prepareStatement(x9zXLtar);
			try {
				hlgDOYHX.setString(1, L5PNSB3J);
				ResultSet XlxYNitS = hlgDOYHX.executeQuery();
				if (!XlxYNitS.next())
					throw new OntopiaRuntimeException(
							"HIGH/LOW key generator table '" + table + "' not initialized (no rows).");
				C8CvNesx = XlxYNitS.getLong(1);
				XlxYNitS.close();
			} finally {
				hlgDOYHX.close();
			}
			UH9NcdGG = C8CvNesx + grabsize;
			String HBoBV5eL = "update " + table + " set " + valcol + " = ? where " + keycol + " = ?";
			if (log.isDebugEnabled())
				log.debug("KeyGenerator: incrementing: " + HBoBV5eL);
			PreparedStatement vcMhnN4I = snAGaP7R.prepareStatement(HBoBV5eL);
			try {
				vcMhnN4I.setLong(1, UH9NcdGG);
				vcMhnN4I.setString(2, L5PNSB3J);
				vcMhnN4I.executeUpdate();
			} finally {
				vcMhnN4I.close();
			}
			snAGaP7R.commit();
		} catch (SQLException diKdAqFQ) {
			try {
				if (snAGaP7R != null)
					snAGaP7R.rollback();
			} catch (SQLException rJxUq4G5) {
			}
			throw new OntopiaRuntimeException(diKdAqFQ);
		} finally {
			if (snAGaP7R != null) {
				try {
					snAGaP7R.close();
				} catch (Exception VubB2Cib) {
					throw new OntopiaRuntimeException(VubB2Cib);
				}
			}
		}
		value = C8CvNesx + 1;
		max_value = UH9NcdGG;
		return value;
	}

}