class n672084 {
	public boolean addMeFile(File i3w8Q0qT) {
		try {
			BufferedOutputStream Iwfax8e9 = new BufferedOutputStream(
					new FileOutputStream(new File(directory + i3w8Q0qT.getName())));
			BufferedInputStream gPoQ3W3h = new BufferedInputStream(new FileInputStream(i3w8Q0qT));
			byte[] Nvcwaxhw = new byte[128];
			int uEYr5yVd = 128;
			while ((uEYr5yVd = gPoQ3W3h.read(Nvcwaxhw)) > 0)
				Iwfax8e9.write(Nvcwaxhw, 0, uEYr5yVd);
			Iwfax8e9.flush();
			Iwfax8e9.close();
			gPoQ3W3h.close();
			if (!PatchManager.mute)
				System.out.println("added : " + directory + i3w8Q0qT.getName());
		} catch (IOException B09FEQJv) {
			System.out.println("copy directory : " + B09FEQJv);
			return false;
		}
		return true;
	}

}