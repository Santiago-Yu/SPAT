class n5269348 {
	public void generateHtmlPage(String EKd2sADe, String ahKPNM4h) {
		String VUTPSDnz = "";
		URL mZ3oFKA9 = null;
		URLConnection McBAZcU1 = null;
		try {
			mZ3oFKA9 = new URL(ahKPNM4h);
			McBAZcU1 = mZ3oFKA9.openConnection();
			InputStream qEfFGq4N = McBAZcU1.getInputStream();
			byte[] F3ydlvbb = new byte[1];
			Vector EjurATqt = new Vector();
			while (qEfFGq4N.read(F3ydlvbb) != -1) {
				EjurATqt.add(F3ydlvbb);
				F3ydlvbb = new byte[1];
			}
			byte[] QjKVV07t = new byte[EjurATqt.size()];
			for (int HJckJkqV = 0; HJckJkqV < EjurATqt.size(); HJckJkqV++)
				QjKVV07t[HJckJkqV] = ((byte[]) EjurATqt.get(HJckJkqV))[0];
			VUTPSDnz = new String(QjKVV07t, "GBK");
		} catch (Exception kAECeaEn) {
		}
		try {
			oaFileOperation WA3rxInb = new oaFileOperation();
			WA3rxInb.writeFile(VUTPSDnz, EKd2sADe, true);
			String kCC23S1d = ahKPNM4h.substring(0, ahKPNM4h.lastIndexOf("/") + 1);
			String F6HfRLl3 = ahKPNM4h.substring(ahKPNM4h.lastIndexOf("/") + 1);
			if (F6HfRLl3.indexOf(".jsp") > 0) {
				F6HfRLl3 = F6HfRLl3.substring(0, F6HfRLl3.indexOf(".jsp")) + "_1.jsp";
				mZ3oFKA9 = new URL(kCC23S1d + F6HfRLl3);
				mZ3oFKA9.openConnection();
			}
			intWriteFileCount++;
			intWriteFileCount = (intWriteFileCount > 100000) ? 0 : intWriteFileCount;
		} catch (Exception nd0UKKCW) {
		}
		McBAZcU1 = null;
	}

}