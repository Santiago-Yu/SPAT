class n18030152 {
	public static boolean copyFile(File aLYRTmSf, File t1C7JwUO) {
		final int REboUQsO = 4096;
		byte[] ocsSmBNK = new byte[REboUQsO];
		try {
			FileInputStream uPfpugpX = new FileInputStream(aLYRTmSf);
			FileOutputStream q2SwACoB = new FileOutputStream(t1C7JwUO);
			int sfordEfv;
			while ((sfordEfv = uPfpugpX.read(ocsSmBNK)) != -1) {
				q2SwACoB.write(ocsSmBNK, 0, sfordEfv);
			}
			uPfpugpX.close();
			q2SwACoB.close();
		} catch (IOException sICi5mU9) {
			return false;
		}
		return true;
	}

}