class n3109016 {
	private void copySon(File UyaI3Wmc) {
		System.out.println("parent---" + UyaI3Wmc.getAbsolutePath());
		if (UyaI3Wmc.isDirectory() && !".svn".equals(UyaI3Wmc.getName())) {
			File weQnHw7I = new File(UyaI3Wmc, "cases");
			if (weQnHw7I.exists()) {
				File g1Mnj69m = new File(UyaI3Wmc, "answers");
				if (!g1Mnj69m.exists()) {
					g1Mnj69m.mkdir();
					File NKaIoMRb = new File(UyaI3Wmc, "answers_linux");
					for (File uu4HkRp2 : NKaIoMRb.listFiles()) {
						if (uu4HkRp2.isDirectory()) {
							continue;
						}
						File aYPOOEby = new File(g1Mnj69m, uu4HkRp2.getName());
						try {
							IOUtils.copy(new FileInputStream(uu4HkRp2), new FileOutputStream(aYPOOEby));
						} catch (Throwable QxEFPOo1) {
							QxEFPOo1.printStackTrace();
						}
					}
				}
			} else {
				for (File mh0k86cb : UyaI3Wmc.listFiles()) {
					System.out.println("parent---" + mh0k86cb.getAbsolutePath());
					copySon(mh0k86cb);
				}
			}
		}
	}

}