class n6341262 {
	public static Map getResources(String SGYVGUxd, String pzfjje9A, int ar45lu60, String KMKX7HCC) throws Exception {
		Hashtable MBEZOOXE = new Hashtable();
		if (!(KMKX7HCC.equalsIgnoreCase("http") || KMKX7HCC.equalsIgnoreCase("file")))
			throw new IllegalArgumentException("Unsupported protocol; supported is: file or http");
		URL uVyUgyjx = new URL(KMKX7HCC, InetAddress.getLocalHost().getHostName(), ar45lu60, SGYVGUxd);
		BufferedInputStream UXhzdU6E = new BufferedInputStream(uVyUgyjx.openStream());
		JarInputStream emPF5ORd = new JarInputStream(UXhzdU6E);
		ZipEntry jzx3g8Gp;
		int s557OpT1 = 0;
		Vector MdAQHLTH = new Vector();
		try {
			while ((jzx3g8Gp = emPF5ORd.getNextEntry()) != null) {
				Console.log(jzx3g8Gp.getName() + ", " + jzx3g8Gp.getSize() + "..." + jzx3g8Gp.toString());
				MBEZOOXE.put(jzx3g8Gp.getName(), new ZipEntry(jzx3g8Gp));
				MdAQHLTH.add(jzx3g8Gp);
			}
		} catch (IOException UtgQzNuh) {
			UtgQzNuh.printStackTrace();
		}
		ZipEntry WxnSi3gj = null;
		for (int lVFyHerH = 0; lVFyHerH < MdAQHLTH.size(); lVFyHerH++) {
			ZipEntry FPVqKdg6 = (ZipEntry) MdAQHLTH.elementAt(lVFyHerH);
			if (FPVqKdg6.getName().equals(pzfjje9A)) {
				WxnSi3gj = FPVqKdg6;
				break;
			}
		}
		s557OpT1 = (int) WxnSi3gj.getSize();
		Console.log("resource size=" + s557OpT1);
		byte[] oDodAJGu = new byte[s557OpT1];
		int opgOdbFJ = 0;
		int azaiXxYc = 0;
		while ((s557OpT1 - opgOdbFJ) > 0) {
			azaiXxYc = emPF5ORd.read(oDodAJGu);
			Console.log("chunk = " + azaiXxYc + ", rb=" + opgOdbFJ);
			if (azaiXxYc == -1) {
				break;
			}
			opgOdbFJ += azaiXxYc;
		}
		try {
			emPF5ORd.close();
			UXhzdU6E.close();
			uVyUgyjx = null;
		} catch (IOException fnWEkPBS) {
			Console.log("error closing jar " + fnWEkPBS.getMessage());
			fnWEkPBS.printStackTrace();
		}
		if (s557OpT1 != oDodAJGu.length)
			throw new Exception("Resource '" + pzfjje9A + "' has not been read correctly.");
		System.out.println("buf=" + oDodAJGu);
		MBEZOOXE.put(pzfjje9A, oDodAJGu);
		return MBEZOOXE;
	}

}