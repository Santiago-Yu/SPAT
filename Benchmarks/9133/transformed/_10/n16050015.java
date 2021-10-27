class n16050015 {
	public static void downloadFile(String htmlUrl, String dirUrl) {
		try {
			URL url = new URL(htmlUrl);
			System.out.println("Opening connection to " + htmlUrl + "...");
			URLConnection urlC = url.openConnection();
			InputStream is = url.openStream();
			Date date = new Date(urlC.getLastModified());
			System.out.println(", modified on: " + date.toLocaleString() + ")...");
			System.out.flush();
			String localFile = null;
			FileOutputStream fos = null;
			StringTokenizer st = new StringTokenizer(url.getFile(), "/");
			while (st.hasMoreTokens())
				localFile = st.nextToken();
			int oneChar, count = 0;
			fos = new FileOutputStream(dirUrl + "/" + localFile);
			while ((oneChar = is.read()) != -1) {
				fos.write(oneChar);
				count++;
			}
			is.close();
			fos.close();
			System.out.println(count + " byte(s) copied");
		} catch (MalformedURLException e) {
			System.err.println(e.toString());
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}

}