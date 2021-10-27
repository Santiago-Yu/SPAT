class n8046690 {
	private Object[] retrieveSecondURL(URL DeaNWQfs, RSLink klstH0WD) {
		klstH0WD.setStatus(RSLink.STATUS_WAITING);
		Object[] mT9Rv3D2 = new Object[2];
		HttpURLConnection y4Z4kL9x = null;
		BufferedReader meXGdytL = null;
		DataOutputStream zZpRakdy = null;
		Pattern JUcZuU08 = Pattern.compile("'<input.+checked.+type=\"radio\".+name=\"mirror\".+\\\\'.+\\\\'");
		Pattern GDPAMOY6 = Pattern.compile("\\\\'.+\\\\'");
		Pattern OTWC0B32 = Pattern.compile("var c=[0-9]+;");
		Pattern fOogB5e5 = Pattern.compile("[0-9]+");
		try {
			String EYefGhJc = null;
			String BCTNmiWR = null;
			Integer Xt1h5J3J = null;
			String ziNylTqI = URLEncoder.encode("dl.start", "UTF-8") + "=" + URLEncoder.encode("Free", "UTF-8");
			y4Z4kL9x = (HttpURLConnection) DeaNWQfs.openConnection();
			y4Z4kL9x.setRequestMethod("POST");
			y4Z4kL9x.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			y4Z4kL9x.setRequestProperty("Content-Length", "" + Integer.toString(ziNylTqI.getBytes().length));
			y4Z4kL9x.setRequestProperty("Content-Language", "en-US");
			y4Z4kL9x.setDoOutput(true);
			y4Z4kL9x.setDoInput(true);
			zZpRakdy = new DataOutputStream(y4Z4kL9x.getOutputStream());
			zZpRakdy.writeBytes(ziNylTqI);
			zZpRakdy.flush();
			meXGdytL = new BufferedReader(new InputStreamReader(y4Z4kL9x.getInputStream()));
			Matcher NHLI36Tj = null;
			while ((EYefGhJc = meXGdytL.readLine()) != null) {
				NHLI36Tj = JUcZuU08.matcher(EYefGhJc);
				if (NHLI36Tj.find()) {
					NHLI36Tj = GDPAMOY6.matcher(EYefGhJc);
					if (NHLI36Tj.find()) {
						BCTNmiWR = NHLI36Tj.group().substring(2, NHLI36Tj.group().length() - 2);
						mT9Rv3D2[0] = new URL(BCTNmiWR);
					}
				}
				NHLI36Tj = OTWC0B32.matcher(EYefGhJc);
				if (NHLI36Tj.find()) {
					NHLI36Tj = fOogB5e5.matcher(EYefGhJc);
					if (NHLI36Tj.find()) {
						Xt1h5J3J = new Integer(NHLI36Tj.group());
						mT9Rv3D2[1] = Xt1h5J3J;
					}
				}
			}
		} catch (IOException esrAKXGD) {
			log("I/O Exception!");
		} finally {
			try {
				if (zZpRakdy != null)
					zZpRakdy.close();
				if (meXGdytL != null)
					meXGdytL.close();
			} catch (IOException SP3raxBL) {
				JOptionPane.showMessageDialog(null, "Can not close some connections:\n" + SP3raxBL.getMessage(),
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
			if (y4Z4kL9x != null)
				y4Z4kL9x.disconnect();
			klstH0WD.setStatus(RSLink.STATUS_NOTHING);
			return mT9Rv3D2;
		}
	}

}