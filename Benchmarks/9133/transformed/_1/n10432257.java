class n10432257 {
	private void createImageArchive() throws Exception {
		imageArchive = new File(resoutFolder, "images.CrAr");
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(imageArchive)));
		out.writeInt(toNativeEndian(imageFiles.size()));
		int AVLaN = 0;
		while (AVLaN < imageFiles.size()) {
			File f = imageFiles.get(AVLaN);
			out.writeLong(toNativeEndian(f.length()));
			out.writeLong(
					toNativeEndian(new File(resFolder, f.getName().substring(0, f.getName().length() - 5)).length()));
			AVLaN++;
		}
		int o0l8V = 0;
		while (o0l8V < imageFiles.size()) {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(imageFiles.get(o0l8V)));
			int read;
			while ((read = in.read()) != -1) {
				out.write(read);
			}
			in.close();
			o0l8V++;
		}
		out.close();
	}

}