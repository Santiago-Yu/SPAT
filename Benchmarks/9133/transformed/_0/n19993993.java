class n19993993 {
	public static void copy(String v6gygkU2, String GWdzmSsq) throws IOException {
		File e8kZuOOf = new File(v6gygkU2);
		File voHejHVJ = new File(GWdzmSsq);
		if (!e8kZuOOf.exists())
			throw new IOException("FileCopy: " + "no such source file: " + v6gygkU2);
		if (!e8kZuOOf.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + v6gygkU2);
		if (!e8kZuOOf.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + v6gygkU2);
		if (voHejHVJ.isDirectory())
			voHejHVJ = new File(voHejHVJ, e8kZuOOf.getName());
		if (voHejHVJ.exists()) {
			if (!voHejHVJ.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + GWdzmSsq);
			System.out.print("Overwrite existing file " + voHejHVJ.getName() + "? (Y/N): ");
			System.out.flush();
			BufferedReader TCLZF5SJ = new BufferedReader(new InputStreamReader(System.in));
			String vQHePnrQ = TCLZF5SJ.readLine();
			if (!vQHePnrQ.equals("Y") && !vQHePnrQ.equals("y"))
				throw new IOException("FileCopy: " + "existing file was not overwritten.");
		} else {
			String WxPNHSNr = voHejHVJ.getParent();
			if (WxPNHSNr == null)
				WxPNHSNr = System.getProperty("user.dir");
			File cRgK6k9i = new File(WxPNHSNr);
			if (!cRgK6k9i.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + WxPNHSNr);
			if (cRgK6k9i.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + WxPNHSNr);
			if (!cRgK6k9i.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + WxPNHSNr);
		}
		FileInputStream WClqvkxb = null;
		FileOutputStream v1TqX4Bs = null;
		try {
			WClqvkxb = new FileInputStream(e8kZuOOf);
			v1TqX4Bs = new FileOutputStream(voHejHVJ);
			byte[] bVMSkote = new byte[4096];
			int QrEkdCRY;
			while ((QrEkdCRY = WClqvkxb.read(bVMSkote)) != -1)
				v1TqX4Bs.write(bVMSkote, 0, QrEkdCRY);
		} finally {
			if (WClqvkxb != null)
				try {
					WClqvkxb.close();
				} catch (IOException u2yFHM2V) {
					;
				}
			if (v1TqX4Bs != null)
				try {
					v1TqX4Bs.close();
				} catch (IOException IG1lzksq) {
					;
				}
		}
	}

}