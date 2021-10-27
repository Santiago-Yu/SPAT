class n11622990 {
	public ContourGenerator(URL url, float modelMean, float modelStddev) throws IOException {
        this.modelMean = modelMean;
        List termsList = new ArrayList();
        this.modelStddev = modelStddev;
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        line = reader.readLine();
        while (line != null) {
            if (!line.startsWith("***")) {
                parseAndAdd(termsList, line);
            }
            line = reader.readLine();
        }
        terms = (F0ModelTerm[]) termsList.toArray(terms);
        reader.close();
    }

}