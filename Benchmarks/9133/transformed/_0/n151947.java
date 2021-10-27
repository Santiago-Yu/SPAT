class n151947 {
	public static void test(String n8ayi1RO[]) {
		int n9NWPoq7;
		int GdUulDu7 = 0;
		int zXbqguk2 = 0;
		try {
			BufferedReader EgFevMOK;
			URL oRALicly;
			oRALicly = new URL(n8ayi1RO[0]);
			URLConnection r24FDcqh = oRALicly.openConnection();
			zXbqguk2 = r24FDcqh.getContentLength();
			EgFevMOK = new BufferedReader(new InputStreamReader(r24FDcqh.getInputStream()));
			System.out.println(oRALicly.toString());
			String b4IzMigw;
			n9NWPoq7 = t2pNewTrace();
			while ((b4IzMigw = EgFevMOK.readLine()) != null) {
				GdUulDu7 = GdUulDu7 + b4IzMigw.length() + 1;
				t2pProcessLine(n9NWPoq7, b4IzMigw);
			}
			t2pHandleEventPairs(n9NWPoq7);
			t2pSort(n9NWPoq7, 0);
			t2pExportTrace(n9NWPoq7, new String("pngtest2.png"), 1000, 700, (float) 0, (float) 33);
			t2pExportTrace(n9NWPoq7, new String("pngtest3.png"), 1000, 700, (float) 2.3, (float) 2.44);
			System.out.println("Press any key to contiune read from stream !!!");
			System.out.println(t2pGetProcessName(n9NWPoq7, 0));
			System.in.read();
			r24FDcqh = oRALicly.openConnection();
			if (zXbqguk2 != r24FDcqh.getContentLength()) {
				r24FDcqh = oRALicly.openConnection();
				r24FDcqh.setRequestProperty("Range", "bytes=" + Integer.toString(GdUulDu7) + "-");
				System.out.println(Integer.toString(r24FDcqh.getContentLength()));
				EgFevMOK = new BufferedReader(new InputStreamReader(r24FDcqh.getInputStream()));
				while ((b4IzMigw = EgFevMOK.readLine()) != null) {
					System.out.println(b4IzMigw);
					t2pProcessLine(n9NWPoq7, b4IzMigw);
				}
			} else
				System.out.println("File not changed !");
			t2pDeleteTrace(n9NWPoq7);
		} catch (MalformedURLException iiqcs2DQ) {
			System.out.println("MalformedURLException !!!");
		} catch (IOException tHEqrcJW) {
			System.out.println("File not found " + n8ayi1RO[0]);
		}
		;
	}

}