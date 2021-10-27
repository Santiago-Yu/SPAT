class n8641070 {
	public static void main(String[] eihs2sOz) {
		String StNxGDve = "josh888@byu.net";
		String Fiu39IrJ = "josh8573";
		String WfGFGH8I = "josh8573";
		String cAXvAzdy = "3030";
		double[] bsgKNFUC = { 1000 };
		double[] llXYvJG6 = bsgKNFUC;
		double[] uljCuyTn = { 58.0 };
		int[] vQC0QoVK = { 0, 1, 2 };
		double[] awlRamc0 = { 0 };
		double[] PyCUPye3 = { 0 };
		double[] EDGL4Eg3 = { 0 };
		double[] V8rIkkbb = null;
		boolean[] woWjGTQc = { false, true };
		boolean aHpZz94R = true;
		boolean ZzeehKz0 = false;
		boolean vMLK9n0s = true;
		boolean TJOANI8o = false;
		boolean bso6Vpba = false;
		boolean FFwbrx5V = false;
		ORBIT[] KusV9sMW;
		KusV9sMW = ORBIT.CreateOrbits(bsgKNFUC, llXYvJG6, uljCuyTn, woWjGTQc, vQC0QoVK, awlRamc0, PyCUPye3, EDGL4Eg3,
				V8rIkkbb, aHpZz94R, ZzeehKz0, vMLK9n0s, TJOANI8o, bso6Vpba, FFwbrx5V);
		TRP[] ECQlSBoV = {};
		GTRN[] kCtHVZ3m = {};
		if (KusV9sMW != null) {
			Vector d3KuYF97 = new Vector();
			for (int f1F6uStm = 0; f1F6uStm < KusV9sMW.length; f1F6uStm++) {
				TRP OyOgD84p = KusV9sMW[f1F6uStm].getTRP();
				if (OyOgD84p != null) {
					d3KuYF97.add(OyOgD84p);
				}
			}
			if (d3KuYF97.size() != 0) {
				TRP[] GGjP6is3 = new TRP[d3KuYF97.size()];
				ECQlSBoV = (TRP[]) d3KuYF97.toArray(GGjP6is3);
			}
			Vector H1idy7eR = new Vector();
			for (int PAciXXOg = 0; PAciXXOg < KusV9sMW.length; PAciXXOg++) {
				GTRN y3Duf121 = KusV9sMW[PAciXXOg].getGTRN();
				if (y3Duf121 != null) {
					H1idy7eR.add(y3Duf121);
				}
			}
			if (H1idy7eR.size() != 0) {
				GTRN[] yAzi94x9 = new GTRN[H1idy7eR.size()];
				kCtHVZ3m = (GTRN[]) H1idy7eR.toArray(yAzi94x9);
			}
		}
		int[] ZzQaxQdm = { 1 };
		int[] ycuPwDpH = { 92 };
		int[] ASpMIfk5 = { 00, 01, 11, 12, 13 };
		boolean za5wzyNG = true;
		boolean uy4HJvx8 = false;
		boolean zMwmUuyr = false;
		ORBIT[] A7jvQLTU = KusV9sMW;
		FLUX[] h9cUzMnw;
		h9cUzMnw = FLUX.CreateFLUX_URF(ZzQaxQdm, ycuPwDpH, ASpMIfk5, A7jvQLTU, za5wzyNG, uy4HJvx8, zMwmUuyr);
		FLUX[] q6dtiBaP = h9cUzMnw;
		int[] DlQDDohq = { 1 };
		double[] lfj7v8kB = { 100 };
		boolean NkP3kV0V = false;
		TRANS[] cwnEalSE;
		cwnEalSE = TRANS.CreateTRANS_URF(q6dtiBaP, DlQDDohq, lfj7v8kB, NkP3kV0V);
		URFInterface[] sCjB5eYE = cwnEalSE;
		int[] gbvdxxQq = { 2 };
		int[] f5AMoBvL = { 0 };
		double[] VjlZMEWZ = { .1 };
		boolean[] jsaioEDN = { false };
		boolean Sd58rsiR = false;
		LETSPEC[] czjU3qYd;
		czjU3qYd = LETSPEC.CreateLETSPEC_URF(sCjB5eYE, gbvdxxQq, f5AMoBvL, VjlZMEWZ, jsaioEDN, Sd58rsiR);
		URFInterface[] HDACE8NZ = cwnEalSE;
		double[] Uk8BvtPt = { 20, 4, 0.5, .0153 };
		PUP_Device[][] EJpS2UOe = { { new PUP_Device("sample", null, null, 50648448, 4, Uk8BvtPt) } };
		boolean TsJ21zKP = false;
		boolean zFUlIoC9 = false;
		boolean CY4sdIVZ = false;
		boolean LiYKNF4h = false;
		boolean ffdZpKtH = false;
		PUP[] uWeWdvLN;
		uWeWdvLN = PUP.CreatePUP_URF(HDACE8NZ, EJpS2UOe, TsJ21zKP, zFUlIoC9, CY4sdIVZ, LiYKNF4h, ffdZpKtH);
		LETSPEC[] TdnARcfl = czjU3qYd;
		double[][] RFMZAwMu = { { 9.74, 30.25, 2.5, 22600 }, { 9.74, 30.25, 2.5, 2260 }, { 9.74, 30.25, 2.5, 226 },
				{ 9.74, 30.25, 2.5, 22.6 }, { 9.74, 30.25, 2.5, 2.26 }, { 9.74, 30.25, 2.5, .226 },
				{ 9.74, 30.25, 2.5, .0226 } };
		HUP_Device[][] qMife32a = new HUP_Device[7][1];
		double gXfcbuaq = (float) 0.01;
		for (int CzQYiRkM = 0; CzQYiRkM < 7; CzQYiRkM++) {
			qMife32a[CzQYiRkM][0] = new HUP_Device("sample", null, null, 0, 0, (Math.sqrt(RFMZAwMu[CzQYiRkM][3]) / 100),
					0, (int) Math.pow(10, CzQYiRkM), 4, RFMZAwMu[CzQYiRkM]);
			gXfcbuaq += .01;
		}
		boolean P14t3FVZ = false;
		boolean aDIkQKj9 = false;
		boolean tLNeeqB5 = false;
		boolean ddtK6H2w = false;
		boolean kHXYfIzV = false;
		boolean pNM1SuTH = false;
		boolean SAMTL7Ov = false;
		boolean Vd2jb9KX = true;
		boolean a3QRIvLe = false;
		boolean kWkaNyc2 = false;
		boolean YyPA2YOH = false;
		boolean OFmtLyHN = false;
		HUP[] nFKomQpL;
		nFKomQpL = HUP.CreateHUP_URF(TdnARcfl, qMife32a, P14t3FVZ, aDIkQKj9, tLNeeqB5, ddtK6H2w, kHXYfIzV, pNM1SuTH,
				SAMTL7Ov, Vd2jb9KX, a3QRIvLe, kWkaNyc2, YyPA2YOH, OFmtLyHN);
		System.out.println("Finished creating User Request Files");
		int GXj4DVnz = ECQlSBoV.length + kCtHVZ3m.length + h9cUzMnw.length + cwnEalSE.length + czjU3qYd.length
				+ uWeWdvLN.length + nFKomQpL.length;
		int euyewnYk = 0;
		String[] nwRQzzcu = new String[GXj4DVnz];
		for (int iLGCOEuC = 0; iLGCOEuC < ECQlSBoV.length; iLGCOEuC++) {
			nwRQzzcu[euyewnYk] = ECQlSBoV[iLGCOEuC].getThisFileName();
			euyewnYk++;
		}
		for (int vyQpyT5U = 0; vyQpyT5U < kCtHVZ3m.length; vyQpyT5U++) {
			nwRQzzcu[euyewnYk] = kCtHVZ3m[vyQpyT5U].getThisFileName();
			euyewnYk++;
		}
		for (int vlz43L9z = 0; vlz43L9z < h9cUzMnw.length; vlz43L9z++) {
			nwRQzzcu[euyewnYk] = h9cUzMnw[vlz43L9z].getThisFileName();
			euyewnYk++;
		}
		for (int ShdnTJae = 0; ShdnTJae < cwnEalSE.length; ShdnTJae++) {
			nwRQzzcu[euyewnYk] = cwnEalSE[ShdnTJae].getThisFileName();
			euyewnYk++;
		}
		for (int iCoa4wVq = 0; iCoa4wVq < czjU3qYd.length; iCoa4wVq++) {
			nwRQzzcu[euyewnYk] = czjU3qYd[iCoa4wVq].getThisFileName();
			euyewnYk++;
		}
		for (int WuF6Z48T = 0; WuF6Z48T < uWeWdvLN.length; WuF6Z48T++) {
			nwRQzzcu[euyewnYk] = uWeWdvLN[WuF6Z48T].getThisFileName();
			euyewnYk++;
		}
		for (int FHFGUejN = 0; FHFGUejN < nFKomQpL.length; FHFGUejN++) {
			nwRQzzcu[euyewnYk] = nFKomQpL[FHFGUejN].getThisFileName();
			euyewnYk++;
		}
		Logger etKS5NcR = Logger.getLogger(CreateAStudy.class);
		String intzcz7k = "creme96.nrl.navy.mil";
		String Y467k2UP = "anonymous";
		String bHqCGbwn = StNxGDve;
		Logger.setLevel(Level.ALL);
		FTPClient h3UR61Jh = null;
		try {
			h3UR61Jh = new FTPClient();
			h3UR61Jh.setRemoteHost(intzcz7k);
			FTPMessageCollector JUQCR5Ci = new FTPMessageCollector();
			h3UR61Jh.setMessageListener(JUQCR5Ci);
			etKS5NcR.info("Connecting");
			h3UR61Jh.connect();
			etKS5NcR.info("Logging in");
			h3UR61Jh.login(Y467k2UP, bHqCGbwn);
			etKS5NcR.debug("Setting up passive, ASCII transfers");
			h3UR61Jh.setConnectMode(FTPConnectMode.ACTIVE);
			h3UR61Jh.setType(FTPTransferType.BINARY);
			etKS5NcR.info("Putting file");
			for (int CnP86DlX = 0; CnP86DlX < nwRQzzcu.length; CnP86DlX++) {
				h3UR61Jh.put(nwRQzzcu[CnP86DlX], nwRQzzcu[CnP86DlX]);
			}
			etKS5NcR.info("Quitting client");
			h3UR61Jh.quit();
			etKS5NcR.debug("Listener log:");
			etKS5NcR.info("Test complete");
		} catch (Exception fCvJBWD8) {
			etKS5NcR.error("Demo failed", fCvJBWD8);
			fCvJBWD8.printStackTrace();
		}
		System.out.println("Finished FTPing User Request Files to common directory");
		Upload_Files.upload(nwRQzzcu, Fiu39IrJ, WfGFGH8I, cAXvAzdy);
		System.out.println("Finished transfering User Request Files to your CREME96 personal directory");
		RunRoutines.routines(nwRQzzcu, Fiu39IrJ, WfGFGH8I, cAXvAzdy);
		System.out.println("Finished running all of your uploaded routines");
	}

}