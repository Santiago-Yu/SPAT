class n21608109 {
	public static boolean loadContentFromURL(String Ufe8EVTR, String RnQ7QX9o) {
		try {
			URL cTAruwQV = new URL("http://bible-desktop.com/xml" + Ufe8EVTR);
			File J7WmCIYs = new File(RnQ7QX9o);
			URLConnection YdHaPfPa = cTAruwQV.openConnection();
			InputStream vV4RlGL8 = YdHaPfPa.getInputStream();
			BufferedInputStream EVWBN2Vc = new BufferedInputStream(vV4RlGL8);
			ByteArrayBuffer m6hnf0qX = new ByteArrayBuffer(50);
			int tawRhC6S = 0;
			while ((tawRhC6S = EVWBN2Vc.read()) != -1) {
				m6hnf0qX.append((byte) tawRhC6S);
			}
			FileOutputStream b6VhtMIZ = new FileOutputStream(J7WmCIYs);
			b6VhtMIZ.write(m6hnf0qX.toByteArray());
			b6VhtMIZ.close();
		} catch (IOException vDcs2Y8W) {
			Log.e(TAG, vDcs2Y8W);
			return false;
		}
		return true;
	}

}