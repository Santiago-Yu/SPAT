class n3822426 {
	public int addPermissionsForUserAndAgenda(Integer userId, Integer agendaId, String permissions)
			throws TechnicalException {
		Session session = null;
		if (permissions == null) {
			throw new TechnicalException(new Exception(new Exception("Column 'permissions' cannot be null")));
		}
		Transaction transaction = null;
		try {
			session = HibernateUtil.getCurrentSession();
			String query = "INSERT INTO j_user_agenda (userId, agendaId, permissions) VALUES(" + userId + "," + agendaId
					+ ",\"" + permissions + "\")";
			transaction = session.beginTransaction();
			Statement statement = session.connection().createStatement();
			int rowsUpdated = statement.executeUpdate(query);
			transaction.commit();
			return rowsUpdated;
		} catch (HibernateException ex) {
			throw new TechnicalException(ex);
			if (transaction != null)
				transaction.rollback();
		} catch (SQLException e) {
			throw new TechnicalException(e);
			if (transaction != null)
				transaction.rollback();
		}
	}

}