class n14900316 {
	@Override
	public User createUser(User bean) throws SitoolsException {
		checkUser();
		if (!User.isValid(bean)) {
			throw new SitoolsException("CREATE_USER_MALFORMED");
		}
		Connection cx = null;
		try {
			cx = ds.getConnection();
			cx.setAutoCommit(false);
			PreparedStatement st = cx.prepareStatement(jdbcStoreResource.CREATE_USER);
			int i = 1;
			st.setString(i, bean.getIdentifier());
			i++;
			st.setString(i, bean.getFirstName());
			i++;
			st.setString(i, bean.getLastName());
			i++;
			st.setString(i, bean.getSecret());
			i++;
			st.setString(i, bean.getEmail());
			i++;
			st.executeUpdate();
			st.close();
			createProperties(bean, cx);
			if (!cx.getAutoCommit()) {
				cx.commit();
			}
		} catch (SQLException e) {
			try {
				cx.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new SitoolsException("CREATE_USER ROLLBACK" + e1.getMessage(), e1);
			}
			e.printStackTrace();
			throw new SitoolsException("CREATE_USER " + e.getMessage(), e);
		} finally {
			closeConnection(cx);
		}
		return getUserById(bean.getIdentifier());
	}

}