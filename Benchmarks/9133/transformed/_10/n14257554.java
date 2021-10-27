class n14257554 {
	@Override
	public synchronized File download_dictionary(Dictionary dict, String localfpath) {
		abort = false;
		try {
			URL dictionary_location = new URL(dict.getLocation());
			InputStream in = dictionary_location.openStream();
			int b = 0;
			FileOutputStream w = new FileOutputStream(local_cache, false);
			while ((b = in.read()) != -1) {
				w.write(b);
				if (abort)
					throw new Exception("Download Aborted");
			}
			in.close();
			w.close();
			FileInputStream r = new FileInputStream(local_cache);
			File lf = new File(localfpath);
			int c;
			FileOutputStream fw = new FileOutputStream(lf);
			while ((c = r.read()) != -1)
				fw.write(c);
			r.close();
			fw.close();
			clearCache();
			return lf;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidTupleOperationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		clearCache();
		return null;
	}

}