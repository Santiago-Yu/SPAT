class n80378 {
	public static void test(String uT3X0772[]) {
		int HFUS5Ta7;
		int wjhYofUb = 0;
		int EbhpQhIv = 0;
		try {
			BufferedReader YvZhNpDX;
			URL SpilCNEf;
			SpilCNEf = new URL(uT3X0772[0]);
			URLConnection dhPA6Ejn = SpilCNEf.openConnection();
			EbhpQhIv = dhPA6Ejn.getContentLength();
			YvZhNpDX = new BufferedReader(new InputStreamReader(dhPA6Ejn.getInputStream()));
			System.out.println(SpilCNEf.toString());
			String vZ0DVTyJ;
			HFUS5Ta7 = t2pNewTrace();
			while ((vZ0DVTyJ = YvZhNpDX.readLine()) != null) {
				wjhYofUb = wjhYofUb + vZ0DVTyJ.length() + 1;
				t2pProcessLine(HFUS5Ta7, vZ0DVTyJ);
			}
			t2pHandleEventPairs(HFUS5Ta7);
			t2pSort(HFUS5Ta7, 0);
			t2pExportTrace(HFUS5Ta7, new String("pngtest2.png"), 1000, 700, (float) 0, (float) 33);
			t2pExportTrace(HFUS5Ta7, new String("pngtest3.png"), 1000, 700, (float) 2.3, (float) 2.44);
			System.out.println("Press any key to contiune read from stream !!!");
			System.out.println(t2pGetProcessName(HFUS5Ta7, 0));
			System.in.read();
			dhPA6Ejn = SpilCNEf.openConnection();
			if (EbhpQhIv != dhPA6Ejn.getContentLength()) {
				dhPA6Ejn = SpilCNEf.openConnection();
				dhPA6Ejn.setRequestProperty("Range", "bytes=" + Integer.toString(wjhYofUb) + "-");
				System.out.println(Integer.toString(dhPA6Ejn.getContentLength()));
				YvZhNpDX = new BufferedReader(new InputStreamReader(dhPA6Ejn.getInputStream()));
				while ((vZ0DVTyJ = YvZhNpDX.readLine()) != null) {
					System.out.println(vZ0DVTyJ);
					t2pProcessLine(HFUS5Ta7, vZ0DVTyJ);
				}
			} else
				System.out.println("File not changed !");
			t2pDeleteTrace(HFUS5Ta7);
		} catch (MalformedURLException loZb8tB4) {
			System.out.println("MalformedURLException !!!");
		} catch (IOException JHaMt65L) {
			System.out.println("File not found " + uT3X0772[0]);
		}
		;
	}

}