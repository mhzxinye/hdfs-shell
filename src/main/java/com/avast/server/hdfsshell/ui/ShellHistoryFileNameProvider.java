/*
 * Copyright 2011-2012 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.avast.server.hdfsshell.ui;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultHistoryFileNameProvider;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 
 * @author Jarred Li
 *
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ShellHistoryFileNameProvider extends DefaultHistoryFileNameProvider {

	public String getHistoryFileName() {
		final String dir = System.getProperty("user.home") + "/.hdfs-shell/";
		final File targetDir = new File(dir);
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}
		return dir + "hdfs-shell.log";
	}

	@Override
	public String getProviderName() {
		return "History file name provider";
	}
	
}
