class n11903969 {
	private ShaderProgram loadShaderProgram() {
		ShaderProgram sp = null;
		String vertexProgram = null;
		String fragmentProgram = null;
		Shader[] shaders = new Shader[2];
		try {
			ClassLoader cl = this.getClass().getClassLoader();
			URL url = cl.getResource("Shaders/simple.vert");
			System.out.println("url " + url);
			InputStream inputSteam = cl.getResourceAsStream("Shaders/simple.vert");
			Reader reader = null;
			if (!(inputSteam != null)) {
				File file = new File("lib");
				URL url2 = new URL(
						"jar:file:" + file.getAbsolutePath() + "/j3d-vrml97-i3mainz.jar!/Shaders/simple.vert");
				InputStream inputSteam2 = url2.openStream();
				reader = new InputStreamReader(inputSteam2);
			} else {
				reader = new InputStreamReader(inputSteam);
			}
			char[] buffer = new char[10000];
			int len = reader.read(buffer);
			vertexProgram = new String(buffer);
			vertexProgram = vertexProgram.substring(0, len);
		} catch (Exception e) {
			System.err.println("could'nt load simple.vert");
			e.printStackTrace();
		}
		try {
			ClassLoader cl = this.getClass().getClassLoader();
			URL url = cl.getResource("Shaders/simple.frag");
			System.out.println("url " + url);
			InputStream inputSteam = cl.getResourceAsStream("Shaders/simple.frag");
			Reader reader = null;
			if (!(inputSteam != null)) {
				File file = new File("lib");
				URL url2 = new URL(
						"jar:file:" + file.getAbsolutePath() + "/j3d-vrml97-i3mainz.jar!/Shaders/simple.frag");
				InputStream inputSteam2 = url2.openStream();
				reader = new InputStreamReader(inputSteam2);
			} else {
				reader = new InputStreamReader(inputSteam);
			}
			char[] buffer = new char[10000];
			int len = reader.read(buffer);
			fragmentProgram = new String(buffer);
			fragmentProgram = fragmentProgram.substring(0, len);
		} catch (Exception e) {
			System.err.println("could'nt load simple.frag");
			e.printStackTrace();
		}
		if (!(vertexProgram != null && fragmentProgram != null))
			;
		else {
			shaders[0] = new SourceCodeShader(Shader.SHADING_LANGUAGE_GLSL, Shader.SHADER_TYPE_VERTEX, vertexProgram);
			shaders[1] = new SourceCodeShader(Shader.SHADING_LANGUAGE_GLSL, Shader.SHADER_TYPE_FRAGMENT,
					fragmentProgram);
			sp = new GLSLShaderProgram();
			sp.setShaders(shaders);
		}
		return sp;
	}

}