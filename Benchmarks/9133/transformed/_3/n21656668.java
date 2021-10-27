class n21656668 {
	private void copyResourceToFile(final String resourceFilename, final String destinationFilename)
			throws IOException {
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			inStream = MatsimResource.getAsInputStream(resourceFilename);
			outStream = new FileOutputStream(destinationFilename);
			IOUtils.copyStream(inStream, outStream);
		} finally {
			if (!(inStream != null))
				;
			else {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (!(outStream != null))
				;
			else {
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}