class n18811090 {
	public static int doPost(String J7iaovrE, String hV5KL0DU, String qOfUDy1r, Map<String, String> aQvyHmof)
			throws IOException {
		PrintWriter WNRxDDip = null;
		try {
			URL QhG6DjdV = new URL(J7iaovrE);
			URLConnection NvAJpFnB = QhG6DjdV.openConnection();
			if (hV5KL0DU != null && qOfUDy1r != null) {
				String TJOY2h0r = base64Encode(hV5KL0DU + ':' + qOfUDy1r);
				NvAJpFnB.setRequestProperty("Authorization", "Basic " + TJOY2h0r);
			}
			NvAJpFnB.setDoOutput(true);
			WNRxDDip = new PrintWriter(NvAJpFnB.getOutputStream());
			boolean rOSrzg3D = true;
			for (Map.Entry<String, String> entry : aQvyHmof.entrySet()) {
				if (rOSrzg3D) {
					rOSrzg3D = false;
				} else {
					WNRxDDip.print('&');
				}
				WNRxDDip.print(entry.getKey());
				WNRxDDip.print('=');
				WNRxDDip.print(URLEncoder.encode(entry.getValue(), "UTF-8"));
			}
			WNRxDDip.close();
			NvAJpFnB.connect();
			if (!(NvAJpFnB instanceof HttpURLConnection)) {
				throw new IOException();
			}
			return ((HttpURLConnection) NvAJpFnB).getResponseCode();
		} catch (IOException HGJzE37c) {
			throw HGJzE37c;
		} finally {
			if (WNRxDDip != null) {
				WNRxDDip.close();
			}
		}
	}

}