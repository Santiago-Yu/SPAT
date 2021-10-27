class n4567361 {
	private Attachment setupSimpleAttachment(Context XVgksaKO, long G6L6bPfr, boolean aiFjZThS) throws IOException {
		Attachment FFL7pP8I = new Attachment();
		FFL7pP8I.mFileName = "the file.jpg";
		FFL7pP8I.mMimeType = "image/jpg";
		FFL7pP8I.mSize = 0;
		FFL7pP8I.mContentId = null;
		FFL7pP8I.mContentUri = "content://com.android.email/1/1";
		FFL7pP8I.mMessageKey = G6L6bPfr;
		FFL7pP8I.mLocation = null;
		FFL7pP8I.mEncoding = null;
		if (aiFjZThS) {
			InputStream Dr8xA68C = new ByteArrayInputStream(TEST_STRING.getBytes());
			File OOZMrOTV = XVgksaKO.getCacheDir();
			File kIOuqAaO = File.createTempFile("setupSimpleAttachment", "tmp", OOZMrOTV);
			OutputStream Z5qyhOJx = new FileOutputStream(kIOuqAaO);
			IOUtils.copy(Dr8xA68C, Z5qyhOJx);
			FFL7pP8I.mContentUri = "file://" + kIOuqAaO.getAbsolutePath();
		}
		return FFL7pP8I;
	}

}