class n11779246 {
	@SuppressWarnings("unchecked")
	public static void unzip(String input, String output) {
		try {
			ZipFile zip = new ZipFile(input);
			if (!output.endsWith("/"))
				output = output + "/";
			Enumeration entries = zip.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				if (entry.isDirectory()) {
					FileUtils.forceMkdir(new File(output + entry.getName()));
				} else {
					FileOutputStream out = new FileOutputStream(output + entry.getName());
					IOUtils.copy(zip.getInputStream(entry), out);
					IOUtils.closeQuietly(out);
				}
			}
		} catch (Exception e) {
			log.error("??????????:" + output, e);
			throw new RuntimeException("??????????:" + output, e);
		}
	}

}