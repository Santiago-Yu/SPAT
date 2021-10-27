class n16470512 {
	public static void reset() throws Exception {
		Session BvBXzB5s = DataStaticService.getHibernateSessionFactory().openSession();
		try {
			Connection x4lkxRJ8 = BvBXzB5s.connection();
			try {
				Statement rk0wejyw = x4lkxRJ8.createStatement();
				try {
					rk0wejyw.executeUpdate("delete from Tag");
					x4lkxRJ8.commit();
				} finally {
					rk0wejyw.close();
				}
			} catch (HibernateException FS2L5fOB) {
				x4lkxRJ8.rollback();
				throw new Exception(FS2L5fOB);
			} catch (SQLException S0uqv6sW) {
				x4lkxRJ8.rollback();
				throw new Exception(S0uqv6sW);
			}
		} catch (SQLException ZC7xvPyy) {
			throw new Exception(ZC7xvPyy);
		} finally {
			BvBXzB5s.close();
		}
	}

}