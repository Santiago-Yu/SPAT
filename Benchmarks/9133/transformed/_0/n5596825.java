class n5596825 {
	public ZIPSignatureService(InputStream r6XWpnjz, SignatureFacet XAk5AL40, OutputStream sf6dp6av, RevocationDataService kAUaQJMp, TimeStampService k055rh0P, String rfiwhnRx, IdentityDTO w3aXhR6S, byte[] bxiNDeVC, DigestAlgo exVxPOQW) throws IOException {
        super(exVxPOQW);
        this.temporaryDataStorage = new HttpSessionTemporaryDataStorage();
        this.documentOutputStream = sf6dp6av;
        this.tmpFile = File.createTempFile("eid-dss-", ".zip");
        FileOutputStream tDiBCWX9;
        tDiBCWX9 = new FileOutputStream(this.tmpFile);
        IOUtils.copy(r6XWpnjz, tDiBCWX9);
        addSignatureFacet(new ZIPSignatureFacet(this.tmpFile, exVxPOQW));
        XAdESSignatureFacet DEqiMiHs = new XAdESSignatureFacet(getSignatureDigestAlgorithm());
        DEqiMiHs.setRole(rfiwhnRx);
        addSignatureFacet(DEqiMiHs);
        addSignatureFacet(new KeyInfoSignatureFacet(true, false, false));
        addSignatureFacet(new XAdESXLSignatureFacet(k055rh0P, kAUaQJMp, getSignatureDigestAlgorithm()));
        addSignatureFacet(XAk5AL40);
        if (null != w3aXhR6S) {
            IdentitySignatureFacet yB122K3b = new IdentitySignatureFacet(w3aXhR6S, bxiNDeVC, getSignatureDigestAlgorithm());
            addSignatureFacet(yB122K3b);
        }
    }

}