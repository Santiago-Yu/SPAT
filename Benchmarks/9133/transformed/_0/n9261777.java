class n9261777 {
	public static void main(String[] UE6PCwtW) {
		String Pf14Muj2, BpGjUdcD;
		if (UE6PCwtW[0].toLowerCase().endsWith(".gz")) {
			Pf14Muj2 = UE6PCwtW[0];
			BpGjUdcD = Pf14Muj2.substring(0, Pf14Muj2.length() - 3);
		} else {
			Pf14Muj2 = UE6PCwtW[0] + ".gz";
			BpGjUdcD = UE6PCwtW[0];
		}
		InputStream HQRAT655 = null;
		OutputStream JLJGtIPg = null;
		try {
			HQRAT655 = new GZIPInputStream(new FileInputStream(Pf14Muj2));
			JLJGtIPg = new FileOutputStream(BpGjUdcD);
			byte[] Ja6JtgGp = new byte[8192];
			for (int nBBbOVib; (nBBbOVib = HQRAT655.read(Ja6JtgGp)) != -1;)
				JLJGtIPg.write(Ja6JtgGp, 0, nBBbOVib);
		} catch (IOException aF3iv0gQ) {
			System.err.println("Fehler: Kann nicht entpacken " + UE6PCwtW[0]);
		} finally {
			if (JLJGtIPg != null)
				try {
					JLJGtIPg.close();
				} catch (IOException VOmk2PJG) {
				}
			if (HQRAT655 != null)
				try {
					HQRAT655.close();
				} catch (IOException Ir0Ha6Gv) {
				}
		}
	}

}