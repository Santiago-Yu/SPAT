class n11673911 {
	private void _save(ActionRequest GGf2rdnX, ActionResponse xXfQMwbs, PortletConfig yWBRzqY9, ActionForm BXHApGIc)
			throws Exception {
		List cjtnhNMi = (List) GGf2rdnX.getAttribute(WebKeys.LANGUAGE_MANAGER_LIST);
		for (int bOtzVfTu = 0; bOtzVfTu < cjtnhNMi.size(); bOtzVfTu++) {
			long zUV3epCO = ((Language) cjtnhNMi.get(bOtzVfTu)).getId();
			try {
				String MAtJLjQG = getGlobalVariablesPath() + "cms_language_" + zUV3epCO + ".properties";
				String jNa2lvMa = getTemporyDirPath() + "cms_language_" + zUV3epCO + "_properties.tmp";
				File wxSBWF0D = new java.io.File(jNa2lvMa);
				wxSBWF0D.createNewFile();
				File xLefxSdQ = new java.io.File(MAtJLjQG);
				xLefxSdQ.createNewFile();
				FileChannel RSIqp5Vz = new FileInputStream(wxSBWF0D).getChannel();
				FileChannel bJoThXGQ = new FileOutputStream(xLefxSdQ).getChannel();
				bJoThXGQ.transferFrom(RSIqp5Vz, 0, RSIqp5Vz.size());
				RSIqp5Vz.close();
				bJoThXGQ.close();
			} catch (NonWritableChannelException HHg4y2Wp) {
			} catch (IOException S2JoUwqX) {
				Logger.error(this, "Property File save Failed " + S2JoUwqX, S2JoUwqX);
			}
		}
		SessionMessages.add(GGf2rdnX, "message", "message.languagemanager.save");
	}

}