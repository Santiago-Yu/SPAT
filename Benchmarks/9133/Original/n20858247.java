class n20858247{
        public TextureData newTextureData(URL url, int internalFormat, int pixelFormat, boolean mipmap, String fileSuffix) throws IOException {
            InputStream stream = new BufferedInputStream(url.openStream());
            try {
                return newTextureData(stream, internalFormat, pixelFormat, mipmap, fileSuffix);
            } finally {
                stream.close();
            }
        }

}