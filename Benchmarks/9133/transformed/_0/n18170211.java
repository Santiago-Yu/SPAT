class n18170211 {
	static List<String> readZipFilesOftypeToFolder(String amBWiGp2, String x0qkEGSa, String BLFZbJ8T) {
		List<String> nrnAWQmw = new ArrayList<String>();
		ZipFile VegrQxL0 = readZipFile(amBWiGp2);
		FileOutputStream MyvDcHfY = null;
		InputStream I0muHjJ0 = null;
		Enumeration<ZipEntry> wyiDkuAf = (Enumeration<ZipEntry>) VegrQxL0.entries();
		try {
			while (wyiDkuAf.hasMoreElements()) {
				java.util.zip.ZipEntry lbsqKSw7 = wyiDkuAf.nextElement();
				String wPt6EzUB = lbsqKSw7.getName();
				if (wPt6EzUB != null && wPt6EzUB.toLowerCase().endsWith(BLFZbJ8T)) {
					I0muHjJ0 = VegrQxL0.getInputStream(lbsqKSw7);
					String ig4kkVbi = x0qkEGSa + wPt6EzUB.substring(wPt6EzUB.lastIndexOf("/"));
					File yQCOoytT = new File(ig4kkVbi);
					MyvDcHfY = new FileOutputStream(yQCOoytT);
					IOUtils.copy(I0muHjJ0, MyvDcHfY);
					nrnAWQmw.add(ig4kkVbi);
				}
			}
		} catch (Exception ExaOXDIk) {
			throw new RuntimeException(ExaOXDIk);
		} finally {
			try {
				if (MyvDcHfY != null)
					MyvDcHfY.close();
				if (I0muHjJ0 != null)
					I0muHjJ0.close();
				if (VegrQxL0 != null)
					VegrQxL0.close();
			} catch (IOException tDONmBPs) {
				throw new RuntimeException(tDONmBPs);
			}
		}
		return nrnAWQmw;
	}

}