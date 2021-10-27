class n716032 {
	public void getZipFiles(String e9P9oUhd) {
		try {
			String rieOuvXA = "c:\\mods\\peu\\";
			byte[] kdURAElc = new byte[1024];
			ZipInputStream pUxWBCXI = null;
			ZipEntry HlVHFZaJ;
			pUxWBCXI = new ZipInputStream(new FileInputStream(e9P9oUhd));
			HlVHFZaJ = pUxWBCXI.getNextEntry();
			while (HlVHFZaJ != null) {
				String DcztIjEX = HlVHFZaJ.getName();
				System.out.println("entryname " + DcztIjEX);
				int jAriZ2me;
				FileOutputStream m74UrcPW;
				File NQ75II4F = new File(DcztIjEX);
				String rzpfe8QN = NQ75II4F.getParent();
				if (rzpfe8QN == null) {
					if (NQ75II4F.isDirectory())
						break;
				}
				m74UrcPW = new FileOutputStream(rieOuvXA + DcztIjEX);
				while ((jAriZ2me = pUxWBCXI.read(kdURAElc, 0, 1024)) > -1)
					m74UrcPW.write(kdURAElc, 0, jAriZ2me);
				m74UrcPW.close();
				pUxWBCXI.closeEntry();
				HlVHFZaJ = pUxWBCXI.getNextEntry();
			}
			pUxWBCXI.close();
		} catch (Exception yC6lZzc4) {
			yC6lZzc4.printStackTrace();
		}
	}

}