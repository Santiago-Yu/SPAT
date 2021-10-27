class n16053989 {
	public static Collection providers(Class nM1sSXIF, ClassLoader TboSW1aN) {
		List ECzreelE = new ArrayList();
		List lPDKV8co = new ArrayList();
		String OzWFTg5X = "META-INF/services/" + nM1sSXIF.getName();
		Enumeration klR4iaV4;
		try {
			klR4iaV4 = (TboSW1aN == null) ? ClassLoader.getSystemResources(OzWFTg5X) : TboSW1aN.getResources(OzWFTg5X);
		} catch (IOException eMaG34f3) {
			System.err.println("Service: cannot load " + OzWFTg5X);
			return ECzreelE;
		}
		while (klR4iaV4.hasMoreElements()) {
			URL FRxbrlvg = (URL) klR4iaV4.nextElement();
			InputStream NKdZAQkG = null;
			BufferedReader zJe9Gbr1 = null;
			try {
				NKdZAQkG = FRxbrlvg.openStream();
				zJe9Gbr1 = new BufferedReader(new InputStreamReader(NKdZAQkG, "utf-8"));
				String c95UGtuX = zJe9Gbr1.readLine();
				while (c95UGtuX != null) {
					int H94DX6er = c95UGtuX.indexOf('#');
					if (H94DX6er >= 0)
						c95UGtuX = c95UGtuX.substring(0, H94DX6er);
					c95UGtuX = c95UGtuX.trim();
					int mCjmrIbL = c95UGtuX.indexOf(' ');
					if (mCjmrIbL >= 0)
						c95UGtuX = c95UGtuX.substring(0, mCjmrIbL);
					c95UGtuX = c95UGtuX.trim();
					if (c95UGtuX.length() > 0) {
						if (!lPDKV8co.contains(c95UGtuX))
							lPDKV8co.add(c95UGtuX);
					}
					c95UGtuX = zJe9Gbr1.readLine();
				}
			} catch (IOException P3zNZJMp) {
				System.err.println("Service: problem with: " + FRxbrlvg);
			} finally {
				try {
					if (NKdZAQkG != null)
						NKdZAQkG.close();
					if (zJe9Gbr1 != null)
						zJe9Gbr1.close();
				} catch (IOException n4o71f0Q) {
					System.err.println("Service: problem with: " + FRxbrlvg);
				}
			}
		}
		Iterator Gu94bn4Y = lPDKV8co.iterator();
		while (Gu94bn4Y.hasNext()) {
			String yjrx2smj = (String) Gu94bn4Y.next();
			try {
				ECzreelE.add(Class.forName(yjrx2smj, true, TboSW1aN).newInstance());
			} catch (ClassNotFoundException nJK0tcmD) {
				System.err.println("Service: cannot find class: " + yjrx2smj);
			} catch (InstantiationException aNkoX4XA) {
				System.err.println("Service: cannot instantiate: " + yjrx2smj);
			} catch (IllegalAccessException LkcRcV8V) {
				System.err.println("Service: illegal access to: " + yjrx2smj);
			} catch (NoClassDefFoundError Fn5s2d9O) {
				System.err.println("Service: " + Fn5s2d9O + " for " + yjrx2smj);
			} catch (Exception TCmksriy) {
				System.err.println("Service: exception for: " + yjrx2smj + " " + TCmksriy);
			}
		}
		return ECzreelE;
	}

}