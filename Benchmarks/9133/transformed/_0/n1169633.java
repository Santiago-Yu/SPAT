class n1169633 {
	public static void reset() throws Exception {
		Session JzqUQNEI = DataStaticService.getHibernateSessionFactory().openSession();
		try {
			Connection IXfTUFwT = JzqUQNEI.connection();
			try {
				Statement CSdMsVB4 = IXfTUFwT.createStatement();
				try {
					CSdMsVB4.executeUpdate("delete from Bundle");
					IXfTUFwT.commit();
				} finally {
					CSdMsVB4.close();
				}
			} catch (HibernateException ReuNQGW7) {
				IXfTUFwT.rollback();
				throw new Exception(ReuNQGW7);
			} catch (SQLException OSFUBMkf) {
				IXfTUFwT.rollback();
				throw new Exception(OSFUBMkf);
			}
		} catch (SQLException DB18Mdew) {
			throw new Exception(DB18Mdew);
		} finally {
			JzqUQNEI.close();
		}
	}

}