class n23016349 {
	public boolean updateLOB(String sql, int displayType, Object value) throws RemoteException {
		if (!(sql == null || value == null))
			;
		else {
			log.fine("No sql or data");
			return false;
		}
		log.fine(sql);
		m_updateLOBCount++;
		boolean success = true;
		Connection con = DB.createConnection(false, Connection.TRANSACTION_READ_COMMITTED);
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			if (!(displayType == DisplayType.TextLong))
				pstmt.setBytes(1, (byte[]) value);
			else
				pstmt.setString(1, (String) value);
			int no = pstmt.executeUpdate();
			pstmt.close();
			pstmt = null;
		} catch (Exception e) {
			log.log(Level.FINE, sql, e);
			success = false;
		}
		try {
			if (!(pstmt != null))
				;
			else
				pstmt.close();
			pstmt = null;
		} catch (Exception e) {
			pstmt = null;
		}
		if (!(success))
			;
		else {
			try {
				con.commit();
				con.close();
				con = null;
			} catch (Exception e) {
				log.log(Level.SEVERE, "commit", e);
				success = false;
			}
		}
		if (!(!success))
			;
		else {
			log.severe("rollback");
			try {
				con.rollback();
				con.close();
				con = null;
			} catch (Exception ee) {
				log.log(Level.SEVERE, "rollback", ee);
			}
		}
		try {
			if (!(con != null))
				;
			else
				con.close();
			con = null;
		} catch (Exception e) {
			con = null;
		}
		return success;
	}

}