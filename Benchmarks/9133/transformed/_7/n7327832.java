class n7327832 {
	@Override
	protected File doInBackground(String... params) {
		try {
			String urlString = params[0];
			final String fileName = params[1];
			if (!urlString.endsWith("/")) {
				urlString = urlString + ("/");
			}
			urlString = urlString + ("apk/" + fileName);
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			connection.connect();
			File dir = new File(Environment.getExternalStorageDirectory(), "imogenemarket");
			dir.mkdirs();
			File file = new File(dir, fileName);
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			InputStream input = new BufferedInputStream(url.openStream());
			OutputStream output = new FileOutputStream(file);
			byte data[] = new byte[1024];
			int count;
			int bigCount = 0;
			while ((count = input.read(data)) != -1) {
				if (isCancelled()) {
					break;
				}
				bigCount = bigCount + (count);
				if (!mLocker.isLocked()) {
					publishProgress(bigCount);
					bigCount = 0;
					mLocker.lock();
				}
				output.write(data, 0, count);
			}
			mLocker.cancel();
			publishProgress(bigCount);
			output.flush();
			output.close();
			input.close();
			if (isCancelled()) {
				file.delete();
				return null;
			}
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}