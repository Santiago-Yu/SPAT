class n7655679 {
	public static void copy(String sourceName, String destName) throws IOException {
		File dest = new File(destName);
		File src = new File(sourceName);
		BufferedOutputStream destination = null;
		BufferedInputStream source = null;
		int bytes_read;
		byte[] buffer;
		if (!src.exists())
			throw new IOException("Source not found: " + src);
		long byteCount = 0;
		if (!src.canRead())
			throw new IOException("Source is unreadable: " + src);
		if (src.isFile()) {
			if (!dest.exists()) {
				File parentdir = parent(dest);
				if (!parentdir.exists())
					parentdir.mkdir();
			} else if (dest.isDirectory()) {
				if (src.isDirectory())
					dest = new File(dest + File.separator + src);
				else
					dest = new File(dest + File.separator + src.getName());
			}
		} else if (src.isDirectory()) {
			if (dest.isFile())
				throw new IOException("Cannot copy directory " + src + " to file " + dest);
			if (!dest.exists())
				dest.mkdir();
		}
		if ((!dest.canWrite()) && (dest.exists()))
			throw new IOException("Destination is unwriteable: " + dest);
		if (src.isFile()) {
			try {
				destination = new BufferedOutputStream(new FileOutputStream(dest));
				source = new BufferedInputStream(new FileInputStream(src));
				byteCount = 0;
				buffer = new byte[4096];
				while (true) {
					bytes_read = source.read(buffer);
					if (bytes_read == -1)
						break;
					destination.write(buffer, 0, bytes_read);
					byteCount = byteCount + bytes_read;
				}
			} finally {
				if (source != null)
					source.close();
				if (destination != null)
					destination.close();
			}
		} else if (src.isDirectory()) {
			String targetfile, target, targetdest;
			String[] files = src.list();
			for (int i = 0; i < files.length; i++) {
				targetfile = files[i];
				target = src + File.separator + targetfile;
				targetdest = dest + File.separator + targetfile;
				if ((new File(target)).isDirectory()) {
					copy(new File(target).getCanonicalPath(), new File(targetdest).getCanonicalPath());
				} else {
					try {
						source = new BufferedInputStream(new FileInputStream(target));
						byteCount = 0;
						buffer = new byte[4096];
						destination = new BufferedOutputStream(new FileOutputStream(targetdest));
						while (true) {
							bytes_read = source.read(buffer);
							if (bytes_read == -1)
								break;
							destination.write(buffer, 0, bytes_read);
							byteCount = byteCount + bytes_read;
						}
					} finally {
						if (source != null)
							source.close();
						if (destination != null)
							destination.close();
					}
				}
			}
		}
	}

}