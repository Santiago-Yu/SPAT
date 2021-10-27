class n6992204 {
	public static void executePost(String targetURL, File file, int msec) {
		HttpURLConnection connection = null;
		URL url;
		try {
			long fileLen = file.length();
			long wrCount = 0;
			log("File length is " + fileLen);
			log("Sleep " + msec + " between each send");
			url = new URL(targetURL);
			FileInputStream fis = new FileInputStream(file);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "text/xml");
			connection.setRequestProperty("Content-Length", Long.toString(fileLen));
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			int count = 0;
			OutputStream wr = connection.getOutputStream();
			byte[] buffer = new byte[1024 * 10];
			while ((count = fis.read(buffer)) != -1) {
				wr.write(buffer, 0, count);
				wr.flush();
				wrCount += (long) count;
				log("Progress is " + (wrCount * 100) / fileLen + "%");
				Thread.sleep(msec);
			}
			wr.close();
			fis.close();
			InputStream is = connection.getInputStream();
			String line;
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return;
	}

}