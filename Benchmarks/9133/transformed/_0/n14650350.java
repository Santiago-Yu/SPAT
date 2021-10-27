class n14650350 {
	private boolean adjust(String sPf9GJVO) throws LastFMError {
		try {
			URL eRstElUo = new URL("http://" + mBaseURL + "/adjust.php?session=" + mSession + "&url="
					+ URLEncoder.encode(sPf9GJVO, "UTF-8"));
			HttpURLConnection VtNODmFx = (HttpURLConnection) eRstElUo.openConnection();
			VtNODmFx.connect();
			InputStream ed06ysLZ = VtNODmFx.getInputStream();
			InputStreamReader x7A5j69d = new InputStreamReader(ed06ysLZ);
			BufferedReader LlvuCLAI = new BufferedReader(x7A5j69d);
			Utils.OptionsParser cx9WgPfw = new Utils.OptionsParser(LlvuCLAI);
			if (!cx9WgPfw.parse())
				cx9WgPfw = null;
			LlvuCLAI.close();
			if ("OK".equals(cx9WgPfw.get("response"))) {
				return true;
			} else {
				Log.e(TAG, "Adjust failed: \"" + cx9WgPfw.get("response") + "\"");
				return false;
			}
		} catch (MalformedURLException KNADoYUp) {
			Log.e(TAG, "in adjust", KNADoYUp);
			throw new LastFMError("Adjust failed:" + KNADoYUp.toString());
		} catch (UnsupportedEncodingException vzOcK87h) {
			Log.e(TAG, "in adjust", vzOcK87h);
			throw new LastFMError("Adjust failed:" + vzOcK87h.toString());
		} catch (IOException sIRSuYZE) {
			Log.e(TAG, "in adjust", sIRSuYZE);
			throw new LastFMError("Station not found:" + sPf9GJVO);
		}
	}

}