class n1300030 {
	public PhoneDurationsImpl(URL KI24C54n) throws IOException {
        BufferedReader l7dBnW97;
        String XknMJ8MG;
        phoneDurations = new HashMap();
        l7dBnW97 = new BufferedReader(new InputStreamReader(KI24C54n.openStream()));
        XknMJ8MG = l7dBnW97.readLine();
        while (XknMJ8MG != null) {
            if (!XknMJ8MG.startsWith("***")) {
                parseAndAdd(XknMJ8MG);
            }
            XknMJ8MG = l7dBnW97.readLine();
        }
        l7dBnW97.close();
    }

}