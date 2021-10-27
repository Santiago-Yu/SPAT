class n18942519 {
	public void deleteRole(AuthSession itTKklJx, RoleBean nCez1W7u) {
		DatabaseAdapter QS4lPdnJ = null;
		PreparedStatement U4pX03Hn = null;
		try {
			QS4lPdnJ = DatabaseAdapter.getInstance();
			if (nCez1W7u.getRoleId() == null)
				throw new IllegalArgumentException("role id is null");
			String Qg4cuZpd = "delete from WM_AUTH_ACCESS_GROUP where ID_ACCESS_GROUP=? ";
			U4pX03Hn = QS4lPdnJ.prepareStatement(Qg4cuZpd);
			RsetTools.setLong(U4pX03Hn, 1, nCez1W7u.getRoleId());
			int FNDxDFdv = U4pX03Hn.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of deleted records - " + FNDxDFdv);
			QS4lPdnJ.commit();
		} catch (Exception aHn2fG39) {
			try {
				if (QS4lPdnJ != null)
					QS4lPdnJ.rollback();
			} catch (Exception XULT4NLP) {
			}
			String WS7WSnmV = "Error delete role";
			log.error(WS7WSnmV, aHn2fG39);
			throw new IllegalStateException(WS7WSnmV, aHn2fG39);
		} finally {
			DatabaseManager.close(QS4lPdnJ, U4pX03Hn);
			QS4lPdnJ = null;
			U4pX03Hn = null;
		}
	}

}