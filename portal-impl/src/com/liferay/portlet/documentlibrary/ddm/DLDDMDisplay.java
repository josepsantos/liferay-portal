/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.documentlibrary.ddm;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.metadata.RawMetadataProcessor;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata;
import com.liferay.portlet.dynamicdatamapping.storage.StorageType;
import com.liferay.portlet.dynamicdatamapping.util.BaseDDMDisplay;
import com.liferay.portlet.dynamicdatamapping.util.DDMPermissionHandler;

import java.util.Locale;

/**
 * @author Eduardo Garcia
 */
public class DLDDMDisplay extends BaseDDMDisplay {

	public static final long[] RESOURCE_CLASS_NAME_IDS = new long[] {
		PortalUtil.getClassNameId(DLFileEntryMetadata.class),
		PortalUtil.getClassNameId(RawMetadataProcessor.class)
	};

	@Override
	public DDMPermissionHandler getDDMPermissionHandler() {
		return _ddmPermissionHandler;
	}

	@Override
	public String getPortletId() {
		return PortletKeys.DOCUMENT_LIBRARY;
	}

	@Override
	public String getStorageType() {
		return StorageType.JSON.toString();
	}

	@Override
	public String getStructureName(Locale locale) {
		return LanguageUtil.get(locale, "metadata-set");
	}

	@Override
	public String getStructureType() {
		return DLFileEntryMetadata.class.getName();
	}

	private final DDMPermissionHandler _ddmPermissionHandler =
		new DLDDMPermissionHandler();

}