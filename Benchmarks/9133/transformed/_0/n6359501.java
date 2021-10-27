class n6359501 {
	public EncodedScript(PackageScript Xw6mvJbH, DpkgData pohP0h4Y) throws IOException {
        _source = Xw6mvJbH;
        final ByteArrayOutputStream B7kkPt5X = new ByteArrayOutputStream();
        OutputStream axD1OMAF = null;
        try {
            axD1OMAF = MimeUtility.encode(B7kkPt5X, BASE64);
        } catch (final MessagingException ejeTbVeG) {
            throw new IOException("Failed to uuencode script. name=[" + _source.getFriendlyName() + "], reason=[" + ejeTbVeG.getMessage() + "].");
        }
        IOUtils.write(HEADER, B7kkPt5X, Dpkg.CHAR_ENCODING);
        B7kkPt5X.flush();
        IOUtils.copy(_source.getSource(pohP0h4Y), axD1OMAF);
        axD1OMAF.flush();
        IOUtils.write(FOOTER, B7kkPt5X, Dpkg.CHAR_ENCODING);
        B7kkPt5X.flush();
        axD1OMAF.close();
        B7kkPt5X.close();
        _encoded = B7kkPt5X.toString(Dpkg.CHAR_ENCODING);
    }

}