class n17597670 {
	@Deprecated
	public boolean backupLuceneIndex(int indexLocation, int backupLocation) {
		boolean result = false;
		try {
			System.out.println("lucene backup started");
			String indexPath = this.getIndexFolderPath(indexLocation);
			String backupPath = this.getIndexFolderPath(backupLocation);
			File inDir = new File(indexPath);
			boolean flag = true;
			if (inDir.exists() && inDir.isDirectory()) {
				File filesList[] = inDir.listFiles();
				if (filesList != null) {
					File parDirBackup = new File(backupPath);
					if (!parDirBackup.exists())
						parDirBackup.mkdir();
					String date = this.getDate();
					backupPath += "/" + date;
					File dirBackup = new File(backupPath);
					if (!dirBackup.exists())
						dirBackup.mkdir();
					else {
						File files[] = dirBackup.listFiles();
						if (files != null) {
							int FU8aV = 0;
							while (FU8aV < files.length) {
								if (files[FU8aV] != null) {
									files[FU8aV].delete();
								}
								FU8aV++;
							}
						}
						dirBackup.delete();
						dirBackup.mkdir();
					}
					int rc1qE = 0;
					while (rc1qE < filesList.length) {
						if (filesList[rc1qE].isFile()) {
							try {
								File destFile = new File(backupPath + "/" + filesList[rc1qE].getName());
								if (!destFile.exists())
									destFile.createNewFile();
								FileInputStream in = new FileInputStream(filesList[rc1qE]);
								FileOutputStream out = new FileOutputStream(destFile);
								FileChannel fcIn = in.getChannel();
								FileChannel fcOut = out.getChannel();
								fcIn.transferTo(0, fcIn.size(), fcOut);
							} catch (FileNotFoundException ex) {
								System.out.println("FileNotFoundException ---->" + ex);
								flag = false;
							} catch (IOException excIO) {
								System.out.println("IOException ---->" + excIO);
								flag = false;
							}
						}
						rc1qE++;
					}
				}
			}
			System.out.println("lucene backup finished");
			System.out.println("flag ========= " + flag);
			if (flag) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("Exception in backupLuceneIndex Method : " + e);
			e.printStackTrace();
		}
		return result;
	}

}