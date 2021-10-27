class n15674873 {
	public static void uploadAsync(final String eY7eA1ts, final String kA8x114N, final String QerJmQnv,
			final String Dk64xDgC, final boolean i41udO6v, final ArrayList<RecordedGeoPoint> MKwCnXUv,
			final String hgUWiZm0) {
		if (eY7eA1ts == null || eY7eA1ts.length() == 0)
			return;
		if (kA8x114N == null || kA8x114N.length() == 0)
			return;
		if (QerJmQnv == null || QerJmQnv.length() == 0)
			return;
		if (Dk64xDgC == null || Dk64xDgC.length() == 0)
			return;
		if (hgUWiZm0 == null || hgUWiZm0.endsWith(".gpx"))
			return;
		new Thread(new Runnable() {

			public void run() {
				if (!Util.isSufficienDataForUpload(MKwCnXUv))
					return;
				final InputStream WgQsdMkJ = new ByteArrayInputStream(
						RecordedRouteGPXFormatter.create(MKwCnXUv).getBytes());
				String d0D9mPkv = Dk64xDgC;
				if (i41udO6v || d0D9mPkv == null)
					if (d0D9mPkv == null)
						d0D9mPkv = autoTagFormat.format(new GregorianCalendar().getTime());
					else
						d0D9mPkv = d0D9mPkv + " " + autoTagFormat.format(new GregorianCalendar().getTime());
				try {
					final String jZWCilq4 = (QerJmQnv == null) ? DEFAULT_DESCRIPTION
							: QerJmQnv.replaceAll("\\.;&?,/", "_");
					final String zmmWFRI4 = (d0D9mPkv == null) ? DEFAULT_TAGS : d0D9mPkv.replaceAll("\\\\.;&?,/", "_");
					final URL XWPKz7VY = new URL("http://www.openstreetmap.org/api/" + API_VERSION + "/gpx/create");
					final HttpURLConnection TAlwcnee = (HttpURLConnection) XWPKz7VY.openConnection();
					TAlwcnee.setConnectTimeout(15000);
					TAlwcnee.setRequestMethod("POST");
					TAlwcnee.setDoOutput(true);
					TAlwcnee.addRequestProperty("Authorization", "Basic " + encodeBase64(eY7eA1ts + ":" + kA8x114N));
					TAlwcnee.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
					TAlwcnee.addRequestProperty("Connection", "close");
					TAlwcnee.addRequestProperty("Expect", "");
					TAlwcnee.connect();
					DataOutputStream d6TkRVaH = new DataOutputStream(
							new BufferedOutputStream(TAlwcnee.getOutputStream()));
					writeContentDispositionFile(d6TkRVaH, "file", WgQsdMkJ, hgUWiZm0);
					writeContentDisposition(d6TkRVaH, "description", jZWCilq4);
					writeContentDisposition(d6TkRVaH, "tags", zmmWFRI4);
					writeContentDisposition(d6TkRVaH, "public", "1");
					d6TkRVaH.writeBytes("--" + BOUNDARY + "--" + LINE_END);
					d6TkRVaH.flush();
					final int e7h1yCPS = TAlwcnee.getResponseCode();
					String Eqxti9c5 = TAlwcnee.getResponseMessage();
					if (e7h1yCPS != 200) {
						if (TAlwcnee.getHeaderField("Error") != null)
							Eqxti9c5 += "\n" + TAlwcnee.getHeaderField("Error");
						TAlwcnee.disconnect();
						throw new RuntimeException(e7h1yCPS + " " + Eqxti9c5);
					}
					d6TkRVaH.close();
					TAlwcnee.disconnect();
				} catch (Exception kO8e1ZT5) {
				}
			}
		}, "OSMUpload-Thread").start();
	}

}