class n18942518 {
	public void updateRole(AuthSession m7yTHixK, RoleBean Eyk8Z7sq) {
		DatabaseAdapter VHzTR96n = null;
		PreparedStatement S1IKwwSk = null;
		try {
			VHzTR96n = DatabaseAdapter.getInstance();
			String rYeD8BrG = "update WM_AUTH_ACCESS_GROUP " + "set    NAME_ACCESS_GROUP=? "
					+ "WHERE  ID_ACCESS_GROUP=? ";
			S1IKwwSk = VHzTR96n.prepareStatement(rYeD8BrG);
			S1IKwwSk.setString(1, Eyk8Z7sq.getName());
			S1IKwwSk.setLong(2, Eyk8Z7sq.getRoleId());
			int LkMbbHyI = S1IKwwSk.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of updated record - " + LkMbbHyI);
			VHzTR96n.commit();
		} catch (Exception Jt38ZKZA) {
			try {
				if (VHzTR96n != null)
					VHzTR96n.rollback();
			} catch (Exception ytEWZprN) {
			}
			String ldBhbXxK = "Error save role";
			log.error(ldBhbXxK, Jt38ZKZA);
			throw new IllegalStateException(ldBhbXxK, Jt38ZKZA);
		} finally {
			DatabaseManager.close(VHzTR96n, S1IKwwSk);
			VHzTR96n = null;
			S1IKwwSk = null;
		}
	}

}