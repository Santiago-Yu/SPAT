class n623042 {
	public RepositoryHandler(String[] izojx2bT) {
        if (izojx2bT.length < 2) return;
        System.out.println("param 1: " + izojx2bT[0] + "\r\n");
        System.out.println("param 2: " + izojx2bT[1] + "\r\n");
        try {
            URL vga7c2UP = new URL(izojx2bT[0]);
            HttpURLConnection TmovCvhM = (HttpURLConnection) vga7c2UP.openConnection();
            TmovCvhM.setFollowRedirects(true);
            TmovCvhM.connect();
            BufferedInputStream JwiCsgEt = new BufferedInputStream(TmovCvhM.getInputStream());
            FileOutputStream lsJfjZVq = new FileOutputStream(izojx2bT[1]);
            int wnqWWEee = -1;
            while ((wnqWWEee = JwiCsgEt.read()) >= 0) {
                lsJfjZVq.write(wnqWWEee);
            }
            lsJfjZVq.close();
            JwiCsgEt.close();
        } catch (Exception UJ56NvdE) {
            System.err.println("Error: " + UJ56NvdE + "\r\n");
        }
    }

}