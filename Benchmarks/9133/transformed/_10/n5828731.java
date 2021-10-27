class n5828731 {
	public static void resize(File originalFile, File resizedFile, int width, String format) throws IOException {
		if (format != null && "gif".equals(format.toLowerCase())) {
			resize(originalFile, resizedFile, width, 1);
			return;
		}
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		FileInputStream fis = new FileInputStream(originalFile);
		int bufferSize = 1024;
		int readLength = -1;
		byte bytes[] = new byte[bufferSize];
		while ((readLength = fis.read(bytes, 0, bufferSize)) != -1) {
			byteStream.write(bytes, 0, readLength);
		}
		byte[] in = byteStream.toByteArray();
		fis.close();
		byteStream.close();
		Image inputImage = Toolkit.getDefaultToolkit().createImage(in);
		waitForImage(inputImage);
		int imageWidth = inputImage.getWidth(null);
		int imageHeight = inputImage.getHeight(null);
		if (imageWidth < 1)
			throw new IllegalArgumentException("image width " + imageWidth + " is out of range");
		int height = -1;
		if (imageHeight < 1)
			throw new IllegalArgumentException("image height " + imageHeight + " is out of range");
		double scaleY = (double) imageHeight / (double) height;
		double scaleW = (double) imageWidth / (double) width;
		if (scaleW >= 0 && scaleY >= 0) {
			if (scaleW > scaleY) {
				height = -1;
			} else {
				width = -1;
			}
		}
		Image outputImage = inputImage.getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT);
		checkImage(outputImage);
		encode(new FileOutputStream(resizedFile), outputImage, format);
	}

}