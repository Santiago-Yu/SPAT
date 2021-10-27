class n73657 {
	public static void test(String ECRvnxXj[]) {
		int VIDXFrAn;
		int Ns66kk2g = 0;
		int NmOtc8we = 0;
		try {
			BufferedReader iQddeje9;
			URL bAOeQMmn;
			bAOeQMmn = new URL(ECRvnxXj[0]);
			URLConnection fyfuKCBd = bAOeQMmn.openConnection();
			NmOtc8we = fyfuKCBd.getContentLength();
			iQddeje9 = new BufferedReader(new InputStreamReader(fyfuKCBd.getInputStream()));
			System.out.println(bAOeQMmn.toString());
			String Z494icbE;
			VIDXFrAn = t2pNewTrace();
			while ((Z494icbE = iQddeje9.readLine()) != null) {
				Ns66kk2g = Ns66kk2g + Z494icbE.length() + 1;
				t2pProcessLine(VIDXFrAn, Z494icbE);
			}
			t2pHandleEventPairs(VIDXFrAn);
			t2pSort(VIDXFrAn, 0);
			t2pExportTrace(VIDXFrAn, new String("pngtest2.png"), 1000, 700, (float) 0, (float) 33);
			t2pExportTrace(VIDXFrAn, new String("pngtest3.png"), 1000, 700, (float) 2.3, (float) 2.44);
			System.out.println("Press any key to contiune read from stream !!!");
			System.out.println(t2pGetProcessName(VIDXFrAn, 0));
			System.in.read();
			fyfuKCBd = bAOeQMmn.openConnection();
			if (NmOtc8we != fyfuKCBd.getContentLength()) {
				fyfuKCBd = bAOeQMmn.openConnection();
				fyfuKCBd.setRequestProperty("Range", "bytes=" + Integer.toString(Ns66kk2g) + "-");
				System.out.println(Integer.toString(fyfuKCBd.getContentLength()));
				iQddeje9 = new BufferedReader(new InputStreamReader(fyfuKCBd.getInputStream()));
				while ((Z494icbE = iQddeje9.readLine()) != null) {
					System.out.println(Z494icbE);
					t2pProcessLine(VIDXFrAn, Z494icbE);
				}
			} else
				System.out.println("File not changed !");
			t2pDeleteTrace(VIDXFrAn);
		} catch (MalformedURLException rAxiYgQ0) {
			System.out.println("MalformedURLException !!!");
		} catch (IOException JV8Mdzee) {
			System.out.println("File not found " + ECRvnxXj[0]);
		}
		;
	}

}