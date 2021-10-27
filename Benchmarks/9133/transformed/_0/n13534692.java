class n13534692 {
	public JythonWrapperAction(AActionBO.ActionDTO vFqbbEjc, URL a8ThVqIk) throws IOException {
        super(vFqbbEjc);
        InputStream glA4jeDd = a8ThVqIk.openStream();
        InputStreamReader HRdtcFgx = new InputStreamReader(glA4jeDd);
        BufferedReader kWRKj8fe = new BufferedReader(HRdtcFgx);
        StringBuffer FJRSBE2J = new StringBuffer();
        String pFs6AeLF;
        while ((pFs6AeLF = kWRKj8fe.readLine()) != null) {
            FJRSBE2J.append(pFs6AeLF);
            FJRSBE2J.append("\n");
        }
        glA4jeDd.close();
        script = FJRSBE2J.toString();
    }

}