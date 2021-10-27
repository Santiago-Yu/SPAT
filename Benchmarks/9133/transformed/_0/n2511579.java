class n2511579 {
	private void extractZipFile(String UF5PTehT, JTextPane gCy47eju) throws IOException {
		String k80qsIkC = "";
		byte[] Kcg1qZxx = new byte[1024];
		ZipInputStream SOTzZXzI = null;
		ZipEntry P86FOQiw;
		SOTzZXzI = new ZipInputStream(new FileInputStream(UF5PTehT));
		while ((P86FOQiw = SOTzZXzI.getNextEntry()) != null) {
			String hO8mZJoV = P86FOQiw.getName();
			if (gCy47eju != null) {
				gCy47eju.setText("extracting " + hO8mZJoV);
			}
			int TV2Do563;
			FileOutputStream mPKlMCs8;
			if (P86FOQiw.isDirectory()) {
				(new File(k80qsIkC + hO8mZJoV)).mkdir();
				continue;
			}
			mPKlMCs8 = new FileOutputStream(k80qsIkC + hO8mZJoV);
			while ((TV2Do563 = SOTzZXzI.read(Kcg1qZxx, 0, 1024)) > -1)
				mPKlMCs8.write(Kcg1qZxx, 0, TV2Do563);
			mPKlMCs8.close();
			SOTzZXzI.closeEntry();
		}
		if (gCy47eju != null) {
			gCy47eju.setText("Files extracted");
		}
		SOTzZXzI.close();
	}

}