/*
 * Copyright 2023 The Fury Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fury.serializer;

import static org.testng.Assert.assertEquals;

import io.fury.Fury;
import io.fury.config.Language;
import io.fury.serializer.test.Factory;
import java.io.Externalizable;
import org.testng.annotations.Test;

public class ExternalizableSerializerTest {

  @Test
  public void testInaccessibleExternalizable() {
    Externalizable e = Factory.newInstance(1, 1, "bytes".getBytes());

    Fury fury =
        Fury.builder()
            .withLanguage(Language.JAVA)
            .withRefTracking(false)
            .requireClassRegistration(false)
            .build();
    assertEquals(e, fury.deserialize(fury.serialize(e)));
  }
}
