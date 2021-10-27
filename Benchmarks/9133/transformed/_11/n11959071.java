class n11959071 {
	private String download(MacroManagerProgress progress, String fileName, String url) throws Exception {
		URLConnection conn = new URL(url).openConnection();
		progress.setMaximum(Math.max(0, conn.getContentLength()));
		String path = MiscUtilities.constructPath(installDirectory, fileName);
		if (!copy(progress, conn.getInputStream(), new FileOutputStream(path), true, true))
			return null;
		if (archive_zip) {
			Enumeration entries;
			ZipFile zipFile;
			try {
				File tempFile = new File(path);
				zipFile = new ZipFile(tempFile);
				entries = zipFile.entries();
				while (entries.hasMoreElements()) {
					ZipEntry entry = (ZipEntry) entries.nextElement();
					if (entry.isDirectory()) {
						String dpath = MiscUtilities.constructPath(installDirectory, entry.getName());
						(new File(dpath)).mkdir();
					} else {
						progress.setMaximum((int) entry.getSize());
						String ePath = MiscUtilities.constructPath(installDirectory, entry.getName());
						copy(progress, zipFile.getInputStream(entry),
								new BufferedOutputStream(new FileOutputStream(ePath)), true, true);
					}
				}
				zipFile.close();
				tempFile.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else if (archive_gzip) {
			File srce = new File(path);
			GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(srce));
			File temp = File.createTempFile("macro", "mgr");
			progress.setMaximum((int) srce.length());
			copy(progress, gzis, new BufferedOutputStream(new FileOutputStream(temp)), true, true);
			TarArchive tarc = new TarArchive(new FileInputStream(temp));
			tarc.extractContents(new File(installDirectory));
			tarc.closeArchive();
			(new File(path)).delete();
		}
		return path;
	}

}