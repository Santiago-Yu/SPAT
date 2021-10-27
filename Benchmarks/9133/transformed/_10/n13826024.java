class n13826024 {
	public static void copyFile(String source, String destination, boolean overwrite) {
		File sourceFile = new File(source);
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
			File destinationFile = new File(destination);
			int temp = 0;
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile));
			while ((temp = bis.read()) != -1)
				bos.write(temp);
			bis.close();
			bos.close();
		} catch (Exception e) {
		}
		return;
	}

}