class n16902397 {
	private void convertClasses(File o0h2WTwT, File zxGcRMxe)
			throws PostProcessingException, CodeCheckException, IOException {
		Stack YCKWU4w8 = new Stack();
		Stack KoFH4bz2 = new Stack();
		YCKWU4w8.push(o0h2WTwT);
		KoFH4bz2.push(zxGcRMxe);
		while (!YCKWU4w8.isEmpty()) {
			o0h2WTwT = (File) YCKWU4w8.pop();
			zxGcRMxe = (File) KoFH4bz2.pop();
			if (!zxGcRMxe.exists())
				zxGcRMxe.mkdirs();
			File[] LPGNobaz = o0h2WTwT.listFiles();
			for (int X0ApVTdh = 0; X0ApVTdh < LPGNobaz.length; X0ApVTdh++) {
				File gYq1mVAG = (File) LPGNobaz[X0ApVTdh];
				if (gYq1mVAG.isDirectory()) {
					YCKWU4w8.push(gYq1mVAG);
					KoFH4bz2.push(new File(zxGcRMxe, gYq1mVAG.getName()));
				} else if (gYq1mVAG.getName().endsWith(".class")) {
					ClassWriter upGggJZb = new ClassWriter();
					InputStream sZJB0SRi = new BufferedInputStream(new FileInputStream(gYq1mVAG));
					upGggJZb.readClass(sZJB0SRi);
					sZJB0SRi.close();
					if ((getStatusFlags(upGggJZb.getClassName(upGggJZb.getCurrentClassIndex())) & PP_PROCESSED) != 0) {
						ClassWriter[] vW67VpKQ = new ClassWriter[1];
						transformClass(upGggJZb, vW67VpKQ);
						File K21NzEnO = new File(zxGcRMxe, gYq1mVAG.getName());
						OutputStream VJod64PI = new BufferedOutputStream(new FileOutputStream(K21NzEnO));
						upGggJZb.writeClass(VJod64PI);
						VJod64PI.close();
						if (vW67VpKQ[0] != null) {
							String UPXAcw57 = vW67VpKQ[0].getClassName(vW67VpKQ[0].getCurrentClassIndex());
							UPXAcw57 = UPXAcw57.substring(UPXAcw57.lastIndexOf('.') + 1, UPXAcw57.length());
							K21NzEnO = new File(zxGcRMxe, UPXAcw57 + ".class");
							VJod64PI = new BufferedOutputStream(new FileOutputStream(K21NzEnO));
							vW67VpKQ[0].writeClass(VJod64PI);
							VJod64PI.close();
						}
					}
				}
			}
		}
	}

}