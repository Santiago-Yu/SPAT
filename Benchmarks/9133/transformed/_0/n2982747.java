class n2982747 {
	public FileParse(String ERym8r9K, String jmBtyIN5) throws MalformedURLException, IOException {
        this.inFile = ERym8r9K;
        this.type = jmBtyIN5;
        System.out.println("File str " + ERym8r9K);
        if (ERym8r9K.indexOf("http://") == 0) {
            URL qQk3Bns4 = new URL(ERym8r9K);
            urlconn = qQk3Bns4.openConnection();
            inStream = urlconn.getInputStream();
            bufReader = new BufferedReader(new InputStreamReader(inStream));
        } else if (jmBtyIN5.equals("File")) {
            File DAKp1WkS = new File(ERym8r9K);
            size = DAKp1WkS.length();
            inStream = new FileInputStream(DAKp1WkS);
            bufReader = new BufferedReader(new InputStreamReader(inStream));
        } else if (jmBtyIN5.equals("URL")) {
            URL dSaLxXsI = new URL(ERym8r9K);
            urlconn = dSaLxXsI.openConnection();
            inStream = urlconn.getInputStream();
            bufReader = new BufferedReader(new InputStreamReader(inStream));
        } else if (jmBtyIN5.equals("URLZip")) {
            URL tEdqwOpT = new URL(ERym8r9K);
            inStream = new GZIPInputStream(tEdqwOpT.openStream(), 16384);
            InputStreamReader lmOTsVlf = new InputStreamReader(inStream);
            bufReader = new BufferedReader(lmOTsVlf, 16384);
        } else {
            System.out.println("Unknown FileParse inType " + jmBtyIN5);
        }
    }

}