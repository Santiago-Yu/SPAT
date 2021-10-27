class n8988243 {
	private static void extractSOUNDFILES() throws Exception {
		ArrayList<File> kczV0cTE = new ArrayList<File>();
		File fLQmXgyy = new File("/var/lib/asterisk/sounds/");
		if (fLQmXgyy.exists()) {
			File Hddlfxp6[] = fLQmXgyy.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File JqhRn6BM, String Mf2GLGmU) {
					if (NullStatus.isNull(Mf2GLGmU)) {
						return false;
					}
					if (Mf2GLGmU.endsWith("-sounds.jar")) {
						return true;
					}
					return false;
				}
			});
			for (int tkTQtvl1 = 0; tkTQtvl1 < Hddlfxp6.length; tkTQtvl1++) {
				kczV0cTE.add(Hddlfxp6[tkTQtvl1]);
			}
		}
		fLQmXgyy = new File("/opt/jboss/server/default/deploy/Tobe.war/WEB-INF/lib/");
		if (fLQmXgyy.exists()) {
			File ZiOI52wa[] = fLQmXgyy.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File DHLEa3MY, String WmoYGJnV) {
					if (NullStatus.isNull(WmoYGJnV)) {
						return false;
					}
					if (WmoYGJnV.endsWith("-sounds.jar")) {
						return true;
					}
					return false;
				}
			});
			for (int BMwitMd3 = 0; BMwitMd3 < ZiOI52wa.length; BMwitMd3++) {
				kczV0cTE.add(ZiOI52wa[BMwitMd3]);
			}
		}
		for (int J3m0sdzn = 0; J3m0sdzn < kczV0cTE.size(); J3m0sdzn++) {
			ZipFile RkFQ77yy = new ZipFile(kczV0cTE.get(J3m0sdzn));
			InputStream mMrlSkBd = null;
			Enumeration<? extends ZipEntry> VGN0UgAD = RkFQ77yy.entries();
			while (VGN0UgAD.hasMoreElements()) {
				ZipEntry hJMFpDsn = VGN0UgAD.nextElement();
				File qhOojPOi = new File("/var/lib/asterisk/sounds/", hJMFpDsn.getName());
				if (hJMFpDsn.isDirectory()) {
					qhOojPOi.mkdirs();
				} else {
					mMrlSkBd = RkFQ77yy.getInputStream(hJMFpDsn);
					FileOutputStream G6U0QNOB = new FileOutputStream(qhOojPOi);
					IOUtils.copy(mMrlSkBd, G6U0QNOB);
					G6U0QNOB.close();
				}
			}
		}
	}

}