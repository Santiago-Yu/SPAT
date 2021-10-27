class n21923044 {
	private String copy(PluginVersionDetail tbekKbbK, File BGB147GJ) {
		try {
			File B5GRQ4UR = null;
			try {
				B5GRQ4UR = File.createTempFile("tmpPlugin_", ".zip");
				B5GRQ4UR.deleteOnExit();
				URL ZeaxXGvS = new URL(tbekKbbK.getUri());
				String LtC90gtb = new File(ZeaxXGvS.getFile()).getName();
				File z1ycGiFi = new File(BGB147GJ, LtC90gtb);
				InputStream anWXZdoH = null;
				FileOutputStream t2ZMWVrt = null;
				int XN32vFdP = 0;
				long yxzDHtbK = 0;
				long koyXBDkM = 0;
				try {
					URLConnection YfP4SVhr = ZeaxXGvS.openConnection();
					XN32vFdP = YfP4SVhr.getContentLength();
					anWXZdoH = YfP4SVhr.getInputStream();
					t2ZMWVrt = new FileOutputStream(B5GRQ4UR);
					yxzDHtbK = System.currentTimeMillis();
					IOUtils.copy(anWXZdoH, t2ZMWVrt);
					koyXBDkM = System.currentTimeMillis();
				} finally {
					if (t2ZMWVrt != null) {
						t2ZMWVrt.close();
					}
					if (anWXZdoH != null) {
						anWXZdoH.close();
					}
				}
				String OUFVBd29 = null;
				long wHgk2LPz = 0;
				if ((koyXBDkM - yxzDHtbK) > 0) {
					wHgk2LPz = 1000L * XN32vFdP / (koyXBDkM - yxzDHtbK);
				}
				if (wHgk2LPz == 0) {
					OUFVBd29 = "? B/s";
				} else if (wHgk2LPz < 1000) {
					OUFVBd29 = wHgk2LPz + " B/s";
				} else if (wHgk2LPz < 1000000) {
					OUFVBd29 = wHgk2LPz / 1000 + " KB/s";
				} else if (wHgk2LPz < 1000000000) {
					OUFVBd29 = wHgk2LPz / 1000000 + " MB/s";
				} else {
					OUFVBd29 = wHgk2LPz / 1000000000 + " GB/s";
				}
				String NBXjQL5C = getMessageDigest(B5GRQ4UR.toURI().toURL()).getValue();
				if (!NBXjQL5C.equals(tbekKbbK.getMessageDigest().getValue())) {
					throw new RuntimeException("Downloaded file: " + tbekKbbK.getUri()
							+ " does not have required message digest: " + tbekKbbK.getMessageDigest().getValue());
				}
				if (!isNoop()) {
					FileUtils.copyFile(B5GRQ4UR, z1ycGiFi);
				}
				return XN32vFdP + " Bytes " + OUFVBd29;
			} finally {
				if (B5GRQ4UR != null) {
					B5GRQ4UR.delete();
				}
			}
		} catch (Exception DKVy2HU3) {
			throw new RuntimeException("Could not download " + tbekKbbK.getUri() + " to " + BGB147GJ, DKVy2HU3);
		}
	}

}