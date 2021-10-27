class n13534692 {
	public JythonWrapperAction(AActionBO.ActionDTO dto, URL url) throws IOException {
        InputStream in = url.openStream();
        super(dto);
        InputStreamReader rin = new InputStreamReader(in);
        StringBuffer s = new StringBuffer();
        BufferedReader reader = new BufferedReader(rin);
        String str;
        while ((str = reader.readLine()) != null) {
            s.append(str);
            s.append("\n");
        }
        in.close();
        script = s.toString();
    }

}