class n17947247 {
	public String postURL(String rAzsoaof, ArrayList VcIbo1UL, String BxjRR8HB, HashMap vhZKYd0B, RenderEngine REwIpkOX)
			throws Exception {
		String m39Rg0CF = null;
		if (vhZKYd0B != null) {
			boolean nf3nXFxo = true;
			m39Rg0CF = new String();
			Iterator gleigB8I = vhZKYd0B.keySet().iterator();
			while (gleigB8I.hasNext()) {
				String G74V7nrj = (String) gleigB8I.next();
				String Ul3EJihE = (String) vhZKYd0B.get(G74V7nrj);
				if (nf3nXFxo) {
					m39Rg0CF += Encoder.URLEncode(G74V7nrj) + "=" + Encoder.URLEncode(Ul3EJihE);
					nf3nXFxo = false;
				} else {
					m39Rg0CF += "&" + Encoder.URLEncode(G74V7nrj) + "=" + Encoder.URLEncode(Ul3EJihE);
				}
			}
			gleigB8I = null;
		} else {
			m39Rg0CF = BxjRR8HB;
		}
		Debug.log("Connecting to URL '" + rAzsoaof + "', content '" + m39Rg0CF + "'");
		URL Efpx5ye3 = null;
		try {
			Efpx5ye3 = new URL(rAzsoaof);
		} catch (MalformedURLException c9JV3JGA) {
			Debug.log("Unable to retrieve URL '" + rAzsoaof + "': " + c9JV3JGA.getMessage());
			return null;
		}
		StringBuffer tDV8aVXC = new StringBuffer();
		HttpURLConnection Rpiqjssj = null;
		boolean YjIyx1d8 = false;
		try {
			Rpiqjssj = (HttpURLConnection) Efpx5ye3.openConnection();
			loadCookies(rAzsoaof, Rpiqjssj, REwIpkOX);
			if (VcIbo1UL != null) {
				for (int dijzru6X = 0; dijzru6X < VcIbo1UL.size(); dijzru6X++) {
					String s78KL58G = (String) VcIbo1UL.get(dijzru6X);
					String Uv3hw0pL = s78KL58G.substring(0, s78KL58G.indexOf(":"));
					String jv4UiejA = s78KL58G.substring(s78KL58G.indexOf(":") + 2);
					if (Uv3hw0pL != null && Uv3hw0pL.equalsIgnoreCase("content-length")) {
						YjIyx1d8 = true;
					}
					Debug.log("Adding new request header '" + Uv3hw0pL + "'='" + jv4UiejA + "'");
					Rpiqjssj.setRequestProperty(Uv3hw0pL, jv4UiejA);
				}
			}
			if (!YjIyx1d8) {
				Debug.log("Adding new request header 'Content-Length'='" + m39Rg0CF.length() + "'");
				Rpiqjssj.setRequestProperty("Content-Length", Integer.toString(m39Rg0CF.length()));
			}
			Rpiqjssj.setDoOutput(true);
			OutputStreamWriter JefxwmaN = new OutputStreamWriter(Rpiqjssj.getOutputStream());
			JefxwmaN.write(m39Rg0CF);
			JefxwmaN.flush();
			BufferedReader O9IJrtVN = new BufferedReader(new InputStreamReader(Rpiqjssj.getInputStream()));
			String i8ID1OU2 = null;
			while ((i8ID1OU2 = O9IJrtVN.readLine()) != null) {
				tDV8aVXC.append(i8ID1OU2);
				tDV8aVXC.append("\r\n");
			}
			handleHeaders(rAzsoaof, Rpiqjssj.getHeaderFields());
			JefxwmaN.close();
			O9IJrtVN.close();
			JefxwmaN = null;
			O9IJrtVN = null;
		} catch (IOException lovmCEw7) {
			if (Rpiqjssj != null) {
				tDV8aVXC = new StringBuffer();
				try {
					throw new Exception("Server returned error code '" + Rpiqjssj.getResponseCode() + "': "
							+ Rpiqjssj.getResponseMessage());
				} catch (IOException OW2cOARx) {
					throw new Exception("Unable to report error codes: " + OW2cOARx.getMessage());
				}
			}
			Debug.log("I/O Exception occurred while communicating with endpoint: " + lovmCEw7.getMessage());
			return tDV8aVXC.toString().trim();
		} catch (Exception it6qthXv) {
		}
		Efpx5ye3 = null;
		Rpiqjssj = null;
		return tDV8aVXC.toString().trim();
	}

}