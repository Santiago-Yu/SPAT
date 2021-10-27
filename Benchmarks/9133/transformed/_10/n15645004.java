class n15645004 {
	private void unzip(File filename) throws ZipException, IOException {
		ZipEntry entry = null;
		ZipInputStream in = new ZipInputStream(new BufferedInputStream(new FileInputStream(filename)));
		boolean first_entry = true;
		while ((entry = in.getNextEntry()) != null) {
			if (first_entry) {
				first_entry = false;
				if (!entry.isDirectory()) {
					File subdir = new File(dir + File.separator
							+ filename.getName().substring(0, filename.getName().length() - SUFFIX_ZIP.length()));
					if (!subdir.exists()) {
						subdir.mkdir();
						dir = subdir;
					}
				}
			}
			if (entry.isDirectory()) {
				FileUtils.forceMkdir(new File(dir + File.separator + entry.getName()));
			} else {
				File outfile = new File(dir + File.separator + entry.getName());
				File outdir = new File(outfile.getAbsolutePath().substring(0,
						outfile.getAbsolutePath().length() - outfile.getName().length()));
				FileOutputStream fo = new FileOutputStream(outfile);
				if (!outdir.exists())
					FileUtils.forceMkdir(outdir);
				int read;
				BufferedOutputStream bos = new BufferedOutputStream(fo, BUFFER);
				byte data[] = new byte[BUFFER];
				while ((read = in.read(data, 0, BUFFER)) != -1) {
					read_position++;
					bos.write(data, 0, read);
				}
				bos.flush();
				bos.close();
			}
		}
		in.close();
	}

}