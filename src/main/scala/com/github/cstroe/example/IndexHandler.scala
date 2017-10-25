package com.github.cstroe.example

import com.sun.net.httpserver.{HttpExchange, HttpHandler}

class IndexHandler extends HttpHandler {
  override def handle(exchange: HttpExchange) = {
    val response =
      """
        |<html>
        |  <head>
        |    <title>Hello World!</title>
        |  </head>
        |  <body>
        |    <h1>Hello!</h1>
        |  </body>
        |</html>
      """.stripMargin

    exchange.getResponseHeaders.add("Content-Type", "text/html")
    exchange.sendResponseHeaders(200, response.length)
    val outputStream = exchange.getResponseBody
    outputStream.write(response.getBytes())
    outputStream.close()
  }
}
