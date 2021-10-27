class n20684330 {
	public String downloadToSdCard(String localFileName, String suffixFromHeader, String extension) {
		FileOutputStream fos = null;
		InputStream in = null;
		String absolutePath = null;
		try {
			Log.i(TAG, "Opening URL: " + url);
			StreamAndHeader inAndHeader = HTTPUtils.openWithHeader(url, suffixFromHeader);
			if (inAndHeader == null || inAndHeader.mStream == null) {
				return null;
			}
			in = inAndHeader.mStream;
			String sdcardpath = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
			String headerValue = suffixFromHeader == null || inAndHeader.mHeaderValue == null ? ""
					: inAndHeader.mHeaderValue;
			headerValue = headerValue.replaceAll("[-:]*\\s*", "");
			mSize = in.available();
			String filename = sdcardpath + "/" + localFileName + headerValue + (extension == null ? "" : extension);
			Log.i(TAG, "Downloading " + filename + ", size: " + mSize);
			int buffersize = 1024;
			fos = new FileOutputStream(new File(filename));
			byte[] buffer = new byte[buffersize];
			mCount = 0;
			int readsize = buffersize;
			while (readsize != -1) {
				readsize = in.read(buffer, 0, buffersize);
				if (readsize > 0) {
					Log.i(TAG, "Read " + readsize + " bytes...");
					fos.write(buffer, 0, readsize);
					mCount += readsize;
				}
			}
			fos.flush();
			fos.close();
			FileInputStream controlIn = new FileInputStream(filename);
			mSavedSize = controlIn.available();
			Log.v(TAG, "saved size: " + mSavedSize);
			mAbsolutePath = filename;
			done();
		} catch (Exception e) {
			Log.e(TAG, "LoadingWorker.run", e);
		} finally {
			HTTPUtils.close(in);
		}
		return mAbsolutePath;
	}

}