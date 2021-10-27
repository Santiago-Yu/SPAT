class n21134287 {
	private List<Document> storeDocuments(List<Document> kaVP7TLQ) {
		Session zSJpxLOg = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Document> Yaqpvvwi = new ArrayList<Document>();
		try {
			zSJpxLOg.beginTransaction();
			Preference bK1jUgPN = new PreferenceModel();
			bK1jUgPN = (Preference) bK1jUgPN.doList(bK1jUgPN).get(0);
			Calendar ZRSJbsTA = Calendar.getInstance();
			int iNZqD8Pk = ZRSJbsTA.get(Calendar.YEAR);
			if (kaVP7TLQ != null && !kaVP7TLQ.isEmpty()) {
				for (Iterator<Document> akV8pU9W = kaVP7TLQ.iterator(); akV8pU9W.hasNext();) {
					Document uwShMK15 = akV8pU9W.next();
					if (AppConstants.STATUS_ACTIVE.equals(uwShMK15.getStatus())) {
						try {
							uwShMK15 = (Document) preAdd(uwShMK15, getParams());
							File qBMERLKV = new File(bK1jUgPN.getScanLocation() + File.separator + uwShMK15.getName());
							File VIWTteuI = new File(bK1jUgPN.getStoreLocation() + File.separator + uwShMK15.getName());
							FileInputStream bQ0XtZhm = new FileInputStream(qBMERLKV);
							FileOutputStream JrE3Tsks = new FileOutputStream(VIWTteuI);
							int tYlNgFBb;
							while ((tYlNgFBb = bQ0XtZhm.read()) != -1)
								JrE3Tsks.write(tYlNgFBb);
							bQ0XtZhm.close();
							JrE3Tsks.close();
							uwShMK15.doAdd(uwShMK15);
							boolean vYi8MnNB = qBMERLKV.delete();
							System.out.println("Deleted scan folder file: " + uwShMK15.getName() + ":" + vYi8MnNB);
							if (vYi8MnNB) {
								uwShMK15.setStatus(AppConstants.STATUS_PROCESSING);
								int nrSfy29Q = 0;
								if (uwShMK15.getUploadCount() != null) {
									nrSfy29Q = uwShMK15.getUploadCount();
								}
								nrSfy29Q++;
								uwShMK15.setUploadCount(nrSfy29Q);
								Yaqpvvwi.add(uwShMK15);
							}
						} catch (Exception DgqEOVp6) {
							DgqEOVp6.printStackTrace();
						}
					} else if (AppConstants.STATUS_PROCESSING.equals(uwShMK15.getStatus())) {
						int aBSuML44 = uwShMK15.getUploadCount();
						if (aBSuML44 < 5) {
							aBSuML44++;
							uwShMK15.setUploadCount(aBSuML44);
							System.out.println("increase upload count: " + uwShMK15.getName() + ":" + aBSuML44);
							Yaqpvvwi.add(uwShMK15);
						} else {
							System.out.println("delete from documents list: " + uwShMK15.getName());
						}
					} else if (AppConstants.STATUS_INACTIVE.equals(uwShMK15.getStatus())) {
						uwShMK15.setFixFlag(AppConstants.FLAG_NO);
						Yaqpvvwi.add(uwShMK15);
					}
				}
			}
		} catch (Exception DgmuPsay) {
			DgmuPsay.printStackTrace();
		}
		return Yaqpvvwi;
	}

}