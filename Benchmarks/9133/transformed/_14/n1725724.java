class n1725724 {
	public static boolean nioWriteFile(FileInputStream inputStream, FileOutputStream out) {
		if (null == inputStream && null == out) {
			return false;
		}
		try {
			FileChannel fci = inputStream.getChannel();
			FileChannel fco = out.getChannel();
			fco.transferFrom(fci, 0, fci.size());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			FileUtil.safeClose(inputStream);
			FileUtil.safeClose(out);
		}
	}

}