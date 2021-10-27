class n17452177 {
	public Object apply(Context UnboLAD4, Object AYj1Ghge) {
		Object dXfhstk1 = null;
		if (AYj1Ghge == null) {
			throw new NullArgument("Null argument to read().");
		}
		if (AYj1Ghge instanceof String) {
			String co4Fq5W6 = (String) AYj1Ghge;
			File lxGVupHl = new File(co4Fq5W6);
			if (!lxGVupHl.exists()) {
				throw new FileNotFound("File not found: " + co4Fq5W6);
			}
			if (!lxGVupHl.isFile()) {
				throw new BadArgument("Argument to read() is not a file: " + co4Fq5W6);
			}
			if (!lxGVupHl.canRead()) {
				throw new BadArgument("File cannot be read: " + co4Fq5W6);
			}
			try {
				StringBuffer RpVEJnCA = new StringBuffer();
				BufferedReader nJKQnse8 = new BufferedReader(new FileReader(lxGVupHl));
				String uQXPAV0R = System.getProperty("line.separator");
				String guFrxDLw = null;
				for (;;) {
					guFrxDLw = nJKQnse8.readLine();
					if (guFrxDLw == null) {
						break;
					}
					RpVEJnCA.append(guFrxDLw);
					RpVEJnCA.append(uQXPAV0R);
				}
				dXfhstk1 = RpVEJnCA.toString();
				nJKQnse8.close();
			} catch (Exception KLyG2en6) {
				throw new IOError("Error reading " + co4Fq5W6);
			}
		} else if (AYj1Ghge instanceof URL) {
			URL zjJJP36h = (URL) AYj1Ghge;
			try {
				StringBuffer iUuILsGy = new StringBuffer();
				InputStreamReader JDqIXxvI = new InputStreamReader(zjJJP36h.openStream());
				BufferedReader AfMNyq2j = new BufferedReader(JDqIXxvI);
				String rnbnPSb7 = System.getProperty("line.separator");
				String dA88l8L7 = null;
				for (;;) {
					dA88l8L7 = AfMNyq2j.readLine();
					if (dA88l8L7 == null) {
						break;
					}
					iUuILsGy.append(dA88l8L7);
					iUuILsGy.append(rnbnPSb7);
				}
				dXfhstk1 = iUuILsGy.toString();
				AfMNyq2j.close();
			} catch (Exception GuoaAqki) {
				throw new IOError("Error reading " + zjJJP36h);
			}
		} else {
			throw new BadArgument("Bad argument to read()");
		}
		return dXfhstk1;
	}

}