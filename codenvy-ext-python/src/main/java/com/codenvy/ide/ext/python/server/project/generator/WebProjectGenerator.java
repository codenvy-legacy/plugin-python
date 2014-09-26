/*******************************************************************************
 * Copyright (c) 2012-2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.ide.ext.python.server.project.generator;

import com.codenvy.api.core.ConflictException;
import com.codenvy.api.core.ForbiddenException;
import com.codenvy.api.core.ServerException;
import com.codenvy.api.project.server.FolderEntry;
import com.codenvy.api.project.server.ProjectGenerator;
import com.google.inject.Singleton;

import java.util.Map;

/** @author Vladyslav Zhukovskii */
@Singleton
public class WebProjectGenerator implements ProjectGenerator {

    private static final String MAIN_PY = "from flask import Flask\n" +
                                          "app = Flask(__name__)\n" +
                                          "\n" +
                                          "@app.route(\"/\")\n" +
                                          "def hello():\n" +
                                          "\treturn \"Hello World!\"\n" +
                                          "\n" +
                                          "if __name__ == \"__main__\":\n" +
                                          "\tapp.run(host='0.0.0.0', port=8080, debug=True)";

    private static final String REQUIREMENTS_TXT = "Flask==0.10";

    /** {@inheritDoc} */
    @Override
    public String getId() {
        return "python-web-simple";
    }

    /** {@inheritDoc} */
    @Override
    public void generateProject(FolderEntry baseFolder, Map<String, String> options)
            throws ForbiddenException, ConflictException, ServerException {
        baseFolder.createFile("main.py", MAIN_PY.getBytes(), "text/x-python");
        baseFolder.createFile("requirements.txt", REQUIREMENTS_TXT.getBytes(), "text/plain");
    }
}
