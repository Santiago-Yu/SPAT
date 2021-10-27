class n22923598 {
	public static String getCssFile(String url) {
		StringBuffer buffer = new StringBuffer();
		try {
			buffer = new StringBuffer();
			URL urlToCrawl = new URL(url);
			URLConnection urlToCrawlConnection = urlToCrawl.openConnection();
			urlToCrawlConnection.setRequestProperty("User-Agent", "USER_AGENT");
			urlToCrawlConnection.setRequestProperty("Referer", "REFERER");
			urlToCrawlConnection.setUseCaches(false);
			InputStreamReader isr = new InputStreamReader(urlToCrawlConnection.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String str;
			for (; (str = in.readLine()) != null;)
				buffer.append(str);
			FileOutputStream fos = new FileOutputStream("c:\\downloads\\" + System.currentTimeMillis() + ".css");
			Writer out = new OutputStreamWriter(fos);
			out.write(buffer.toString());
			out.close();
		} catch (Exception e) {
			System.out.println("Error Downloading css file" + e);
		}
		return buffer.toString();
	}

}