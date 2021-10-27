class n18880071 {
	private static boolean unzipWithWarning(File source, File targetDirectory, OverwriteValue policy) {
		try {
			if (!source.exists())
				return false;
			ZipEntry zipEntry = null;
			ZipInputStream input = new ZipInputStream(new FileInputStream(source));
			byte[] buffer = new byte[1024];
			while ((zipEntry = input.getNextEntry()) != null) {
				if (zipEntry.isDirectory())
					continue;
				File newFile = new File(targetDirectory, zipEntry.getName());
				if (newFile.exists()) {
					switch (policy.value) {
					case NO_TO_ALL:
						continue;
					case YES_TO_ALL:
						break;
					default:
						switch (policy.value = confirmOverwrite(zipEntry.getName())) {
						case NO_TO_ALL:
						case NO:
							continue;
						default:
						}
					}
				}
				newFile.getParentFile().mkdirs();
				FileOutputStream output = new FileOutputStream(newFile);
				int bytesRead;
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