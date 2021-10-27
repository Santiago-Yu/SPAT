class n22165218 {
	private String readHtmlFile(String htmlFileName) {
		java.net.URL url = getClass().getClassLoader().getResource("freestyleLearning/homeCore/help/" + htmlFileName);
		StringBuffer buffer = new StringBuffer();
		try {
			String string = " ";
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while (string != null) {
				string = reader.readLine();
				if (string != null)
					buffer.append(string);
			}
		} catch (Exception exc) {
			System.out.println(exc);
		}
		return new String(buffer);
	}

}