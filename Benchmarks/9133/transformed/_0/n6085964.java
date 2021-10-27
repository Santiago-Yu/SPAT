class n6085964 {
	private static String readStreamToString(InputStream P1p9RtRh, boolean WZmNppL7, String aYBC9cdO,
			Map<String, Object> dGunRG1f) throws IOException {
		StringWriter b2gltXbk = new StringWriter();
		IOUtils.copy(P1p9RtRh, b2gltXbk, "UTF-8");
		if (WZmNppL7) {
			return tpl.formatStr(b2gltXbk.toString(), dGunRG1f, aYBC9cdO);
		}
		return b2gltXbk.toString();
	}

}