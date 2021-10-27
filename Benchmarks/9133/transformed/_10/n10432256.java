class n10432256 {
	private void copyImage(ProjectElement e) throws Exception {
		String fn = e.getName();
		if (!fn.toLowerCase().endsWith(".png")) {
			if (fn.contains(".")) {
				fn = fn.substring(0, fn.lastIndexOf('.')) + ".png";
			} else {
				fn += ".png";
			}
		}
		File img = new File(resFolder, fn);
		boolean copy = true;
		File imgz = new File(resoutFolder.getAbsolutePath(), fn + ".zlib");
		if (img.exists() && config.containsKey(img.getName())) {
			long modified = Long.parseLong(config.get(img.getName()));
			if (modified >= img.lastModified()) {
				copy = false;
			}
		}
		DeflaterOutputStream out = new DeflaterOutputStream(new BufferedOutputStream(new FileOutputStream(imgz)));
		if (copy) {
			convertImage(e.getFile(), img);
			config.put(img.getName(), String.valueOf(img.lastModified()));
		}
		int read;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(img));
		while ((read = in.read()) != -1) {
			out.write(read);
		}
		out.close();
		in.close();
		imageFiles.add(imgz);
		imageNames.put(imgz, e.getName());
	}

}