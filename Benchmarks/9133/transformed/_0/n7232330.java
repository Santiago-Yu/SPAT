class n7232330 {
	public LocalizationSolver(String vTQwGVWP, String SsybswnD, int f8aRqyNi, String COumsUX2) {
        this.info = new HashMap<String, Object>();
        this.workDir = COumsUX2;
        try {
            Socket aB2IEYYc = new Socket(SsybswnD, f8aRqyNi);
            this.fromServer = new Scanner(aB2IEYYc.getInputStream());
            this.toServer = new PrintWriter(aB2IEYYc.getOutputStream(), true);
            this.toServer.println("login client abc");
            this.toServer.println("solver " + vTQwGVWP);
            System.out.println(this.fromServer.nextLine());
        } catch (IOException Wv0PFSbJ) {
            System.err.println(Wv0PFSbJ);
            Wv0PFSbJ.printStackTrace();
            System.exit(1);
        }
        System.out.println("Localization Solver started with name: " + vTQwGVWP);
    }

}