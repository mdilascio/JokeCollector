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

package com.man4rky.akka.http.service

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.man4rky.akka.http.service.support._
import com.typesafe.config.ConfigFactory

object MainHttpService extends App with CorsSupport with SwaggerSite {
  protected implicit val system = ActorSystem()
  protected implicit val executor = system.dispatcher
  protected implicit val materializer = ActorMaterializer()

  protected val config = ConfigFactory.load()
  protected val logger = Logging(system, getClass)

  val routes =
    new JokeService().route ~
      site ~
      corsHandler(
        new SwaggerDocService(
          config.getString("http.interface"),
          config.getInt("http.port"),
          system).routes
      )

  val serverBindingFuture = Http().bindAndHandle(routes, config.getString("http.interface"), config.getInt("http.port"))
  serverBindingFuture.onFailure { case e =>
    logger.error(s"Server binding failed with ${e.getMessage}")
    system.terminate()
  }
}