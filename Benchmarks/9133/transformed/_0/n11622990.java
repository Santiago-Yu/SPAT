class n11622990 {
	public ContourGenerator(URL QZv76wfB, float OCcjnEu5, float Jm2GbdpD) throws IOException {
        this.modelMean = OCcjnEu5;
        this.modelStddev = Jm2GbdpD;
        List FMc6cbSj = new ArrayList();
        String SVZkAhhB;
        BufferedReader Et60ApzR = new BufferedReader(new InputStreamReader(QZv76wfB.openStream()));
        SVZkAhhB = Et60ApzR.readLine();
        while (SVZkAhhB != null) {
            if (!SVZkAhhB.startsWith("***")) {
                parseAndAdd(FMc6cbSj, SVZkAhhB);
            }
            SVZkAhhB = Et60ApzR.readLine();
        }
        terms = (F0ModelTerm[]) FMc6cbSj.toArray(terms);
        Et60ApzR.close();
    }

}