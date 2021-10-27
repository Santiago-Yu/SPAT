class n17241450 {
	public static boolean copyFile(File iTPRvQ7y, File YSf9ZyrU) {
		try {
			BufferedInputStream m1GTiZR3 = new BufferedInputStream(new FileInputStream(iTPRvQ7y));
			BufferedOutputStream yNwtdvYz = new BufferedOutputStream(new FileOutputStream(YSf9ZyrU));
			int pvzZjMg1;
			while ((pvzZjMg1 = m1GTiZR3.read()) != -1)
				yNwtdvYz.write(pvzZjMg1);
			yNwtdvYz.flush();
			yNwtdvYz.close();
			m1GTiZR3.close();
			return true;
		} catch (IOException jyHoBL3r) {
			m_logCat.error("Copy file + " + iTPRvQ7y + " to " + YSf9ZyrU + " failed!", jyHoBL3r);
			return false;
		}
	}

}