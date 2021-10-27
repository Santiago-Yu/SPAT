class n22765730 {
	public void addUser(String KUtnHGJE, String tgIvXo4K, String fDVnJv4Q, int RkRrsWh4, int Bs9xe6R8,
			String MPtCixX0) {
		Connection jy4qA1Sc = null;
		PreparedStatement MzzWBXtG = null;
		DBOperation GLjPPIcF = factory.createDBOperation(POOL_NAME);
		try {
			jy4qA1Sc = GLjPPIcF.getConnection();
			MzzWBXtG = jy4qA1Sc.prepareStatement(INSERT_USER);
			MzzWBXtG.setInt(1, AddrslistMainDao.getNewID());
			MzzWBXtG.setInt(2, -100);
			MzzWBXtG.setString(3, KUtnHGJE.substring(0, 1));
			MzzWBXtG.setString(4, KUtnHGJE.substring(1));
			MzzWBXtG.setString(5, tgIvXo4K);
			MzzWBXtG.setString(6, fDVnJv4Q);
			MzzWBXtG.setString(7, "");
			MzzWBXtG.setString(8, MPtCixX0);
			MzzWBXtG.setString(9, "");
			MzzWBXtG.setString(10, "");
			MzzWBXtG.setString(11, "");
			MzzWBXtG.setString(12, "");
			MzzWBXtG.setString(13, "");
			MzzWBXtG.setString(14, "");
			MzzWBXtG.setString(15, "");
			MzzWBXtG.setString(16, "");
			MzzWBXtG.setString(17, "");
			MzzWBXtG.setString(18, "");
			MzzWBXtG.setInt(19, RkRrsWh4);
			MzzWBXtG.setInt(20, Bs9xe6R8);
			MzzWBXtG.executeUpdate();
			jy4qA1Sc.commit();
		} catch (Exception XdjXKN9n) {
			XdjXKN9n.printStackTrace();
			try {
				jy4qA1Sc.rollback();
			} catch (SQLException m5hMJtv9) {
			}
		} finally {
			try {
				MzzWBXtG.close();
				jy4qA1Sc.close();
				GLjPPIcF.close();
			} catch (Exception qVILLD5x) {
			}
		}
	}

}