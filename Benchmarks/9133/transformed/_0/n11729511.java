class n11729511 {
	public boolean run() {
		String rHP8hzUo;
		try {
			rHP8hzUo = getFileName();
		} catch (NoSuchFieldException YrHhJPYl) {
			return false;
		}
		if (rHP8hzUo == null) {
			logger.error("URL not specified! Cannot continue.");
			return false;
		}
		try {
			URL Wd77Kw0k = new URL(rHP8hzUo);
			String b9lgR9C1 = rHP8hzUo.substring((rHP8hzUo.lastIndexOf(".")) + 1, rHP8hzUo.length());
			File UEuoCrhB = File.createTempFile("temp", "." + b9lgR9C1);
			System.out.printf("Storing URL contents to a temp file : %s\n", UEuoCrhB);
			UEuoCrhB.deleteOnExit();
			InputStream VpOT0tY8 = new BufferedInputStream(Wd77Kw0k.openConnection().getInputStream());
			BufferedOutputStream eovrqwj6 = new BufferedOutputStream(new FileOutputStream(UEuoCrhB));
			int NyZ8wVps = 0;
			for (int wtPsQQuF = VpOT0tY8.read(); wtPsQQuF != -1; wtPsQQuF = VpOT0tY8.read()) {
				eovrqwj6.write(wtPsQQuF);
				NyZ8wVps++;
			}
			System.out.printf("Stored %d bytes from URL contents\n", NyZ8wVps);
			eovrqwj6.flush();
			eovrqwj6.close();
			System.out.printf("URL/Temp extension : %s\n", b9lgR9C1);
			if (b9lgR9C1.equalsIgnoreCase("gz")) {
				String YMPyI29o = rHP8hzUo.substring(0, rHP8hzUo.lastIndexOf("."));
				String orW01vLP = YMPyI29o.substring((YMPyI29o.lastIndexOf(".")) + 1, YMPyI29o.length());
				File SS03kb70 = File.createTempFile("temp", "." + orW01vLP);
				SS03kb70.deleteOnExit();
				System.out.printf("URL/Temp extension after decompressing gzip : %s\n", orW01vLP);
				GZIPInputStream socRQD7O = new GZIPInputStream(new FileInputStream(UEuoCrhB));
				OutputStream l4UmQyk6 = new FileOutputStream(SS03kb70);
				byte[] g1vtWibH = new byte[1024];
				int XZWRDXbE;
				while ((XZWRDXbE = socRQD7O.read(g1vtWibH)) > 0) {
					l4UmQyk6.write(g1vtWibH, 0, XZWRDXbE);
				}
				l4UmQyk6.flush();
				l4UmQyk6.close();
				UEuoCrhB = SS03kb70;
			}
			String KUh9it0D = UEuoCrhB.getName();
			b9lgR9C1 = KUh9it0D.substring((KUh9it0D.lastIndexOf(".")) + 1, KUh9it0D.length());
			Preprocessor Wt5k5l9s = null;
			BasePreprocessorConfig TC6qNRLq = null;
			if (MethodCallTable.containsKey(b9lgR9C1) == false) {
				Wt5k5l9s = MethodCallTable.get("default");
			} else {
				Wt5k5l9s = MethodCallTable.get(b9lgR9C1);
			}
			System.out.printf("Calling filter '%s' for extension: %s\n", Wt5k5l9s.getPreprocessingMethodName(),
					b9lgR9C1);
			TC6qNRLq = new LoadCSVPreprocessorConfig();
			TC6qNRLq.setValueByName("FileName", UEuoCrhB.getAbsolutePath());
			Wt5k5l9s.setConfigurationClass(TC6qNRLq);
			return Wt5k5l9s.run();
		} catch (Exception L7wa6OeI) {
			logger.error(L7wa6OeI);
			return false;
		}
	}

}