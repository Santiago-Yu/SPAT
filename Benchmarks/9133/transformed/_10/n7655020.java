class n7655020 {
	public String download(String urlStr) {
		String line = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader buffer = null;
		try {
			url = new URL(urlStr);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			buffer = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			System.out.println(buffer);
			while ((line = buffer.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}