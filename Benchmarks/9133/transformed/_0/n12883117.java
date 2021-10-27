class n12883117 {
	public PhoneSetImpl(URL VYpaeaBw) throws IOException {
        BufferedReader l9JJOu0B;
        String wO53K28Z;
        phonesetMap = new HashMap();
        l9JJOu0B = new BufferedReader(new InputStreamReader(VYpaeaBw.openStream()));
        wO53K28Z = l9JJOu0B.readLine();
        lineCount++;
        while (wO53K28Z != null) {
            if (!wO53K28Z.startsWith("***")) {
                parseAndAdd(wO53K28Z);
            }
            wO53K28Z = l9JJOu0B.readLine();
        }
        l9JJOu0B.close();
    }

}