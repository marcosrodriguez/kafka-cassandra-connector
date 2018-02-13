/*
 * Copyright 2016 Tuplejump
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

package com.datastax.driver.core

import com.datastax.driver.core.ColumnDefinitions.Definition

/**
  * This is a hack to create a dummy ColumnDefinition for unit-tests.
  * Could not mock using Mockito since the constructors are not public
  */
object TestUtil {

  def getColumnDef(cols:Map[String,DataType]):ColumnDefinitions = {
    val definitions: Array[Definition] = cols.map {
      case (x, y) => new Definition("test", "dummy", x, y)
    }.toArray
    new ColumnDefinitions(definitions, CodecRegistry.DEFAULT_INSTANCE)
  }
}
