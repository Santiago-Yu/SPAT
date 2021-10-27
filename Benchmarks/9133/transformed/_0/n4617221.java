class n4617221 {
	public String postDownloadRequest(String dU2TIUjL) throws Exception {
		String fzVCUiIk = "";
		String jBWAjg7K = "";
		if (dU2TIUjL == null) {
			error = true;
			errorStr = errorStr.concat("No local target for: " + currentFile.getRelativePath() + "\n");
			return "";
		}
		try {
			for (java.util.Iterator vli8wutA = parameters.entrySet().iterator(); vli8wutA.hasNext();) {
				java.util.Map.Entry y6x02Vdk = (java.util.Map.Entry) vli8wutA.next();
				jBWAjg7K = jBWAjg7K + URLEncoder.encode((String) y6x02Vdk.getKey(), "UTF-8") + "="
						+ URLEncoder.encode((String) y6x02Vdk.getValue(), "UTF-8") + "&";
			}
			URL Wr62R4f5 = new URL(urlString);
			URLConnection IU4bYm5w = Wr62R4f5.openConnection();
			HttpURLConnection waKzjxvl = (HttpURLConnection) IU4bYm5w;
			waKzjxvl.setRequestProperty("Content-Length", String.valueOf(jBWAjg7K.length()));
			waKzjxvl.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			waKzjxvl.setRequestMethod("POST");
			waKzjxvl.setDoOutput(true);
			waKzjxvl.setDoInput(true);
			IU4bYm5w.connect();
			PrintWriter OyvRlugz = new PrintWriter(waKzjxvl.getOutputStream());
			OyvRlugz.println(jBWAjg7K);
			OyvRlugz.close();
			if (waKzjxvl.HTTP_NOT_FOUND == waKzjxvl.getResponseCode()) {
				error = true;
				errorStr = errorStr.concat("Cannot find file: " + currentFile.getRelativePath() + "\n");
				return fzVCUiIk;
			}
			String JfxYeDJW = new String(dU2TIUjL);
			File oaMORB2i = new File(JfxYeDJW);
			File YsxfXFPP = new File(oaMORB2i.getParent());
			YsxfXFPP.mkdirs();
			FileOutputStream RS2C5Llh = new FileOutputStream(oaMORB2i);
			try {
				InputStream B4kPyR8a = waKzjxvl.getInputStream();
				java.util.zip.GZIPInputStream RaXOFd29 = new java.util.zip.GZIPInputStream(
						new BufferedInputStream(B4kPyR8a));
				int BF7D5a5M;
				while ((BF7D5a5M = RaXOFd29.read()) != -1) {
					RS2C5Llh.write(BF7D5a5M);
				}
				if (RS2C5Llh.getChannel().size() > 0) {
					RS2C5Llh.getChannel().truncate(RS2C5Llh.getChannel().size() - 1);
				}
				fzVCUiIk = downloadDir + "/" + currentFile.getRelativePath();
				B4kPyR8a.close();
				RS2C5Llh.close();
				waKzjxvl.disconnect();
			} catch (IOException MzNcBbp2) {
				error = true;
				errorStr = errorStr.concat("Cannot find file: " + currentFile.getRelativePath() + "\n");
				return fzVCUiIk;
			}
		} catch (java.net.ConnectException Md412GBe) {
			error = true;
			finished = true;
			errorStr = "Cannot connect to: " + urlString;
		} catch (java.io.InterruptedIOException p8NGQFFT) {
			error = true;
			finished = true;
			errorStr = "Connection to Portal lost: communication is timeouted.";
			parentWorkflow.getMenuButtonEventHandler().stopAutomaticRefresh();
		} catch (java.net.MalformedURLException d6zGPa2B) {
			error = true;
			finished = true;
			errorStr = "Error in postDownloadRequest()";
		} catch (Exception ahU2ORaW) {
			ahU2ORaW.printStackTrace();
			error = true;
			finished = true;
			errorStr = "Error in Download: " + ahU2ORaW.getMessage();
		}
		return fzVCUiIk;
	}

}