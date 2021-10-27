class n13344859 {
	public static File copyFile(File cBKWdRji, File xLzPTBKK) {
		BufferedInputStream RRQajCeJ = null;
		BufferedOutputStream i3I5cArd = null;
		if (!xLzPTBKK.exists()) {
			try {
				xLzPTBKK.createNewFile();
			} catch (IOException nZh5nsxi) {
				ExceptionHandlingService.INSTANCE.handleException(nZh5nsxi);
				return null;
			}
		}
		try {
			RRQajCeJ = new BufferedInputStream(new FileInputStream(cBKWdRji), 4096);
			i3I5cArd = new BufferedOutputStream(new FileOutputStream(xLzPTBKK), 4096);
			int UTrpTaKf;
			while ((UTrpTaKf = RRQajCeJ.read()) != -1)
				i3I5cArd.write(UTrpTaKf);
			RRQajCeJ.close();
			i3I5cArd.close();
		} catch (FileNotFoundException tZfiJZXl) {
			ExceptionHandlingService.INSTANCE.handleException(tZfiJZXl);
			return null;
		} catch (IOException pXaY6uQg) {
			ExceptionHandlingService.INSTANCE.handleException(pXaY6uQg);
			return null;
		}
		return xLzPTBKK;
	}

}