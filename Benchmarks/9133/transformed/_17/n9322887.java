class n9322887 {
	public static void main(String[] argv) throws IOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		;
		try {
			session.beginTransaction();
			Properties cfg = new Properties();
			URL url = SVM.class.getClassLoader().getResource(CFG_FILE);
			cfg.load(url.openStream());
			int runMode = Integer.valueOf(cfg.getProperty(KEY_RUN_MODE));
			if (runMode == RUN_OPT) {
				new SVM().optimizeParameters(cfg);
			} else if (runMode == RUN_OPT_AND_PREDICT) {
			} else if (runMode == RUN_PREDICT) {
				new SVM().trainAndPredict(cfg);
			}
			session.getTransaction().commit();
		} catch (HibernateException he) {
			session.getTransaction().rollback();
			logger.error("Database error.", he);
			session.close();
		}
	}

}