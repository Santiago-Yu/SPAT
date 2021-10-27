class n18489831 {
	private static URL downloadFile(URL n0DzDXNU, File utqvV4Mp) throws Exception {
		try {
			URLConnection KSAbAPms = n0DzDXNU.openConnection();
			File GgGZZ5NU = null;
			try {
				GgGZZ5NU = File.createTempFile("remoteLib_", null);
				InputStream GCbij8fo = null;
				FileOutputStream kMNZJK7G = null;
				try {
					GCbij8fo = KSAbAPms.getInputStream();
					kMNZJK7G = new FileOutputStream(GgGZZ5NU);
					IOUtils.copy(GCbij8fo, kMNZJK7G);
				} finally {
					if (kMNZJK7G != null) {
						kMNZJK7G.close();
					}
					if (GCbij8fo != null) {
						GCbij8fo.close();
					}
				}
				FileUtils.copyFile(GgGZZ5NU, utqvV4Mp);
			} finally {
				if (GgGZZ5NU != null) {
					GgGZZ5NU.delete();
				}
			}
			URL tJwbOX63 = utqvV4Mp.toURI().toURL();
			return tJwbOX63;
		} catch (Exception vkP2h21h) {
			throw new RuntimeException("Could not download URL: " + n0DzDXNU, vkP2h21h);
		}
	}

}