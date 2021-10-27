class n17083702 {
	public void savaUserPerm(String EMUOSzUI, Collection UFOo8Ub6) throws DAOException, SQLException {
		ConnectionProvider Owxtj0IT = null;
		Connection E5k9ryt1 = null;
		ResultSet ShCqqrho = null;
		PreparedStatement gvHdMUfA = null;
		PrivilegeFactory bNV6fF74 = PrivilegeFactory.getInstance();
		Operation aV6erckJ = bNV6fF74.createOperation();
		try {
			Owxtj0IT = ConnectionProviderFactory.getConnectionProvider(Constants.DATA_SOURCE);
			E5k9ryt1 = Owxtj0IT.getConnection();
			gvHdMUfA = E5k9ryt1.prepareStatement(DEL_USER_PERM);
			gvHdMUfA.setString(1, EMUOSzUI);
			gvHdMUfA.executeUpdate();
			if ((UFOo8Ub6 == null) || (UFOo8Ub6.size() <= 0)) {
				return;
			} else {
				E5k9ryt1.setAutoCommit(false);
				gvHdMUfA = E5k9ryt1.prepareStatement(ADD_USER_PERM);
				Iterator xXxUneG8 = UFOo8Ub6.iterator();
				while (xXxUneG8.hasNext()) {
					UserPermission qwEhja6u = (UserPermission) xXxUneG8.next();
					gvHdMUfA.setString(1, String.valueOf(qwEhja6u.getUser_id()));
					gvHdMUfA.setString(2, String.valueOf(qwEhja6u.getResource_id()));
					gvHdMUfA.setString(3, String.valueOf(qwEhja6u.getResop_id()));
					gvHdMUfA.executeUpdate();
				}
				E5k9ryt1.commit();
				E5k9ryt1.setAutoCommit(true);
			}
		} catch (Exception gLpElSZV) {
			gLpElSZV.printStackTrace();
			E5k9ryt1.rollback();
			throw new DAOException();
		} finally {
			try {
				if (E5k9ryt1 != null) {
					E5k9ryt1.close();
				}
				if (gvHdMUfA != null) {
					gvHdMUfA.close();
				}
			} catch (Exception B7FKSo0y) {
			}
		}
	}

}