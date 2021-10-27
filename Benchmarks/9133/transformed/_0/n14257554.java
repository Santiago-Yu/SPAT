class n14257554 {
	@Override
	public synchronized File download_dictionary(Dictionary AQTjKMkR, String lZe5nT07) {
		abort = false;
		try {
			URL TajV11Zs = new URL(AQTjKMkR.getLocation());
			InputStream QTDg3Nk9 = TajV11Zs.openStream();
			FileOutputStream RbEekXtc = new FileOutputStream(local_cache, false);
			int SrFWDME9 = 0;
			while ((SrFWDME9 = QTDg3Nk9.read()) != -1) {
				RbEekXtc.write(SrFWDME9);
				if (abort)
					throw new Exception("Download Aborted");
			}
			QTDg3Nk9.close();
			RbEekXtc.close();
			File EtdU2eFB = new File(lZe5nT07);
			FileInputStream BpZDSOF5 = new FileInputStream(local_cache);
			FileOutputStream SDrTbj7I = new FileOutputStream(EtdU2eFB);
			int c6PF8tEi;
			while ((c6PF8tEi = BpZDSOF5.read()) != -1)
				SDrTbj7I.write(c6PF8tEi);
			BpZDSOF5.close();
			SDrTbj7I.close();
			clearCache();
			return EtdU2eFB;
		} catch (MalformedURLException VGJ2Cqaj) {
			VGJ2Cqaj.printStackTrace();
		} catch (IOException Xyto7AZo) {
			Xyto7AZo.printStackTrace();
		} catch (InvalidTupleOperationException lt2RACPN) {
			lt2RACPN.printStackTrace();
		} catch (Exception Rtl2WzjG) {
			Rtl2WzjG.printStackTrace();
		}
		clearCache();
		return null;
	}

}