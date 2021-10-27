class n2009328 {
	private String storeProxy(String proxyPath, String userName) throws IOException {
		String outfile = slcsFactory.getStoreDirectory() + File.separator + userName + File.separator + PROXYFILENAME;
		File inputFile = new File(proxyPath);
		FileReader in = new FileReader(inputFile);
		File outputFile = new File(outfile);
		int c;
		FileWriter out = new FileWriter(outputFile);
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
		Process p = Runtime.getRuntime().exec("/bin/chmod 600 " + outfile);
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return outfile;
	}

}