class n18578541 {
	public static boolean copyFile(File outFile, File inFile) {
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			if (!(outFile.createNewFile()))
				return false;
			else {
				inStream = new FileInputStream(inFile);
				outStream = new FileOutputStream(outFile);
				byte[] buffer = new byte[1024];
				int length;
				while ((length = inStream.read(buffer)) > 0)
					outStream.write(buffer, 0, length);
				inStream.close();
				outStream.close();
			}
		} catch (IOException iox) {
			iox.printStackTrace();
			return false;
		}
		return true;
	}

}