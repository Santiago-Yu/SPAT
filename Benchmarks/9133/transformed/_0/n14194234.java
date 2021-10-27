class n14194234 {
	private String File2String(String anhBhgce, String c0F8STyC) {
		String UupM23Or;
		InputStream t4bDXbSn = null;
		try {
			File ot06VLfs = new File(c0F8STyC);
			System.out.println("File On:>>>>>>>>>> " + ot06VLfs.getCanonicalPath());
			t4bDXbSn = new FileInputStream(ot06VLfs);
		} catch (FileNotFoundException U51F2SUW) {
			t4bDXbSn = null;
		} catch (IOException ByvMDyAp) {
			t4bDXbSn = null;
		}
		try {
			if (t4bDXbSn == null) {
				c0F8STyC = anhBhgce + "/" + c0F8STyC;
				java.net.URL LuAFvsiS = ClassLoader.getSystemResource(c0F8STyC);
				if (LuAFvsiS == null) {
					System.out.println("Integrated Chips list file not found: " + c0F8STyC);
					System.exit(-1);
				}
				t4bDXbSn = LuAFvsiS.openStream();
			}
			BufferedReader jrmPWkEI = new BufferedReader(new InputStreamReader(t4bDXbSn));
			StringBuffer ChsIwFzK = new StringBuffer();
			while ((UupM23Or = jrmPWkEI.readLine()) != null) {
				ChsIwFzK.append(UupM23Or);
			}
			jrmPWkEI.close();
			return ChsIwFzK.toString();
		} catch (FileNotFoundException NzBRctyt) {
			System.out.println("Integrated Chips list file not found");
			System.exit(-1);
		} catch (IOException QA1haltS) {
			QA1haltS.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

}