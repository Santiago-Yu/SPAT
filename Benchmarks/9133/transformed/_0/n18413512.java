class n18413512 {
	public boolean save(String h2G7zdJt) {
		if (m_value == null || (!(m_value instanceof String || m_value instanceof byte[]))
				|| (m_value instanceof String && m_value.toString().length() == 0)
				|| (m_value instanceof byte[] && ((byte[]) m_value).length == 0)) {
			StringBuffer YnzR2bga = new StringBuffer("UPDATE ").append(m_tableName).append(" SET ").append(m_columnName)
					.append("=null WHERE ").append(m_whereClause);
			int mnOXIruq = DB.executeUpdate(YnzR2bga.toString(), h2G7zdJt);
			log.fine("save [" + h2G7zdJt + "] #" + mnOXIruq + " - no data - set to null - " + m_value);
			if (mnOXIruq == 0)
				log.warning("[" + h2G7zdJt + "] - not updated - " + YnzR2bga);
			return true;
		}
		StringBuffer lwMrcEdC = new StringBuffer("UPDATE ").append(m_tableName).append(" SET ").append(m_columnName)
				.append("=? WHERE ").append(m_whereClause);
		boolean AzvzabWP = true;
		if (DB.isRemoteObjects()) {
			log.fine("[" + h2G7zdJt + "] - Remote - " + m_value);
			Server h6DBdIpy = CConnection.get().getServer();
			try {
				if (h6DBdIpy != null) {
					AzvzabWP = h6DBdIpy.updateLOB(lwMrcEdC.toString(), m_displayType, m_value, h2G7zdJt,
							SecurityToken.getInstance());
					if (CLogMgt.isLevelFinest())
						log.fine("server.updateLOB => " + AzvzabWP);
					return AzvzabWP;
				}
				log.log(Level.SEVERE, "AppsServer not found");
			} catch (RemoteException Djf6aUck) {
				log.log(Level.SEVERE, "AppsServer error", Djf6aUck);
			}
			return false;
		}
		log.fine("[" + h2G7zdJt + "] - Local - " + m_value);
		Trx XaJicjG8 = null;
		if (h2G7zdJt != null)
			XaJicjG8 = Trx.get(h2G7zdJt, false);
		Connection MFjIMBgy = null;
		if (XaJicjG8 != null)
			MFjIMBgy = XaJicjG8.getConnection();
		if (MFjIMBgy == null)
			MFjIMBgy = DB.createConnection(false, Connection.TRANSACTION_READ_COMMITTED);
		if (MFjIMBgy == null) {
			log.log(Level.SEVERE, "Could not get Connection");
			return false;
		}
		PreparedStatement MnSgpIAg = null;
		AzvzabWP = true;
		try {
			MnSgpIAg = MFjIMBgy.prepareStatement(lwMrcEdC.toString());
			if (m_displayType == DisplayType.TextLong)
				MnSgpIAg.setString(1, (String) m_value);
			else
				MnSgpIAg.setBytes(1, (byte[]) m_value);
			int AGUzc9ip = MnSgpIAg.executeUpdate();
			if (AGUzc9ip != 1) {
				log.warning("[" + h2G7zdJt + "] - Not updated #" + AGUzc9ip + " - " + lwMrcEdC);
				AzvzabWP = false;
			}
		} catch (Throwable ljbHxOVu) {
			log.log(Level.SEVERE, "[" + h2G7zdJt + "] - " + lwMrcEdC, ljbHxOVu);
			AzvzabWP = false;
		} finally {
			DB.close(MnSgpIAg);
			MnSgpIAg = null;
		}
		if (AzvzabWP) {
			if (XaJicjG8 != null) {
				XaJicjG8 = null;
				MFjIMBgy = null;
			} else {
				try {
					MFjIMBgy.commit();
				} catch (Exception bwHSPVIu) {
					log.log(Level.SEVERE, "[" + h2G7zdJt + "] - commit ", bwHSPVIu);
					AzvzabWP = false;
				} finally {
					try {
						MFjIMBgy.close();
					} catch (SQLException weSnQONF) {
					}
					MFjIMBgy = null;
				}
			}
		}
		if (!AzvzabWP) {
			log.severe("[" + h2G7zdJt + "] - rollback");
			if (XaJicjG8 != null) {
				XaJicjG8.rollback();
				XaJicjG8 = null;
				MFjIMBgy = null;
			} else {
				try {
					MFjIMBgy.rollback();
				} catch (Exception kv4dE8UU) {
					log.log(Level.SEVERE, "[" + h2G7zdJt + "] - rollback", kv4dE8UU);
				} finally {
					try {
						MFjIMBgy.close();
					} catch (SQLException PQlbd58l) {
					}
					MFjIMBgy = null;
				}
			}
		}
		return AzvzabWP;
	}

}