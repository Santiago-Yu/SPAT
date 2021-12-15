class n17513478 {
	public void create(File target) {
		if ((type != null && type.equals("dir"))) {
			File dir = new File(target, name);
			dir.mkdirs();
			for (Resource c : children) {
				c.create(dir);
			}
		} else if ((type != null && type.equals("package"))) {
			String[] dirs = name.split("\\.");
			File parent = target;
			for (String d : dirs) {
				parent = new File(parent, d);
			}
			parent.mkdirs();
			for (Resource c : children) {
				c.create(parent);
			}
		} else if ((type != null && type.equals("file"))) {
			InputStream is = getInputStream();
			File file = new File(target, name);
			try {
				if (is != null) {
					FileOutputStream fos = new FileOutputStream(file);
					IOUtils.copy(is, fos);
					fos.flush();
					fos.close();
				} else {
					PrintStream ps = new PrintStream(file);
					ps.print(content);
					ps.flush();
					ps.close();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if ((type != null && type.equals("zip"))) {
			try {
				unzip(target);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException("unknown resource type: " + type);
		}
	}

}