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

package org.broadleafcommerce.profile.aop.test;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.broadleafcommerce.profile.core.service.CustomerService;

public class CustomerStateAOP {

	@Resource(name = "blCustomerService")
	private CustomerService customerService;

    public Object processCustomerRetrieval(ProceedingJoinPoint call) throws Throwable {
        return customerService.readCustomerById(1L);
    }

}
