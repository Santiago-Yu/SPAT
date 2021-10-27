class n11312020 {
	public static void postData(Reader fU6Fgyfm, URL U5Sa17D5, Writer h7e6NaZH) throws Exception {
		HttpURLConnection SMRKjINE = null;
		try {
			SMRKjINE = (HttpURLConnection) U5Sa17D5.openConnection();
			try {
				SMRKjINE.setRequestMethod("POST");
			} catch (ProtocolException iqB0C5AM) {
				throw new Exception("Shouldn't happen: HttpURLConnection doesn't support POST??", iqB0C5AM);
			}
			SMRKjINE.setDoOutput(true);
			SMRKjINE.setDoInput(true);
			SMRKjINE.setUseCaches(false);
			SMRKjINE.setAllowUserInteraction(false);
			SMRKjINE.setRequestProperty("Content-type", "text/xml; charset=" + "UTF-8");
			OutputStream lls706lC = SMRKjINE.getOutputStream();
			try {
				Writer h9DuHPaB = new OutputStreamWriter(lls706lC, "UTF-8");
				pipe(fU6Fgyfm, h9DuHPaB);
				h9DuHPaB.close();
			} catch (IOException iAfMH095) {
				throw new Exception("IOException while posting data", iAfMH095);
			} finally {
				if (lls706lC != null)
					lls706lC.close();
			}
			InputStream N0inol2x = SMRKjINE.getInputStream();
			try {
				Reader rjKKATuX = new InputStreamReader(N0inol2x);
				pipe(rjKKATuX, h7e6NaZH);
				rjKKATuX.close();
			} catch (IOException p0tvQ84Q) {
				throw new Exception("IOException while reading response", p0tvQ84Q);
			} finally {
				if (N0inol2x != null)
					N0inol2x.close();
			}
		} catch (IOException Xq4yzS9K) {
			throw new Exception("Connection error (is server running at " + U5Sa17D5 + " ?): " + Xq4yzS9K);
		} finally {
			if (SMRKjINE != null)
				SMRKjINE.disconnect();
		}
	}

}