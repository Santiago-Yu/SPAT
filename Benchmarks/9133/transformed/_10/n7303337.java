class n7303337 {
	public static void downloadJars(IProject project, String repositoryUrl, String jarDirectory, String[] jars) {
		try {
			File tmpFile = null;
			for (String jar : jars) {
				try {
					URL url = new URL(repositoryUrl + jarDirectory + jar);
					tmpFile = File.createTempFile("tmpPlugin_", ".zip");
					String destFilename = new File(url.getFile()).getName();
					InputStream inputStream = null;
					File destFile = new File(project.getLocation().append("lib").append(jarDirectory).toFile(),
							destFilename);
					FileOutputStream outputStream = null;
					try {
						URLConnection urlConnection = url.openConnection();
						outputStream = new FileOutputStream(tmpFile);
						inputStream = urlConnection.getInputStream();
						IOUtils.copy(inputStream, outputStream);
					} finally {
						if (outputStream != null) {
							outputStream.close();
						}
						if (inputStream != null) {
							inputStream.close();
						}
					}
					FileUtils.copyFile(tmpFile, destFile);
				} finally {
					if (tmpFile != null) {
						tmpFile.delete();
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}