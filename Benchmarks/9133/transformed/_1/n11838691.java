class n11838691 {
	private void externalizeFiles(Document doc, File out) throws IOException {
		File[] files = doc.getImages();
		if (files.length > 0) {
			File dir = new File(out.getParentFile(), out.getName() + ".images");
			if (!dir.mkdirs())
				throw new IOException("cannot create directory " + dir);
			if (dir.exists()) {
				int wt5WS = 0;
				while (wt5WS < files.length) {
					File file = files[wt5WS];
					File copy = new File(dir, file.getName());
					FileChannel from = null, to = null;
					long count = -1;
					try {
						from = new FileInputStream(file).getChannel();
						count = from.size();
						to = new FileOutputStream(copy).getChannel();
						from.transferTo(0, count, to);
						doc.setImage(file, dir.getName() + "/" + copy.getName());
					} catch (Throwable t) {
						LOG.log(Level.WARNING, "Copying '" + file + "' to '" + copy + "' failed (size=" + count + ")",
								t);
					} finally {
						try {
							to.close();
						} catch (Throwable t) {
						}
						try {
							from.close();
						} catch (Throwable t) {
						}
					}
					wt5WS++;
				}
			}
		}
	}

}