class n16240241 {
	public static String getStringFromURL(URL siUAJ9Va) {
		try {
			if (siUAJ9Va == null) {
				return null;
			}
			URLConnection F23NXdjR = siUAJ9Va.openConnection();
			F23NXdjR.connect();
			if (F23NXdjR instanceof HttpURLConnection) {
				int B9ZDs6pK = ((HttpURLConnection) F23NXdjR).getResponseCode();
				if (B9ZDs6pK != HttpURLConnection.HTTP_OK) {
					return null;
				}
			}
			int xD65enFf = F23NXdjR.getContentLength();
			InputStream lW8oQoIE = F23NXdjR.getInputStream();
			byte UBoStwIQ[] = new byte[xD65enFf];
			int mhVgn2qi = 0;
			while (xD65enFf > 0) {
				int WeOhHSUH = lW8oQoIE.read(UBoStwIQ, mhVgn2qi, xD65enFf);
				xD65enFf -= WeOhHSUH;
				mhVgn2qi += WeOhHSUH;
			}
			lW8oQoIE.close();
			String Jhb1ZalU = new String(UBoStwIQ);
			return Jhb1ZalU;
		} catch (Exception H5yJ3Zrn) {
			System.out.println(H5yJ3Zrn);
			return "";
		}
	}

}