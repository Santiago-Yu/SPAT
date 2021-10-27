class n16639229 {
	public static void copy(File source, File destination) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(destination);
			FileInputStream fileInputStream = new FileInputStream(source);
			FileChannel inputChannel = fileInputStream.getChannel();
			FileChannel outputChannel = fileOutputStream.getChannel();
			transfer(inputChannel, outputChannel, source.length(), 1024 * 1024 * 32, true, true);
			fileInputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}