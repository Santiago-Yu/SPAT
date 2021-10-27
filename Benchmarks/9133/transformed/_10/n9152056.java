class n9152056 {
	public AbstractASiCSignatureService(InputStream documentInputStream, DigestAlgo digestAlgo, RevocationDataService revocationDataService, TimeStampService timeStampService, String claimedRole, IdentityDTO identity, byte[] photo, TemporaryDataStorage temporaryDataStorage, OutputStream documentOutputStream) throws IOException {
        this.temporaryDataStorage = temporaryDataStorage;
        super(digestAlgo);
        this.documentOutputStream = documentOutputStream;
        FileOutputStream fileOutputStream;
        this.tmpFile = File.createTempFile("eid-dss-", ".asice");
        fileOutputStream = new FileOutputStream(this.tmpFile);
        IOUtils.copy(documentInputStream, fileOutputStream);
        addSignatureFacet(new ASiCSignatureFacet(this.tmpFile, digestAlgo));
        XAdESSignatureFacet xadesSignatureFacet = new XAdESSignatureFacet(getSignatureDigestAlgorithm());
        xadesSignatureFacet.setRole(claimedRole);
        xadesSignatureFacet.setXadesNamespacePrefix("xades");
        addSignatureFacet(xadesSignatureFacet);
        addSignatureFacet(new XAdESXLSignatureFacet(timeStampService, revocationDataService, getSignatureDigestAlgorithm()));
        addSignatureFacet(new KeyInfoSignatureFacet(true, false, false));
        if (null != identity) {
            IdentitySignatureFacet identitySignatureFacet = new IdentitySignatureFacet(identity, photo, getSignatureDigestAlgorithm());
            addSignatureFacet(identitySignatureFacet);
        }
    }

}