class n4032668 {
	public CertificateID(String olQSofia, X509Certificate w4kSm9R0, BigInteger a60gnj3a, String QhXK2iVr) throws OCSPException {
        try {
            MessageDigest tH9Szq6N = MessageDigest.getInstance(olQSofia, QhXK2iVr);
            AlgorithmIdentifier xG3Oyom8 = new AlgorithmIdentifier(new DERObjectIdentifier(olQSofia), new DERNull());
            X509Principal Vkqn6qwI = PrincipalUtil.getSubjectX509Principal(w4kSm9R0);
            tH9Szq6N.update(Vkqn6qwI.getEncoded());
            ASN1OctetString os5pDKjr = new DEROctetString(tH9Szq6N.digest());
            PublicKey Bus2nfAi = w4kSm9R0.getPublicKey();
            ASN1InputStream knyJlMnV = new ASN1InputStream(Bus2nfAi.getEncoded());
            SubjectPublicKeyInfo mBJfnkoq = SubjectPublicKeyInfo.getInstance(knyJlMnV.readObject());
            tH9Szq6N.update(mBJfnkoq.getPublicKeyData().getBytes());
            ASN1OctetString Lss2PVsa = new DEROctetString(tH9Szq6N.digest());
            DERInteger ugjSl4Qc = new DERInteger(a60gnj3a);
            this.id = new CertID(xG3Oyom8, os5pDKjr, Lss2PVsa, ugjSl4Qc);
        } catch (Exception gSxtQdWS) {
            throw new OCSPException("problem creating ID: " + gSxtQdWS, gSxtQdWS);
        }
    }

}