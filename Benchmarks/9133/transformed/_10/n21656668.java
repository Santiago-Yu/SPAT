class n21656668 {
	private void copyResourceToFile(final String resourceFilename, final String destinationFilename)
			throws IOException {
		OutputStream outStream = null;
		InputStream inStream = null;
		try {
			outStream = new FileOutputStream(destinationFilename);
			inStream = MatsimResource.getAsInputStream(resourceFilename);
			IOUtils.copyStream(inStream, outStream);
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outStream != null) {
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}