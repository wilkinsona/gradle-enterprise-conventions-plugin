/*
 * Copyright 2020-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.ge.conventions.gradle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link AnonymousPublicationBuildScanConventions}.
 *
 * @author Andy Wilkinson
 */
class AnonymousPublicationBuildScanConventionsTests {

	private final TestProcessRunner processRunner = new TestProcessRunner();

	private final TestDevelocityConfiguration develocity = new TestDevelocityConfiguration();

	private final TestBuildScanConfiguration buildScan = new TestBuildScanConfiguration();

	@Test
	void buildScansAreConfiguredToUseDefaultPublicationBehaviour() {
		new AnonymousPublicationBuildScanConventions(this.develocity, this.processRunner).execute(this.buildScan);
		assertThat(this.buildScan.publishing.predicate).isNull();
	}

	@Test
	void buildScansAreConfiguredToPublishToDefaultServer() {
		new AnonymousPublicationBuildScanConventions(this.develocity, this.processRunner).execute(this.buildScan);
		assertThat(this.develocity.getServer().getOrNull()).isNull();
	}

}
