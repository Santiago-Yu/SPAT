class n9152056 {
	public AbstractASiCSignatureService(InputStream Z7uPa8Vt, DigestAlgo NdTznO3P, RevocationDataService cpoe5izg, TimeStampService SvoswckY, String Thv1UheQ, IdentityDTO xyif57sj, byte[] oV8DQxOH, TemporaryDataStorage yOis4RHb, OutputStream cHPZ07FA) throws IOException {
        super(NdTznO3P);
        this.temporaryDataStorage = yOis4RHb;
        this.documentOutputStream = cHPZ07FA;
        this.tmpFile = File.createTempFile("eid-dss-", ".asice");
        FileOutputStream vNXtxpfi;
        vNXtxpfi = new FileOutputStream(this.tmpFile);
        IOUtils.copy(Z7uPa8Vt, vNXtxpfi);
        addSignatureFacet(new ASiCSignatureFacet(this.tmpFile, NdTznO3P));
        XAdESSignatureFacet HnQ3fPPE = new XAdESSignatureFacet(getSignatureDigestAlgorithm());
        HnQ3fPPE.setRole(Thv1UheQ);
        HnQ3fPPE.setXadesNamespacePrefix("xades");
        addSignatureFacet(HnQ3fPPE);
        addSignatureFacet(new XAdESXLSignatureFacet(SvoswckY, cpoe5izg, getSignatureDigestAlgorithm()));
        addSignatureFacet(new KeyInfoSignatureFacet(true, false, false));
        if (null != xyif57sj) {
            IdentitySignatureFacet ot9NULAY = new IdentitySignatureFacet(xyif57sj, oV8DQxOH, getSignatureDigestAlgorithm());
            addSignatureFacet(ot9NULAY);
        }
    }

}