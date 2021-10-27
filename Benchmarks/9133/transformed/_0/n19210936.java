class n19210936 {
	private static void copierScriptChargement(File reG89TVm, String VRjPWEW5) {
		File fDic7ifz = new File(reG89TVm, "chargementInitial");
		File hsIw3PFZ = new File(fDic7ifz, "ScriptChargementInitial.sql");
		File FogWViOA = new File(fDic7ifz, "ScriptChargementInitial-All.sql");
		File CmHJ4JZN = new File(fDic7ifz, "ScriptChargementInitial-TypesDocument.sql");
		File p3RHsdHH = new File(fDic7ifz, "ScriptChargementInitial-Vide.sql");
		if (hsIw3PFZ.exists()) {
			hsIw3PFZ.delete();
		}
		File tc8M3FxU = null;
		if ("all".equals(VRjPWEW5)) {
			tc8M3FxU = FogWViOA;
		} else if ("typesDocument".equals(VRjPWEW5)) {
			tc8M3FxU = CmHJ4JZN;
		} else if ("empty".equals(VRjPWEW5)) {
			tc8M3FxU = p3RHsdHH;
		}
		if (tc8M3FxU != null && tc8M3FxU.exists()) {
			FileChannel VmZ9jxQC = null;
			FileChannel sX1SQzUb = null;
			try {
				VmZ9jxQC = new FileInputStream(tc8M3FxU).getChannel();
				sX1SQzUb = new FileOutputStream(hsIw3PFZ).getChannel();
				sX1SQzUb.transferFrom(VmZ9jxQC, 0, VmZ9jxQC.size());
			} catch (Exception SjFWtAjP) {
				throw new RuntimeException(SjFWtAjP);
			} finally {
				if (VmZ9jxQC != null) {
					try {
						VmZ9jxQC.close();
					} catch (Exception l9D7v0bV) {
						l9D7v0bV.printStackTrace();
					}
				}
				if (sX1SQzUb != null) {
					try {
						sX1SQzUb.close();
					} catch (Exception sUqobeDy) {
						sUqobeDy.printStackTrace();
					}
				}
			}
		}
	}

}