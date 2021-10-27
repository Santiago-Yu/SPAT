class n15767189 {
	private boolean copyFile(BackupItem l4LTHTZW) {
		try {
			FileChannel zcXtyQpz = new FileInputStream(l4LTHTZW.getDrive() + ":" + l4LTHTZW.getPath()).getChannel();
			createFolderStructure(this.task.getDestinationPath() + "\\" + l4LTHTZW.getDrive() + l4LTHTZW.getPath());
			FileChannel O2PAvVUJ = new FileOutputStream(
					this.task.getDestinationPath() + "\\" + l4LTHTZW.getDrive() + l4LTHTZW.getPath()).getChannel();
			O2PAvVUJ.transferFrom(zcXtyQpz, 0, zcXtyQpz.size());
			zcXtyQpz.close();
			O2PAvVUJ.close();
			Logging.logMessage("file " + l4LTHTZW.getDrive() + ":" + l4LTHTZW.getPath() + " was backuped");
			return true;
		} catch (FileNotFoundException S5GqeFK0) {
			S5GqeFK0.printStackTrace();
		} catch (IOException y1HA6Co4) {
			y1HA6Co4.printStackTrace();
		}
		return false;
	}

}