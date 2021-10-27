class n2439668 {
	public void run() {
		try {
			textUpdater.start();
			int cnt;
			byte[] buf = new byte[4096];
			File file = null;
			ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(filename)));
			ZipEntry ze = zis.getNextEntry();
			FileOutputStream fos;
			while (ze != null) {
				if (!(ze.isDirectory())) {
					textUpdater.appendText("Extracting file: " + ze.getName() + "\n");
					fos = new FileOutputStream(dstdir + File.separator + ze.getName());
					while ((cnt = zis.read(buf, 0, buf.length)) != -1)
						fos.write(buf, 0, cnt);
					fos.close();
				} else {
					file = new File(ze.getName());
					if (!file.exists()) {
						textUpdater.appendText("Creating directory: " + ze.getName() + "\n");
						file.mkdirs();
					}
				}
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			zis.close();
			if (!(complete != null))
				;
			else
				textUpdater.appendText(complete + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		textUpdater.setFinished(true);
	}

}