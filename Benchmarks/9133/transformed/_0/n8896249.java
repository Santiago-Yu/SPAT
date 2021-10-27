class n8896249 {
	Response doSend() throws IOException {
		HttpURLConnection KolZy2Xv;
		String L35POH36 = this.headers.get("Authorization");
		if (L35POH36 != null) {
			String FhiNXBbU[] = L35POH36.split(",");
			if (FhiNXBbU[0].startsWith("OAuth ")) {
				FhiNXBbU[0] = FhiNXBbU[0].substring("OAuth ".length());
			}
			String tceqImVX = url + "?";
			for (int XWcoP6it = 0; XWcoP6it < FhiNXBbU.length; XWcoP6it++) {
				FhiNXBbU[XWcoP6it] = FhiNXBbU[XWcoP6it].trim().replace("\"", "");
				if (XWcoP6it == FhiNXBbU.length - 1) {
					tceqImVX += FhiNXBbU[XWcoP6it];
				} else {
					tceqImVX += FhiNXBbU[XWcoP6it] + "&";
				}
			}
			System.out.println("newUrl=" + tceqImVX);
			KolZy2Xv = (HttpURLConnection) new URL(tceqImVX).openConnection();
			KolZy2Xv.setRequestMethod(this.verb.name());
			if (verb.equals(Verb.PUT) || verb.equals(Verb.POST)) {
				addBody(KolZy2Xv, getBodyContents());
			}
			return new Response(KolZy2Xv);
		}
		KolZy2Xv = (HttpURLConnection) new URL(url).openConnection();
		KolZy2Xv.setRequestMethod(this.verb.name());
		addHeaders(KolZy2Xv);
		if (verb.equals(Verb.PUT) || verb.equals(Verb.POST)) {
			addBody(KolZy2Xv, getBodyContents());
		}
		return new Response(KolZy2Xv);
	}

}