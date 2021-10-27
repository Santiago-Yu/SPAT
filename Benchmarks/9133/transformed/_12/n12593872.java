class n12593872 {
	public String upload(String urlString, ByteArrayOutputStream dataStream) {
		HttpURLConnection conn = null;
		DataOutputStream dos = null;
		String exsistingFileName = "blah.png", lineEnd = "\r\n";
		String twoHyphens = "--", boundary = "*****";
		try {
			URL url = new URL(urlString);
			conn = (HttpURLConnection) url.openConnection();
			conn.setInstanceFollowRedirects(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			dos = new DataOutputStream(conn.getOutputStream());
			dos.writeBytes(twoHyphens + boundary + lineEnd);
			dos.writeBytes("Content-Disposition: form-data; name=\"aFile\";" + " filename=\"" + exsistingFileName + "\""
					+ lineEnd);
			dos.writeBytes(lineEnd);
			dos.write(dataStream.toByteArray());
			dos.writeBytes(lineEnd);
			dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
			dos.flush();
			dos.close();
			return conn.getHeaderField("location");
		} catch (MalformedURLException ex) {
			log.log(Level.INFO, "From ServletCom CLIENT REQUEST:" + ex);
		} catch (IOException ioe) {
			log.log(Level.INFO, "From ServletCom CLIENT REQUEST:" + ioe);
		}
		return null;
	}

}