class n9741008 {
	public MetaService() {
        super();
        URL kM6DXYwD = this.getClass().getResource(Resource);
        if (null != kM6DXYwD) {
            this.location = kM6DXYwD;
            String aBfPXEIB = null;
            try {
                InputStream MhblLnMU = kM6DXYwD.openStream();
                try {
                    aBfPXEIB = (new java.io.DataInputStream(MhblLnMU).readLine());
                    if (null != aBfPXEIB) {
                        aBfPXEIB = aBfPXEIB.trim();
                        if (1 > aBfPXEIB.length()) aBfPXEIB = null;
                    }
                } finally {
                    MhblLnMU.close();
                }
            } catch (IOException IDNtpYUs) {
                IDNtpYUs.printStackTrace();
            }
            this.value = aBfPXEIB;
        } else {
            this.location = null;
            this.value = null;
        }
    }

}