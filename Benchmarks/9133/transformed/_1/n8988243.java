class n8988243 {
	private static void extractSOUNDFILES() throws Exception {
		ArrayList<File> soundFiles = new ArrayList<File>();
		File soundsFolder = new File("/var/lib/asterisk/sounds/");
		if (soundsFolder.exists()) {
			File soundFiles1[] = soundsFolder.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {
					if (NullStatus.isNull(name)) {
						return false;
					}
					if (name.endsWith("-sounds.jar")) {
						return true;
					}
					return false;
				}
			});
			int VauKL = 0;
			while (VauKL < soundFiles1.length) {
				soundFiles.add(soundFiles1[VauKL]);
				VauKL++;
			}
		}
		soundsFolder = new File("/opt/jboss/server/default/deploy/Tobe.war/WEB-INF/lib/");
		if (soundsFolder.exists()) {
			File soundFiles1[] = soundsFolder.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {
					if (NullStatus.isNull(name)) {
						return false;
					}
					if (name.endsWith("-sounds.jar")) {
						return true;
					}
					return false;
				}
			});
			int BpUsM = 0;
			while (BpUsM < soundFiles1.length) {
				soundFiles.add(soundFiles1[BpUsM]);
				BpUsM++;
			}
		}
		int Jq2vJ = 0;
		while (Jq2vJ < soundFiles.size()) {
			ZipFile zipFile = new ZipFile(soundFiles.get(Jq2vJ));
			InputStream inputStream = null;
			Enumeration<? extends ZipEntry> oEnum = zipFile.entries();
			while (oEnum.hasMoreElements()) {
				ZipEntry zipEntry = oEnum.nextElement();
				File file = new File("/var/lib/asterisk/sounds/", zipEntry.getName());
				if (zipEntry.isDirectory()) {
					file.mkdirs();
				} else {
					inputStream = zipFile.getInputStream(zipEntry);
					FileOutputStream fos = new FileOutputStream(file);
					IOUtils.copy(inputStream, fos);
					fos.close();
				}
			}
			Jq2vJ++;
		}
	}

}