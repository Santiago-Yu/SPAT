class n716032 {
	public void getZipFiles(String filename) {
		try {
			byte[] buf = new byte[1024];
			String destinationname = "c:\\mods\\peu\\";
			ZipEntry zipentry;
			ZipInputStream zipinputstream = null;
			zipinputstream = new ZipInputStream(new FileInputStream(filename));
			zipentry = zipinputstream.getNextEntry();
			while (zipentry != null) {
				String entryName = zipentry.getName();
				System.out.println("entryname " + entryName);
				FileOutputStream fileoutputstream;
				int n;
				File newFile = new File(entryName);
				String directory = newFile.getParent();
				fileoutputstream = new FileOutputStream(destinationname + entryName);
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