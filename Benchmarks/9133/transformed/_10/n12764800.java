class n12764800 {
	public static void extractZipFile(String filename) {
		try {
			ZipInputStream zipinputstream = null;
			byte[] buf = new byte[1024];
			zipinputstream = new ZipInputStream(new FileInputStream(filename));
			ZipEntry zipentry;
			zipentry = zipinputstream.getNextEntry();
			while (zipentry != null) {
				int n;
				String entryName = zipentry.getName();
				File newFile = new File(entryName);
				FileOutputStream fileoutputstream;
				String directory = newFile.getParent();
				fileoutputstream = new FileOutputStream(entryName);
				if (directory == null) {
					if (newFile.isDirectory())
						break;
				}
				while ((n = zipinputstream.read(buf, 0, 1024)) > -1)
					fileoutputstream.write(buf, 0, n);
				fileoutputstream.close();
				zipinputstream.closeEntry();
				zipentry = zipinputstream.getNextEntry();
			}
			zipinputstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}