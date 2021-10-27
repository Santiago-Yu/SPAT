class n21224680 {
	public void add(String ioyzkOB5, String j6Ktenn7, boolean IvEpvPS2, boolean qBHKmWyG) throws FidoDatabaseException {
		try {
			Connection mUxa655I = null;
			Statement U11LiYVc = null;
			try {
				mUxa655I = FidoDataSource.getConnection();
				mUxa655I.setAutoCommit(false);
				U11LiYVc = mUxa655I.createStatement();
				String DCNwdn6z;
				if (contains(U11LiYVc, ioyzkOB5) == true) {
					DCNwdn6z = "update Principals set Password = '" + j6Ktenn7 + "' " + " where PrincipalId = '"
							+ ioyzkOB5 + "'";
				} else {
					DCNwdn6z = "insert into Principals (PrincipalId, Password) " + " values ('" + ioyzkOB5 + "', '"
							+ j6Ktenn7 + "')";
				}
				U11LiYVc.executeUpdate(DCNwdn6z);
				updateRoles(U11LiYVc, ioyzkOB5, IvEpvPS2, qBHKmWyG);
				mUxa655I.commit();
			} catch (SQLException i56PTfSb) {
				if (mUxa655I != null)
					mUxa655I.rollback();
				throw i56PTfSb;
			} finally {
				if (U11LiYVc != null)
					U11LiYVc.close();
				if (mUxa655I != null)
					mUxa655I.close();
			}
		} catch (SQLException LQK5E4eg) {
			throw new FidoDatabaseException(LQK5E4eg);
		}
	}

}