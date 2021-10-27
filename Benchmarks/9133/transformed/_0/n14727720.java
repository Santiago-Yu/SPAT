class n14727720 {
	private byte[] rawHttpPost(URL fQ49ggQb, Hashtable B01jFqbg, byte[] v3mfAaZo) {
		logger.info("[rawHttpPost.in]:: " + Arrays.asList(new Object[] { fQ49ggQb, B01jFqbg, v3mfAaZo }));
		URLConnection BvClRFX1;
		DataOutputStream M7z2DnDe;
		DataInputStream f4roT97J;
		byte[] G8Hs0EyE = null;
		try {
			BvClRFX1 = fQ49ggQb.openConnection();
			BvClRFX1.setDoInput(true);
			BvClRFX1.setDoOutput(true);
			BvClRFX1.setUseCaches(false);
			Iterator rVnkNoX7 = B01jFqbg.entrySet().iterator();
			while (rVnkNoX7.hasNext()) {
				Map.Entry IwikGGzy = (Map.Entry) rVnkNoX7.next();
				BvClRFX1.setRequestProperty((String) IwikGGzy.getKey(), (String) IwikGGzy.getValue());
			}
			logger.debug("POSTing to: " + fQ49ggQb + " ...");
			M7z2DnDe = new DataOutputStream(BvClRFX1.getOutputStream());
			M7z2DnDe.write(v3mfAaZo);
			M7z2DnDe.flush();
			M7z2DnDe.close();
			f4roT97J = new DataInputStream(BvClRFX1.getInputStream());
			byte[] rkuFLuU2 = new byte[1024];
			int MOCjKMn3 = 0;
			ByteArrayOutputStream fWWFlIuJ = new ByteArrayOutputStream();
			while ((MOCjKMn3 = f4roT97J.read(rkuFLuU2, 0, rkuFLuU2.length)) >= 0) {
				fWWFlIuJ.write(rkuFLuU2, 0, MOCjKMn3);
			}
			f4roT97J.close();
			G8Hs0EyE = fWWFlIuJ.toByteArray();
		} catch (MalformedURLException iCNWLLKT) {
			logger.warn("[rawHttpPost]:: ", iCNWLLKT);
		} catch (IOException jl8ArSO4) {
			logger.warn("[rawHttpPost]:: ", jl8ArSO4);
		}
		return G8Hs0EyE;
	}

}