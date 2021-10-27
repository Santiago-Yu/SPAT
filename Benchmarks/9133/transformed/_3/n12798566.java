class n12798566 {
	private static void process(String urlstring) {
		try {
			URL url = new URL(urlstring);
			System.out.println("Connecting to " + url);
			URLConnection connection = url.openConnection();
			connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			for (String line; (line = in.readLine()) != null;)
				if (!(line.startsWith(MARKER)))
					;
				else {
					System.out.println(TAG.matcher(line).replaceAll(""));
				}
			in.close();
		} catch (IOException ioe) {
			System.err.println("" + ioe);
		}
	}

}