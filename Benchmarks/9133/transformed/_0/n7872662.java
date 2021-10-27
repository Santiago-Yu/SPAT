class n7872662 {
	private static boolean prepareProbeFile(String cTJEl6S6, String cpa8ugBg) {
		try {
			File RmIjEq1k = new File(cTJEl6S6 + fSep + "probe.txt");
			FileChannel qGVtIH8w = new FileInputStream(RmIjEq1k).getChannel();
			BufferedReader bei2wEVd = new BufferedReader(new FileReader(RmIjEq1k));
			File BODWF6yi = new File(cTJEl6S6 + fSep + "SmartGRAPE" + fSep + cpa8ugBg);
			FileChannel mp00QJrE = new FileOutputStream(BODWF6yi, true).getChannel();
			boolean HEx6CvPE = true;
			short nvR8sdRu = 0;
			int xsCf3IQb = 0;
			while (HEx6CvPE) {
				String ZHVgKEZp = bei2wEVd.readLine();
				if (ZHVgKEZp != null) {
					if (ZHVgKEZp.indexOf(":") >= 0) {
						nvR8sdRu = new Short(ZHVgKEZp.substring(0, ZHVgKEZp.length() - 1)).shortValue();
					} else {
						xsCf3IQb = new Integer(ZHVgKEZp).intValue();
						ByteBuffer bMp2NHYS = ByteBuffer.allocate(6);
						bMp2NHYS.putShort(nvR8sdRu);
						bMp2NHYS.putInt(xsCf3IQb);
						bMp2NHYS.flip();
						mp00QJrE.write(bMp2NHYS);
					}
				} else
					HEx6CvPE = false;
			}
			bei2wEVd.close();
			mp00QJrE.close();
			return true;
		} catch (IOException Zeb9ATzw) {
			System.err.println(Zeb9ATzw);
			return false;
		}
	}

}