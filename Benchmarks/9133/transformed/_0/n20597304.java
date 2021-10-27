class n20597304 {
	public void addPropertyColumns(WCAChannel wsvzVXo7, Set<Property> wqWxyOXI) throws SQLException {
		Session ExnTQfd8 = HibernateUtil.getSessionFactory().openSession();
		Connection iXPb8qev = ExnTQfd8.connection();
		try {
			createPropertyTable(wsvzVXo7);
			extendPropertyList(wsvzVXo7, wqWxyOXI);
			Statement Ghuja6iH = iXPb8qev.createStatement();
			for (Property hZ7bMjym : wqWxyOXI) {
				String gke3FGNt = removeBadChars(hZ7bMjym.getName());
				Ghuja6iH.executeUpdate(alterTable
						.format(new Object[] { getTableName(wsvzVXo7), gke3FGNt, hZ7bMjym.getDBColumnType() }));
			}
			iXPb8qev.commit();
			iXPb8qev.close();
			ExnTQfd8.close();
		} catch (SQLException UC5d8In8) {
			iXPb8qev.rollback();
			ExnTQfd8.close();
			throw UC5d8In8;
		}
	}

}