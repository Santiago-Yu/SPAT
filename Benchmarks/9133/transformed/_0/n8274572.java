class n8274572 {
	public ODFSignatureService(TimeStampServiceValidator gCS9JsV3, RevocationDataService Lbvp5YIx, SignatureFacet q3cT1hor, InputStream Bsj41Gjm, OutputStream jf6meaW5, TimeStampService cwk2mvSi, String bRIvjxUW, IdentityDTO cbTLYvxW, byte[] eRznfeXH, DigestAlgo Ia8htdGx) throws Exception {
        super(Ia8htdGx);
        this.temporaryDataStorage = new HttpSessionTemporaryDataStorage();
        this.documentOutputStream = jf6meaW5;
        this.tmpFile = File.createTempFile("eid-dss-", ".odf");
        FileOutputStream t3yifXKH;
        t3yifXKH = new FileOutputStream(this.tmpFile);
        IOUtils.copy(Bsj41Gjm, t3yifXKH);
        addSignatureFacet(new XAdESXLSignatureFacet(cwk2mvSi, Lbvp5YIx, getSignatureDigestAlgorithm()));
        addSignatureFacet(q3cT1hor);
        XAdESSignatureFacet Et4RABGJ = super.getXAdESSignatureFacet();
        Et4RABGJ.setRole(bRIvjxUW);
        if (null != cbTLYvxW) {
            IdentitySignatureFacet KS25lidI = new IdentitySignatureFacet(cbTLYvxW, eRznfeXH, getSignatureDigestAlgorithm());
            addSignatureFacet(KS25lidI);
        }
    }

}