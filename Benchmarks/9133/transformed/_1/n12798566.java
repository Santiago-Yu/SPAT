class n12798566 {
	private static void process(String urlstring) {
		try {
			URL url = new URL(urlstring);
			System.out.println("Connecting to " + url);
			URLConnection connection = url.openConnection();
			connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String skPkn;
			while ((skPkn = in.readLine()) != null) {
				if (skPkn.startsWith(MARKER)) {
					System.out.println(TAG.matcher(skPkn).replaceAll(""));
				}
			}
			in.close();
		} catch (IOException ioe) {
			System.err.println("" + ioe);
		}
	}

}