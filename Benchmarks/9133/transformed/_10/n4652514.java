class n4652514 {
	public Certificate(URL url) throws CertificateException {
        try {
            URLConnection con = url.openConnection();
            InputStream in2 = con.getInputStream();
            String inputLine;
            BufferedReader in = new BufferedReader(new InputStreamReader(in2));
            StringBuffer cert = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                cert.append(inputLine);
                cert.append("\n");
            }
            in.close();
            this.certificate = cert.toString();
        } catch (IOException ex) {
            throw new CertificateException("Unable to read in credential: " + ex.getMessage(), ex);
        }
        loadCredential(this.certificate);
    }

}