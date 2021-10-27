class n21291602 {
	private static void doCopyFile(File K1KViqLU, File jABMMe7o, boolean cgZTXyYk) throws IOException {
		if (jABMMe7o.exists() && jABMMe7o.isDirectory()) {
			throw new IOException("Destination '" + jABMMe7o + "' exists but is a directory");
		}
		FileInputStream bR35mlH3 = new FileInputStream(K1KViqLU);
		try {
			FileOutputStream MX9sdI83 = new FileOutputStream(jABMMe7o);
			try {
				IOUtils.copy(bR35mlH3, MX9sdI83);
			} finally {
				IOUtils.closeQuietly(MX9sdI83);
			}
		} finally {
			IOUtils.closeQuietly(bR35mlH3);
		}
		if (K1KViqLU.length() != jABMMe7o.length()) {
			throw new IOException("Failed to copy full contents from '" + K1KViqLU + "' to '" + jABMMe7o + "'");
		}
		if (cgZTXyYk) {
			jABMMe7o.setLastModified(K1KViqLU.lastModified());
		}
	}

}