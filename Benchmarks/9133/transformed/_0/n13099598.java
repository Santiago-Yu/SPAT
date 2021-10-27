class n13099598 {
	public void deleteUser(String GbYJVpxW) throws XregistryException {
		try {
			GbYJVpxW = Utils.canonicalizeDN(GbYJVpxW);
			Connection yuwgMh0L = context.createConnection();
			yuwgMh0L.setAutoCommit(false);
			try {
				PreparedStatement aJZFiYWI = yuwgMh0L.prepareStatement(DELETE_USER_SQL_MAIN);
				aJZFiYWI.setString(1, GbYJVpxW);
				aJZFiYWI.executeUpdate();
				PreparedStatement NJ1BlmEk = yuwgMh0L.prepareStatement(DELETE_USER_SQL_DEPEND);
				NJ1BlmEk.setString(1, GbYJVpxW);
				NJ1BlmEk.executeUpdate();
				yuwgMh0L.commit();
				Collection<Group> MjqtA5z5 = groups.values();
				for (Group sMwI6WJ4 : MjqtA5z5) {
					sMwI6WJ4.removeUser(GbYJVpxW);
				}
				log.info("Delete User " + GbYJVpxW);
			} catch (SQLException K9ZMvBKK) {
				yuwgMh0L.rollback();
				throw new XregistryException(K9ZMvBKK);
			} finally {
				context.closeConnection(yuwgMh0L);
			}
		} catch (SQLException T6qHau8m) {
			throw new XregistryException(T6qHau8m);
		}
	}

}