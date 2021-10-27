class n22923598 {
	public static String getCssFile(String url) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL urlToCrawl = new URL(url);
			buffer = new StringBuffer();
			URLConnection urlToCrawlConnection = urlToCrawl.openConnection();
			urlToCrawlConnection.setRequestProperty("User-Agent", "USER_AGENT");
			urlToCrawlConnection.setRequestProperty("Referer", "REFERER");
			urlToCrawlConnection.setUseCaches(false);
			InputStreamReader isr = new InputStreamReader(urlToCrawlConnection.getInputStream());
			String str;
			BufferedReader in = new BufferedReader(isr);
			FileOutputStream fos = new FileOutputStream("c:\\downloads\\" + System.currentTimeMillis() + ".css");
			while ((str = in.readLine()) != null)
				buffer.append(str);
			Writer out = new OutputStreamWriter(fos);
			out.write(buffer.toString());
			out.close();
		} catch (Exception e) {
			System.out.println("Error Downloading css file" + e);
		}
		return buffer.toString();
	}

}