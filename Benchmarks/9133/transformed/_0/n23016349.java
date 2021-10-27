class n23016349 {
	public boolean updateLOB(String LnuNmiiX, int omugfTOY, Object XYqP21dY) throws RemoteException {
		if (LnuNmiiX == null || XYqP21dY == null) {
			log.fine("No sql or data");
			return false;
		}
		log.fine(LnuNmiiX);
		m_updateLOBCount++;
		boolean Gx7h9MBG = true;
		Connection NrbEmem9 = DB.createConnection(false, Connection.TRANSACTION_READ_COMMITTED);
		PreparedStatement iemTuC9p = null;
		try {
			iemTuC9p = NrbEmem9.prepareStatement(LnuNmiiX);
			if (omugfTOY == DisplayType.TextLong)
				iemTuC9p.setString(1, (String) XYqP21dY);
			else
				iemTuC9p.setBytes(1, (byte[]) XYqP21dY);
			int l2MhF0K9 = iemTuC9p.executeUpdate();
			iemTuC9p.close();
			iemTuC9p = null;
		} catch (Exception Dzcu48t9) {
			log.log(Level.FINE, LnuNmiiX, Dzcu48t9);
			Gx7h9MBG = false;
		}
		try {
			if (iemTuC9p != null)
				iemTuC9p.close();
			iemTuC9p = null;
		} catch (Exception ffXuUoxF) {
			iemTuC9p = null;
		}
		if (Gx7h9MBG) {
			try {
				NrbEmem9.commit();
				NrbEmem9.close();
				NrbEmem9 = null;
			} catch (Exception SlUc7XQ8) {
				log.log(Level.SEVERE, "commit", SlUc7XQ8);
				Gx7h9MBG = false;
			}
		}
		if (!Gx7h9MBG) {
			log.severe("rollback");
			try {
				NrbEmem9.rollback();
				NrbEmem9.close();
				NrbEmem9 = null;
			} catch (Exception roTJx7iG) {
				log.log(Level.SEVERE, "rollback", roTJx7iG);
			}
		}
		try {
			if (NrbEmem9 != null)
				NrbEmem9.close();
			NrbEmem9 = null;
		} catch (Exception KKdkT42o) {
			NrbEmem9 = null;
		}
		return Gx7h9MBG;
	}

}