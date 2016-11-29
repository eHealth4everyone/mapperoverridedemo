/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.module.mapperoverridedemo.overrideadminlogo;

// package org.openmrs.web;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ServletContextAware;
public class CopyLegacyUiContentToWebInf implements ServletContextAware {
	
	private static Log log = LogFactory.getLog(CopyLegacyUiContentToWebInf.class);
	
	private static final String MODULE_ROOT_DIR = "/WEB-INF/view/module/mapperoverridedemo";
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		
		String basePath = servletContext.getRealPath("");
		
		try {
			
			//copy images
			File destDir = new File(basePath + "/images".replace("/", File.separator));
			File srcDir = new File(basePath + MODULE_ROOT_DIR + "/resources/images".replace("/", File.separator));
			FileUtils.copyDirectory(srcDir, destDir);
			
		}
		catch (IOException ex) {
			log.error("Failed to copy legacy ui files", ex);
		}
	}
}
