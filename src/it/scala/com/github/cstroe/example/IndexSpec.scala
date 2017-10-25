package com.github.cstroe.example

import org.scalatest.{FlatSpec, Matchers}

import scalaj.http.Http

class IndexSpec extends FlatSpec with Matchers {
  val serviceName = "myhttpserver"
  val host = System.getenv(s"${serviceName.toUpperCase()}_HOST")
  val port = System.getenv(s"${serviceName.toUpperCase()}_TCP_8080")

  "The HttpServer" should "display an index page" in {
    val response = Http(s"http://$host:$port").asString
    response.code should be(200)
    response.body should include("Hello")
  }
}
