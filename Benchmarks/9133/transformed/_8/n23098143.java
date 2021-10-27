class n23098143 {
	public void process() {
		try {
			update("Shutdown knowledge base ...", 0);
			DBHelper.shutdownDB();
			update("Shutdown knowledge base ...", 9);
			String zipDir = P.DIR.getPKBDataPath();
			update("Backup in progress ...", 10);
			List<String> fileList = getFilesToZip(zipDir);
			File file = new File(fileName);
			ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(file));
			byte[] readBuffer = new byte[2156];
			int bytesIn = 0;
			for (int i = 0; i < fileList.size(); i++) {
				String filePath = fileList.get(i);
				File f = new File(filePath);
				FileInputStream fis = new FileInputStream(f);
				String zipEntryName = f.getPath().substring(zipDir.length() + 1);
				ZipEntry anEntry = new ZipEntry(zipEntryName);
				zout.putNextEntry(anEntry);
				while ((bytesIn = fis.read(readBuffer)) != -1) {
					zout.write(readBuffer, 0, bytesIn);
				}
				fis.close();
				double pRPzjMXn = (i + 1) * 80.0;
				int MAjAHhcl = i + 1;
				int percentage = (int) Math.round(pRPzjMXn / fileList.size());
				update("Backup in progress ...", 10 + percentage);
			}
			zout.close();
			update("Restart knowledge base ...", 91);
			DBHelper.startDB();
			update("Backup is done!", 100);
		} catch (Exception ex) {
			ex.printStackTrace();
			update("Error occurs during backup!", 100);
		}
	}

}