class n8011262 {
	private void uploadFile() {
		String end = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		try {
			URL url = new URL(actionUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setRequestMethod("POST");
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			con.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			DataOutputStream ds = new DataOutputStream(con.getOutputStream());
			ds.writeBytes(twoHyphens + boundary + end);
			ds.writeBytes("Content-Disposition: form-data; " + "name=\"file1\";filename=\"" + newName + "\"" + end);
			ds.writeBytes(end);
			int bufferSize = 1024;
			FileInputStream fStream = new FileInputStream(uploadFile);
			int length = -1;
			byte[] buffer = new byte[bufferSize];
			while ((length = fStream.read(buffer)) != -1) {
				ds.write(buffer, 0, length);
			}
			ds.writeBytes(end);
			ds.writeBytes(twoHyphens + boundary + twoHyphens + end);
			fStream.close();
			ds.flush();
			int ch;
			InputStream is = con.getInputStream();
			StringBuffer b = new StringBuffer();
			while ((ch = is.read()) != -1) {
				b.append((char) ch);
			}
			showDialog(b.toString().trim());
			ds.close();
		} catch (Exception e) {
			showDialog("" + e);
		}
	}

}