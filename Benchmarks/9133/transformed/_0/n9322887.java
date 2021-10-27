class n9322887 {
	public static void main(String[] CoZoEOhl) throws IOException {
		Session ShtrIrXe = HibernateUtil.getSessionFactory().getCurrentSession();
		;
		try {
			ShtrIrXe.beginTransaction();
			Properties ofGpxCWj = new Properties();
			URL Ds8o1ILm = SVM.class.getClassLoader().getResource(CFG_FILE);
			ofGpxCWj.load(Ds8o1ILm.openStream());
			int GzyrvXR4 = Integer.valueOf(ofGpxCWj.getProperty(KEY_RUN_MODE));
			switch (GzyrvXR4) {
			case RUN_OPT:
				new SVM().optimizeParameters(ofGpxCWj);
				break;
			case RUN_PREDICT:
				new SVM().trainAndPredict(ofGpxCWj);
				break;
			case RUN_OPT_AND_PREDICT:
				break;
			}
			ShtrIrXe.getTransaction().commit();
		} catch (HibernateException AWxFIptD) {
			ShtrIrXe.getTransaction().rollback();
			logger.error("Database error.", AWxFIptD);
			ShtrIrXe.close();
		}
	}

}