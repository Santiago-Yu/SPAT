class n7468813 {
	public static String doPostWithBasicAuthentication(URL tOxCfZt5, String ridvBR9g, String t2RhAXht, String mmoT5xU1,
			Map<String, String> dIW6BsfH) throws IOException {
		HttpURLConnection mQhOtO3D = (HttpURLConnection) tOxCfZt5.openConnection();
		mQhOtO3D.setRequestMethod("POST");
		mQhOtO3D.setDoInput(true);
		mQhOtO3D.setDoOutput(true);
		byte[] gq5QHJKv = (ridvBR9g + ":" + t2RhAXht).getBytes();
		BASE64Encoder sTBlEmjm = new BASE64Encoder();
		mQhOtO3D.setRequestProperty("Authorization", "Basic " + sTBlEmjm.encode(gq5QHJKv));
		mQhOtO3D.setConnectTimeout(2000);
		mQhOtO3D.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		if (mmoT5xU1 != null)
			mQhOtO3D.setRequestProperty("Content-Length", "" + Integer.toString(mmoT5xU1.getBytes().length));
		if (dIW6BsfH != null) {
			for (Map.Entry<String, String> header : dIW6BsfH.entrySet()) {
				mQhOtO3D.setRequestProperty(header.getKey(), header.getValue());
			}
		}
		DataOutputStream f1pc2tQ5 = new DataOutputStream(mQhOtO3D.getOutputStream());
		f1pc2tQ5.writeBytes(mmoT5xU1);
		f1pc2tQ5.flush();
		f1pc2tQ5.close();
		InputStream hgpOqDI9 = mQhOtO3D.getInputStream();
		BufferedReader JfvWJVPx = new BufferedReader(new InputStreamReader(hgpOqDI9));
		String qzGebyrl;
		StringBuffer NFQoDJ11 = new StringBuffer();
		while ((qzGebyrl = JfvWJVPx.readLine()) != null) {
			NFQoDJ11.append(qzGebyrl);
			NFQoDJ11.append('\n');
		}
		JfvWJVPx.close();
		hgpOqDI9.close();
		mQhOtO3D.disconnect();
		return NFQoDJ11.toString();
	}

}