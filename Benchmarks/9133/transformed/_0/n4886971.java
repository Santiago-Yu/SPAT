class n4886971 {
	private static void copyFile(String gsOIf6CN, String Q8PWTbn2) {
		try {
			File Jlvtu4a9 = new File(gsOIf6CN);
			File I8gU12gt = new File(Q8PWTbn2);
			InputStream KiKHB3dl = new FileInputStream(Jlvtu4a9);
			OutputStream Fdmz2fY9 = new FileOutputStream(I8gU12gt);
			byte[] XKQAkhoB = new byte[1024];
			int cQBOKBL1;
			while ((cQBOKBL1 = KiKHB3dl.read(XKQAkhoB)) > 0)
				Fdmz2fY9.write(XKQAkhoB, 0, cQBOKBL1);
			KiKHB3dl.close();
			Fdmz2fY9.close();
		} catch (FileNotFoundException PsnbkyZI) {
			System.out.println("Error copying " + gsOIf6CN + " to " + Q8PWTbn2);
			System.out.println(PsnbkyZI.getMessage() + " in the specified directory.");
		} catch (IOException ALMT0wqk) {
			System.out.println(ALMT0wqk.getMessage());
		}
	}

}