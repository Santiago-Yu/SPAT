class n390730 {
	public static void test(String npamELEA[]) {
		int bYHTSpxD;
		int KQJ49O2K = 0;
		int VrJ4jobH = 0;
		try {
			BufferedReader oOabFowg;
			URL rRuxdTYZ;
			rRuxdTYZ = new URL(npamELEA[0]);
			URLConnection SIr5VsAF = rRuxdTYZ.openConnection();
			VrJ4jobH = SIr5VsAF.getContentLength();
			oOabFowg = new BufferedReader(new InputStreamReader(SIr5VsAF.getInputStream()));
			System.out.println(rRuxdTYZ.toString());
			String e9RfPap0;
			bYHTSpxD = t2pNewTrace();
			while ((e9RfPap0 = oOabFowg.readLine()) != null) {
				KQJ49O2K = KQJ49O2K + e9RfPap0.length() + 1;
				t2pProcessLine(bYHTSpxD, e9RfPap0);
			}
			t2pHandleEventPairs(bYHTSpxD);
			t2pSort(bYHTSpxD, 0);
			t2pExportTrace(bYHTSpxD, new String("pngtest2.png"), 1000, 700, (float) 0, (float) 33);
			t2pExportTrace(bYHTSpxD, new String("pngtest3.png"), 1000, 700, (float) 2.3, (float) 2.44);
			System.out.println("Press any key to contiune read from stream !!!");
			System.out.println(t2pGetProcessName(bYHTSpxD, 0));
			System.in.read();
			SIr5VsAF = rRuxdTYZ.openConnection();
			if (VrJ4jobH != SIr5VsAF.getContentLength()) {
				SIr5VsAF = rRuxdTYZ.openConnection();
				SIr5VsAF.setRequestProperty("Range", "bytes=" + Integer.toString(KQJ49O2K) + "-");
				System.out.println(Integer.toString(SIr5VsAF.getContentLength()));
				oOabFowg = new BufferedReader(new InputStreamReader(SIr5VsAF.getInputStream()));
				while ((e9RfPap0 = oOabFowg.readLine()) != null) {
					System.out.println(e9RfPap0);
					t2pProcessLine(bYHTSpxD, e9RfPap0);
				}
			} else
				System.out.println("File not changed !");
			t2pDeleteTrace(bYHTSpxD);
		} catch (MalformedURLException LkHRrFPo) {
			System.out.println("MalformedURLException !!!");
		} catch (IOException F10LcANd) {
			System.out.println("File not found " + npamELEA[0]);
		}
		;
	}

}