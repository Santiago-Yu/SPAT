class n8335943 {
	public static byte[] sendRequestV2(String nArGr7sP, String Nz87uSpH, Map<String, String> QHbi8W1v, String k6N9IKkU,
			String b9T7BD94) {
		byte[] RXcvHF3U = null;
		try {
			HttpURLConnection QOREHf3o = (HttpURLConnection) new URL(nArGr7sP).openConnection();
			QOREHf3o.setUseCaches(false);
			QOREHf3o.setInstanceFollowRedirects(true);
			QOREHf3o.setRequestMethod(k6N9IKkU);
			QOREHf3o.setRequestProperty("Content-Type", b9T7BD94);
			QOREHf3o.setRequestProperty("Accept-Encoding", "gzip");
			if (QHbi8W1v != null && QHbi8W1v.size() > 0) {
				Iterator<String> Czl6DR0S = QHbi8W1v.keySet().iterator();
				while (Czl6DR0S.hasNext()) {
					String qs7l6Myr = Czl6DR0S.next();
					QOREHf3o.setRequestProperty(qs7l6Myr, QHbi8W1v.get(qs7l6Myr));
				}
			}
			QOREHf3o.setDoOutput(true);
			if (Nz87uSpH != null)
				QOREHf3o.getOutputStream().write(Nz87uSpH.getBytes("UTF-8"));
			System.setProperty("http.strictPostRedirect", "true");
			QOREHf3o.connect();
			ByteArrayOutputStream v7UqR8JE = new ByteArrayOutputStream();
			try {
				InputStream qP2EspHI = QOREHf3o.getInputStream();
				byte[] sLntOGGa = new byte[500];
				int yjAhmHdA = 0;
				while ((yjAhmHdA = qP2EspHI.read(sLntOGGa)) > 0) {
					v7UqR8JE.write(sLntOGGa, 0, yjAhmHdA);
				}
				RXcvHF3U = v7UqR8JE.toByteArray();
			} catch (Exception oaWIw010) {
				oaWIw010.printStackTrace();
			} finally {
				if (v7UqR8JE != null)
					v7UqR8JE.close();
			}
			System.clearProperty("http.strictPostRedirect");
		} catch (Exception a2owA6ky) {
			logger.error(a2owA6ky, a2owA6ky);
		}
		return RXcvHF3U;
	}

}