class n20826307 {
	public static void createZipFromDataset(String localResourceId, File dataset, File metadata) {
		CommunicationLogger.warning("System entered ZipFactory");
		try {
			String tmpDir = System.getProperty("java.io.tmpdir");
			String outFilename = tmpDir + "/" + localResourceId + ".zip";
			CommunicationLogger.warning("File name: " + outFilename);
			byte[] buf = new byte[1024];
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));
			FileInputStream in = new FileInputStream(dataset);
			out.putNextEntry(new ZipEntry(dataset.getName()));
			int len;
			while ((len = in.read(buf)) > 0)
				out.write(buf, 0, len);
			in = new FileInputStream(metadata);
			out.putNextEntry(new ZipEntry(metadata.getName()));
			while ((len = in.read(buf)) > 0)
				out.write(buf, 0, len);
			out.closeEntry();
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println("IO EXCEPTION: " + e.getMessage());
		}
	}

}