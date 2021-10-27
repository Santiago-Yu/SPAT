class n7122523 {
	public ActionForward execute(ActionMapping MiErIOTt, ActionForm DQsEZ6OS, HttpServletRequest WPPKUXCo,
			HttpServletResponse n5Hh53xM) throws Exception {
		InstanciaDelegate S8zlHXTy = RegistroManager.recuperarInstancia(WPPKUXCo);
		if (S8zlHXTy == null) {
			ActionErrors F5bMKnyB = new ActionErrors();
			F5bMKnyB.add(null, new ActionError("errors.session"));
			saveErrors(WPPKUXCo, F5bMKnyB);
			return MiErIOTt.findForward("fail");
		}
		AyudaPantalla fRpc3JoY = S8zlHXTy.obtenerAyudaPantalla();
		TraAyudaPantalla DLi9S2YL = (TraAyudaPantalla) fRpc3JoY.getTraduccion();
		String DMG7qneC = DLi9S2YL.getUrlSonido();
		if (DMG7qneC == null) {
			return null;
		}
		URL DLBv2oI3 = new URL(DMG7qneC);
		URLConnection PAL5x7YF = DLBv2oI3.openConnection();
		PAL5x7YF.connect();
		String juKHAXO7 = PAL5x7YF.getContentType();
		log.debug("Tipo Mime: " + juKHAXO7);
		Map cNWDkUCv = new HashMap();
		if (juKHAXO7.indexOf("audio") != -1 || juKHAXO7.indexOf("asf") != -1 || juKHAXO7.equals("unknown/unknown")) {
			cNWDkUCv.put("id", "MediaPlayer");
			cNWDkUCv.put("codeBase",
					"http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=6,4,7,1112");
			cNWDkUCv.put("classId", "CLSID:22D6F312-B0F6-11D0-94AB-0080C74C7E95");
			cNWDkUCv.put("mimeType", "application/x-mplayer2");
			cNWDkUCv.put("urlSonido", DMG7qneC);
			cNWDkUCv.put("pluginSpage", "http://www.microsoft.com/Windows/Downloads/Contents/Products/MediaPlayer/");
		} else if (juKHAXO7.indexOf("real") != -1) {
			cNWDkUCv.put("id", "RVOCX");
			cNWDkUCv.put("codeBase", "");
			cNWDkUCv.put("classId", "clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA");
			cNWDkUCv.put("mimeType", "audio/x-pn-realaudio-plugin");
			cNWDkUCv.put("urlSonido", DMG7qneC);
			cNWDkUCv.put("pluginSpage", "");
		}
		WPPKUXCo.setAttribute("audioOptions", cNWDkUCv);
		log.debug("entra success");
		return MiErIOTt.findForward("success");
	}

}