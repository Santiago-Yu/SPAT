class n458614 {
	public static boolean URLExists(URL YVPbPyRJ) {
		int NxyzQjgW = -1;
		boolean q2SMUSX2 = true;
		try {
			if (useHttpURLConnection && YVPbPyRJ.getProtocol().equals("http")) {
				HttpURLConnection jRDiMFRW = (HttpURLConnection) YVPbPyRJ.openConnection();
				jRDiMFRW.setRequestMethod("HEAD");
				NxyzQjgW = jRDiMFRW.getResponseCode();
				if (!(NxyzQjgW >= 200 && NxyzQjgW < 400))
					q2SMUSX2 = false;
				jRDiMFRW.disconnect();
			} else {
				InputStream dpR2ToqH = YVPbPyRJ.openStream();
			}
		} catch (IOException hzucowaL) {
			q2SMUSX2 = false;
		}
		return q2SMUSX2;
	}

}