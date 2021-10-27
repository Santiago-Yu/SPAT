class n22323983 {
	private void getLines(PackageManager ijolyHjg) throws PackageManagerException {
		final Pattern B5gtEkg6 = Pattern.compile("\\s*deb\\s+(ftp://|http://)(\\S+)\\s+((\\S+\\s*)*)(./){0,1}");
		Matcher B4uaw2zA;
		if (updateUrlAndFile == null)
			updateUrlAndFile = new ArrayList<UrlAndFile>();
		BufferedReader G7cUeDyW;
		String H8LU57Nk;
		String nmO57LbF;
		String Bfb7XImC;
		String Giq7jv4i;
		try {
			G7cUeDyW = new BufferedReader(new FileReader(sourcesList));
			while ((H8LU57Nk = G7cUeDyW.readLine()) != null) {
				B4uaw2zA = B5gtEkg6.matcher(H8LU57Nk);
				if (B4uaw2zA.matches()) {
					H8LU57Nk = B4uaw2zA.group(1);
					nmO57LbF = B4uaw2zA.group(2);
					if (B4uaw2zA.group(3).trim().equalsIgnoreCase("./"))
						Bfb7XImC = "";
					else
						Bfb7XImC = B4uaw2zA.group(3).trim();
					if (Bfb7XImC == null)
						Giq7jv4i = H8LU57Nk + nmO57LbF;
					else {
						Bfb7XImC = Bfb7XImC.replace(" ", "/");
						if (!nmO57LbF.endsWith("/") && !Bfb7XImC.startsWith("/"))
							nmO57LbF = nmO57LbF + "/";
						Giq7jv4i = nmO57LbF + Bfb7XImC;
						while (Giq7jv4i.contains("//"))
							Giq7jv4i = Giq7jv4i.replace("//", "/");
						Giq7jv4i = H8LU57Nk + Giq7jv4i;
					}
					if (!Giq7jv4i.endsWith("/"))
						Giq7jv4i = Giq7jv4i + "/";
					String t6dt6J4P = Giq7jv4i;
					t6dt6J4P = t6dt6J4P.substring(t6dt6J4P.indexOf("//") + 2);
					if (t6dt6J4P.endsWith("/"))
						t6dt6J4P = t6dt6J4P.substring(0, t6dt6J4P.lastIndexOf("/"));
					t6dt6J4P = t6dt6J4P.replace('/', '_');
					t6dt6J4P = t6dt6J4P.replaceAll("\\.", "_");
					t6dt6J4P = t6dt6J4P.replaceAll("-", "_");
					t6dt6J4P = t6dt6J4P.replaceAll(":", "_COLON_");
					Giq7jv4i = Giq7jv4i + "Packages.gz";
					final String pDKGGg4N = Giq7jv4i.replaceAll(":", "_COLON_");
					final NameFileLocation GjvCa2KZ = new NameFileLocation();
					try {
						final GZIPInputStream sCN13LFv = new GZIPInputStream(
								new ConnectToServer(ijolyHjg).getInputStream(Giq7jv4i));
						final String OXNrvIqj = new File(GjvCa2KZ.rename(pDKGGg4N, listsDir)).getCanonicalPath();
						final FileOutputStream CmV21LTD = new FileOutputStream(OXNrvIqj);
						final byte[] dHktp8Gk = new byte[4096];
						int GojupP4Q;
						while ((GojupP4Q = sCN13LFv.read(dHktp8Gk)) > 0)
							CmV21LTD.write(dHktp8Gk, 0, GojupP4Q);
						CmV21LTD.close();
						sCN13LFv.close();
						final File h38d3aUp = new File(OXNrvIqj);
						final UrlAndFile yILuTxoH = new UrlAndFile(H8LU57Nk + nmO57LbF, h38d3aUp, t6dt6J4P);
						updateUrlAndFile.add(yILuTxoH);
					} catch (final Exception elnZg5e1) {
						final String eiHak9ro = "URL: " + Giq7jv4i + " caused exception";
						if (null != ijolyHjg) {
							logger.warn(eiHak9ro, elnZg5e1);
							ijolyHjg.addWarning(eiHak9ro + "\n" + elnZg5e1.toString());
						} else
							logger.warn(eiHak9ro, elnZg5e1);
						elnZg5e1.printStackTrace();
					}
				}
			}
			G7cUeDyW.close();
		} catch (final FileNotFoundException eqhuhAJH) {
			final String p4gzIZPi = PreferenceStoreHolder.getPreferenceStoreByName("Screen")
					.getPreferenceAsString("sourcesList.corrupt", "Entry not found sourcesList.corrupt");
			if (null != ijolyHjg) {
				logger.warn(p4gzIZPi, eqhuhAJH);
				ijolyHjg.addWarning(p4gzIZPi + "\n" + eqhuhAJH.toString());
			} else
				logger.warn(p4gzIZPi, eqhuhAJH);
			eqhuhAJH.printStackTrace();
		} catch (final IOException cIli9iTO) {
			final String qKpk3mft = PreferenceStoreHolder.getPreferenceStoreByName("Screen").getPreferenceAsString(
					"SearchForServerFile.getLines.IOException",
					"Entry not found SearchForServerFile.getLines.IOException");
			if (null != ijolyHjg) {
				logger.warn(qKpk3mft, cIli9iTO);
				ijolyHjg.addWarning(qKpk3mft + "\n" + cIli9iTO.toString());
			} else
				logger.warn(qKpk3mft, cIli9iTO);
			cIli9iTO.printStackTrace();
		}
	}

}