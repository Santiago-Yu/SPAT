class n10713685 {
	public static boolean unzip_and_merge(String infile, String outfile) {
		try {
			FileInputStream fis = new FileInputStream(infile);
			BufferedOutputStream dest = null;
			FileOutputStream fos = new FileOutputStream(outfile);
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
			dest = new BufferedOutputStream(fos, BUFFER);
			while (zis.getNextEntry() != null) {
				byte data[] = new byte[BUFFER];
				int count;
				while ((count = zis.read(data, 0, BUFFER)) != -1)
					dest.write(data, 0, count);
				dest.flush();
			}
			dest.close();
			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}