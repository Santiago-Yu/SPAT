class n22717685 {
	public static final void copy(File src, File dest) throws IOException {
		FileOutputStream destination = null;
		FileInputStream source = null;
		int bytes_read;
		byte[] buffer;
		if (!src.exists()) {
			throw new IOException("Source not found: " + src);
		}
		if (!src.canRead()) {
			throw new IOException("Source is unreadable: " + src);
		}
		if (src.isFile()) {
			if (!dest.exists()) {
				File parentdir = parent(dest);
				if (!parentdir.exists()) {
					parentdir.mkdir();
				}
			} else if (dest.isDirectory()) {
				dest = new File(dest + File.separator + src);
			}
		} else if (src.isDirectory()) {
			if (dest.isFile()) {
				throw new IOException("Cannot copy directory " + src + " to file " + dest);
			}
			if (!dest.exists()) {
				dest.mkdir();
			}
		}
		if (src.isFile()) {
			try {
				destination = new FileOutputStream(dest);
				source = new FileInputStream(src);
				buffer = new byte[1024];
				while (true) {
					bytes_read = source.read(buffer);
					if (bytes_read == -1) {
						break;
					}
					destination.write(buffer, 0, bytes_read);
				}
			} finally {
				if (source != null) {
					try {
						source.close();
					} catch (IOException e) {
					}
				}
				if (destination != null) {
					try {
						destination.close();
					} catch (IOException e) {
					}
				}
			}
		} else if (src.isDirectory()) {
			String targetfile, target, targetdest;
			String[] files = src.list();
			for (int i = 0; i < files.length; i++) {
				targetfile = files[i];
				target = src + File.separator + targetfile;
				targetdest = dest + File.separator + targetfile;
				if ((new File(target)).isDirectory()) {
					copy(new File(target), new File(targetdest));
				} else {
					try {
						destination = new FileOutputStream(targetdest);
						source = new FileInputStream(target);
						buffer = new byte[1024];
						while (true) {
							bytes_read = source.read(buffer);
							if (bytes_read == -1) {
								break;
							}
							destination.write(buffer, 0, bytes_read);
						}
					} finally {
						if (source != null) {
							try {
								source.close();
							} catch (IOException e) {
							}
						}
						if (destination != null) {
							try {
								destination.close();
							} catch (IOException e) {
							}
						}
					}
				}
			}
		}
	}

}