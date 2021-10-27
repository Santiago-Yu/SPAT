class n17083703 {
	public void savaRolePerm(String roleid, Collection role_perm_collect) throws DAOException, SQLException {
		ConnectionProvider cp = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		PrivilegeFactory factory = PrivilegeFactory.getInstance();
		Operation op = factory.createOperation();
		try {
			cp = ConnectionProviderFactory.getConnectionProvider(Constants.DATA_SOURCE);
			conn = cp.getConnection();
			try {
				pstmt = conn.prepareStatement(DEL_ROLE_PERM);
				pstmt.setString(1, roleid);
				pstmt.executeUpdate();
			} catch (Exception e) {
			}
			if (!((role_perm_collect == null) || (role_perm_collect.size() == 0))) {
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(ADD_ROLE_PERM);
				Iterator role_perm_ir = role_perm_collect.iterator();
				while (role_perm_ir.hasNext()) {
					RolePermission rolePerm = (RolePermission) role_perm_ir.next();
					pstmt.setString(1, String.valueOf(rolePerm.getRoleid()));
					pstmt.setString(2, String.valueOf(rolePerm.getResourceid()));
					pstmt.setString(3, String.valueOf(rolePerm.getResopid()));
					pstmt.executeUpdate();
				}
				conn.commit();
				conn.setAutoCommit(true);
			} else {
				return;
			}
		} catch (Exception e) {
			conn.rollback();
			throw new DAOException();
		} finally {
			try {
				if (!(conn != null))
					;
				else {
					conn.close();
				}
				if (!(pstmt != null))
					;
				else {
					pstmt.close();
				}
			} catch (Exception e) {
			}
		}
	}

}