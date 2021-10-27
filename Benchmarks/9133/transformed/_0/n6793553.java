class n6793553 {
	@SuppressWarnings("unchecked")
	public void handle(Map<String, Object> H7lwuoWt, String PadtcFB1) {
		try {
			URL WHU5kiCp = new URL(PadtcFB1);
			BufferedReader t8Usa3xH = new BufferedReader(new InputStreamReader(WHU5kiCp.openStream(), "utf-8"));
			String EnFeqLtr = null;
			CMGroup jihIPeFm = null;
			List<CMGroup> KX0XTXx9 = (List<CMGroup>) H7lwuoWt.get(CMConstants.GROUP);
			List<CMTag> XOopeMsR = (List<CMTag>) H7lwuoWt.get(CMConstants.TAG);
			List<CMTagGroup> P1QYad7i = (List<CMTagGroup>) H7lwuoWt.get(CMConstants.TAG_GROUP);
			while ((EnFeqLtr = t8Usa3xH.readLine()) != null) {
				CMGroup uxCeaHv1 = null;
				try {
					uxCeaHv1 = FetchUtil.getCMGroup(EnFeqLtr);
				} catch (Exception dN6WOnBR) {
					CMLog.getLogger(this).severe("getCMGroup error:" + EnFeqLtr);
				}
				if (uxCeaHv1 != null) {
					if (jihIPeFm != null) {
						KX0XTXx9.add(jihIPeFm);
					}
					jihIPeFm = uxCeaHv1;
				}
				CMTag C2Iji7vU = null;
				try {
					C2Iji7vU = FetchUtil.getCMTag(EnFeqLtr);
				} catch (Exception Z9kyJqxT) {
					CMLog.getLogger(this).severe("getCMTag error:" + EnFeqLtr);
				}
				if (C2Iji7vU != null) {
					CMTagGroup NHiy5WAR = new CMTagGroup();
					NHiy5WAR.setGroupName(jihIPeFm.getName());
					NHiy5WAR.setTagName(C2Iji7vU.getName());
					XOopeMsR.add(C2Iji7vU);
					P1QYad7i.add(NHiy5WAR);
				}
			}
			KX0XTXx9.add(jihIPeFm);
			t8Usa3xH.close();
		} catch (MalformedURLException ee2nmq5f) {
			CMLog.getLogger(this).severe("GTagHandler error:" + ee2nmq5f.getMessage());
			ee2nmq5f.printStackTrace();
		} catch (IOException xTyjJyzW) {
			CMLog.getLogger(this).severe("GTagHandler error:" + xTyjJyzW.getMessage());
			xTyjJyzW.printStackTrace();
		}
	}

}