class n14050303 {
	public int subclass(int e3fXttdK, String OvIvKLwP) throws FidoDatabaseException, ObjectNotFoundException {
		try {
			Connection vAL4PBY1 = null;
			Statement vQFUOjXc = null;
			ResultSet CNvNtnwe = null;
			try {
				String S71DspEe = "insert into Objects (Description) " + "values ('" + OvIvKLwP + "')";
				vAL4PBY1 = fido.util.FidoDataSource.getConnection();
				vAL4PBY1.setAutoCommit(false);
				vQFUOjXc = vAL4PBY1.createStatement();
				if (contains(vQFUOjXc, e3fXttdK) == false)
					throw new ObjectNotFoundException(e3fXttdK);
				vQFUOjXc.executeUpdate(S71DspEe);
				int MYGzBHaY;
				S71DspEe = "select currval('objects_objectid_seq')";
				CNvNtnwe = vQFUOjXc.executeQuery(S71DspEe);
				if (CNvNtnwe.next() == false)
					throw new SQLException("No rows returned from select currval() query");
				else
					MYGzBHaY = CNvNtnwe.getInt(1);
				ObjectLinkTable sl8j9TWs = new ObjectLinkTable();
				sl8j9TWs.linkObjects(vQFUOjXc, MYGzBHaY, "isa", e3fXttdK);
				vAL4PBY1.commit();
				return MYGzBHaY;
			} catch (SQLException VxBcoF0e) {
				if (vAL4PBY1 != null)
					vAL4PBY1.rollback();
				throw VxBcoF0e;
			} finally {
				if (CNvNtnwe != null)
					CNvNtnwe.close();
				if (vQFUOjXc != null)
					vQFUOjXc.close();
				if (vAL4PBY1 != null)
					vAL4PBY1.close();
			}
		} catch (SQLException UA6iIjo2) {
			throw new FidoDatabaseException(UA6iIjo2);
		}
	}

}