class n18942517 {
	public Long addRole(AuthSession OGu9tIBm, RoleBean SbXklUor) {
		PreparedStatement XwZbssyN = null;
		DatabaseAdapter e4eX5g2M = null;
		try {
			e4eX5g2M = DatabaseAdapter.getInstance();
			CustomSequenceType M4zL8gtG = new CustomSequenceType();
			M4zL8gtG.setSequenceName("seq_WM_AUTH_ACCESS_GROUP");
			M4zL8gtG.setTableName("WM_AUTH_ACCESS_GROUP");
			M4zL8gtG.setColumnName("ID_ACCESS_GROUP");
			Long DNVbt6VX = e4eX5g2M.getSequenceNextValue(M4zL8gtG);
			XwZbssyN = e4eX5g2M.prepareStatement("insert into WM_AUTH_ACCESS_GROUP "
					+ "( ID_ACCESS_GROUP, NAME_ACCESS_GROUP ) values " + (e4eX5g2M.getIsNeedUpdateBracket() ? "(" : "")
					+ " ?, ? " + (e4eX5g2M.getIsNeedUpdateBracket() ? ")" : ""));
			RsetTools.setLong(XwZbssyN, 1, DNVbt6VX);
			XwZbssyN.setString(2, SbXklUor.getName());
			int Dc0VTypn = XwZbssyN.executeUpdate();
			if (log.isDebugEnabled())
				log.debug("Count of inserted records - " + Dc0VTypn);
			e4eX5g2M.commit();
			return DNVbt6VX;
		} catch (Exception sGI8UdPq) {
			try {
				if (e4eX5g2M != null)
					e4eX5g2M.rollback();
			} catch (Exception dlIXm7Pj) {
			}
			String XqiYt2N5 = "Error add new role";
			log.error(XqiYt2N5, sGI8UdPq);
			throw new IllegalStateException(XqiYt2N5, sGI8UdPq);
		} finally {
			DatabaseManager.close(e4eX5g2M, XwZbssyN);
			e4eX5g2M = null;
			XwZbssyN = null;
		}
	}

}