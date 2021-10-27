class n19602043 {
	public RSClassLoader(Map<String, byte[]> ezbrOk5n, URL zQyp9giK) {
        try {
            CodeSource UdU2hoPT = new CodeSource(zQyp9giK, (CodeSigner[]) null);
            domain = new ProtectionDomain(UdU2hoPT, getPermissions());
            this.classes = ezbrOk5n;
            String hgqmM9pj = getClass().getResource("RSClassLoader.class").toString();
            hgqmM9pj = hgqmM9pj.replace("bot/RSClassLoader.class", "client/RandomAccessFile.class");
            URL IXpoptWN = new URL(hgqmM9pj);
            InputStream OMK66sXr = null;
            try {
                ByteArrayOutputStream niPfPruQ = new ByteArrayOutputStream(5000);
                OMK66sXr = new BufferedInputStream(IXpoptWN.openStream());
                byte[] PvBTyMWc = new byte[1024];
                int MbfS1zRl = -1;
                while ((MbfS1zRl = OMK66sXr.read(PvBTyMWc)) != -1) niPfPruQ.write(PvBTyMWc, 0, MbfS1zRl);
                byte[] iOUc88ip = niPfPruQ.toByteArray();
                this.classes.put("org.rsbot.client.RandomAccessFile", iOUc88ip);
            } catch (IOException HRsjs8jY) {
                HRsjs8jY.printStackTrace();
            } finally {
                if (OMK66sXr != null) OMK66sXr.close();
            }
        } catch (final Exception pTZxQETO) {
        }
    }

}