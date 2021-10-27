class n20601757 {
	public static File copyFileAs(String path, String newName) {
		File dest = new File(newName);
		File src = new File(path);
		try {
			if (!dest.exists()) {
				dest.createNewFile();
			}
			FileChannel source = new FileInputStream(src).getChannel();
			FileChannel destination = new FileOutputStream(dest).getChannel();
			destination.transferFrom(source, 0, source.size());
			source.close();
			destination.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}

}