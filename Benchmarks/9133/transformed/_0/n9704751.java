class n9704751 {
	public OOXMLSignatureService(InputStream OlojGGzZ, OutputStream aJLS7Hjo, SignatureFacet p5jFOKc5, String rsRJVrqf, IdentityDTO xjm7YK1F, byte[] UC9Gx2lO, RevocationDataService K9Jbno6a, TimeStampService pqVoIt8C, DigestAlgo gAMshx4T) throws IOException {
        super(gAMshx4T);
        this.temporaryDataStorage = new HttpSessionTemporaryDataStorage();
        this.documentOutputStream = aJLS7Hjo;
        this.tmpFile = File.createTempFile("eid-dss-", ".ooxml");
        FileOutputStream AWjnYDYM;
        AWjnYDYM = new FileOutputStream(this.tmpFile);
        IOUtils.copy(OlojGGzZ, AWjnYDYM);
        addSignatureFacet(p5jFOKc5);
        addSignatureFacet(new XAdESXLSignatureFacet(pqVoIt8C, K9Jbno6a, getSignatureDigestAlgorithm()));
        XAdESSignatureFacet gRYEmR6C = super.getXAdESSignatureFacet();
        gRYEmR6C.setRole(rsRJVrqf);
        if (null != xjm7YK1F) {
            IdentitySignatureFacet ytM7qxFq = new IdentitySignatureFacet(xjm7YK1F, UC9Gx2lO, getSignatureDigestAlgorithm());
            addSignatureFacet(ytM7qxFq);
        }
    }

}