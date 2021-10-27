class n833870 {
	public static void test(String D7OzHbZb[]) {
		int gUnpiqDr;
		int eHaTRP4b = 0;
		int kmIdr3Pa = 0;
		try {
			BufferedReader m3vaPBZc;
			URL uiZ2ZIDf;
			uiZ2ZIDf = new URL(D7OzHbZb[0]);
			URLConnection NXKEuPUf = uiZ2ZIDf.openConnection();
			kmIdr3Pa = NXKEuPUf.getContentLength();
			m3vaPBZc = new BufferedReader(new InputStreamReader(NXKEuPUf.getInputStream()));
			System.out.println(uiZ2ZIDf.toString());
			String dRBPz2aX;
			gUnpiqDr = t2pNewTrace();
			while ((dRBPz2aX = m3vaPBZc.readLine()) != null) {
				eHaTRP4b = eHaTRP4b + dRBPz2aX.length() + 1;
				t2pProcessLine(gUnpiqDr, dRBPz2aX);
			}
			t2pHandleEventPairs(gUnpiqDr);
			t2pSort(gUnpiqDr, 0);
			t2pExportTrace(gUnpiqDr, new String("pngtest2.png"), 1000, 700, (float) 0, (float) 33);
			t2pExportTrace(gUnpiqDr, new String("pngtest3.png"), 1000, 700, (float) 2.3, (float) 2.44);
			System.out.println("Press any key to contiune read from stream !!!");
			System.out.println(t2pGetProcessName(gUnpiqDr, 0));
			System.in.read();
			NXKEuPUf = uiZ2ZIDf.openConnection();
			if (kmIdr3Pa != NXKEuPUf.getContentLength()) {
				NXKEuPUf = uiZ2ZIDf.openConnection();
				NXKEuPUf.setRequestProperty("Range", "bytes=" + Integer.toString(eHaTRP4b) + "-");
				System.out.println(Integer.toString(NXKEuPUf.getContentLength()));
				m3vaPBZc = new BufferedReader(new InputStreamReader(NXKEuPUf.getInputStream()));
				while ((dRBPz2aX = m3vaPBZc.readLine()) != null) {
					System.out.println(dRBPz2aX);
					t2pProcessLine(gUnpiqDr, dRBPz2aX);
				}
			} else
				System.out.println("File not changed !");
			t2pDeleteTrace(gUnpiqDr);
		} catch (MalformedURLException onvupkdH) {
			System.out.println("MalformedURLException !!!");
		} catch (IOException gq6CsTdA) {
			System.out.println("File not found " + D7OzHbZb[0]);
		}
		;
	}

}