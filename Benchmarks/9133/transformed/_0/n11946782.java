class n11946782 {
	public static void addIntegrityEnforcements(Session Ar4i9krk) throws HibernateException {
		Transaction KhGJLpFZ = null;
		try {
			KhGJLpFZ = Ar4i9krk.beginTransaction();
			Statement cG7ZRK9P = Ar4i9krk.connection().createStatement();
			cG7ZRK9P.executeUpdate("DROP TABLE hresperformsrole;" + "CREATE TABLE hresperformsrole" + "("
					+ "hresid varchar(255) NOT NULL," + "rolename varchar(255) NOT NULL,"
					+ "CONSTRAINT hresperformsrole_pkey PRIMARY KEY (hresid, rolename),"
					+ "CONSTRAINT ResourceFK FOREIGN KEY (hresid) REFERENCES resserposid (id) ON UPDATE CASCADE ON DELETE CASCADE,"
					+ "CONSTRAINT RoleFK FOREIGN KEY (rolename) REFERENCES role (rolename) ON UPDATE CASCADE ON DELETE CASCADE"
					+ ");");
			KhGJLpFZ.commit();
		} catch (Exception Cn46O9y1) {
			KhGJLpFZ.rollback();
		}
	}

}