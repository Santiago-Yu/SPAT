class n18288470 {
	public static void unzip(String zipfile, String outputDirectory) {
		try {
			ZipInputStream zipinputstream = null;
			byte[] buf = new byte[1024];
			zipinputstream = new ZipInputStream(new FileInputStream(zipfile));
			ZipEntry zipentry;
			zipentry = zipinputstream.getNextEntry();
			while (zipentry != null) {
				String entryName = zipentry.getName();
				System.out.println("entryname " + entryName);
				FileOutputStream fileoutputstream;
				int n;
				File newFile = new File(entryName);
				String directory = newFile.getParent();
				fileoutputstream = new FileOutputStream(outputDirectory + entryName);
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