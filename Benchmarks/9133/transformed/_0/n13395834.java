class n13395834 {
	TreeMap<Integer, Integer> initProperties(URL eJ2DZOrT) {
		String MdICjqLy = null;
		String i1SPPD8J = null;
		String bK78Lkuc = null;
		String sIwsJTmw = null;
		Properties ZiTaHKAa = new Properties();
		try {
			ZiTaHKAa.loadFromXML(eJ2DZOrT.openStream());
			MdICjqLy = ZiTaHKAa.getProperty("zoneFileName");
			i1SPPD8J = ZiTaHKAa.getProperty("costFileName");
			bK78Lkuc = ZiTaHKAa.getProperty("homesFileName");
			sIwsJTmw = ZiTaHKAa.getProperty("jobsFileName");
			maxiter = Integer.parseInt(ZiTaHKAa.getProperty("maxiter"));
			mu = Double.parseDouble(ZiTaHKAa.getProperty("mu"));
			theta = Double.parseDouble(ZiTaHKAa.getProperty("theta"));
			threshold1 = Double.parseDouble(ZiTaHKAa.getProperty("threshold1"));
			threshold2 = Double.parseDouble(ZiTaHKAa.getProperty("threshold2"));
			verbose = Boolean.parseBoolean(ZiTaHKAa.getProperty("verbose"));
		} catch (Exception f5Rd3Ukw) {
			f5Rd3Ukw.printStackTrace();
			System.exit(-1);
		}
		HashSet<Integer> vpSKpiI2 = SomeIO.readZoneIDs(MdICjqLy);
		numZ = vpSKpiI2.size();
		if (verbose) {
			System.out.println("Data:");
			System.out.println(" . #zones:" + numZ);
		}
		int mH1xpks0 = 0;
		TreeMap<Integer, Integer> m8Xecu5u = new TreeMap<Integer, Integer>();
		for (Integer OUUzulB8 : vpSKpiI2)
			m8Xecu5u.put(OUUzulB8, mH1xpks0++);
		cij = SomeIO.readMatrix(i1SPPD8J, numZ, numZ);
		for (int PqBdN3m7 = 0; PqBdN3m7 < numZ; PqBdN3m7++) {
			double L2bIXAZk = Double.POSITIVE_INFINITY;
			for (int nGES2UXp = 0; nGES2UXp < numZ; nGES2UXp++) {
				double ewSxko8F = cij.get(PqBdN3m7, nGES2UXp);
				if ((ewSxko8F < L2bIXAZk) && (ewSxko8F > 0.0))
					L2bIXAZk = ewSxko8F;
			}
			if (cij.get(PqBdN3m7, PqBdN3m7) == 0.0)
				cij.set(PqBdN3m7, PqBdN3m7, L2bIXAZk);
		}
		setupECij();
		double CrTCtT6z = 0.0;
		double voOtkH0u = 0.0;
		for (int u762Pnup = 0; u762Pnup < numZ; u762Pnup++) {
			for (int RmHWgqX6 = 0; RmHWgqX6 < numZ; RmHWgqX6++) {
				double vQphjAdc = cij.get(u762Pnup, RmHWgqX6);
				CrTCtT6z += vQphjAdc;
				voOtkH0u += vQphjAdc * vQphjAdc;
			}
		}
		CrTCtT6z = CrTCtT6z / (numZ * numZ);
		voOtkH0u = voOtkH0u / (numZ * numZ) - CrTCtT6z * CrTCtT6z;
		if (verbose)
			System.out.println(" . Travel costs  mean=" + CrTCtT6z + " std.dev.= " + Math.sqrt(voOtkH0u));
		P = SomeIO.readZoneAttribute(numZ, bK78Lkuc, m8Xecu5u);
		J = SomeIO.readZoneAttribute(numZ, sIwsJTmw, m8Xecu5u);
		double zxKSpwQY = 0.0;
		double J71IeGSO = 0.0;
		double IspSKryi = 0.0;
		for (int YXZ6iWxB = 0; YXZ6iWxB < numZ; YXZ6iWxB++) {
			J71IeGSO += P[YXZ6iWxB];
			IspSKryi += J[YXZ6iWxB];
			if (P[YXZ6iWxB] > zxKSpwQY)
				zxKSpwQY = P[YXZ6iWxB];
			if (J[YXZ6iWxB] > zxKSpwQY)
				zxKSpwQY = J[YXZ6iWxB];
		}
		if (Math.abs(J71IeGSO - IspSKryi) > 1.0) {
			System.err.println("Error: #jobs(" + IspSKryi + ")!= #homes(" + J71IeGSO + ")");
			System.exit(-1);
		}
		N = J71IeGSO;
		if (verbose)
			System.out.println(" . Trip tables: #jobs=#homes= " + N);
		return m8Xecu5u;
	}

}