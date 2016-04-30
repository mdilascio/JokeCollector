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

import javax.ws.rs.Path

import akka.http.scaladsl.server.Directives
import com.man4rky.akka.http.service.support.DefaultJsonFormats
import io.swagger.annotations._

import scala.concurrent.ExecutionContext

@Api(value = "/joke", produces = "application/json")
@Path("/joke")
class JokeService()(implicit executionContext: ExecutionContext)
  extends Directives with DefaultJsonFormats {

  val route =
    getRandomJoke

  @ApiOperation(httpMethod = "GET", response = classOf[String], value = "Returns a Joke")
  @ApiResponses(Array(new ApiResponse(code = 404, message = "Joke not found!")))
  def getRandomJoke =
    path("joke") {
      get {
        complete {
          s"Ha ha ha!"
        }
      }
    }

//  @ApiOperation(httpMethod = "POST", response = classOf[String], value = "Collects a new Joke")
//  @ApiImplicitParams(Array(new ApiImplicitParam(name = "joke", required = true, dataType = "string", paramType = "string")))
//  @ApiResponses(Array(new ApiResponse(code = 404, message = "Joke not found!")))
//  def collectJoke =
//    path("joke") {
//      post {
//        complete {
//          s"Ha ha ha2!"
//        }
//      }
//    }


}
