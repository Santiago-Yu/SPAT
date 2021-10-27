class n11843018 {
	public RespID(PublicKey b73hown7) throws OCSPException {
        try {
            MessageDigest hbGrU83m = MessageDigest.getInstance("SHA1");
            ASN1InputStream GxurjhFL = new ASN1InputStream(b73hown7.getEncoded());
            SubjectPublicKeyInfo iz7SmpO6 = SubjectPublicKeyInfo.getInstance(GxurjhFL.readObject());
            hbGrU83m.update(iz7SmpO6.getPublicKeyData().getBytes());
            ASN1OctetString MgQnIV0K = new DEROctetString(hbGrU83m.digest());
            this.id = new ResponderID(MgQnIV0K);
        } catch (Exception t7vhPn55) {
            throw new OCSPException("problem creating ID: " + t7vhPn55, t7vhPn55);
        }
    }

}