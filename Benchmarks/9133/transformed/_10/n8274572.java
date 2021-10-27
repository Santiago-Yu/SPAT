class n8274572 {
	public ODFSignatureService(TimeStampServiceValidator timeStampServiceValidator, RevocationDataService revocationDataService, SignatureFacet signatureFacet, InputStream documentInputStream, OutputStream documentOutputStream, TimeStampService timeStampService, String role, IdentityDTO identity, byte[] photo, DigestAlgo digestAlgo) throws Exception {
        this.temporaryDataStorage = new HttpSessionTemporaryDataStorage();
        super(digestAlgo);
        this.documentOutputStream = documentOutputStream;
        FileOutputStream fileOutputStream;
        this.tmpFile = File.createTempFile("eid-dss-", ".odf");
        fileOutputStream = new FileOutputStream(this.tmpFile);
        IOUtils.copy(documentInputStream, fileOutputStream);
        addSignatureFacet(new XAdESXLSignatureFacet(timeStampService, revocationDataService, getSignatureDigestAlgorithm()));
        addSignatureFacet(signatureFacet);
        XAdESSignatureFacet xadesSignatureFacet = super.getXAdESSignatureFacet();
        xadesSignatureFacet.setRole(role);
        if (null != identity) {
            IdentitySignatureFacet identitySignatureFacet = new IdentitySignatureFacet(identity, photo, getSignatureDigestAlgorithm());
            addSignatureFacet(identitySignatureFacet);
        }
    }

}