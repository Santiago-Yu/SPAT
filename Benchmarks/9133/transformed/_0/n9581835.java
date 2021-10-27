class n9581835 {
	public static void main(String[] gsB42LOP) {
		String gmZKINKU = null;
		String tdx1RfXb = null;
		String D8mszJvT = null;
		String hYE2Or14 = null;
		String u9YoTDsl = null;
		Manifest rNORrAfx;
		if (gsB42LOP.length == 0) {
			usage();
			return;
		}
		int qtw8OSDi = 0;
		while (qtw8OSDi < gsB42LOP.length && gsB42LOP[qtw8OSDi].startsWith("-")) {
			if (("-WTK".equals(gsB42LOP[qtw8OSDi])) && (qtw8OSDi < gsB42LOP.length - 1)) {
				qtw8OSDi++;
				gmZKINKU = gsB42LOP[qtw8OSDi];
			} else if (("-source".equals(gsB42LOP[qtw8OSDi])) && (qtw8OSDi < gsB42LOP.length - 1)) {
				qtw8OSDi++;
				tdx1RfXb = gsB42LOP[qtw8OSDi];
			} else if (("-instr".equals(gsB42LOP[qtw8OSDi])) && (qtw8OSDi < gsB42LOP.length - 1)) {
				qtw8OSDi++;
				D8mszJvT = gsB42LOP[qtw8OSDi];
			} else if (("-o".equals(gsB42LOP[qtw8OSDi])) && (qtw8OSDi < gsB42LOP.length - 1)) {
				qtw8OSDi++;
				hYE2Or14 = gsB42LOP[qtw8OSDi];
			} else if (("-jad".equals(gsB42LOP[qtw8OSDi])) && (qtw8OSDi < gsB42LOP.length - 1)) {
				qtw8OSDi++;
				u9YoTDsl = gsB42LOP[qtw8OSDi];
			} else {
				System.out.println("Error: Unrecognized option: " + gsB42LOP[qtw8OSDi]);
				System.exit(0);
			}
			qtw8OSDi++;
		}
		if (gmZKINKU == null || tdx1RfXb == null || D8mszJvT == null) {
			System.out.println("Error: Missing parameter!!!");
			usage();
			return;
		}
		if (hYE2Or14 == null)
			hYE2Or14 = tdx1RfXb;
		FileInputStream VfmerWhq;
		try {
			VfmerWhq = new FileInputStream(tdx1RfXb);
		} catch (FileNotFoundException TBhoUOFB) {
			System.out.println("Cannot find source jar file: " + tdx1RfXb);
			TBhoUOFB.printStackTrace();
			return;
		}
		FileOutputStream qKkbt88T;
		File QMlSdlsq = null;
		try {
			QMlSdlsq = File.createTempFile("predef", "aux");
			qKkbt88T = new FileOutputStream(QMlSdlsq);
		} catch (IOException nPQvGvsF) {
			System.out.println("Cannot find temporary jar file: " + QMlSdlsq);
			nPQvGvsF.printStackTrace();
			return;
		}
		JarFile lfMOob67 = null;
		Enumeration qQb9yrQt = null;
		File OkP2QPhD = null;
		try {
			lfMOob67 = new JarFile(D8mszJvT);
			qQb9yrQt = lfMOob67.entries();
			OkP2QPhD = File.createTempFile("jbtp", "");
			OkP2QPhD.delete();
			System.out.println("Create directory: " + OkP2QPhD.mkdirs());
			OkP2QPhD.deleteOnExit();
		} catch (IOException eTYnQgPR) {
			System.out.println("Cannot open instrumented file: " + D8mszJvT);
			eTYnQgPR.printStackTrace();
			return;
		}
		String[] hr3lYITR = new java.io.File(gmZKINKU + File.separator + "lib").list(new OnlyJar());
		String qXKEP78E = gmZKINKU + File.separator + "bin" + File.separator + "preverify -classpath " + gmZKINKU
				+ File.separator + "lib" + File.separator + CLDC_JAR + File.pathSeparator + gmZKINKU + File.separator
				+ "lib" + File.separator + MIDP_JAR + File.pathSeparator + gmZKINKU + File.separator + "lib"
				+ File.separator + WMA_JAR + File.pathSeparator + D8mszJvT;
		for (int EAKjAfva = 0; EAKjAfva < hr3lYITR.length; EAKjAfva++) {
			qXKEP78E += File.pathSeparator + gmZKINKU + File.separator + "lib" + hr3lYITR[EAKjAfva];
		}
		qXKEP78E += " " + "-d " + OkP2QPhD.getAbsolutePath() + " ";
		while (qQb9yrQt.hasMoreElements()) {
			JarEntry cdVmVWUC = (JarEntry) qQb9yrQt.nextElement();
			String MHM710Al = cdVmVWUC.getName();
			if (MHM710Al.endsWith(".class"))
				MHM710Al = MHM710Al.substring(0, MHM710Al.length() - 6);
			qXKEP78E += MHM710Al + " ";
		}
		try {
			Process NXR4t3Ld = Runtime.getRuntime().exec(qXKEP78E);
			if (NXR4t3Ld.waitFor() != 0) {
				BufferedReader nONJawNH = new BufferedReader(new InputStreamReader(NXR4t3Ld.getErrorStream()));
				System.out.println("Error calling the preverify command.");
				while (nONJawNH.ready()) {
					System.out.print("" + nONJawNH.readLine());
				}
				System.out.println();
				nONJawNH.close();
				return;
			}
		} catch (Exception ythYEfOU) {
			System.out.println("Cannot execute preverify command");
			ythYEfOU.printStackTrace();
			return;
		}
		File[] aPC9Oqcd = computeFiles(OkP2QPhD);
		System.out.println("-------------------------------\n" + "Files to insert: ");
		String[] P7qnMcVf = new String[aPC9Oqcd.length];
		int VXdhCm78 = OkP2QPhD.toString().length() + 1;
		for (int UFwhK7uG = 0; UFwhK7uG < aPC9Oqcd.length; UFwhK7uG++) {
			P7qnMcVf[UFwhK7uG] = aPC9Oqcd[UFwhK7uG].toString().substring(VXdhCm78);
			P7qnMcVf[UFwhK7uG] = P7qnMcVf[UFwhK7uG].replace(File.separatorChar, '/');
			System.out.println(P7qnMcVf[UFwhK7uG]);
		}
		System.out.println("-------------------------------");
		try {
			JarInputStream UjOTqlte = new JarInputStream(VfmerWhq);
			rNORrAfx = UjOTqlte.getManifest();
			JarOutputStream O43SN3n8 = new JarOutputStream(qKkbt88T, rNORrAfx);
			nextJar: for (JarEntry LMAL6OGf = UjOTqlte.getNextJarEntry(); LMAL6OGf != null; LMAL6OGf = UjOTqlte
					.getNextJarEntry()) {
				String DYNq4sno = LMAL6OGf.getName();
				for (int Xq8IneBO = 0; Xq8IneBO < P7qnMcVf.length; Xq8IneBO++) {
					if (P7qnMcVf[Xq8IneBO].equals(DYNq4sno))
						continue nextJar;
				}
				O43SN3n8.putNextEntry(LMAL6OGf);
				byte[] SUD1UMKy = new byte[512];
				for (int aWUmCECL = UjOTqlte.read(SUD1UMKy, 0, 512); aWUmCECL >= 0; aWUmCECL = UjOTqlte.read(SUD1UMKy,
						0, 512)) {
					O43SN3n8.write(SUD1UMKy, 0, aWUmCECL);
				}
			}
			UjOTqlte.close();
			for (int ngEO4XgA = 0; ngEO4XgA < P7qnMcVf.length; ngEO4XgA++) {
				FileInputStream c7JCkPy8 = new FileInputStream(aPC9Oqcd[ngEO4XgA]);
				JarEntry rsc1zB78 = new JarEntry(P7qnMcVf[ngEO4XgA]);
				O43SN3n8.putNextEntry(rsc1zB78);
				byte[] Oy1LLlJE = new byte[512];
				while (c7JCkPy8.available() > 0) {
					int Z7mB2v5x = c7JCkPy8.read(Oy1LLlJE, 0, 512);
					O43SN3n8.write(Oy1LLlJE, 0, Z7mB2v5x);
				}
				c7JCkPy8.close();
			}
			O43SN3n8.close();
			VfmerWhq.close();
			qKkbt88T.close();
		} catch (IOException gVTrOYOF) {
			System.out.println("Cannot read/write jar file.");
			gVTrOYOF.printStackTrace();
			return;
		}
		try {
			FileOutputStream n8ljuQqL = new FileOutputStream(hYE2Or14);
			FileInputStream QNfz5XQz = new FileInputStream(QMlSdlsq);
			byte[] QvEGmKVV = new byte[512];
			while (QNfz5XQz.available() > 0) {
				int ZPsUSfSZ = QNfz5XQz.read(QvEGmKVV, 0, 512);
				n8ljuQqL.write(QvEGmKVV, 0, ZPsUSfSZ);
			}
			QNfz5XQz.close();
			n8ljuQqL.close();
		} catch (IOException InJNluSD) {
			System.out.println("Cannot write output jar file: " + hYE2Or14);
			InJNluSD.printStackTrace();
		}
		Iterator MaVxTtg9;
		Attributes WweUPM2T;
		WweUPM2T = rNORrAfx.getMainAttributes();
		MaVxTtg9 = WweUPM2T.keySet().iterator();
		if (u9YoTDsl != null) {
			FileOutputStream pAXueuMn;
			try {
				File Xl8kurVa = new File(hYE2Or14);
				pAXueuMn = new FileOutputStream(u9YoTDsl);
				PrintStream YyUzsSt6 = new PrintStream(pAXueuMn);
				while (MaVxTtg9.hasNext()) {
					Object wPC18P5q = MaVxTtg9.next();
					YyUzsSt6.println(wPC18P5q + ": " + WweUPM2T.get(wPC18P5q));
				}
				YyUzsSt6.println("MIDlet-Jar-URL: " + hYE2Or14);
				YyUzsSt6.println("MIDlet-Jar-Size: " + Xl8kurVa.length());
				pAXueuMn.close();
			} catch (IOException dZEGiKDs) {
				System.out.println("Cannot create jad file.");
				dZEGiKDs.printStackTrace();
			}
		}
	}

}