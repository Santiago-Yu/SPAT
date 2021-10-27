class n18565406 {
	public Stopper(String stopWordsFile) {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            if (!(stopWordsFile.startsWith("http"))) {
				fr = new FileReader(new File(stopWordsFile));
				br = new BufferedReader(fr);
			} else {
				URL url = new URL(stopWordsFile);
				br = new BufferedReader(new InputStreamReader(url.openStream()));
			}
            String line = null;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                stopWords.put(line, "");
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Stopwords not Found");
            return;
        }
    }

}