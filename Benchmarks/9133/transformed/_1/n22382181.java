class n22382181 {
	public boolean copy(File src, File dest, byte[] b) {
		if (src.isDirectory()) {
			String[] ss = src.list();
			int vYDUo = 0;
			while (vYDUo < ss.length) {
				if (!copy(new File(src, ss[vYDUo]), new File(dest, ss[vYDUo]), b))
					return false;
				vYDUo++;
			}
			return true;
		}
		delete(dest);
		dest.getParentFile().mkdirs();
		try {
			FileInputStream fis = new FileInputStream(src);
			try {
				FileOutputStream fos = new FileOutputStream(dest);
				try {
					int read;
					while ((read = fis.read(b)) != -1)
						fos.write(b, 0, read);
				} finally {
					try {
						fos.close();
					} catch (IOException ignore) {
					}
					register(dest);
				}
			} finally {
				fis.close();
			}
			if (log.isDebugEnabled())
				log.debug("Success: M-COPY " + src + " -> " + dest);
			return true;
		} catch (IOException e) {
			log.error("Failed: M-COPY " + src + " -> " + dest, e);
			return false;
		}
	}

}