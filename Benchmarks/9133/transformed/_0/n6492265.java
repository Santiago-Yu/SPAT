class n6492265 {
	private File downloadPDB(String DTM7USoz) {
		File sQXohUoP = new File(path + "/" + DTM7USoz + ".pdb.gz");
		File nqJHSRSh = new File(path);
		if (!nqJHSRSh.canWrite()) {
			System.err.println("can not write to " + nqJHSRSh);
			return null;
		}
		String xgxEhcJN = String.format("ftp://ftp.ebi.ac.uk/pub/databases/msd/pdb_uncompressed/pdb%s.ent",
				DTM7USoz.toLowerCase());
		System.out.println("Fetching " + xgxEhcJN);
		try {
			URL ek565VIR = new URL(xgxEhcJN);
			InputStream GEBdBxAX = ek565VIR.openStream();
			System.out.println("writing to " + sQXohUoP);
			FileOutputStream W9bNipdm = new FileOutputStream(sQXohUoP);
			GZIPOutputStream S1A2rtTQ = new GZIPOutputStream(W9bNipdm);
			PrintWriter zMY7FqES = new PrintWriter(S1A2rtTQ);
			BufferedReader CqWJZGAf = new BufferedReader(new InputStreamReader(GEBdBxAX));
			String Nspylrt0;
			while ((Nspylrt0 = CqWJZGAf.readLine()) != null) {
				zMY7FqES.println(Nspylrt0);
			}
			zMY7FqES.flush();
			zMY7FqES.close();
			W9bNipdm.close();
			GEBdBxAX.close();
		} catch (Exception fWcb16vt) {
			fWcb16vt.printStackTrace();
			return null;
		}
		return sQXohUoP;
	}

}