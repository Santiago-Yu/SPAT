class n2099972 {
	public static void copyResource(String args) {
		try {
			URL url = copyURL.class.getResource(args);
			InputStream is = url.openStream();
			System.out.flush();
			FileOutputStream fos = null;
			int oneChar, count = 0;
			fos = new FileOutputStream(System.getProperty("user.home") + "/JavaCPC/" + args);
			while ((oneChar = is.read()) != -1) {
				fos.write(oneChar);
				count++;
			}
			is.close();
			fos.close();
		} catch (MalformedURLException e) {
			System.err.println(e.toString());
		} catch (IOException e) {
			System.err.println(e.toString());
		}
	}

}