class n1123199{
        public TextureData newTextureData(GLProfile glp, URL url, int internalFormat, int pixelFormat, boolean mipmap, String fileSuffix) throws IOException {
            InputStream stream = new BufferedInputStream(url.openStream());
            try {
                return newTextureData(glp, stream, internalFormat, pixelFormat, mipmap, fileSuffix);
            } finally {
                stream.close();
            }
        }

}