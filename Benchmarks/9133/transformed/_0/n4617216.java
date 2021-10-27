class n4617216 {
	public Object downloadObject()
			throws CommunicationException, FileNotFoundException, InvalidClassException, ClassNotFoundException {
		Object PwFvAEbH = null;
		String IbEtdncC = new String();
		HttpURLConnection KLJpnCWy = null;
		try {
			URL LicXY3dj = new URL(urlString);
			for (java.util.Iterator P4kxwwL4 = parameters.entrySet().iterator(); P4kxwwL4.hasNext();) {
				java.util.Map.Entry sWlfT58m = (java.util.Map.Entry) P4kxwwL4.next();
				IbEtdncC += URLEncoder.encode((String) sWlfT58m.getKey(), "UTF-8") + "="
						+ URLEncoder.encode((String) sWlfT58m.getValue(), "UTF-8") + "&";
			}
			KLJpnCWy = (HttpURLConnection) LicXY3dj.openConnection();
			KLJpnCWy.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			KLJpnCWy.setRequestMethod("POST");
			KLJpnCWy.setDoOutput(true);
			KLJpnCWy.setDoInput(true);
			KLJpnCWy.connect();
			PrintWriter FKdrauki = new PrintWriter(KLJpnCWy.getOutputStream());
			FKdrauki.println(IbEtdncC);
			FKdrauki.close();
			System.out.println("HTTPCommunication.downloadObject() - Response:" + KLJpnCWy.getResponseCode() + " : "
					+ KLJpnCWy.getResponseMessage());
			if (KLJpnCWy.getResponseCode() == KLJpnCWy.HTTP_OK) {
				GZIPInputStream wgsyMPsr = new GZIPInputStream(KLJpnCWy.getInputStream());
				ObjectInputStream qQantiA9 = new ObjectInputStream(wgsyMPsr);
				PwFvAEbH = qQantiA9.readObject();
				qQantiA9.close();
			} else if (KLJpnCWy.getResponseCode() == KLJpnCWy.HTTP_NOT_FOUND) {
				throw new FileNotFoundException(KLJpnCWy.getResponseMessage());
			} else {
				throw new CommunicationException(KLJpnCWy.getResponseMessage(), KLJpnCWy.getResponseCode());
			}
		} catch (java.net.ConnectException g88IZmbD) {
			throw new CommunicationException("Cannot connect to " + urlString + ".\n" + "Server is not responding!",
					g88IZmbD);
		} catch (java.net.MalformedURLException LFNTpMaD) {
			throw new CommunicationException("Cannot connect to " + urlString + ".\n" + "Bad url string!", LFNTpMaD);
		} catch (ClassNotFoundException IU9gnbDE) {
			throw IU9gnbDE;
		} catch (InvalidClassException ewbUn3HB) {
			throw ewbUn3HB;
		} catch (java.io.FileNotFoundException wklEQ71K) {
			throw wklEQ71K;
		} catch (java.io.InterruptedIOException m7n3lFQN) {
			this.parentWorkflow.getMenuButtonEventHandler().stopAutomaticRefresh();
			throw new CommunicationException("Communication is timeouted", m7n3lFQN);
		} catch (java.io.IOException zedgkQcn) {
			throw new CommunicationException("Error while trying to communicate the server: \n" + zedgkQcn.getMessage(),
					zedgkQcn);
		} finally {
			if (KLJpnCWy != null) {
				KLJpnCWy.disconnect();
			}
		}
		return PwFvAEbH;
	}

}