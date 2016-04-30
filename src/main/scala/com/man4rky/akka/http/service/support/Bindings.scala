/*
 * Copyright 2016 Man4rky
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
 *
 * @author Mariano Dilascio
 */

package com.man4rky.akka.http.service.support

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import net.codingwell.scalaguice.ScalaModule

class Bindings extends ScalaModule{
  override def configure(): Unit = {
    bind[ActorSystem].to(classOf[ActorSystem])
    bind[ActorMaterializer].to(classOf[ActorMaterializer])
  }
}
