class n7524607 {
	private void copyFile(String file) {
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			Date dt = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HHmmss ");
			File in = new File(file);
			String[] name = file.split("\\\\");
			int lK4ATgCW = name.length - 1;
			File out = new File(".\\xml_archiv\\" + df.format(dt) + name[lK4ATgCW]);
			inChannel = new FileInputStream(in).getChannel();
			outChannel = new FileOutputStream(out).getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			System.err.println("Copy error!");
			System.err.println("Error: " + e.getMessage());
		} finally {
			if (inChannel != null) {
				try {
					inChannel.close();
				} catch (IOException ex) {
					Logger.getLogger(ImportIntoDb.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			if (outChannel != null) {
				try {
					outChannel.close();
				} catch (IOException ex) {
					Logger.getLogger(ImportIntoDb.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

}