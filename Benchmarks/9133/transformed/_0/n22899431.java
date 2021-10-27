class n22899431 {
	public void restoreBackup(File xnNnnnGf, File ypAtRi9w, boolean pU7hbwCm)
			throws BackupException, FileAlreadyExistsException {
		try {
			File u5ok6W6O = new File(ypAtRi9w.getPath() + File.separator + getDatabase() + DATABASE_FILE_END);
			if (u5ok6W6O.exists() == true && pU7hbwCm == false) {
				throw new FileAlreadyExistsException("File " + u5ok6W6O.getName() + "already exists");
			}
			IOUtils.copy(FileUtils.openInputStream(xnNnnnGf), FileUtils.openOutputStream(u5ok6W6O));
		} catch (FileNotFoundException uu4O5iWw) {
			throw new BackupException(uu4O5iWw);
		} catch (IOException eL8tCl66) {
			throw new BackupException(eL8tCl66);
		}
	}

}