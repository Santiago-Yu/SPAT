class n3577905 {
	public static TestResponse post(String AhtVIqyI, byte[] GPjK6nff, String e44HUriT, String jSXGkWT2)
			throws IOException {
		HttpURLConnection spvrJAxQ = null;
		byte[] gu1z6mvO = null;
		byte[] x8WfNnJI = null;
		try {
			URL T0u5JhLd = new URL(AhtVIqyI);
			spvrJAxQ = (HttpURLConnection) T0u5JhLd.openConnection();
			spvrJAxQ.setDoOutput(true);
			spvrJAxQ.setRequestMethod("POST");
			spvrJAxQ.setRequestProperty("Content-Type", e44HUriT);
			spvrJAxQ.setRequestProperty("Accept", jSXGkWT2);
			if (GPjK6nff != null) {
				OutputStream EBo4n2uN = spvrJAxQ.getOutputStream();
				EBo4n2uN.write(GPjK6nff);
				EBo4n2uN.close();
			}
			BufferedInputStream Y8SWsYCc = new BufferedInputStream(spvrJAxQ.getInputStream());
			ByteArrayOutputStream zlAdNvSp = new ByteArrayOutputStream();
			int hJ4wC8Jp = Y8SWsYCc.read();
			while (hJ4wC8Jp > -1) {
				zlAdNvSp.write(hJ4wC8Jp);
				hJ4wC8Jp = Y8SWsYCc.read();
			}
			zlAdNvSp.flush();
			gu1z6mvO = zlAdNvSp.toByteArray();
			zlAdNvSp.close();
		} catch (IOException cBSVtHQo) {
			cBSVtHQo.printStackTrace();
		} finally {
			InputStream dAH3tgnO = spvrJAxQ.getErrorStream();
			if (dAH3tgnO != null) {
				BufferedInputStream M9OyJw34 = new BufferedInputStream(dAH3tgnO);
				ByteArrayOutputStream spDe4omj = new ByteArrayOutputStream();
				int BBrrcwj3 = M9OyJw34.read();
				while (BBrrcwj3 > -1) {
					spDe4omj.write(BBrrcwj3);
					BBrrcwj3 = M9OyJw34.read();
				}
				spDe4omj.flush();
				x8WfNnJI = spDe4omj.toByteArray();
				spDe4omj.close();
			}
			return new TestResponse(spvrJAxQ.getResponseCode(), x8WfNnJI, gu1z6mvO);
		}
	}

}