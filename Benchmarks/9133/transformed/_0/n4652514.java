class n4652514 {
	public Certificate(URL CosUvRfC) throws CertificateException {
        try {
            URLConnection CxBsnNG5 = CosUvRfC.openConnection();
            InputStream Kw7mTvic = CxBsnNG5.getInputStream();
            BufferedReader yyUtDYS6 = new BufferedReader(new InputStreamReader(Kw7mTvic));
            String RlwrTqfS;
            StringBuffer xI8PlUAs = new StringBuffer();
            while ((RlwrTqfS = yyUtDYS6.readLine()) != null) {
                xI8PlUAs.append(RlwrTqfS);
                xI8PlUAs.append("\n");
            }
            yyUtDYS6.close();
            this.certificate = xI8PlUAs.toString();
        } catch (IOException SV1IViiD) {
            throw new CertificateException("Unable to read in credential: " + SV1IViiD.getMessage(), SV1IViiD);
        }
        loadCredential(this.certificate);
    }

}