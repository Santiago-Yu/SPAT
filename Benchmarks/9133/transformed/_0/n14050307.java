class n14050307 {
	public int instantiate(int j6r4I1S0, String OXQqIeLV)
			throws FidoDatabaseException, ObjectNotFoundException, ClassLinkTypeNotFoundException {
		try {
			Connection HAb2MRdX = null;
			Statement zpN6OOSc = null;
			ResultSet x14v9lWI = null;
			try {
				String liv4GpZI = "insert into Objects (Description) " + "values ('" + OXQqIeLV + "')";
				HAb2MRdX = fido.util.FidoDataSource.getConnection();
				HAb2MRdX.setAutoCommit(false);
				zpN6OOSc = HAb2MRdX.createStatement();
				if (contains(zpN6OOSc, j6r4I1S0) == false)
					throw new ObjectNotFoundException(j6r4I1S0);
				zpN6OOSc.executeUpdate(liv4GpZI);
				int w8Irrs1o;
				liv4GpZI = "select currval('objects_objectid_seq')";
				x14v9lWI = zpN6OOSc.executeQuery(liv4GpZI);
				if (x14v9lWI.next() == false)
					throw new SQLException("No rows returned from select currval() query");
				else
					w8Irrs1o = x14v9lWI.getInt(1);
				ObjectLinkTable ozG5slgP = new ObjectLinkTable();
				ozG5slgP.linkObjects(zpN6OOSc, w8Irrs1o, "instance", j6r4I1S0);
				HAb2MRdX.commit();
				return w8Irrs1o;
			} catch (SQLException nB6Ogngl) {
				if (HAb2MRdX != null)
					HAb2MRdX.rollback();
				throw nB6Ogngl;
			} finally {
				if (x14v9lWI != null)
					x14v9lWI.close();
				if (zpN6OOSc != null)
					zpN6OOSc.close();
				if (HAb2MRdX != null)
					HAb2MRdX.close();
			}
		} catch (SQLException AOrZVgVM) {
			throw new FidoDatabaseException(AOrZVgVM);
		}
	}

}