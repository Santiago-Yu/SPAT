class n5518199 {
	protected String loadPage(String k32Rn0yX) {
		try {
			URL jyTxu3X5 = new URL(k32Rn0yX);
			HttpURLConnection nlyB8uTZ = null;
			InputStream rpZmjFqO = null;
			try {
				nlyB8uTZ = (HttpURLConnection) jyTxu3X5.openConnection();
				int A1VkT0yV = nlyB8uTZ.getResponseCode();
				if (A1VkT0yV == HttpURLConnection.HTTP_ACCEPTED || A1VkT0yV == HttpURLConnection.HTTP_OK) {
					rpZmjFqO = nlyB8uTZ.getInputStream();
					String fPy4FENd = "";
					while (fPy4FENd.length() < MAX_PAGE_SIZE) {
						byte[] Bcio9aWh = new byte[2048];
						int H3RGEm66 = rpZmjFqO.read(Bcio9aWh);
						if (H3RGEm66 < 0) {
							break;
						}
						fPy4FENd += new String(Bcio9aWh, 0, H3RGEm66);
					}
					return (fPy4FENd);
				} else {
					informFailure("httpinvalidresponse", "" + A1VkT0yV);
					return (null);
				}
			} finally {
				try {
					if (rpZmjFqO != null) {
						rpZmjFqO.close();
					}
					if (nlyB8uTZ != null) {
						nlyB8uTZ.disconnect();
					}
				} catch (Throwable qCnuKAgu) {
					Debug.printStackTrace(qCnuKAgu);
				}
			}
		} catch (Throwable A7z4OyVE) {
			informFailure("httploadfail", A7z4OyVE.toString());
			return (null);
		}
	}

}