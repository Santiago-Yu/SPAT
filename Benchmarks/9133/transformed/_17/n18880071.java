class n18880071 {
	private static boolean unzipWithWarning(File source, File targetDirectory, OverwriteValue policy) {
		try {
			if (!source.exists())
				return false;
			ZipInputStream input = new ZipInputStream(new FileInputStream(source));
			ZipEntry zipEntry = null;
			byte[] buffer = new byte[1024];
			while ((zipEntry = input.getNextEntry()) != null) {
				if (zipEntry.isDirectory())
					continue;
				File newFile = new File(targetDirectory, zipEntry.getName());
				if (newFile.exists()) {
					if (policy.value == YES_TO_ALL) {
					} else if (policy.value == NO_TO_ALL) {
						continue;
					} else {
						switch (policy.value = confirmOverwrite(zipEntry.getName())) {
						case NO_TO_ALL:
						case NO:
							continue;
						default:
						}
					}
				}
				newFile.getParentFile().mkdirs();
				int bytesRead;
				FileOutputStream output = new FileOutputStream(newFile);
				while ((bytesRead = input.read(buffer)) != -1)
					output.write(buffer, 0, bytesRead);
				output.close();
				input.closeEntry();
			}
			input.close();
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
		return true;
	}

}