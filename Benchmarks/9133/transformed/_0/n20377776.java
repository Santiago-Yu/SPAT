class n20377776 {
	public static void assertEquals(String W6UPkian, Object T8DEMLsm) throws Exception {
		InputStreamReader CfrChDGX;
		try {
			CfrChDGX = new FileReader(W6UPkian);
		} catch (FileNotFoundException S6OKENQe) {
			URL Hfqzr4Sw = AssertHelper.class.getClassLoader().getResource(W6UPkian);
			if (null != Hfqzr4Sw) {
				try {
					CfrChDGX = new InputStreamReader(Hfqzr4Sw.openStream());
				} catch (Exception SnEjOhC9) {
					throw new AssertionFailedError("Unable to find output xml : " + W6UPkian);
				}
			} else {
				throw new AssertionFailedError("Could not read output xml : " + W6UPkian);
			}
		}
		DOMParser VDbO6PIy = new DOMParser();
		VDbO6PIy.parse(new InputSource(CfrChDGX));
		Document qzXERSpc = VDbO6PIy.getDocument();
		try {
			assertEqual(qzXERSpc.getDocumentElement(), T8DEMLsm);
		} catch (AssertionFailedError QZYViCuv) {
			String jqOzcBvR = null;
			if (null != QZYViCuv.getCause()) {
				jqOzcBvR = QZYViCuv.getCause().getMessage();
			} else {
				jqOzcBvR = QZYViCuv.getMessage();
			}
			StringBuffer r3TMSqgr = new StringBuffer(jqOzcBvR + " \n " + W6UPkian);
			Iterator eCXvqaxC = nodestack.iterator();
			while (eCXvqaxC.hasNext()) {
				r3TMSqgr.append(" -> " + ((Object[]) eCXvqaxC.next())[0]);
				eCXvqaxC.remove();
			}
			AssertionFailedError vWOClCTA = new AssertionFailedError(r3TMSqgr.toString());
			vWOClCTA.setStackTrace(QZYViCuv.getStackTrace());
			throw vWOClCTA;
		} catch (Exception bKRZISCs) {
			String vwNQCVFX = null;
			if (null != bKRZISCs.getCause()) {
				vwNQCVFX = bKRZISCs.getCause().getMessage();
			} else {
				vwNQCVFX = bKRZISCs.getMessage();
			}
			StringBuffer hTR9691w = new StringBuffer(vwNQCVFX + " \n " + W6UPkian);
			Iterator RG0wNBx8 = nodestack.iterator();
			while (RG0wNBx8.hasNext()) {
				hTR9691w.append(" -> " + ((Object[]) RG0wNBx8.next())[0]);
				RG0wNBx8.remove();
			}
			Exception E3nlUEXg = new Exception(hTR9691w.toString());
			E3nlUEXg.setStackTrace(bKRZISCs.getStackTrace());
			throw E3nlUEXg;
		}
	}

}