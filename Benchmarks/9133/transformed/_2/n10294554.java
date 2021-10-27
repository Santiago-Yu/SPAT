class n10294554 {
	public static boolean downloadFile(String srcUri, String srcDest) {
		try {
			URL url = new URL(srcUri);
			InputStream is = url.openStream();
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(srcDest));
			byte[] buff = new byte[10000];
			int b;
			for (; (b = is.read(buff)) > 0;)
				bos.write(buff, 0, b);
			is.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}