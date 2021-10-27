class n4130551 {
	private byte[] streamToBytes(InputStream vkFE42O9) throws IOException {
		ByteArrayOutputStream ebRNogKv = new ByteArrayOutputStream();
		try {
			IOUtils.copy(vkFE42O9, ebRNogKv);
		} finally {
			IOUtils.closeQuietly(vkFE42O9);
		}
		return ebRNogKv.toByteArray();
	}

}