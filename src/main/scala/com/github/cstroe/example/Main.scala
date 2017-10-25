package com.github.cstroe.example

import java.net.InetSocketAddress

import com.sun.net.httpserver.HttpServer
import org.apache.logging.log4j.LogManager

object Main {
  def main(args: Array[String]) = {
    val logger = LogManager.getLogger("Main")

    val port = 8080
    val httpServer = HttpServer.create(new InetSocketAddress(port), 0)
    httpServer.createContext("/", new IndexHandler)
    httpServer.setExecutor(null)

    logger.info(s"Starting HttpServer on port: $port")
    logger.info(s"Access the server via: http://localhost:$port")
    httpServer.start()
  }
}
