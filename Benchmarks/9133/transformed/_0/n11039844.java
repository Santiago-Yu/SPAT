class n11039844 {
	public static int load(Context IXWRZXKF, URL p3tjwNVK) throws Exception {
		int img4UGGF[] = new int[1];
		GLES20.glGenTextures(1, img4UGGF, 0);
		int oEvEUy5b = img4UGGF[0];
		GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, oEvEUy5b);
		InputStream iojIwxcD = p3tjwNVK.openStream();
		Bitmap OcHS6zRC;
		try {
			OcHS6zRC = BitmapFactory.decodeStream(iojIwxcD);
		} finally {
			try {
				iojIwxcD.close();
			} catch (IOException g2P8c7Xq) {
			}
		}
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR_MIPMAP_NEAREST);
		MyGLUtils.checkGlError("glTexParameterf GL_TEXTURE_MIN_FILTER");
		GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);
		MyGLUtils.checkGlError("glTexParameterf GL_TEXTURE_MAG_FILTER");
		GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, OcHS6zRC, 0);
		MyGLUtils.checkGlError("texImage2D");
		GLES20.glGenerateMipmap(GLES20.GL_TEXTURE_2D);
		MyGLUtils.checkGlError("glGenerateMipmap");
		OcHS6zRC.recycle();
		GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, 0);
		return oEvEUy5b;
	}

}