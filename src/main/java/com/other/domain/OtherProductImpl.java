/*
 * Copyright 2008-2009 the original author or authors.
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

package com.other.domain;

import org.broadleafcommerce.core.catalog.domain.ProductSkuImpl;
import org.broadleafcommerce.openadmin.client.presentation.SupportedFieldType;
import org.broadleafcommerce.presentation.AdminPresentation;
import org.broadleafcommerce.presentation.AdminPresentationClass;
import org.broadleafcommerce.presentation.AdminPresentationOverride;
import org.broadleafcommerce.presentation.AdminPresentationOverrides;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Date;

/**
 * 
 * @author jfischer
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "OTHER_PRODUCT")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="blOrderElements")
@AdminPresentationClass(friendlyName = "otherProduct")
@AdminPresentationOverrides(
    {
        @AdminPresentationOverride(name="description", value=@AdminPresentation(friendlyName="My Company Description", order=2, group="Product Description", prominent=false, largeEntry=true, groupOrder=1)),
        @AdminPresentationOverride(name="dimension.container", value=@AdminPresentation(friendlyName="Product Container Shape", order=15, group="Dimension", fieldType= SupportedFieldType.BROADLEAF_ENUMERATION, broadleafEnumeration="com.other.domain.OtherContainerShapeType"))
    }
)
public class OtherProductImpl extends ProductSkuImpl implements OtherProduct {

	private static final long serialVersionUID = 1L;

	@Column(name = "COMPANY_NUMBER")
	@AdminPresentation(friendlyName="Company Number", order=3, group="My Special Descriptions", prominent=false)
	protected Long companyNumber;
	
	@Column(name = "RELEASE_DATE")
	@AdminPresentation(friendlyName="Release Date", order=4, group="My Special Descriptions", prominent=false)
	protected Date releaseDate;
	
	public Long getCompanyNumber() {
		return companyNumber;
	}
	
	public void setCompanyNumber(Long companyNumber) {
		this.companyNumber = companyNumber;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}
