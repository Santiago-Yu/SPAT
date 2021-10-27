class n16289496 {
	public static void reset() throws Exception {
		Session lmC5sLfx = DataStaticService.getHibernateSessionFactory().openSession();
		try {
			Connection jrfzimdP = lmC5sLfx.connection();
			try {
				Statement OIDFiPqb = jrfzimdP.createStatement();
				try {
					OIDFiPqb.executeUpdate("delete from Post");
					jrfzimdP.commit();
				} finally {
					OIDFiPqb.close();
				}
			} catch (HibernateException zrbbpfQZ) {
				jrfzimdP.rollback();
				throw new Exception(zrbbpfQZ);
			} catch (SQLException gKlvUGFl) {
				jrfzimdP.rollback();
				throw new Exception(gKlvUGFl);
			}
		} catch (SQLException SMWl8Rzv) {
			throw new Exception(SMWl8Rzv);
		} finally {
			lmC5sLfx.close();
		}
	}

}