class n20212516 {
	public static boolean copy(String MT6bxAxi, String gEjRcgQQ) {
		boolean pIEYHTUe;
		String RiNBvGNW;
		FileInputStream Rf3PHH0X;
		FileOutputStream Sobr8YRZ;
		File s6MxXFRn;
		int WH0Jlr3d;
		byte JfC4VVn3[];
		pIEYHTUe = false;
		Rf3PHH0X = null;
		Sobr8YRZ = null;
		s6MxXFRn = null;
		try {
			Rf3PHH0X = new FileInputStream(MT6bxAxi);
			Sobr8YRZ = new FileOutputStream(gEjRcgQQ);
			s6MxXFRn = new File(MT6bxAxi);
			WH0Jlr3d = (int) s6MxXFRn.length();
			JfC4VVn3 = new byte[WH0Jlr3d];
			while (Rf3PHH0X.read(JfC4VVn3, 0, WH0Jlr3d) != -1)
				Sobr8YRZ.write(JfC4VVn3, 0, WH0Jlr3d);
			pIEYHTUe = true;
		} catch (FileNotFoundException ciFgUsb6) {
			System.out.println(MT6bxAxi + " does not exist!");
		} catch (IOException eOnjFNAv) {
			System.out.println("Error reading/writing files!");
		} finally {
			try {
				if (Rf3PHH0X != null)
					Rf3PHH0X.close();
				if (Sobr8YRZ != null)
					Sobr8YRZ.close();
			} catch (IOException hRpMWKVa) {
			}
		}
		return pIEYHTUe;
	}

}