class n7468827 {
	public void run() {
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			BASE64Encoder encoder = new BASE64Encoder();
			byte[] encodedPassword = (username + ":" + password).getBytes();
			con.setRequestProperty("Authorization", "Basic " + encoder.encode(encodedPassword));
			BufferedInputStream in = new BufferedInputStream(con.getInputStream());
			FileOutputStream fos = new FileOutputStream(toFile);
			byte[] data = new byte[1024];
			BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
			int x = 0;
			while ((x = in.read(data, 0, 1024)) >= 0) {
				bout.write(data, 0, x);
				lastIteraction = System.currentTimeMillis();
			}
			bout.flush();
			bout.close();
			fos.flush();
			fos.close();
			in.close();
			con.disconnect();
			finish = true;
		} catch (Exception e) {
			this.e = e;
		}
	}

}