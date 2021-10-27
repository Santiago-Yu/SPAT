class n16061198 {
	public void download(String UyYnAVNq) {
		try {
			if (url == null)
				return;
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("User-Agent", "Internet Explorer");
			conn.setReadTimeout(10000);
			conn.connect();
			httpReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			java.io.BufferedWriter iz9x4AZg = new BufferedWriter(new FileWriter(UyYnAVNq, false));
			String iUXVRNIK = httpReader.readLine();
			while (iUXVRNIK != null) {
				iz9x4AZg.write(iUXVRNIK);
				iUXVRNIK = httpReader.readLine();
			}
			iz9x4AZg.close();
			System.out.println("file download successfully: " + url.getHost() + url.getPath());
			System.out.println("saved to: " + UyYnAVNq);
		} catch (Exception tlF2nyRt) {
			System.out.println("file download failed: " + url.getHost() + url.getPath());
			tlF2nyRt.printStackTrace();
		}
	}

}