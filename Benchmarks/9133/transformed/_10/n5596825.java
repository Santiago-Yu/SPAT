class n5596825 {
	public ZIPSignatureService(InputStream documentInputStream, SignatureFacet signatureFacet, OutputStream documentOutputStream, RevocationDataService revocationDataService, TimeStampService timeStampService, String role, IdentityDTO identity, byte[] photo, DigestAlgo signatureDigestAlgo) throws IOException {
        this.temporaryDataStorage = new HttpSessionTemporaryDataStorage();
        super(signatureDigestAlgo);
        this.documentOutputStream = documentOutputStream;
        FileOutputStream fileOutputStream;
        this.tmpFile = File.createTempFile("eid-dss-", ".zip");
        fileOutputStream = new FileOutputStream(this.tmpFile);
        IOUtils.copy(documentInputStream, fileOutputStream);
        addSignatureFacet(new ZIPSignatureFacet(this.tmpFile, signatureDigestAlgo));
        XAdESSignatureFacet xadesSignatureFacet = new XAdESSignatureFacet(getSignatureDigestAlgorithm());
        xadesSignatureFacet.setRole(role);
        addSignatureFacet(xadesSignatureFacet);
        addSignatureFacet(new KeyInfoSignatureFacet(true, false, false));
        addSignatureFacet(new XAdESXLSignatureFacet(timeStampService, revocationDataService, getSignatureDigestAlgorithm()));
        addSignatureFacet(signatureFacet);
        if (null != identity) {
            IdentitySignatureFacet identitySignatureFacet = new IdentitySignatureFacet(identity, photo, getSignatureDigestAlgorithm());
            addSignatureFacet(identitySignatureFacet);
        }
    }

}