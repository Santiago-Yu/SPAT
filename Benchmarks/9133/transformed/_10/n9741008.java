class n9741008 {
	public MetaService() {
        URL url = this.getClass().getResource(Resource);
        super();
        if (null != url) {
            String value = null;
            this.location = url;
            try {
                InputStream in = url.openStream();
                try {
                    value = (new java.io.DataInputStream(in).readLine());
                    if (null != value) {
                        value = value.trim();
                        if (1 > value.length()) value = null;
                    }
                } finally {
                    in.close();
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
            this.value = value;
        } else {
            this.location = null;
            this.value = null;
        }
    }

}