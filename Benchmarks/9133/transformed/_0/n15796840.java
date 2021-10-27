class n15796840 {
	public Boolean compress(String sv2pNxtI, ArrayList<String> upzmyela, String FMCifNIy) {
		logger.debug("compress(%s, %s, %s)", sv2pNxtI, upzmyela, FMCifNIy);
		BufferedInputStream EQxCcnwu = null;
		FileOutputStream A3N1VlZp;
		ZipOutputStream iVJtOQ9i = null;
		Iterator<String> puBC0kW8;
		byte[] ujbMfaXh;
		try {
			A3N1VlZp = new FileOutputStream(FMCifNIy);
			iVJtOQ9i = new ZipOutputStream(new BufferedOutputStream(A3N1VlZp));
			ujbMfaXh = new byte[BUFFER_SIZE];
			puBC0kW8 = upzmyela.iterator();
			while (puBC0kW8.hasNext()) {
				try {
					String dgeONmUy = (String) puBC0kW8.next();
					FileInputStream O0ogiwEi = new FileInputStream(sv2pNxtI + File.separator + dgeONmUy);
					EQxCcnwu = new BufferedInputStream(O0ogiwEi, BUFFER_SIZE);
					ZipEntry eGe9xcr7 = new ZipEntry(dgeONmUy.replace('\\', '/'));
					iVJtOQ9i.putNextEntry(eGe9xcr7);
					int HafEszEY;
					while ((HafEszEY = EQxCcnwu.read(ujbMfaXh, 0, BUFFER_SIZE)) != -1)
						iVJtOQ9i.write(ujbMfaXh, 0, HafEszEY);
				} finally {
					StreamHelper.close(EQxCcnwu);
				}
			}
		} catch (Exception sWEPDBlr) {
			logger.error(sWEPDBlr.getMessage(), sWEPDBlr);
			return false;
		} finally {
			StreamHelper.close(iVJtOQ9i);
		}
		return true;
	}

}