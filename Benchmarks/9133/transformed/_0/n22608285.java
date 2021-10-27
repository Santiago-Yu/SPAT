class n22608285 {
	private void dealWith(String Pseex3it) throws Exception {
		if (Pseex3it.startsWith("#") || (Pseex3it.length() == 0)) {
			return;
		}
		String czocAon3[];
		czocAon3 = StringUtil.split(Pseex3it, '\t');
		String WDbh4qJo = destDir + File.separator + czocAon3[0];
		boolean bto6dXaF = true;
		if (czocAon3.length == 2) {
			try {
				String kkJu6zWS = czocAon3[1];
				String O2lhuEpg = loadFileHash(destDir + File.separator + czocAon3[0]);
				if (O2lhuEpg != null) {
					if (kkJu6zWS.equalsIgnoreCase(O2lhuEpg)) {
						bto6dXaF = false;
					} else {
						if (verbose) {
							System.out.println(" -- " + czocAon3[0] + " has changed");
						}
					}
				}
			} catch (Exception CBwi07ZP) {
				CBwi07ZP.printStackTrace();
				System.out.println(CBwi07ZP.getMessage());
				System.exit(2);
			}
		}
		if (bto6dXaF) {
			int whP9B6jg = WDbh4qJo.lastIndexOf('/');
			if (whP9B6jg > 0) {
				String fEjTi4jj = WDbh4qJo.substring(0, whP9B6jg);
				File WMJz5XyN = new File(fEjTi4jj);
				WMJz5XyN.mkdirs();
			}
			FileOutputStream QSJxVN3g = new FileOutputStream(WDbh4qJo);
			byte ffWi9Cuc[] = new byte[1024];
			URLConnection pde05gaU = new URL(urlStr + "/" + czocAon3[0]).openConnection();
			InputStream RYlI0i9F = pde05gaU.getInputStream();
			boolean kpG7u02I = false;
			while (!kpG7u02I) {
				int KhyWNxD0 = RYlI0i9F.read(ffWi9Cuc, 0, 1024);
				if (KhyWNxD0 == -1) {
					kpG7u02I = true;
				} else {
					QSJxVN3g.write(ffWi9Cuc, 0, KhyWNxD0);
				}
			}
			QSJxVN3g.close();
			RYlI0i9F.close();
			if (verbose) {
				System.out.println(" -- Copied: " + czocAon3[0]);
			}
		}
	}

}