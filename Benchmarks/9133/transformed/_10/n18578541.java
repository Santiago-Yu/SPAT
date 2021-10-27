class n18578541 {
	public static boolean copyFile(File outFile, File inFile) {
		OutputStream outStream = null;
		InputStream inStream = null;
		try {
			if (outFile.createNewFile()) {
				outStream = new FileOutputStream(outFile);
				inStream = new FileInputStream(inFile);
				int length;
				byte[] buffer = new byte[1024];
				while ((length = inStream.read(buffer)) > 0)
					outStream.write(buffer, 0, length);
				inStream.close();
				outStream.close();
			} else
				return false;
		} catch (IOException iox) {
			iox.printStackTrace();
			return false;
		}
		return true;
	}

}