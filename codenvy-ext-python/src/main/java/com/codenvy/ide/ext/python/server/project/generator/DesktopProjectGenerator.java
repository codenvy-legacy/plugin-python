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
public class DesktopProjectGenerator implements ProjectGenerator {

    private static final String HELLO_CONTENT = "print \"Hello, world!\"";

    /** {@inheritDoc} */
    @Override
    public String getId() {
        return "python-desktop-simple";
    }

    /** {@inheritDoc} */
    @Override
    public void generateProject(FolderEntry baseFolder, Map<String, String> options)
            throws ForbiddenException, ConflictException, ServerException {
        baseFolder.createFile("main.py", HELLO_CONTENT.getBytes(), "text/x-python");
    }
}
