/*
 * Copyright 2018 the original author or authors.
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

package org.springframework.cloud.scheduler.spi.cloudfoundry;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Validate the basic behavior of the {@link CloudFoundrySchedulerProperties}.
 *
 * @author Glenn Renfro
 */
public class CloudFoundrySchedulerPropertiesTest {

	@Test
	public void testProperties() {
		CloudFoundrySchedulerProperties props = new CloudFoundrySchedulerProperties();
		props.setSchedulerUrl("testProperty");
		props.setScheduleSSLRetryCount(10);
		props.setListTimeoutInSeconds(5);
		props.setUnScheduleTimeoutInSeconds(10);
		props.setScheduleTimeoutInSeconds(15);
		assertThat(props.getSchedulerUrl()).isEqualTo("testProperty");
		assertThat(props.getScheduleSSLRetryCount()).isEqualTo(10);
		assertThat(props.getScheduleTimeoutInSeconds()).isEqualTo(15);
		assertThat(props.getUnScheduleTimeoutInSeconds()).isEqualTo(10);
		assertThat(props.getListTimeoutInSeconds()).isEqualTo(5);
	}

	@Test
	public void testEmptyProperties() {
		CloudFoundrySchedulerProperties props = new CloudFoundrySchedulerProperties();
		assertThat(props.getSchedulerUrl()).isNull();
		assertThat(props.getScheduleSSLRetryCount()).isEqualTo(5);
		assertThat(props.getListTimeoutInSeconds()).isEqualTo(60);
		assertThat(props.getScheduleTimeoutInSeconds()).isEqualTo(30);
		assertThat(props.getUnScheduleTimeoutInSeconds()).isEqualTo(30);
	}

}
