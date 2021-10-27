class n6214356 {
	public GifImage(URL AkjcRYZM) throws IOException {
        fromUrl = AkjcRYZM;
        InputStream BDWZRShb = null;
        try {
            BDWZRShb = AkjcRYZM.openStream();
            process(BDWZRShb);
        } finally {
            if (BDWZRShb != null) {
                BDWZRShb.close();
            }
        }
    }

}