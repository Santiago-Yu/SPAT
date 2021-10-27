class n15383485 {
	protected byte[] getTSAResponse(byte[] YCAVgCre) throws Exception {
		URL YVuVBCpg = new URL(tsaURL);
		URLConnection ux69rjnq;
		ux69rjnq = (URLConnection) YVuVBCpg.openConnection();
		ux69rjnq.setDoInput(true);
		ux69rjnq.setDoOutput(true);
		ux69rjnq.setUseCaches(false);
		ux69rjnq.setRequestProperty("Content-Type", "application/timestamp-query");
		ux69rjnq.setRequestProperty("Content-Transfer-Encoding", "binary");
		if ((tsaUsername != null) && !tsaUsername.equals("")) {
			String XZOr9y0j = tsaUsername + ":" + tsaPassword;
			ux69rjnq.setRequestProperty("Authorization", "Basic " + Base64.encodeBytes(XZOr9y0j.getBytes()));
		}
		OutputStream MPZr5Vn6 = ux69rjnq.getOutputStream();
		MPZr5Vn6.write(YCAVgCre);
		MPZr5Vn6.close();
		InputStream L7cK0PUX = ux69rjnq.getInputStream();
		ByteArrayOutputStream aa2zOgj2 = new ByteArrayOutputStream();
		byte[] ztkXBmaJ = new byte[1024];
		int QfqC99ff = 0;
		while ((QfqC99ff = L7cK0PUX.read(ztkXBmaJ, 0, ztkXBmaJ.length)) >= 0) {
			aa2zOgj2.write(ztkXBmaJ, 0, QfqC99ff);
		}
		byte[] xk9olWs5 = aa2zOgj2.toByteArray();
		String SmaZ0cC5 = ux69rjnq.getContentEncoding();
		if (SmaZ0cC5 != null && SmaZ0cC5.equalsIgnoreCase("base64")) {
			xk9olWs5 = Base64.decode(new String(xk9olWs5));
		}
		return xk9olWs5;
	}

}