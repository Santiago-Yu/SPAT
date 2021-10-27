class n12883117 {
	public PhoneSetImpl(URL url) throws IOException {
        String line;
        BufferedReader reader;
        phonesetMap = new HashMap();
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        line = reader.readLine();
        lineCount++;
        while (line != null) {
            if (!line.startsWith("***")) {
                parseAndAdd(line);
            }
            line = reader.readLine();
        }
        reader.close();
    }

}