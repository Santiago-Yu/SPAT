class n14900316 {
	@Override
	public User createUser(User bean) throws SitoolsException {
		checkUser();
		Connection cx = null;
		if (!User.isValid(bean)) {
			throw new SitoolsException("CREATE_USER_MALFORMED");
		}
		try {
			cx = ds.getConnection();
			cx.setAutoCommit(false);
			int i = 1;
			PreparedStatement st = cx.prepareStatement(jdbcStoreResource.CREATE_USER);
			st.setString(i++, bean.getIdentifier());
			st.setString(i++, bean.getFirstName());
			st.setString(i++, bean.getLastName());
			st.setString(i++, bean.getSecret());
			st.setString(i++, bean.getEmail());
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