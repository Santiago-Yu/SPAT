class n2103971 {
	@Override
	protected void writeFile() {
		super.writeFile();
		try {
			String tagListFilePath = file.toURI().toASCIIString();
			tagListFilePath = tagListFilePath.substring(0,
					tagListFilePath.lastIndexOf(FileManager.GLIPS_VIEW_EXTENSION))
					+ FileManager.TAG_LIST_FILE_EXTENSION;
			StringBuffer buffer = new StringBuffer("");
			File tagListFile = new File(new URI(tagListFilePath));
			for (String tagName : tags) {
				buffer.append(tagName + "\n");
			}
			FileOutputStream out = new FileOutputStream(tagListFile);
			ByteBuffer byteBuffer = ByteBuffer.wrap(buffer.toString().getBytes("UTF-8"));
			FileChannel channel = out.getChannel();
			channel.write(byteBuffer);
			channel.close();
		} catch (Exception ex) {
		}
		try {
			String parentPath = file.getParentFile().toURI().toASCIIString();
			File srcFile = null, destFile = null;
			if (!parentPath.endsWith("/")) {
				parentPath += "/";
			}
			int nb = 0;
			byte[] tab = new byte[1000];
			OutputStream out = null;
			InputStream in = null;
			for (String destinationName : dataBaseFiles.keySet()) {
				srcFile = dataBaseFiles.get(destinationName);
				if (srcFile != null) {
					in = new BufferedInputStream(new FileInputStream(srcFile));
					destFile = new File(new URI(parentPath + destinationName));
					out = new BufferedOutputStream(new FileOutputStream(destFile));
					while (in.available() > 0) {
						nb = in.read(tab);
						if (nb > 0) {
							out.write(tab, 0, nb);
						}
					}
					in.close();
					out.flush();
					out.close();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}