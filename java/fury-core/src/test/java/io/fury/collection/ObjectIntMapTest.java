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

package io.fury.collection;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class ObjectIntMapTest {

  @Test
  public void testMapIteration() {
    Map<Object, Integer> hashMap = new HashMap<>();
    ObjectIntMap<Object> map = new ObjectIntMap<>();
    for (int i = 0; i < 10; i++) {
      hashMap.put(i, i);
      hashMap.put(i, 1);
      hashMap.put(String.valueOf(i), 1);
      map.put(i, i);
      map.put(i, 1);
      map.put(String.valueOf(i), 1);
    }
    assertEquals(map.toHashMap(), hashMap);
    map.forEach(
        (k, v) -> {
          assertEquals(v, hashMap.get(k));
        });
  }
}
