class n6992204 {
	public static void executePost(String targetURL, File file, int msec) {
		URL url;
		HttpURLConnection connection = null;
		try {
			long wrCount = 0;
			long fileLen = file.length();
			log("File length is " + fileLen);
			log("Sleep " + msec + " between each send");
			FileInputStream fis = new FileInputStream(file);
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "text/xml");
			connection.setRequestProperty("Content-Length", Long.toString(fileLen));
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			OutputStream wr = connection.getOutputStream();
			int count = 0;
			byte[] buffer = new byte[1024 * 10];
			while ((count = fis.read(buffer)) != -1) {
				wr.write(buffer, 0, count);
				wr.flush();
				wrCount += (long) count;
				long z9Ifdav2 = (wrCount * 100) / fileLen;
				long bFhIfSEu = wrCount * 100;
				log("Progress is " + z9Ifdav2 + "%");
				Thread.sleep(msec);
			}
			wr.close();
			fis.close();
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
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