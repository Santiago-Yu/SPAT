class n10353862 {
	public boolean copyTo(String OyIpe9PR) {
		try {
			FileInputStream jQaCkgV4 = new FileInputStream(filePath);
			FileOutputStream TnlyNB4E = new FileOutputStream(OyIpe9PR);
			byte[] AdUrX0XK = new byte[1024];
			int mCROcTTq = -1;
			while ((mCROcTTq = jQaCkgV4.read(AdUrX0XK)) > 0)
				TnlyNB4E.write(AdUrX0XK, 0, mCROcTTq);
			jQaCkgV4.close();
			TnlyNB4E.close();
			return true;
		} catch (Exception zqGXmDJO) {
			zqGXmDJO.printStackTrace();
			return false;
		}
	}

}