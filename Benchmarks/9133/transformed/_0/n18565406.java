class n18565406 {
	public Stopper(String FOHxdbSI) {
        try {
            BufferedReader PfxaaEKy = null;
            FileReader PGQ5qFp5 = null;
            if (FOHxdbSI.startsWith("http")) {
                URL YiKm4QLA = new URL(FOHxdbSI);
                PfxaaEKy = new BufferedReader(new InputStreamReader(YiKm4QLA.openStream()));
            } else {
                PGQ5qFp5 = new FileReader(new File(FOHxdbSI));
                PfxaaEKy = new BufferedReader(PGQ5qFp5);
            }
            String A7Y2cka1 = null;
            while ((A7Y2cka1 = PfxaaEKy.readLine()) != null) {
                A7Y2cka1 = A7Y2cka1.trim();
                stopWords.put(A7Y2cka1, "");
            }
            PGQ5qFp5.close();
        } catch (Exception kAZC137H) {
            System.out.println("Stopwords not Found");
            return;
        }
    }

}