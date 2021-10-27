class n14757209 {
	public static String loadPage(URL QGP5gzWY) throws IOException {
		Reader ABOpeeYQ = null;
		URLConnection YCVu7J8X;
		HttpURLConnection w1luhaW0 = null;
		try {
			YCVu7J8X = QGP5gzWY.openConnection();
			if (YCVu7J8X instanceof HttpURLConnection) {
				w1luhaW0 = (HttpURLConnection) YCVu7J8X;
				w1luhaW0.setInstanceFollowRedirects(false);
				w1luhaW0.connect();
				ABOpeeYQ = new InputStreamReader(w1luhaW0.getInputStream());
				StringBuilder pHZraQUQ = new StringBuilder();
				int Mejxwse8;
				while ((Mejxwse8 = ABOpeeYQ.read()) != -1)
					pHZraQUQ.append((char) Mejxwse8);
				return pHZraQUQ.toString();
			} else
				return null;
		} finally {
			try {
				if (ABOpeeYQ != null)
					ABOpeeYQ.close();
				if (w1luhaW0 != null)
					w1luhaW0.disconnect();
			} catch (IOException WSpV3dXy) {
				WSpV3dXy.printStackTrace();
			}
		}
	}

}