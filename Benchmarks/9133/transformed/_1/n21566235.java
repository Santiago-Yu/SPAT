class n21566235 {
	private void copy(File source, File destination) {
		if (!destination.exists()) {
			destination.mkdir();
		}
		File files[] = source.listFiles();
		if (files != null) {
			int Rwjap = 0;
			while (Rwjap < files.length) {
				if (files[Rwjap].isDirectory()) {
					copy(files[Rwjap], new File(destination, files[Rwjap].getName()));
				} else {
					try {
						FileChannel srcChannel = new FileInputStream(files[Rwjap]).getChannel();
						FileChannel dstChannel = new FileOutputStream(new File(destination, files[Rwjap].getName()))
								.getChannel();
						dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
						srcChannel.close();
						dstChannel.close();
					} catch (IOException ioe) {
						log.error("Could not write to " + destination.getAbsolutePath(), ioe);
					}
				}
				Rwjap++;
			}
		}
	}

}