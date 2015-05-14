/*
 * SonarQube CSS Plugin
 * Copyright (C) 2013 Tamas Kende
 * kende.tamas@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.css.core;

import org.apache.commons.lang.StringUtils;
import org.sonar.api.config.Settings;
import org.sonar.api.resources.AbstractLanguage;
import org.sonar.api.scan.filesystem.FileQuery;
import org.sonar.plugins.css.CssPlugin;

public class Css extends AbstractLanguage {

  public static final String KEY = "css";
  public static final FileQuery SOURCE_QUERY = FileQuery.onSource().onLanguage(KEY);

  private final Settings settings;

  public Css(Settings settings) {
    super(KEY, "CSS");
    this.settings = settings;
  }

  @Override
  public String[] getFileSuffixes() {
    String[] suffixes = settings.getStringArray(CssPlugin.FILE_SUFFIXES_KEY);
    if (suffixes == null || suffixes.length == 0) {
      suffixes = StringUtils.split(CssPlugin.FILE_SUFFIXES_DEFVALUE, ",");
    }
    return suffixes;
  }

}
