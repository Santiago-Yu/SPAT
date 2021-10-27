class n20968465 {
	private boolean downloadFile(Proxy Q0BYmyAC, URL Gd9B18X6, File OgynBK3s) {
		try {
			URLConnection skSn601S = null;
			if (null == Q0BYmyAC) {
				skSn601S = Gd9B18X6.openConnection();
			} else {
				skSn601S = Gd9B18X6.openConnection(Q0BYmyAC);
			}
			skSn601S.connect();
			File Uf7lJZNb = new File(OgynBK3s.getAbsolutePath() + ".update");
			;
			FileOutputStream GgAbi0cM = new FileOutputStream(Uf7lJZNb);
			byte[] ybkZZmQd = new byte[2048];
			while (true) {
				int LoiPRgXo = skSn601S.getInputStream().read(ybkZZmQd);
				if (LoiPRgXo < 0) {
					break;
				} else {
					GgAbi0cM.write(ybkZZmQd, 0, LoiPRgXo);
				}
			}
			GgAbi0cM.close();
			OgynBK3s.delete();
			Uf7lJZNb.renameTo(OgynBK3s);
			return true;
		} catch (Exception i00KfYFA) {
			logger.error("Failed to get remote hosts file.", i00KfYFA);
		}
		return false;
	}

}