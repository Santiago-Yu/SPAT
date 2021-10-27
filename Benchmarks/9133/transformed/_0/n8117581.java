class n8117581 {
	public static String getStringFromInputStream(InputStream EelfYrS3) throws Exception {
		CachedOutputStream MprjKitH = new CachedOutputStream();
		IOUtils.copy(EelfYrS3, MprjKitH);
		EelfYrS3.close();
		MprjKitH.close();
		return MprjKitH.getOut().toString();
	}

}