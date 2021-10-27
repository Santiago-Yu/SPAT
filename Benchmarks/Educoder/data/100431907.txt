    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        InstanciaDelegate delegate = RegistroManager.recuperarInstancia(request);
        if (delegate == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(null, new ActionError("errors.session"));
            saveErrors(request, errors);
            return mapping.findForward("fail");
        }
        AyudaPantalla ayudaPantalla = delegate.obtenerAyudaPantalla();
        TraAyudaPantalla traAyudaPantalla = (TraAyudaPantalla) ayudaPantalla.getTraduccion();
        String urlSonido = traAyudaPantalla.getUrlSonido();
        if (urlSonido == null) {
            return null;
        }
        URL url = new URL(urlSonido);
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        String tipoMime = urlConnection.getContentType();
        log.debug("Tipo Mime: " + tipoMime);
        Map audioOptions = new HashMap();
        if (tipoMime.indexOf("audio") != -1 || tipoMime.indexOf("asf") != -1 || tipoMime.equals("unknown/unknown")) {
            audioOptions.put("id", "MediaPlayer");
            audioOptions.put("codeBase", "http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=6,4,7,1112");
            audioOptions.put("classId", "CLSID:22D6F312-B0F6-11D0-94AB-0080C74C7E95");
            audioOptions.put("mimeType", "application/x-mplayer2");
            audioOptions.put("urlSonido", urlSonido);
            audioOptions.put("pluginSpage", "http://www.microsoft.com/Windows/Downloads/Contents/Products/MediaPlayer/");
        } else if (tipoMime.indexOf("real") != -1) {
            audioOptions.put("id", "RVOCX");
            audioOptions.put("codeBase", "");
            audioOptions.put("classId", "clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA");
            audioOptions.put("mimeType", "audio/x-pn-realaudio-plugin");
            audioOptions.put("urlSonido", urlSonido);
            audioOptions.put("pluginSpage", "");
        }
        request.setAttribute("audioOptions", audioOptions);
        log.debug("entra success");
        return mapping.findForward("success");
    }
