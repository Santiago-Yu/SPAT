class n15745420 {
	private void download(String biXsnPXd, String HWSDNipJ) throws UrlNotFoundException, Exception {
		String NA5wlWGg = G_File.getExtensao(biXsnPXd);
		if (NA5wlWGg.equals("jsp")) {
			throw new Exception("Erro ao baixar pagina JSP, tipo negado." + biXsnPXd);
		}
		File aBxxczRh = new File(HWSDNipJ + ".tmp");
		if (aBxxczRh.exists())
			aBxxczRh.delete();
		OutputStream zPG8RPgM = null;
		URLConnection j69lI1uD = null;
		InputStream q6siLJbB = null;
		try {
			try {
				URL u5ll5qba = new URL(biXsnPXd);
				j69lI1uD = u5ll5qba.openConnection();
				q6siLJbB = j69lI1uD.getInputStream();
			} catch (FileNotFoundException W3zwr3oc) {
				throw new UrlNotFoundException();
			}
			zPG8RPgM = new BufferedOutputStream(new FileOutputStream(aBxxczRh));
			byte[] K6bppV5w = new byte[1024];
			int yzcGVQaU;
			long zE1k0bd6 = 0;
			while ((yzcGVQaU = q6siLJbB.read(K6bppV5w)) != -1) {
				zPG8RPgM.write(K6bppV5w, 0, yzcGVQaU);
				zE1k0bd6 += yzcGVQaU;
			}
		} catch (UrlNotFoundException iJvi0jpg) {
			throw iJvi0jpg;
		} catch (Exception sWpPaXcQ) {
			throw sWpPaXcQ;
		} finally {
			try {
				if (q6siLJbB != null) {
					q6siLJbB.close();
				}
				if (zPG8RPgM != null) {
					zPG8RPgM.close();
				}
			} catch (IOException BWpZmN1r) {
			}
		}
		File f8tdoL2B = new File(HWSDNipJ);
		if (f8tdoL2B.exists()) {
			f8tdoL2B.delete();
		}
		f8tdoL2B = null;
		File O5VZsIe1 = new File(HWSDNipJ);
		aBxxczRh.renameTo(O5VZsIe1);
	}

}