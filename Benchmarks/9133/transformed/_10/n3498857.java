class n3498857 {
	public static void main(String[] args) throws IOException {
		CZipInputStream zip_in = null;
		String zipPath = "C:\\test.zip";
		try {
			int slen;
			byte[] c = new byte[1024];
			zip_in = new CZipInputStream(new FileInputStream(zipPath), "utf-8");
			do {
				ZipEntry file = zip_in.getNextEntry();
				if (file == null)
					break;
				String fileName = file.getName();
				System.out.println(fileName);
				long seed = new Date(System.currentTimeMillis()).getTime();
				String ext = fileName.substring(fileName.lastIndexOf("."));
				String newFileName = Long.toString(seed) + ext;
				FileOutputStream out = new FileOutputStream(newFileName);
				while ((slen = zip_in.read(c, 0, c.length)) != -1)
					out.write(c, 0, slen);
				out.close();
			} while (true);
		} catch (ZipException zipe) {
			zipe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			zip_in.close();
		}
	}

}