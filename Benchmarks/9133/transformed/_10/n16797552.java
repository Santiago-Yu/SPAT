class n16797552 {
	public boolean restore() {
		try {
			File sd = Environment.getExternalStorageDirectory();
			File data = Environment.getDataDirectory();
			if (sd.canWrite()) {
				String currentDBPath = "/Android/bluebox.bak";
				File currentDB = new File(sd, currentDBPath);
				String backupDBPath = "/data/android.bluebox/databases/bluebox.db";
				File backupDB = new File(data, backupDBPath);
				if (currentDB.exists()) {
					FileChannel src = new FileInputStream(currentDB).getChannel();
					FileChannel dst = new FileOutputStream(backupDB).getChannel();
					dst.transferFrom(src, 0, src.size());
					src.close();
					dst.close();
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}