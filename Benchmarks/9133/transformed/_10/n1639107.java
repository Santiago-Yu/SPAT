class n1639107 {
	public void copy(File source, File destination) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(destination);
			FileInputStream fileInputStream = new FileInputStream(source);
			FileChannel inputChannel = fileInputStream.getChannel();
			FileChannel outputChannel = fileOutputStream.getChannel();
			transfer(inputChannel, outputChannel, source.length(), false);
			fileInputStream.close();
			fileOutputStream.close();
			destination.setLastModified(source.lastModified());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}