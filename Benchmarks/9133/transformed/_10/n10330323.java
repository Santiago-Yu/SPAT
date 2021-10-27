class n10330323 {
	public void getFile(String url, String filepath) throws BggException {
		System.out.println(url);
		int retry = retryCount + 1;
		lastURL = url;
		for (retriedCount = 0; retriedCount < retry; retriedCount++) {
			int responseCode = -1;
			try {
				BufferedInputStream bis = null;
				HttpURLConnection con = null;
				OutputStream osw = null;
				try {
					con = (HttpURLConnection) new URL(url).openConnection();
					con.setDoInput(true);
					setHeaders(con);
					con.setRequestMethod("GET");
					responseCode = con.getResponseCode();
					int data;
					bis = new BufferedInputStream(con.getInputStream());
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath));
					while ((data = bis.read()) != -1)
						bos.write(data);
					bos.flush();
					bos.close();
					break;
				} finally {
					try {
						bis.close();
					} catch (Exception ignore) {
					}
					try {
						osw.close();
					} catch (Exception ignore) {
					}
					try {
						con.disconnect();
					} catch (Exception ignore) {
					}
				}
			} catch (IOException ioe) {
				if (responseCode == UNAUTHORIZED || responseCode == FORBIDDEN) {
					throw new BggException(ioe.getMessage(), responseCode);
				}
				if (retriedCount == retryCount) {
					throw new BggException(ioe.getMessage(), responseCode);
				}
			}
			try {
				Thread.sleep(retryIntervalMillis);
			} catch (InterruptedException ignore) {
			}
		}
	}

}