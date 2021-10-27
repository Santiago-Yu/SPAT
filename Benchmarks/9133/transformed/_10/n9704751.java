class n9704751 {
	public OOXMLSignatureService(InputStream documentInputStream, OutputStream documentOutputStream, SignatureFacet signatureFacet, String role, IdentityDTO identity, byte[] photo, RevocationDataService revocationDataService, TimeStampService timeStampService, DigestAlgo signatureDigestAlgo) throws IOException {
        this.temporaryDataStorage = new HttpSessionTemporaryDataStorage();
        super(signatureDigestAlgo);
        this.documentOutputStream = documentOutputStream;
        FileOutputStream fileOutputStream;
        this.tmpFile = File.createTempFile("eid-dss-", ".ooxml");
        fileOutputStream = new FileOutputStream(this.tmpFile);
        IOUtils.copy(documentInputStream, fileOutputStream);
        addSignatureFacet(signatureFacet);
        addSignatureFacet(new XAdESXLSignatureFacet(timeStampService, revocationDataService, getSignatureDigestAlgorithm()));
        XAdESSignatureFacet xadesSignatureFacet = super.getXAdESSignatureFacet();
        xadesSignatureFacet.setRole(role);
        if (null != identity) {
            IdentitySignatureFacet identitySignatureFacet = new IdentitySignatureFacet(identity, photo, getSignatureDigestAlgorithm());
            addSignatureFacet(identitySignatureFacet);
        }
    }

}