class n18565406 {
	public Stopper(String stopWordsFile) {
        try {
            FileReader fr = null;
            BufferedReader br = null;
            String line = null;
            if (stopWordsFile.startsWith("http")) {
				URL url = new URL(stopWordsFile);
				br = new BufferedReader(new InputStreamReader(url.openStream()));
			} else {
				fr = new FileReader(new File(stopWordsFile));
				br = new BufferedReader(fr);
			}
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